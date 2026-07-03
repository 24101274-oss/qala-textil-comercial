/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import DAO.GenericDAO;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMaterialLighterIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class buscarProveedorF extends javax.swing.JFrame {

    
    public buscarProveedorF() {
        initComponents();
        SetImageLabel(ie, "icons/buscarCliente.png");
        SetImageLabel(iconem, "icons/qt.png");
        SetImageLabel(iconlupa, "icons/phone.png");
        SetImageLabel(iconlupa, "icons/lupa.png");
        
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        llenarProveedores("");
        txtBusqProveedor.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textoCambiado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textoCambiado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }

            private void textoCambiado() {
                if (txtBusqProveedor.getText().equals("Ingrese nombre del Proveedor")) {
                    llenarProveedores("");
                } else {
                    llenarProveedores(txtBusqProveedor.getText());
                }
            }
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ie = new javax.swing.JLabel();
        iconem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        iconlupa = new javax.swing.JLabel();
        txtBusqProveedor = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("REGISTRAR PROVEEDOR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(ie, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
                .addGap(94, 94, 94)
                .addComponent(iconem, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));

        tablaEntrada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Proveedor", "Nombre", "Nombre Contacto", "Dirección", "Ciudad", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntrada.setRowHeight(25);
        tablaEntrada.setSelectionBackground(new java.awt.Color(250, 222, 182));
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaEntrada);

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel12.setText("BUSCAR");

        txtBusqProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusqProveedor.setForeground(java.awt.Color.lightGray);
        txtBusqProveedor.setText("Ingrese nombre del Proveedor");
        txtBusqProveedor.setBorder(null);
        txtBusqProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBusqProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBusqProveedorFocusLost(evt);
            }
        });
        txtBusqProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusqProveedorActionPerformed(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(iconlupa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusqProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jSeparator6)
                                .addGap(3, 3, 3)))
                        .addGap(636, 636, 636))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBusqProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconlupa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusqProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqProveedorActionPerformed

    private void txtBusqProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqProveedorFocusGained
        if (txtBusqProveedor.getText().equals("Ingrese nombre del Proveedor")) {
            txtBusqProveedor.setText("");
            txtBusqProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBusqProveedorFocusGained

    private void txtBusqProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqProveedorFocusLost
        if (txtBusqProveedor.getText().isEmpty()) {
            txtBusqProveedor.setText("Ingrese nombre del Proveedor");
            txtBusqProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtBusqProveedorFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMTMaterialLighterIJTheme.setup();
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new buscarProveedorF().setVisible(true);
            }
        });
    }
    private void SetImageLabel(JLabel labelName, String resourcePath) {
        // Cargar la imagen desde el classpath
        java.net.URL imgURL = getClass().getClassLoader().getResource(resourcePath);
        if (imgURL != null) {
            ImageIcon image = new ImageIcon(imgURL);
            // Escalar la imagen al tamaño del JLabel
            Icon icon = new ImageIcon(image.getImage().getScaledInstance(
                    labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH));
            labelName.setIcon(icon);
        } else {
            System.out.println("No se encontró el icono: " + resourcePath);
        }
        this.repaint();
    }

    private void personalizarHeader(JTable tabla, Color bgColor, Color fgColor, Font font) {

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {

                JLabel lbl = (JLabel) super.getTableCellRendererComponent(
                        table, value, isSelected, hasFocus, row, column);

                lbl.setOpaque(true);                      // obligatorio para fondo
                lbl.setBackground(bgColor);               // color de fondo
                lbl.setForeground(fgColor);               // color de texto
                if (font != null) lbl.setFont(font);      // fuente opcional
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
                return lbl;
            }
        };

        tabla.getTableHeader().setDefaultRenderer(headerRenderer);

        // Configuración adicional del header
        JTableHeader header = tabla.getTableHeader();
        header.setReorderingAllowed(false);
        header.setResizingAllowed(true);
    }
    
    private void llenarProveedores(String where) {
    try {
        // 1. Llamamos a la Fachada (Servicio)
        SERVICE.ProveedorService servicio = new SERVICE.ProveedorService();
        
        // 2. Obtenemos la lista segura
        java.util.List<Map<String, Object>> proveedores = servicio.buscarProveedoresPorNombre(where);
        
        // 3. Llenamos la tabla
        DAO.GenericDAO.llenarJTable(tablaEntrada, proveedores);
        
    } catch (Exception e) {
        // Si hay error en la base de datos, lo mostramos sin que se caiga el programa
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar proveedores: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
      }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconem;
    private javax.swing.JLabel iconlupa;
    private javax.swing.JLabel ie;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextField txtBusqProveedor;
    // End of variables declaration//GEN-END:variables
}
