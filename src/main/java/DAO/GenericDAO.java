package DAO;

import UTIL.dbBean;
import java.sql.*;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.util.StringJoiner;
public class GenericDAO {

    public static List<Map<String, Object>> selectQuery(Connection conn, String sql, Object... params) throws Exception {
        List<Map<String, Object>> rows = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            try (ResultSet rs = ps.executeQuery()) {
                java.sql.ResultSetMetaData meta = rs.getMetaData();
                int cols = meta.getColumnCount();
                while (rs.next()) {
                    Map<String, Object> row = new LinkedHashMap<>();
                    for (int i = 1; i <= cols; i++) {
                        row.put(meta.getColumnLabel(i), rs.getObject(i));
                    }
                    rows.add(row);
                }
            }
        }
        return rows;
    }
    
    public static List<Map<String, Object>> select(Connection conn, String table, String condition, Object... params) throws Exception {
        String sql = "SELECT * FROM " + table + (condition != null && !condition.isEmpty() ? " WHERE " + condition : "");
        return selectQuery(conn, sql, params);
    }

    public static int insert(Connection conn, String table, Map<String, Object> data) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(table).append(" (");
        StringBuilder placeholders = new StringBuilder();
        
        int i = 0;
        for (String key : data.keySet()) {
            sql.append(key);
            placeholders.append("?");
            if (i < data.size() - 1) {
                sql.append(", ");
                placeholders.append(", ");
            }
            i++;
        }
        sql.append(") VALUES (").append(placeholders).append(")");

        try (PreparedStatement ps = conn.prepareStatement(sql.toString())) {
            int index = 1;
            for (Object value : data.values()) {
                ps.setObject(index++, value);
            }
            return ps.executeUpdate();
        }
    }

    public static int update(Connection conn, String table, Map<String, Object> data, String whereClause, Object... whereParams) throws Exception {
        java.util.StringJoiner set = new java.util.StringJoiner(", ");
        
        for (String col : data.keySet()) {
            set.add(col + " = ?");
        }

        String sql = "UPDATE " + table +
                     " SET " + set +
                     " WHERE " + whereClause;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int i = 1;

            // Valores del SET (los nuevos datos)
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            // Valores del WHERE (las condiciones)
            for (Object param : whereParams) {
                ps.setObject(i++, param);
            }

            return ps.executeUpdate();
        }
    }
    
    public static int delete(Connection conn, String table, String whereClause, Object... params) throws Exception {
        String sql = "DELETE FROM " + table + " WHERE " + whereClause;

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            return ps.executeUpdate();
        } 
        // Ya no capturamos la excepción aquí ni cerramos la conexión en el 'finally', 
        // de eso se encarga ahora el bloque 'finally' de tu clase Service.
    }
    
    public static void llenarComboDesdeTabla(
            JComboBox<String> combo,
            List<Map<String, Object>> datos,
            String columna
    ) {
        combo.removeAllItems();

        if (datos == null || datos.isEmpty()) {
            return;
        }

        for (Map<String, Object> fila : datos) {
            Object valor = fila.get(columna);
            if (valor != null) {
                combo.addItem(valor.toString());
            }
        }
    }
    
    public static void llenarJTable(
            JTable table,
            List<Map<String, Object>> datos
    ) {

        if (datos == null || datos.isEmpty()) {
            table.setModel(new DefaultTableModel());
            return;
        }

        List<String> columnas = new ArrayList<>(datos.get(0).keySet());

        DefaultTableModel model = new DefaultTableModel(
                columnas.toArray(),
                0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Map<String, Object> fila : datos) {
            Object[] row = new Object[columnas.size()];
            for (int i = 0; i < columnas.size(); i++) {
                row[i] = fila.get(columnas.get(i));
            }
            model.addRow(row);
        }

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        table.getTableHeader().setReorderingAllowed(false);

        ajustarAnchoColumnas(table);
    }
    
    private static void ajustarAnchoColumnas(JTable table) {

        for (int col = 0; col < table.getColumnCount(); col++) {

            TableColumn column = table.getColumnModel().getColumn(col);
            int maxWidth = 0;

            TableCellRenderer headerRenderer = table.getTableHeader().getDefaultRenderer();
            Component headerComp = headerRenderer.getTableCellRendererComponent(
                    table,
                    column.getHeaderValue(),
                    false,
                    false,
                    -1,
                    col
            );
            maxWidth = headerComp.getPreferredSize().width;

            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer cellRenderer = table.getCellRenderer(row, col);
                Component cellComp = table.prepareRenderer(cellRenderer, row, col);
                maxWidth = Math.max(maxWidth, cellComp.getPreferredSize().width);
            }

            maxWidth += 10;

            column.setPreferredWidth(maxWidth);
        }
    }
    
    public static int insertAndReturnID(Connection conn, String table, Map<String, Object> data) throws Exception {
        StringBuilder sql = new StringBuilder("INSERT INTO ").append(table).append(" (");
        StringBuilder placeholders = new StringBuilder();
        
        int i = 0;
        for (String key : data.keySet()) {
            sql.append(key);
            placeholders.append("?");
            if (i < data.size() - 1) {
                sql.append(", ");
                placeholders.append(", ");
            }
            i++;
        }
        sql.append(") VALUES (").append(placeholders).append(")");

        // Usamos Statement.RETURN_GENERATED_KEYS de forma segura
        try (PreparedStatement ps = conn.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
            int index = 1;
            for (Object value : data.values()) {
                ps.setObject(index++, value);
            }
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        }
        return -1;
    }
    
}
