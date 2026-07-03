package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class ClienteService {

    public List<Map<String, Object>> buscarClientesPorNombre(String nombre) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        
        try {
            conn = DB.getConnection();
            
            // Aquí le pasamos la conexión (conn) como exige ahora tu DAO seguro
            return GenericDAO.select(conn, "Cliente", "Nombre LIKE ?", "%" + nombre + "%");
            
        } finally {
            // Siempre cerramos la conexión al terminar la búsqueda
            if (conn != null) {
                conn.close();
            }
        }
    }

    public java.util.List<java.util.Map<String, Object>> buscarClientePorNombreExacto(String nombre) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;
        
        try {
            conn = DB.getConnection();
            // Búsqueda exacta usando "="
            return DAO.GenericDAO.select(conn, "Cliente", "Nombre = ?", nombre);
            
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    public void registrarCliente(String nombre, String tipoDoc, String documento, String telefono, String direccion, String email) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Iniciamos transacción segura

            // 1. Validar si ya existe un cliente con ese nombre
            java.util.List<java.util.Map<String, Object>> mismoNombre = 
                DAO.GenericDAO.select(conn, "Cliente", "Nombre = ?", nombre);

            if (!mismoNombre.isEmpty()) {
                throw new Exception("Ya existe un cliente con ese nombre");
            }

            // 2. Validar si ya existe un cliente con el mismo tipo y número de documento
            java.util.List<java.util.Map<String, Object>> existentes = 
                DAO.GenericDAO.select(conn, "Cliente", "TipoDocumento = ? AND Documento = ?", tipoDoc, documento);

            if (!existentes.isEmpty()) {
                throw new Exception("Ya existe un cliente con el mismo tipo y número de documento");
            }

            // 3. Preparar los datos para la inserción
            java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
            data.put("Nombre", nombre);
            data.put("TipoDocumento", tipoDoc);
            data.put("Documento", documento);
            data.put("Telefono", telefono);
            data.put("Direccion", direccion);
            data.put("Email", email);

            // 4. Insertar el cliente
            int filas = DAO.GenericDAO.insert(conn, "Cliente", data);

            if (filas <= 0) {
                throw new Exception("No se pudo registrar el cliente en la base de datos");
            }

            conn.commit(); // Confirmamos los cambios permanentemente

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e; // Lanzamos el error hacia la vista
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
    public void actualizarCliente(int clienteID, String nombre, String tipoDoc, String documento, String telefono, String direccion, String email) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            // 1. Validar si el nuevo nombre ya le pertenece a OTRO cliente distinto
            java.util.List<java.util.Map<String, Object>> mismoNombre = 
                DAO.GenericDAO.select(conn, "Cliente", "Nombre = ? AND ClienteID <> ?", nombre, clienteID);

            if (!mismoNombre.isEmpty()) {
                throw new Exception("Ya existe otro cliente con ese nombre en el sistema");
            }

            // 2. Validar si el documento ya le pertenece a OTRO cliente distinto
            java.util.List<java.util.Map<String, Object>> existentes = 
                DAO.GenericDAO.select(conn, "Cliente", "TipoDocumento = ? AND Documento = ? AND ClienteID <> ?", tipoDoc, documento, clienteID);

            if (!existentes.isEmpty()) {
                throw new Exception("Ya existe otro cliente con el mismo tipo y número de documento");
            }

            // 3. Preparar los datos
            java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
            data.put("Nombre", nombre);
            data.put("TipoDocumento", tipoDoc);
            data.put("Documento", documento);
            data.put("Telefono", telefono);
            data.put("Direccion", direccion);
            data.put("Email", email);

            // 4. Ejecutar la actualización
            int filasAfectadas = DAO.GenericDAO.update(conn, "Cliente", data, "ClienteID = ?", clienteID);

            if (filasAfectadas <= 0) {
                throw new Exception("No se pudo actualizar el cliente en la base de datos");
            }

            conn.commit(); // Confirmamos los cambios permanentemente

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e; // Lanzamos el error hacia la vista
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
    public int eliminarClientes(java.util.List<Integer> clienteIDs) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;
        int eliminados = 0;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            for (Integer id : clienteIDs) {
                // Ejecutamos el delete usando la conexión segura
                eliminados += DAO.GenericDAO.delete(conn, "Cliente", "ClienteID = ?", id);
            }

            conn.commit(); 
            return eliminados;

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw new Exception("Error al eliminar. Es posible que este cliente ya tenga Salidas (ventas) registradas en el sistema.");
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
}
