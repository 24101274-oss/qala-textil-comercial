package UTIL;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.io.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class dbBean {

    private Connection dbCon;
    private String dbURL;
    private String Login;
    private String password;

    public dbBean() {
        loadConfig();
        connect();
    }

    /**
     * Carga la configuración desde db.properties
     * Primero busca en la raíz, si falla busca en dist/
     */
    private void loadConfig() {
        Properties prop = new Properties();
        String[] paths = {"db.properties", "dist/db.properties"};

        boolean loaded = false;
        for (String path : paths) {
            try (InputStream input = new FileInputStream(path)) {
                prop.load(input);
                loaded = true;
                break;
            } catch (IOException e) {
                // archivo no encontrado, intenta siguiente path
            }
        }

        if (!loaded) {
            System.err.println("No se encontró db.properties. Se usarán valores por defecto.");
            this.dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QalaTextil;encrypt=false;trustServerCertificate=true";
            this.Login = "sa";
            this.password = "123456789";
            return;
        }

        String host = prop.getProperty("db.host", "localhost");
        String port = prop.getProperty("db.port", "1433");
        String dbName = prop.getProperty("db.name", "QalaTextil");
        this.Login = prop.getProperty("db.user", "sa");
        this.password = prop.getProperty("db.password", "123456789");

        this.dbURL = String.format(
            "jdbc:sqlserver://%s:%s;databaseName=%s;encrypt=false;trustServerCertificate=true",
            host, port, dbName
        );
    }

    public boolean connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("No se encuentra el driver JDBC de SQL Server");
            return false;
        }

        try {
            dbCon = DriverManager.getConnection(this.dbURL, this.Login, this.password);
        } catch (SQLException ex) {
            System.err.println("No se puede conectar al servidor: " + ex.getMessage());
            return false;
        }

        return true;
    }

    public void connectRep(String ruta, HashMap<String, Object> m, boolean sw) throws SQLException, JRException {
        connect();
        JasperReport reporte = (JasperReport) JRLoader.loadObjectFromFile(ruta);
        JasperPrint imp = (sw) ? JasperFillManager.fillReport(reporte, m, dbCon)
                               : JasperFillManager.fillReport(reporte, null, dbCon);
        JasperViewer ver = new JasperViewer(imp);
        ver.setTitle("Reporte");
        ver.setVisible(true);
    }

    public void close() throws SQLException {
        if (dbCon != null && !dbCon.isClosed()) {
            dbCon.close();
        }
    }

    public ResultSet execSQL(String sql) throws SQLException {
        Statement s = dbCon.createStatement();
        return s.executeQuery(sql);
    }

    public int updateSQL(String sql) throws SQLException {
        Statement s = dbCon.createStatement();
        return s.executeUpdate(sql);
    }
    
    public Connection getConnection() {
        return dbCon;
    }
}
