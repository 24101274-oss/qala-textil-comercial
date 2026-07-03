/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package UI;
import BEAN.MaxLengthFilter;
import BEAN.PriceFilter;
import DAO.GenericDAO;
import UTIL.DocumentFlags;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import java.util.*;
import BEAN.Usuario;


public class registrarMaterialF extends javax.swing.JFrame {
    Usuario user;
    
    public registrarMaterialF() {
        initComponents();
        SetImageLabel(ie, "icons/buscarCliente.png");
        SetImageLabel(iconem, "icons/qt.png");
        
        SetImageLabel(iconCancelar, "icons/x.png");
        SetImageLabel(actualizar, "icons/actualizar.png");
        SetImageLabel(iconGuardar, "icons/check.png");
        SetImageLabel(iconEliminar, "icons/trash.png");
        
        SetImageLabel(iconlupa, "icons/phone.png");
        
        
        SetImageLabel(iconlupa, "icons/lupa.png");
        
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        
        ((AbstractDocument) txtCodMaterial.getDocument())
                .setDocumentFilter(new MaxLengthFilter(50));
        
        ((AbstractDocument) txtnombMaterial.getDocument())
                .setDocumentFilter(new MaxLengthFilter(100));
        
        ((AbstractDocument) txtDescMaterial.getDocument())
                .setDocumentFilter(new MaxLengthFilter(200));
        
        
        ((AbstractDocument) txtPrecioMaterial.getDocument())
                .setDocumentFilter(new PriceFilter());

        
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        
        llenarMateriales("");
        configurarSeleccionTabla();
        llenarCmbCategoria();
        
        txtBusqMaterial.getDocument().addDocumentListener(new DocumentListener() {
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
                if (txtBusqMaterial.getText().equals("Ingrese nombre del Material")) {
                    llenarMateriales("");
                } else {
                    llenarMateriales(txtBusqMaterial.getText());
                }
            }
        });
    }
    public void setUsuario(Usuario u) {
        user = u;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ie = new javax.swing.JLabel();
        iconem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPrecioMaterial = new javax.swing.JTextField();
        txtCodMaterial = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        txtDescMaterial = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtnombMaterial = new javax.swing.JTextField();
        cmbCatMaterial = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbUndMaterial = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        iconlupa = new javax.swing.JLabel();
        txtBusqMaterial = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        panelRound10 = new Clases.PanelRound();
        iconEliminar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        panelRound12 = new Clases.PanelRound();
        iconGuardar = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        iconCancelar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        panelRound14 = new Clases.PanelRound();
        actualizar = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1880, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(1880, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(ie, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 100, 80));
        jPanel2.add(iconem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 0, 110, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Material");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, 60));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 1880, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("PRECIO");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 35));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("MATERIAL");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setText("DESCRIPCIÓN");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 110, 35));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("CATEGORÍA");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setText("LECTURA DE BARRA");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 35));

        txtPrecioMaterial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtPrecioMaterial.setForeground(java.awt.Color.lightGray);
        txtPrecioMaterial.setText("Ingrese Precio por Unidad");
        txtPrecioMaterial.setBorder(null);
        txtPrecioMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioMaterialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioMaterialFocusLost(evt);
            }
        });
        txtPrecioMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioMaterialActionPerformed(evt);
            }
        });
        txtPrecioMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioMaterialKeyPressed(evt);
            }
        });
        jPanel3.add(txtPrecioMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 300, 30));

        txtCodMaterial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCodMaterial.setForeground(java.awt.Color.lightGray);
        txtCodMaterial.setText("Código de Barra");
        txtCodMaterial.setBorder(null);
        txtCodMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodMaterialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodMaterialFocusLost(evt);
            }
        });
        txtCodMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodMaterialActionPerformed(evt);
            }
        });
        txtCodMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodMaterialKeyPressed(evt);
            }
        });
        jPanel3.add(txtCodMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 300, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 310, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 310, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 310, 30));

        txtDescMaterial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDescMaterial.setForeground(java.awt.Color.lightGray);
        txtDescMaterial.setText("Ingrese Descripción del Material");
        txtDescMaterial.setBorder(null);
        txtDescMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescMaterialFocusGained1(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescMaterialFocusLost1(evt);
            }
        });
        txtDescMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescMaterialActionPerformed(evt);
            }
        });
        txtDescMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescMaterialKeyPressed(evt);
            }
        });
        jPanel3.add(txtDescMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 310, 50));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 310, 30));

        txtnombMaterial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtnombMaterial.setForeground(java.awt.Color.lightGray);
        txtnombMaterial.setText("Ingrese nombre del Material");
        txtnombMaterial.setBorder(null);
        txtnombMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombMaterialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombMaterialFocusLost(evt);
            }
        });
        txtnombMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombMaterialActionPerformed(evt);
            }
        });
        txtnombMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombMaterialKeyPressed(evt);
            }
        });
        jPanel3.add(txtnombMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 300, 30));

        cmbCatMaterial.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        cmbCatMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hilo", "Tela", " " }));
        cmbCatMaterial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        cmbCatMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbCatMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCatMaterialActionPerformed(evt);
            }
        });
        jPanel3.add(cmbCatMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 160, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("UNIDAD DE MEDIDA");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, 35));

        cmbUndMaterial.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        cmbUndMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conos", "Kilogramos", "Metros" }));
        cmbUndMaterial.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        cmbUndMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbUndMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUndMaterialActionPerformed(evt);
            }
        });
        jPanel3.add(cmbUndMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 160, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 540, 510));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEntrada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Material", "Código", "Nombre ", "Descripción", "Unidad Medida", "Precio", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntrada.setRowHeight(25);
        tablaEntrada.setSelectionBackground(new java.awt.Color(250, 222, 182));
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaEntrada);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1000, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel12.setText("BUSCAR");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 35));
        jPanel5.add(iconlupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 30));

        txtBusqMaterial.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusqMaterial.setForeground(java.awt.Color.lightGray);
        txtBusqMaterial.setText("Ingrese nombre del Material");
        txtBusqMaterial.setBorder(null);
        txtBusqMaterial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBusqMaterialFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBusqMaterialFocusLost(evt);
            }
        });
        txtBusqMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusqMaterialActionPerformed(evt);
            }
        });
        txtBusqMaterial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusqMaterialKeyPressed(evt);
            }
        });
        jPanel5.add(txtBusqMaterial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 300, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 310, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 1080, 350));

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound10.add(iconEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnEliminar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("Eliminar ");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        panelRound10.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 580, 150, -1));

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound12.add(iconGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnRegistrar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setText("Registrar ");
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMouseExited(evt);
            }
        });
        panelRound12.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        jPanel1.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 160, -1));

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound13.add(iconCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 20, 20));

        btnCancelar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelarMouseExited(evt);
            }
        });
        panelRound13.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 40));

        jPanel1.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1600, 580, 160, 40));

        panelRound14.setBackground(new java.awt.Color(255, 187, 92));
        panelRound14.setRoundBottomLeft(15);
        panelRound14.setRoundBottomRight(15);
        panelRound14.setRoundTopLeft(15);
        panelRound14.setRoundTopRight(15);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound14.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnActualizar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActualizar.setText("Actualizar ");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        panelRound14.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel1.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 580, 150, -1));

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1876, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodMaterialActionPerformed

    private void txtCodMaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodMaterialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodMaterialKeyPressed

    private void txtBusqMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqMaterialActionPerformed

    private void txtBusqMaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqMaterialKeyPressed
        
    }//GEN-LAST:event_txtBusqMaterialKeyPressed

    private void txtDescMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescMaterialActionPerformed

    private void txtDescMaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescMaterialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescMaterialKeyPressed

    private void txtnombMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombMaterialActionPerformed

    private void txtnombMaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombMaterialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombMaterialKeyPressed

    private void cmbCatMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCatMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCatMaterialActionPerformed

    private void txtPrecioMaterialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioMaterialKeyPressed
        
    }//GEN-LAST:event_txtPrecioMaterialKeyPressed

    private void txtPrecioMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioMaterialActionPerformed

    private void cmbUndMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUndMaterialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUndMaterialActionPerformed

    private void btnRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnRegistrarMouseEntered

    private void btnRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseExited
        panelRound12.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnRegistrarMouseExited

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        panelRound14.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        panelRound14.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        panelRound10.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        panelRound13.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtCodMaterialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMaterialFocusGained
        if (txtCodMaterial.getText().equals("Código de Barra")) {
            txtCodMaterial.setText("");
            txtCodMaterial.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCodMaterialFocusGained

    private void txtCodMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodMaterialFocusLost
        if (txtCodMaterial.getText().isEmpty()) {
            txtCodMaterial.setText("Código de Barra");
            txtCodMaterial.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtCodMaterialFocusLost

    private void txtnombMaterialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombMaterialFocusGained
        if (txtnombMaterial.getText().equals("Ingrese nombre del Material")) {
            txtnombMaterial.setText("");
            txtnombMaterial.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtnombMaterialFocusGained

    private void txtnombMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombMaterialFocusLost
        if (txtnombMaterial.getText().isEmpty()) {
            txtnombMaterial.setText("Ingrese nombre del Material");
            txtnombMaterial.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtnombMaterialFocusLost

    private void txtDescMaterialFocusGained1(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescMaterialFocusGained1
        if (txtDescMaterial.getText().equals("Ingrese Descripción del Material")) {
            txtDescMaterial.setText("");
            txtDescMaterial.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDescMaterialFocusGained1

    private void txtDescMaterialFocusLost1(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescMaterialFocusLost1
        if (txtDescMaterial.getText().isEmpty()) {
            txtDescMaterial.setText("Ingrese Descripción del Material");
            txtDescMaterial.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtDescMaterialFocusLost1

    private void txtPrecioMaterialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioMaterialFocusGained
        if (txtPrecioMaterial.getText().equals("Ingrese Precio por Unidad")) {
            setTextProgrammatically(txtPrecioMaterial, "");
            txtPrecioMaterial.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioMaterialFocusGained

    private void txtPrecioMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioMaterialFocusLost
        if (txtPrecioMaterial.getText().isEmpty()) {
            setTextProgrammatically(txtPrecioMaterial, "Ingrese Precio por Unidad");
            txtPrecioMaterial.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtPrecioMaterialFocusLost

    private void txtBusqMaterialFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqMaterialFocusGained
        if (txtBusqMaterial.getText().equals("Ingrese nombre del Material")) {
            txtBusqMaterial.setText("");
            txtBusqMaterial.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBusqMaterialFocusGained

    private void txtBusqMaterialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqMaterialFocusLost
        if (txtBusqMaterial.getText().isEmpty()) {
            txtBusqMaterial.setText("Ingrese nombre del Material");
            txtBusqMaterial.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtBusqMaterialFocusLost

    private void btnRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMouseClicked
        String codigoBarra = txtCodMaterial.getText().trim();
    String nombre      = txtnombMaterial.getText().trim();
    String descripcion = txtDescMaterial.getText().trim();
    String precioStr   = txtPrecioMaterial.getText().trim();

    String unidad      = (String) cmbUndMaterial.getSelectedItem();
    String categoria   = (String) cmbCatMaterial.getSelectedItem();

    if (codigoBarra.isEmpty() || codigoBarra.equals("Código de Barra")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El código de barra es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtCodMaterial.requestFocus(); return;
    }
    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Material")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del material es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombMaterial.requestFocus(); return;
    }
    if (descripcion.isEmpty() || descripcion.equals("Ingrese Descripción del Material")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La descripción del material es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtDescMaterial.requestFocus(); return;
    }
    if (precioStr.isEmpty() || precioStr.equals("Ingrese Precio por Unidad")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El precio por unidad es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtPrecioMaterial.requestFocus(); return;
    }

    double precio;
    try {
        precio = Double.parseDouble(precioStr);
        if (precio <= 0) throw new NumberFormatException();
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "El precio debe ser un número válido mayor a cero", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtPrecioMaterial.requestFocus(); return;
    }

    if (unidad == null || unidad.trim().isEmpty() || categoria == null || categoria.trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una unidad y una categoría", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        servicio.registrarMaterial(codigoBarra, nombre, descripcion, unidad, precio, categoria);

        javax.swing.JOptionPane.showMessageDialog(this, "Material registrado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtBusqMaterial.getText().equals("Ingrese nombre del Material")) {
            llenarMateriales("");
        } else {
            llenarMateriales(txtBusqMaterial.getText());
        }

    } catch (Exception e) {
        String titulo = e.getMessage().contains("Ya existe") ? "Duplicado" : "Error";
        int tipoIcono = e.getMessage().contains("Ya existe") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
    }
    }//GEN-LAST:event_btnRegistrarMouseClicked

    private void btnActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseClicked
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden actualizar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un material para modificar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (filas.length > 1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione solo un material para modificar", "Selección inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int fila = filas[0];
    Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("MaterialID"));
    
    if (idObj == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo obtener el ID del material", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    int materialID = Integer.parseInt(idObj.toString());

    String codigoBarra = txtCodMaterial.getText().trim();
    String nombre      = txtnombMaterial.getText().trim();
    String descripcion = txtDescMaterial.getText().trim();
    String precioStr   = txtPrecioMaterial.getText().trim();
    String unidad    = (String) cmbUndMaterial.getSelectedItem();
    String categoria = (String) cmbCatMaterial.getSelectedItem();

    
    if (codigoBarra.isEmpty() || codigoBarra.equals("Código de Barra")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El código de barra es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtCodMaterial.requestFocus(); return;
    }
    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Material")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del material es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombMaterial.requestFocus(); return;
    }
    if (descripcion.isEmpty() || descripcion.equals("Ingrese Descripción del Material")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La descripción del material es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtDescMaterial.requestFocus(); return;
    }
    if (precioStr.isEmpty() || precioStr.equals("Ingrese Precio por Unidad")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El precio por unidad es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtPrecioMaterial.requestFocus(); return;
    }

    double precio;
    try {
        precio = Double.parseDouble(precioStr);
        if (precio <= 0) throw new NumberFormatException();
    } catch (NumberFormatException ex) {
        javax.swing.JOptionPane.showMessageDialog(this, "El precio debe ser un número válido mayor a cero", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtPrecioMaterial.requestFocus(); return;
    }

    if (unidad == null || unidad.trim().isEmpty() || categoria == null || categoria.trim().isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar una unidad y una categoría", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

   
    try {
        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        servicio.actualizarMaterial(materialID, codigoBarra, nombre, descripcion, unidad, precio, categoria);

        
        javax.swing.JOptionPane.showMessageDialog(this, "Material actualizado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtBusqMaterial.getText().equals("Ingrese nombre del Material")) {
            llenarMateriales("");
        } else {
            llenarMateriales(txtBusqMaterial.getText());
        }
        
    } catch (Exception e) {
        String titulo = e.getMessage().contains("Ya existe") ? "Duplicado" : "Error";
        int tipoIcono = e.getMessage().contains("Ya existe") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
    }
    }//GEN-LAST:event_btnActualizarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
  
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden eliminar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un material para eliminar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el(los) material(es) seleccionado(s)?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
    
    if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    try {
        java.util.List<Integer> idsAEliminar = new java.util.ArrayList<>();
        for (int fila : filas) {
            Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("MaterialID"));
            if (idObj != null) {
                idsAEliminar.add(Integer.parseInt(idObj.toString()));
            }
        }

        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        int eliminados = servicio.eliminarMateriales(idsAEliminar);


        javax.swing.JOptionPane.showMessageDialog(this, eliminados + " material(es) eliminado(s)", "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtBusqMaterial.getText().equals("Ingrese nombre del Material")) {
            llenarMateriales("");
        } else {
            llenarMateriales(txtBusqMaterial.getText());
        }

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

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
                new registrarMaterialF().setVisible(true);
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
    
    private void llenarMateriales(String where) {
    try {
        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        java.util.List<Map<String, Object>> materiales = servicio.buscarMaterialesConCategoria(where);
        
        DAO.GenericDAO.llenarJTable(tablaEntrada, materiales);
        
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar materiales: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    private void configurarSeleccionTabla() {

        tablaEntrada.getSelectionModel().addListSelectionListener(e -> {

            if (e.getValueIsAdjusting()) {
                return;
            }

            int[] filasSeleccionadas = tablaEntrada.getSelectedRows();

            if (filasSeleccionadas.length == 0) {
                return;
            }

            int fila = filasSeleccionadas[filasSeleccionadas.length - 1];

            txtCodMaterial.setText(
                String.valueOf(
                    tablaEntrada.getValueAt(
                        fila,
                        tablaEntrada.getColumnModel()
                            .getColumnIndex("CodigoBarra")
                    )
                )
            );
            txtCodMaterial.setForeground(Color.black);

            txtnombMaterial.setText(
                String.valueOf(
                    tablaEntrada.getValueAt(
                        fila,
                        tablaEntrada.getColumnModel()
                            .getColumnIndex("Nombre")
                    )
                )
            );
            txtnombMaterial.setForeground(Color.black);

            txtDescMaterial.setText(
                String.valueOf(
                    tablaEntrada.getValueAt(
                        fila,
                        tablaEntrada.getColumnModel()
                            .getColumnIndex("Descripcion")
                    )
                )
            );
            txtDescMaterial.setForeground(Color.black);

            txtPrecioMaterial.setText(
                String.valueOf(
                    tablaEntrada.getValueAt(
                        fila,
                        tablaEntrada.getColumnModel()
                            .getColumnIndex("Precio")
                    )
                )
            );
            txtPrecioMaterial.setForeground(Color.black);

            String unidad = String.valueOf(
                tablaEntrada.getValueAt(
                    fila,
                    tablaEntrada.getColumnModel()
                        .getColumnIndex("UnidadMedida")
                )
            );
            cmbUndMaterial.setSelectedItem(unidad);

            String categoria = String.valueOf(
                tablaEntrada.getValueAt(
                    fila,
                    tablaEntrada.getColumnModel()
                        .getColumnIndex("NombreCategoria")
                )
            );
            cmbCatMaterial.setSelectedItem(categoria);
        });
    }
    
    private void limpiarCampos() {
        txtCodMaterial.setText("Código de Barra");
        txtCodMaterial.setForeground(Color.lightGray);
        txtnombMaterial.setText("Ingrese nombre del Material");
        txtnombMaterial.setForeground(Color.lightGray);
        txtDescMaterial.setText("Ingrese Descripción del Material");
        txtDescMaterial.setForeground(Color.lightGray);
        setTextProgrammatically(txtPrecioMaterial, "Ingrese Precio por Unidad");
        txtPrecioMaterial.setForeground(Color.lightGray);
    }
    
    public static void setTextProgrammatically(JTextField field, String text) {
        AbstractDocument doc = (AbstractDocument) field.getDocument();
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, true);
        field.setText(text);
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, false);
    }
    
    private void llenarCmbCategoria() {
    try {
        SERVICE.CategoriaService servicio = new SERVICE.CategoriaService();
        java.util.List<Map<String, Object>> categorias = servicio.obtenerTodasCategorias();
        
        DAO.GenericDAO.llenarComboDesdeTabla(cmbCatMaterial, categorias, "NombreCategoria");
        
    } catch (Exception e) {
        System.out.println("Error al cargar categorías: " + e.getMessage());
    }
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualizar;
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnRegistrar;
    private javax.swing.JComboBox<String> cmbCatMaterial;
    private javax.swing.JComboBox<String> cmbUndMaterial;
    private javax.swing.JLabel iconCancelar;
    private javax.swing.JLabel iconEliminar;
    private javax.swing.JLabel iconGuardar;
    private javax.swing.JLabel iconem;
    private javax.swing.JLabel iconlupa;
    private javax.swing.JLabel ie;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound12;
    private Clases.PanelRound panelRound13;
    private Clases.PanelRound panelRound14;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextField txtBusqMaterial;
    private javax.swing.JTextField txtCodMaterial;
    private javax.swing.JTextField txtDescMaterial;
    private javax.swing.JTextField txtPrecioMaterial;
    private javax.swing.JTextField txtnombMaterial;
    // End of variables declaration//GEN-END:variables
}
