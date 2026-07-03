package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class EntradaService {
    
    // Método para registrar una entrada, guardar sus detalles y sumar el stock en una sola transacción
    public void registrarEntradaCompleta(int usuarioID, String nombreProveedor, String numeroFactura, BigDecimal totalCompra, String observaciones, List<Map<String, Object>> detalleEntrada) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        
        try {
            conn = DB.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false); // Inicia transacción segura
            
            // 1. Validar Proveedor
            List<Map<String, Object>> prov = GenericDAO.select(conn, "Proveedor", "Nombre = ?", nombreProveedor);
            if (prov.isEmpty()) throw new Exception("Proveedor no válido");
            int proveedorID = Integer.parseInt(prov.get(0).get("ProveedorID").toString());
            
            // 2. Validar Factura Duplicada
            List<Map<String, Object>> facturaEntrada = GenericDAO.select(conn, "Entrada", "NumeroFactura = ?", numeroFactura);
            List<Map<String, Object>> facturaSalida = GenericDAO.select(conn, "Salida", "NumeroFactura = ?", numeroFactura);
            if (!facturaEntrada.isEmpty() || !facturaSalida.isEmpty()) {
                throw new Exception("El número de factura ya existe en el sistema");
            }
            
            // 3. Registrar la Entrada Principal
            Timestamp fechaEntrada = new Timestamp(System.currentTimeMillis());
            LinkedHashMap<String, Object> entradaData = new LinkedHashMap<>();
            entradaData.put("ProveedorID", proveedorID);
            entradaData.put("UsuarioID", usuarioID);
            entradaData.put("NumeroFactura", numeroFactura);
            entradaData.put("FechaEntrada", fechaEntrada);
            entradaData.put("TotalCompra", totalCompra);
            entradaData.put("Observaciones", observaciones);
            
            int entradaID = GenericDAO.insertAndReturnID(conn, "Entrada", entradaData);
            if (entradaID <= 0) throw new Exception("No se pudo registrar la entrada");
            
            // 4. Guardar Detalles y Actualizar Stock de cada material
            for (Map<String, Object> fila : detalleEntrada) {
                String codigoBarra = fila.get("CodigoBarra").toString();
                BigDecimal cantidad = new BigDecimal(fila.get("Cantidad").toString());
                
                List<Map<String, Object>> mat = GenericDAO.select(conn, "Material", "CodigoBarra = ?", codigoBarra);
                if (mat.isEmpty()) throw new Exception("No existe material con código de barra: " + codigoBarra);
                
                int materialID = Integer.parseInt(mat.get(0).get("MaterialID").toString());
                BigDecimal stockActual = new BigDecimal(mat.get(0).get("StockActual").toString());
                
                // Insertar el detalle
                LinkedHashMap<String, Object> detalleData = new LinkedHashMap<>();
                detalleData.put("EntradaID", entradaID);
                detalleData.put("MaterialID", materialID);
                detalleData.put("Cantidad", cantidad);
                detalleData.put("CostoUnitario", fila.get("CostoUnitario"));
                GenericDAO.insert(conn, "DetalleEntrada", detalleData);
                
                // Sumar al Stock
                BigDecimal nuevoStock = stockActual.add(cantidad);
                LinkedHashMap<String, Object> stockData = new LinkedHashMap<>();
                stockData.put("StockActual", nuevoStock);
                GenericDAO.update(conn, "Material", stockData, "MaterialID = ?", materialID);
            }
            
            conn.commit(); // Si todo sale perfecto, se guardan los cambios
            
        } catch (Exception e) {
            if (conn != null) { try { conn.rollback(); } catch (Exception ignored) {} }
            throw e; // Lanza el error a la interfaz gráfica
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