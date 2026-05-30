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

public class GenericDAO {

    public static List<Map<String, Object>> select(
            String table,
            String whereClause,
            Object... params
    ) {

        dbBean con = new dbBean();
        List<Map<String, Object>> rows = new ArrayList<>();

        String sql = "SELECT * FROM " + table;
        if (whereClause != null && !whereClause.isBlank()) {
            sql += " WHERE " + whereClause;
        }

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new java.util.LinkedHashMap<>();

                for (int i = 1; i <= cols; i++) {
                    row.put(meta.getColumnLabel(i), rs.getObject(i));
                }

                rows.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return rows;
    }
    
    public static List<Map<String, Object>> selectQuery(
            String sql,
            Object... params
    ) {

        dbBean con = new dbBean();
        List<Map<String, Object>> rows = new ArrayList<>();

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= cols; i++) {
                    row.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                rows.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) {}
        }

        return rows;
    }

    public static int insert(
            String table,
            Map<String, Object> data
    ) {

        dbBean con = new dbBean();
        int rows = 0;

        StringJoiner cols = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        for (String col : data.keySet()) {
            cols.add(col);
            vals.add("?");
        }

        String sql = "INSERT INTO " + table +
                     " (" + cols + ") VALUES (" + vals + ")";

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {

            int i = 1;
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            rows = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return rows;
    }

    public static int update(
            String table,
            Map<String, Object> data,
            String whereClause,
            Object... whereParams
    ) {

        dbBean con = new dbBean();
        int rows = 0;

        StringJoiner set = new StringJoiner(", ");
        for (String col : data.keySet()) {
            set.add(col + " = ?");
        }

        String sql = "UPDATE " + table +
                     " SET " + set +
                     " WHERE " + whereClause;

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {

            int i = 1;

            // valores del SET
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            // valores del WHERE
            for (Object param : whereParams) {
                ps.setObject(i++, param);
            }

            rows = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return rows;
    }
    
    public static int delete(
            String table,
            String whereClause,
            Object... params
    ) {

        dbBean con = new dbBean();
        int rows = 0;

        String sql = "DELETE FROM " + table + " WHERE " + whereClause;

        try (PreparedStatement ps = con.getConnection().prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            rows = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { con.close(); } catch (SQLException e) {}
        }

        return rows;
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
    
    public static int insertAndReturnID(
            String table,
            Map<String, Object> data
    ) {

        dbBean con = new dbBean();
        int generatedId = -1;

        StringJoiner cols = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        for (String col : data.keySet()) {
            cols.add(col);
            vals.add("?");
        }

        String sql =
            "INSERT INTO " + table +
            " (" + cols + ") VALUES (" + vals + "); " +
            "SELECT CAST(SCOPE_IDENTITY() AS INT)";

        try (PreparedStatement ps =
                con.getConnection().prepareStatement(sql)) {

            int i = 1;
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
            }
        }

        return generatedId;
    }
    
    public static List<Map<String, Object>> select(
            Connection conn,
            String table,
            String whereClause,
            Object... params
    ) {

        List<Map<String, Object>> rows = new ArrayList<>();

        String sql = "SELECT * FROM " + table;
        if (whereClause != null && !whereClause.isBlank()) {
            sql += " WHERE " + whereClause;
        }

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }

            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            int cols = meta.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new LinkedHashMap<>();
                for (int i = 1; i <= cols; i++) {
                    row.put(meta.getColumnLabel(i), rs.getObject(i));
                }
                rows.add(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }
    
    public static int insertAndReturnID(
            Connection conn,
            String table,
            Map<String, Object> data
    ) {

        int generatedId = -1;

        StringJoiner cols = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        for (String col : data.keySet()) {
            cols.add(col);
            vals.add("?");
        }

        String sql =
            "INSERT INTO " + table +
            " (" + cols + ") VALUES (" + vals + ")";

        try (PreparedStatement ps =
                conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            int i = 1;
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return generatedId;
    }
    
    public static int insert(
            Connection conn,
            String table,
            Map<String, Object> data
    ) {

        int rows = 0;

        StringJoiner cols = new StringJoiner(", ");
        StringJoiner vals = new StringJoiner(", ");

        for (String col : data.keySet()) {
            cols.add(col);
            vals.add("?");
        }

        String sql =
            "INSERT INTO " + table +
            " (" + cols + ") VALUES (" + vals + ")";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            int i = 1;
            for (Object val : data.values()) {
                ps.setObject(i++, val);
            }

            rows = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rows;
    }
}
