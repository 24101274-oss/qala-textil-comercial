package DAO;

import BEAN.Usuario;
import UTIL.dbBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class usuarioDAO {

    public usuarioDAO() {
    }

    static public Vector<Usuario> consultarPorUsername(String usu) {
        dbBean con = new dbBean();
        Vector<Usuario> usuarios = new Vector<>();

        try {
            String sql = """
                SELECT UsuarioID, Username, Password, RolID, Estado
                FROM Usuario
                WHERE Username = ? AND Estado = 1
            """;

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, usu);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setUsuarioID(rs.getInt("UsuarioID"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password")); // hash
                user.setRolID(rs.getInt("RolID"));
                user.setEstado(rs.getInt("Estado"));
                usuarios.add(user);
            }

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return usuarios;
    }
}
