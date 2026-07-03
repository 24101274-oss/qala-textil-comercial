package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

public class UsuarioService {

    // Método para registrar un usuario de forma segura con transacciones
    public void registrarUsuario(String username, String passwordPlano, String nombreRol, int estado) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción

            // 1. Validar si ya existe el nombre de usuario
            List<Map<String, Object>> usuarioExistente = GenericDAO.select(conn, "Usuario", "Username = ?", username);
            if (!usuarioExistente.isEmpty()) {
                throw new Exception("Ya existe un usuario con ese nombre");
            }

            // 2. Obtener el ID del Rol
            List<Map<String, Object>> rol = GenericDAO.select(conn, "Rol", "NombreRol = ?", nombreRol);
            if (rol.isEmpty()) {
                throw new Exception("El rol seleccionado no existe");
            }
            int rolID = Integer.parseInt(rol.get(0).get("RolID").toString());

            // 3. Encriptar la contraseña
            String hash = BCrypt.hashpw(passwordPlano, BCrypt.gensalt());

            // 4. Preparar datos e insertar
            LinkedHashMap<String, Object> data = new LinkedHashMap<>();
            data.put("Username", username);
            data.put("Password", hash);
            data.put("RolID", rolID);
            data.put("Estado", estado);

            int filas = GenericDAO.insert(conn, "Usuario", data);

            if (filas <= 0) {
                throw new Exception("No se pudo registrar el usuario en la base de datos");
            }

            conn.commit(); // Confirmar los cambios

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e; // Lanza el error hacia la vista
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
    public void actualizarUsuario(int usuarioID, String username, String passwordPlano, String nombreRol, int estado) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción segura

            // 1. Validar si el rol seleccionado existe
            java.util.List<java.util.Map<String, Object>> rolRes = DAO.GenericDAO.select(conn, "Rol", "NombreRol = ?", nombreRol);
            if (rolRes.isEmpty()) {
                throw new Exception("El rol seleccionado no es válido");
            }
            int rolID = Integer.parseInt(rolRes.get(0).get("RolID").toString());

            // 2. Validar que el nombre de usuario no esté duplicado con otro registro
            java.util.List<java.util.Map<String, Object>> duplicado = 
                DAO.GenericDAO.select(conn, "Usuario", "Username = ? AND UsuarioID <> ?", username, usuarioID);
            if (!duplicado.isEmpty()) {
                throw new Exception("Ya existe otro usuario con ese nombre");
            }

            // 3. Preparar los datos básicos
            java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
            data.put("Username", username);
            data.put("RolID", rolID);
            data.put("Estado", estado);

            // 4. Si se ingresó una nueva contraseña válida, generar hash
            if (!passwordPlano.isEmpty() && !passwordPlano.equals("********")) {
                if (passwordPlano.length() < 6) {
                    throw new Exception("La contraseña debe tener al menos 6 caracteres");
                }
                String hash = org.mindrot.jbcrypt.BCrypt.hashpw(passwordPlano, org.mindrot.jbcrypt.BCrypt.gensalt());
                data.put("Password", hash);
            }

            // 5. Ejecutar la actualización en la base de datos
            int filasAfectadas = DAO.GenericDAO.update(conn, "Usuario", data, "UsuarioID = ?", usuarioID);
            if (filasAfectadas <= 0) {
                throw new Exception("No se pudo actualizar el usuario en la base de datos");
            }

            conn.commit(); // Guardamos los cambios permanentemente

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw e; // Lanza el error a la interfaz gráfica
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
    
    public int eliminarUsuarios(java.util.List<Integer> usuarioIDs) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;
        int eliminados = 0;

        try {
            conn = DB.getConnection();
            conn.setAutoCommit(false); // Iniciar transacción segura

            for (Integer id : usuarioIDs) {
                // Borrado físico protegido por el canal seguro
                eliminados += DAO.GenericDAO.delete(conn, "Usuario", "UsuarioID = ?", id);
            }

            conn.commit(); // Confirmamos la eliminación masiva
            return eliminados;

        } catch (Exception e) {
            if (conn != null) {
                try { conn.rollback(); } catch (Exception ex) {}
            }
            throw new Exception("Error al eliminar. Es posible que este usuario haya registrado transacciones de Entrada o Salida.");
        } finally {
            if (conn != null) {
                try { 
                    conn.setAutoCommit(true);
                    conn.close(); 
                } catch (Exception ex) {}
            }
        }
    }
    public java.util.List<java.util.Map<String, Object>> buscarUsuariosPorNombre(String username) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;
        try {
            conn = DB.getConnection();
            String sql = "SELECT UsuarioID, Username, RolID, Estado FROM Usuario WHERE Username LIKE ?";
            return DAO.GenericDAO.selectQuery(conn, sql, "%" + username + "%");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }

    // Método auxiliar para obtener el nombre de un rol específico
    public String obtenerNombreRol(int rolID) throws Exception {
        UTIL.dbBean DB = new UTIL.dbBean();
        java.sql.Connection conn = null;
        try {
            conn = DB.getConnection();
            java.util.List<java.util.Map<String, Object>> rol = 
                DAO.GenericDAO.select(conn, "Rol", "RolID = ?", rolID);
            
            if (!rol.isEmpty()) {
                return rol.get(0).get("NombreRol").toString();
            }
            return "";
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}