package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class CategoriaService {
    
    // Método para obtener todas las categorías de forma segura
    public List<Map<String, Object>> obtenerTodasCategorias() throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        
        try {
            conn = DB.getConnection();
            // Trae todas las categorías activas o disponibles
            return GenericDAO.select(conn, "Categoria", "1 = ?", 1);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    // Método para registrar una nueva categoría de forma segura
    public void registrarCategoria(String nombreCategoria) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Transacción segura

            // 1. Validar si la categoría ya existe
            java.util.List<java.util.Map<String, Object>> existentes = 
                DAO.GenericDAO.select(conn, "Categoria", "NombreCategoria = ?", nombreCategoria);

            if (!existentes.isEmpty()) {
                throw new Exception("Ya existe una categoría con ese nombre");
            }

            // 2. Preparar los datos para la inserción
            java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
            data.put("NombreCategoria", nombreCategoria);

            // 3. Insertar la nueva categoría
            int filas = DAO.GenericDAO.insert(conn, "Categoria", data);

            if (filas <= 0) {
                throw new Exception("No se pudo registrar la categoría en la base de datos");
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
}