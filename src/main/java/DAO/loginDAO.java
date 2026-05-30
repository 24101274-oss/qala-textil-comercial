package DAO;

import UTIL.dbBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class loginDAO {

    public loginDAO() {
    }

    public static boolean consultaLogin(String username, String passwordPlano) {
        dbBean con = new dbBean();
        boolean valido = false;

        try {
            String sql = """
                SELECT Password
                FROM Usuario
                WHERE Username = ? AND Estado = 1
            """;

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String hashGuardado = rs.getString("Password");

                // Comparación segura con BCrypt
                valido = BCrypt.checkpw(passwordPlano, hashGuardado);
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

        return valido;
    }
}
