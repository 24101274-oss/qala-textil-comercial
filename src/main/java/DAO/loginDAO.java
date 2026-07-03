package DAO;

import BEAN.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {

    // Variable global de conexión
    private Connection conn;

    // CONSTRUCTOR: Recibe la conexión desde la Fábrica
    public loginDAO(Connection conn) {
        this.conn = conn;
    }

    // MÉTODO REFACTORIZADO (Ya no es static)
    public Usuario validarAcceso(String username) throws Exception {
        Usuario user = null;
        
        String sql = """
            SELECT UsuarioID, Username, Password, RolID, Estado
            FROM Usuario
            WHERE Username = ? AND Estado = 1
        """;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    user = new Usuario();
                    user.setUsuarioID(rs.getInt("UsuarioID"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password")); 
                    user.setRolID(rs.getInt("RolID"));
                    user.setEstado(rs.getInt("Estado"));
                }
            }
        } catch (SQLException e) {
            throw new Exception("Error en la validación de login: " + e.getMessage());
        }
        
        return user;
    }
}