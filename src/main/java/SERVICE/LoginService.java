package SERVICE;

import UTIL.dbBean;
import DAO.GenericDAO;
import BEAN.Usuario;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import org.mindrot.jbcrypt.BCrypt;

public class LoginService {
    
    public Usuario autenticar(String username, String passwordPlano) throws Exception {
        dbBean DB = new dbBean();
        Connection conn = null;
        
        try {
            // 1. Abrimos la conexión
            conn = DB.getConnection();
            
            // 2. Buscamos al usuario en la base de datos
            List<Map<String, Object>> resultado = GenericDAO.select(conn, "Usuario", "Username = ?", username);
            
            if (resultado.isEmpty()) {
                throw new Exception("El usuario no existe");
            }
            
            Map<String, Object> userData = resultado.get(0);
            
            // 3. CORRECCIÓN: Manejo seguro del campo BIT (Estado)
            // SQL Server devuelve "true" o "false", lo mapeamos a 1 y 0.
            int estado = 0;
            String estadoStr = userData.get("Estado").toString().toLowerCase();
            if (estadoStr.equals("true") || estadoStr.equals("1")) {
                estado = 1;
            }
            
            if (estado == 0) {
                throw new Exception("El usuario está inactivo. Contacte al administrador.");
            }
            
            // 4. Comparamos la contraseña
            String hashBD = userData.get("Password").toString();
            if (!BCrypt.checkpw(passwordPlano, hashBD)) {
                throw new Exception("Contraseña incorrecta");
            }
            
            // 5. Construimos el usuario
            Usuario u = new Usuario();
            u.setUsuarioID(Integer.parseInt(userData.get("UsuarioID").toString()));
            u.setUsername(userData.get("Username").toString());
            u.setRolID(Integer.parseInt(userData.get("RolID").toString()));
            u.setEstado(estado);
            
            return u;
            
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}