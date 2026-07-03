package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class SalidaService {
    
    // El método ahora recibe todos los datos que estaban en los TextBox
    public void registrarSalidaCompleta(int usuarioID, String numeroFactura, String tipoSalida, String nombreCliente, BigDecimal totalVenta, String observaciones, List<Map<String, Object>> detalleSalida) throws Exception {
        
        dbBean DB = new dbBean();
        Connection conn = null;
        
        try {
            conn = DB.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            // 1. Verificamos el Stock con bloqueos (Lógica movida del UI)
            Map<String, Integer> materialIds = new java.util.HashMap<>();
            for (Map<String, Object> fila : detalleSalida) {
                String codigoBarra = fila.get("CodigoBarra").toString();
                BigDecimal cantidad = new BigDecimal(fila.get("Cantidad").toString());

                try (PreparedStatement ps = conn.prepareStatement(
                    "SELECT MaterialID, StockActual FROM Material WITH (UPDLOCK, HOLDLOCK) WHERE CodigoBarra = ?"
                )) {
                    ps.setString(1, codigoBarra);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new Exception("No existe material con código de barra: " + codigoBarra);
                        }
                        int materialID = rs.getInt("MaterialID");
                        BigDecimal stockActual = rs.getBigDecimal("StockActual");

                        if (cantidad.compareTo(stockActual) > 0) {
                            throw new Exception("Stock insuficiente para el material: " + codigoBarra + 
                                                "\nStock disponible: " + stockActual + 
                                                "\nCantidad solicitada: " + cantidad);
                        }
                        materialIds.put(codigoBarra, materialID);
                    }
                }
            }

            // 2. Validamos el Tipo de Salida y Cliente
            List<Map<String, Object>> tipSal = GenericDAO.select(conn, "TipoSalida", "Descripcion = ?", tipoSalida);
            if (tipSal.isEmpty()) throw new Exception("Tipo de salida no válido");
            int TipoSalidaID = Integer.parseInt(tipSal.get(0).get("TipoSalidaID").toString());

            List<Map<String, Object>> cli = GenericDAO.select(conn, "Cliente", "Nombre = ?", nombreCliente);
            if (cli.isEmpty()) throw new Exception("Cliente no válido");
            int ClienteID = Integer.parseInt(cli.get(0).get("ClienteID").toString());

            // 3. Validamos Factura duplicada
            List<Map<String, Object>> facturaEntrada = GenericDAO.select(conn, "Entrada", "NumeroFactura = ?", numeroFactura);
            List<Map<String, Object>> facturaSalida = GenericDAO.select(conn, "Salida", "NumeroFactura = ?", numeroFactura);
            if (!facturaEntrada.isEmpty() || !facturaSalida.isEmpty()) {
                throw new Exception("El número de factura ya existe en el sistema");
            }

            // 4. Insertamos la Salida
            Timestamp fechaSalida = new Timestamp(System.currentTimeMillis());
            LinkedHashMap<String, Object> SalidaData = new LinkedHashMap<>();
            SalidaData.put("UsuarioID", usuarioID);
            SalidaData.put("TipoSalidaID", TipoSalidaID);
            SalidaData.put("ClienteID", ClienteID);
            SalidaData.put("NumeroFactura", numeroFactura);
            SalidaData.put("FechaSalida", fechaSalida);
            SalidaData.put("TotalVenta", totalVenta);
            SalidaData.put("Observaciones", observaciones);

            int salidaID = GenericDAO.insertAndReturnID(conn, "Salida", SalidaData);
            if (salidaID <= 0) throw new Exception("No se pudo registrar la salida");

            // 5. Insertamos DetalleSalida y Actualizamos Stock
            for (Map<String, Object> fila : detalleSalida) {
                String codigoBarra = fila.get("CodigoBarra").toString();
                BigDecimal cantidad = new BigDecimal(fila.get("Cantidad").toString());
                int materialID = materialIds.get(codigoBarra);

                LinkedHashMap<String, Object> detalleData = new LinkedHashMap<>();
                detalleData.put("SalidaID", salidaID);
                detalleData.put("MaterialID", materialID);
                detalleData.put("Cantidad", cantidad);
                detalleData.put("PrecioVenta", fila.get("PrecioUnitario"));

                GenericDAO.insert(conn, "DetalleSalida", detalleData);

                try (PreparedStatement psUpd = conn.prepareStatement(
                    "UPDATE Material SET StockActual = StockActual - ? WHERE MaterialID = ?"
                )) {
                    psUpd.setBigDecimal(1, cantidad);
                    psUpd.setInt(2, materialID);

                    if (psUpd.executeUpdate() != 1) {
                        throw new SQLException("Error al actualizar stock del material: " + codigoBarra);
                    }
                }
            }

            
            conn.commit();
            
        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ignored) {}
            }
            throw e; // Reenviamos el error al UI
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ignored) {}
            }
        }
    }
}