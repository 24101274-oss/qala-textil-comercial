package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProveedorService {

    // 1. Buscar proveedores por coincidencia de nombre
    public List<Map<String, Object>> buscarProveedoresPorNombre(String nombre) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            return GenericDAO.select(conn, "Proveedor", "Nombre LIKE ?", "%" + nombre + "%");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // 2. Registrar un nuevo proveedor
    public void registrarProveedor(String nombre, String contacto, String direccion, String ciudad, String telefono, String ruc) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            // Validar si el proveedor ya existe
            List<Map<String, Object>> existentes = GenericDAO.select(conn, "Proveedor", "Nombre = ?", nombre);
            if (!existentes.isEmpty()) {
                throw new Exception("El proveedor ya existe en el sistema");
            }

            // Preparar datos
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("Nombre", nombre);
            data.put("NombreContacto", contacto);
            data.put("Direccion", direccion);
            data.put("Ciudad", ciudad);
            data.put("Telefono", telefono);
            data.put("RUC", ruc);

            // Insertar
            int filas = GenericDAO.insert(conn, "Proveedor", data);
            if (filas <= 0) {
                throw new Exception("No se pudo registrar el proveedor en la base de datos");
            }

            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e;
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }

    // 3. Actualizar un proveedor existente
    public void actualizarProveedor(int proveedorID, String nombre, String contacto, String direccion, String ciudad, String telefono, String ruc) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            // Validar duplicado excluyendo al proveedor actual
            List<Map<String, Object>> existentes = GenericDAO.select(conn, "Proveedor", "Nombre = ? AND ProveedorID <> ?", nombre, proveedorID);
            if (!existentes.isEmpty()) {
                throw new Exception("Ya existe otro proveedor con ese nombre en el sistema");
            }

            // Preparar datos
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("Nombre", nombre);
            data.put("NombreContacto", contacto);
            data.put("Direccion", direccion);
            data.put("Ciudad", ciudad);
            data.put("Telefono", telefono);
            data.put("RUC", ruc);

            // Actualizar
            int filasAfectadas = GenericDAO.update(conn, "Proveedor", data, "ProveedorID = ?", proveedorID);
            if (filasAfectadas <= 0) {
                throw new Exception("No se pudo actualizar el proveedor en la base de datos");
            }

            conn.commit();

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e;
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }

    // 4. Eliminar proveedores por lote
    public int eliminarProveedores(List<Integer> proveedorIDs) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        int eliminados = 0;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            for (Integer id : proveedorIDs) {
                eliminados += GenericDAO.delete(conn, "Proveedor", "ProveedorID = ?", id);
            }

            conn.commit(); 
            return eliminados;

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw new Exception("Error al eliminar. Es posible que este proveedor ya tenga Entradas registradas en el sistema.");
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