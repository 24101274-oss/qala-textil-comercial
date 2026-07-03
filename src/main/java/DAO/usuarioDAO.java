package DAO;

import BEAN.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class usuarioDAO {

    // Variable global para almacenar la conexión inyectada
    private Connection conn;

    // CONSTRUCTOR: Obliga a recibir la conexión desde la Fábrica
    public usuarioDAO(Connection conn) {
        this.conn = conn;
    }

    // MÉTODO REFACTORIZADO (Ya no es static)
    public Vector<Usuario> consultarPorUsername(String usu) throws Exception {
        Vector<Usuario> usuarios = new Vector<>();

        String sql = """
            SELECT UsuarioID, Username, Password, RolID, Estado
            FROM Usuario
            WHERE Username = ? AND Estado = 1
        """;

        // Usamos try-with-resources para el PreparedStatement y ResultSet (se cierran solos)
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, usu);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Usuario user = new Usuario();
                    user.setUsuarioID(rs.getInt("UsuarioID"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getString("Password")); // hash
                    user.setRolID(rs.getInt("RolID"));
                    user.setEstado(rs.getInt("Estado"));
                    usuarios.add(user);
                }
            }
        } catch (SQLException e) {
            // Mandamos el error a la capa superior
            throw new Exception("Error al consultar usuario: " + e.getMessage());
        } 
        // ¡OJO! Ya no hay bloque "finally" aquí para cerrar la conexión.

        return usuarios;
    }
}