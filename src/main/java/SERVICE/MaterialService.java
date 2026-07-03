package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MaterialService {
    
    // 1. Buscar materiales por coincidencia (El que ya tenías)
    public List<Map<String, Object>> buscarMaterialesPorNombre(String nombre) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            return GenericDAO.select(conn, "Material", "Nombre LIKE ?", "%" + nombre + "%");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // 2. Buscar un material exacto por su código de barras
    public Map<String, Object> buscarMaterialPorCodigoBarra(String codigoBarra) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            List<Map<String, Object>> resultado = GenericDAO.select(conn, "Material", "CodigoBarra = ?", codigoBarra);
            if (resultado.isEmpty()) {
                throw new Exception("No existe material con ese código de barra");
            }
            return resultado.get(0);
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // 3. Registrar un material
    public void registrarMaterial(String codigoBarra, String nombre, String descripcion, String unidadMedida, double precio, String nombreCategoria) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            
            List<Map<String, Object>> existentes = GenericDAO.select(conn, "Material", "CodigoBarra = ?", codigoBarra);
            if (!existentes.isEmpty()) throw new Exception("Ya existe un material con ese código de barra");
            
            List<Map<String, Object>> cat = GenericDAO.select(conn, "Categoria", "NombreCategoria = ?", nombreCategoria);
            if (cat.isEmpty()) throw new Exception("La categoría seleccionada no es válida");
            int categoriaID = ((Number) cat.get(0).get("CategoriaID")).intValue();
            
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("CodigoBarra", codigoBarra);
            data.put("Nombre", nombre);
            data.put("Descripcion", descripcion);
            data.put("UnidadMedida", unidadMedida);
            data.put("Precio", precio);
            data.put("CategoriaID", categoriaID);
            
            int filas = GenericDAO.insert(conn, "Material", data);
            if (filas <= 0) throw new Exception("No se pudo registrar el material en la base de datos");
            
            conn.commit();
        } catch (Exception e) {
            if (conn != null) { try { conn.rollback(); } catch (Exception ex) {} }
            throw e;
        } finally {
            if (conn != null) { try { conn.setAutoCommit(true); conn.close(); } catch (Exception ex) {} }
        }
    }

    // 4. Actualizar un material
    public void actualizarMaterial(int materialID, String codigoBarra, String nombre, String descripcion, String unidadMedida, double precio, String nombreCategoria) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            
            List<Map<String, Object>> existentes = GenericDAO.select(conn, "Material", "CodigoBarra = ? AND MaterialID <> ?", codigoBarra, materialID);
            if (!existentes.isEmpty()) throw new Exception("Ya existe otro material con ese código de barra");
            
            List<Map<String, Object>> cat = GenericDAO.select(conn, "Categoria", "NombreCategoria = ?", nombreCategoria);
            if (cat.isEmpty()) throw new Exception("La categoría seleccionada no es válida");
            int categoriaID = ((Number) cat.get(0).get("CategoriaID")).intValue();
            
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("CodigoBarra", codigoBarra);
            data.put("Nombre", nombre);
            data.put("Descripcion", descripcion);
            data.put("UnidadMedida", unidadMedida);
            data.put("Precio", precio);
            data.put("CategoriaID", categoriaID);
            
            int filasAfectadas = GenericDAO.update(conn, "Material", data, "MaterialID = ?", materialID);
            if (filasAfectadas <= 0) throw new Exception("No se pudo actualizar el material en la base de datos");
            
            conn.commit();
        } catch (Exception e) {
            if (conn != null) { try { conn.rollback(); } catch (Exception ex) {} }
            throw e;
        } finally {
            if (conn != null) { try { conn.setAutoCommit(true); conn.close(); } catch (Exception ex) {} }
        }
    }

    // 5. Eliminar materiales
    public int eliminarMateriales(List<Integer> materialIDs) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        int eliminados = 0;
        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false);
            for (Integer id : materialIDs) {
                eliminados += GenericDAO.delete(conn, "Material", "MaterialID = ?", id);
            }
            conn.commit();
            return eliminados;
        } catch (Exception e) {
            if (conn != null) { try { conn.rollback(); } catch (Exception ex) {} }
            throw new Exception("Error al eliminar. Es posible que este material ya esté en uso en Entradas o Salidas.");
        } finally {
            if (conn != null) { try { conn.setAutoCommit(true); conn.close(); } catch (Exception ex) {} }
        }
    }

    // 6. Buscar materiales con JOIN a Categoria
    public List<Map<String, Object>> buscarMaterialesConCategoria(String nombre) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        try {
            conn = DB.getConnection();
            String sql = """
                SELECT
                    m.MaterialID,
                    m.CodigoBarra,
                    m.Nombre,
                    m.Descripcion,
                    m.UnidadMedida,
                    m.StockActual,
                    m.Precio,
                    c.NombreCategoria
                FROM Material m
                INNER JOIN Categoria c
                    ON m.CategoriaID = c.CategoriaID
                WHERE m.Nombre LIKE ?
                ORDER BY 1
            """;
            return GenericDAO.selectQuery(conn, sql, "%" + nombre + "%");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}