package DAO;

import java.sql.Connection;

public class DAOFactory {

    private static DAOFactory instancia;

    private DAOFactory() {
    }

    public static DAOFactory getInstancia() {
        if (instancia == null) {
            instancia = new DAOFactory();
        }
        return instancia;
    }

    public GenericDAO getGenericDAO() {
        return new GenericDAO();
    }
    
    public usuarioDAO getUsuarioDAO(Connection conn) {
        return new usuarioDAO(conn); 
    }
    
    public loginDAO getLoginDAO(Connection conn) {
        return new loginDAO(conn);
    }
}