package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import UTIL.MaxLengthFilter;
import UTIL.PhoneFilter;
import UTIL.FixedDigitsFilter;
import DAO.GenericDAO;
import java.util.*;
import UTIL.DocumentFlags;
import BEAN.Usuario;


public class registrarProveedorF extends javax.swing.JFrame {
    int xMouse, yMouse;
    Usuario user;
    public registrarProveedorF() {
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
        
        ((AbstractDocument) txtnombProveedor.getDocument())
                .setDocumentFilter(new MaxLengthFilter(100));

        ((AbstractDocument) txtnombContacto.getDocument())
                .setDocumentFilter(new MaxLengthFilter(100));

        ((AbstractDocument) txtDireccionProveedor.getDocument())
                .setDocumentFilter(new MaxLengthFilter(200));

        ((AbstractDocument) txtTelefonoProveedor.getDocument())
                .setDocumentFilter(new PhoneFilter(20));

        ((AbstractDocument) txtCiudadProveedor.getDocument())
                .setDocumentFilter(new MaxLengthFilter(20));
        
        ((AbstractDocument) txtRUCProveedor.getDocument())
                .setDocumentFilter(new FixedDigitsFilter(11));


        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        llenarProveedores("");
        configurarSeleccionTabla();
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
    public void setUsuario(Usuario u) {
        user = u;
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

            txtnombProveedor.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Nombre")).toString()
            );
            txtnombProveedor.setForeground(Color.black);

            txtnombContacto.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("NombreContacto")).toString()
            );
            txtnombContacto.setForeground(Color.black);

            txtDireccionProveedor.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Direccion")).toString()
            );
            txtDireccionProveedor.setForeground(Color.black);

            txtCiudadProveedor.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Ciudad")).toString()
            );
            txtCiudadProveedor.setForeground(Color.black);

            txtTelefonoProveedor.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Telefono")).toString()
            );
            txtTelefonoProveedor.setForeground(Color.black);
            
            txtRUCProveedor.setText(
                String.valueOf(tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("RUC")).toString()
            ));
            txtRUCProveedor.setForeground(Color.black);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtTelefonoProveedor = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtnombProveedor = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtCiudadProveedor = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtDireccionProveedor = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtnombContacto = new javax.swing.JTextField();
        userTxt7 = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtRUCProveedor = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        iconlupa = new javax.swing.JLabel();
        txtBusqProveedor = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        panelRound10 = new Clases.PanelRound();
        iconEliminar = new javax.swing.JLabel();
        btnEliminaProv = new javax.swing.JLabel();
        panelRound12 = new Clases.PanelRound();
        iconGuardar = new javax.swing.JLabel();
        btnRegProv = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        iconCancelar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        panelRound14 = new Clases.PanelRound();
        actualizar = new javax.swing.JLabel();
        btnActProv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(ie, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 100, 80));
        jPanel2.add(iconem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 110, 90));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Proveedor");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, -10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1880, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("TELÉFONO");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, 35));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("CONTACTO");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setText("DIRECCIÓN");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, 35));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("CIUDAD");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setText("PROVEEDOR");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 35));

        txtTelefonoProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtTelefonoProveedor.setForeground(java.awt.Color.lightGray);
        txtTelefonoProveedor.setText("Ingrese Teléfono del Proveedor");
        txtTelefonoProveedor.setBorder(null);
        txtTelefonoProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoProveedorFocusLost(evt);
            }
        });
        txtTelefonoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoProveedorActionPerformed(evt);
            }
        });
        txtTelefonoProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTelefonoProveedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtTelefonoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 300, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 310, 30));

        txtnombProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtnombProveedor.setForeground(java.awt.Color.lightGray);
        txtnombProveedor.setText("Ingrese nombre del Proveedor");
        txtnombProveedor.setBorder(null);
        txtnombProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombProveedorFocusLost(evt);
            }
        });
        txtnombProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombProveedorActionPerformed(evt);
            }
        });
        txtnombProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombProveedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtnombProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 300, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 310, 30));

        txtCiudadProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtCiudadProveedor.setForeground(java.awt.Color.lightGray);
        txtCiudadProveedor.setText("Ingrese ciudad del Proveedor");
        txtCiudadProveedor.setBorder(null);
        txtCiudadProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCiudadProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCiudadProveedorFocusLost(evt);
            }
        });
        txtCiudadProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadProveedorActionPerformed(evt);
            }
        });
        txtCiudadProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCiudadProveedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtCiudadProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 300, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 310, 30));

        txtDireccionProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtDireccionProveedor.setForeground(java.awt.Color.lightGray);
        txtDireccionProveedor.setText("Ingrese dirección del Proveedor");
        txtDireccionProveedor.setBorder(null);
        txtDireccionProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionProveedorFocusLost(evt);
            }
        });
        txtDireccionProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionProveedorActionPerformed(evt);
            }
        });
        txtDireccionProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDireccionProveedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtDireccionProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 300, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 310, 30));

        txtnombContacto.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtnombContacto.setForeground(java.awt.Color.lightGray);
        txtnombContacto.setText("Ingrese nombre del Contacto");
        txtnombContacto.setBorder(null);
        txtnombContacto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombContactoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombContactoFocusLost(evt);
            }
        });
        txtnombContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombContactoActionPerformed(evt);
            }
        });
        txtnombContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombContactoKeyPressed(evt);
            }
        });
        jPanel3.add(txtnombContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 300, 30));

        userTxt7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt7.setForeground(new java.awt.Color(204, 204, 204));
        userTxt7.setText("Ingrese  nombre del Contacto");
        userTxt7.setBorder(null);
        userTxt7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxt7MousePressed(evt);
            }
        });
        userTxt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxt7ActionPerformed(evt);
            }
        });
        userTxt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTxt7KeyPressed(evt);
            }
        });
        jPanel3.add(userTxt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 300, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 310, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("RUC");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 35));

        txtRUCProveedor.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtRUCProveedor.setForeground(java.awt.Color.lightGray);
        txtRUCProveedor.setText("Ingrese RUC del Proveedor");
        txtRUCProveedor.setBorder(null);
        txtRUCProveedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRUCProveedorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRUCProveedorFocusLost(evt);
            }
        });
        txtRUCProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRUCProveedorActionPerformed(evt);
            }
        });
        txtRUCProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRUCProveedorKeyPressed(evt);
            }
        });
        jPanel3.add(txtRUCProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 300, 30));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 310, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 510, 400));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1120, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel12.setText("BUSCAR");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 35));
        jPanel5.add(iconlupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 30));

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
        txtBusqProveedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusqProveedorKeyPressed(evt);
            }
        });
        jPanel5.add(txtBusqProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 300, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 310, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 1180, 350));

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound10.add(iconEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 20, 20));

        btnEliminaProv.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnEliminaProv.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminaProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminaProv.setText("Eliminar Proveedor");
        btnEliminaProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminaProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminaProvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminaProvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminaProvMouseExited(evt);
            }
        });
        panelRound10.add(btnEliminaProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jPanel1.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 600, 220, -1));

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound12.add(iconGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnRegProv.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnRegProv.setForeground(new java.awt.Color(255, 255, 255));
        btnRegProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegProv.setText("Registrar Proveedor");
        btnRegProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegProvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegProvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegProvMouseExited(evt);
            }
        });
        panelRound12.add(btnRegProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 40));

        jPanel1.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 220, -1));

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
        panelRound13.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel1.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 600, 190, 40));

        panelRound14.setBackground(new java.awt.Color(255, 187, 92));
        panelRound14.setRoundBottomLeft(15);
        panelRound14.setRoundBottomRight(15);
        panelRound14.setRoundTopLeft(15);
        panelRound14.setRoundTopRight(15);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound14.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnActProv.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnActProv.setForeground(new java.awt.Color(255, 255, 255));
        btnActProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActProv.setText("Actualizar Proveedor");
        btnActProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActProvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActProvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActProvMouseExited(evt);
            }
        });
        panelRound14.add(btnActProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 40));

        jPanel1.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 600, 210, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1776, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTelefonoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoProveedorActionPerformed

    private void txtTelefonoProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoProveedorKeyPressed

    private void txtnombProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombProveedorActionPerformed

    private void txtnombProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombProveedorKeyPressed

    private void txtCiudadProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadProveedorActionPerformed

    private void txtCiudadProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCiudadProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadProveedorKeyPressed

    private void txtBusqProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqProveedorActionPerformed

    private void txtBusqProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqProveedorKeyPressed

    private void txtDireccionProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedorActionPerformed

    private void txtDireccionProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionProveedorKeyPressed

    private void txtnombContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombContactoActionPerformed

    private void txtnombContactoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombContactoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombContactoKeyPressed

    private void userTxt7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxt7MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt7MousePressed

    private void userTxt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt7ActionPerformed

    private void userTxt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTxt7KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxt7KeyPressed

    private void btnRegProvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegProvMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnRegProvMouseEntered

    private void btnRegProvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegProvMouseExited
        panelRound12.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnRegProvMouseExited

    private void btnActProvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActProvMouseEntered
        panelRound14.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnActProvMouseEntered

    private void btnActProvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActProvMouseExited
        panelRound14.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnActProvMouseExited

    private void btnEliminaProvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminaProvMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnEliminaProvMouseEntered

    private void btnEliminaProvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminaProvMouseExited
        panelRound10.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnEliminaProvMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
       panelRound13.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtnombProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombProveedorFocusGained
        if (txtnombProveedor.getText().equals("Ingrese nombre del Proveedor")) {
            txtnombProveedor.setText("");
            txtnombProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtnombProveedorFocusGained

    private void txtnombProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombProveedorFocusLost
        if (txtnombProveedor.getText().isEmpty()) {
            txtnombProveedor.setText("Ingrese nombre del Proveedor");
            txtnombProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtnombProveedorFocusLost

    private void txtnombContactoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombContactoFocusGained
        if (txtnombContacto.getText().equals("Ingrese nombre del Contacto")) {
            txtnombContacto.setText("");
            txtnombContacto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtnombContactoFocusGained

    private void txtnombContactoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombContactoFocusLost
        if (txtnombContacto.getText().isEmpty()) {
            txtnombContacto.setText("Ingrese nombre del Contacto");
            txtnombContacto.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtnombContactoFocusLost

    private void txtDireccionProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionProveedorFocusGained
        if (txtDireccionProveedor.getText().equals("Ingrese dirección del Proveedor")) {
            txtDireccionProveedor.setText("");
            txtDireccionProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDireccionProveedorFocusGained

    private void txtDireccionProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionProveedorFocusLost
        if (txtDireccionProveedor.getText().isEmpty()) {
            txtDireccionProveedor.setText("Ingrese dirección del Proveedor");
            txtDireccionProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtDireccionProveedorFocusLost

    private void txtCiudadProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCiudadProveedorFocusGained
        if (txtCiudadProveedor.getText().equals("Ingrese ciudad del Proveedor")) {
            txtCiudadProveedor.setText("");
            txtCiudadProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCiudadProveedorFocusGained

    private void txtCiudadProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCiudadProveedorFocusLost
        if (txtCiudadProveedor.getText().isEmpty()) {
            setTextProgrammatically(txtCiudadProveedor, "Ingrese ciudad del Proveedor");
            txtCiudadProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtCiudadProveedorFocusLost

    private void txtTelefonoProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorFocusGained
        if (txtTelefonoProveedor.getText().equals("Ingrese Teléfono del Proveedor")) {
            txtTelefonoProveedor.setText("");
            txtTelefonoProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTelefonoProveedorFocusGained

    private void txtTelefonoProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoProveedorFocusLost
        if (txtTelefonoProveedor.getText().isEmpty()) {
            setTextProgrammatically(txtTelefonoProveedor, "Ingrese Teléfono del Proveedor");
            txtTelefonoProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtTelefonoProveedorFocusLost

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

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnRegProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegProvMouseClicked
        String nombre    = txtnombProveedor.getText().trim();
    String contacto  = txtnombContacto.getText().trim();
    String direccion = txtDireccionProveedor.getText().trim();
    String ciudad    = txtCiudadProveedor.getText().trim();
    String telefono  = txtTelefonoProveedor.getText().trim();
    String ruc       = txtRUCProveedor.getText().trim();

    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombProveedor.requestFocus(); return;
    }
    if (contacto.isEmpty() || contacto.equals("Ingrese nombre del Contacto")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre de contacto del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombContacto.requestFocus(); return;
    }
    if (direccion.isEmpty() || direccion.equals("Ingrese dirección del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La dirección del proveedor es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtDireccionProveedor.requestFocus(); return;
    }
    if (ciudad.isEmpty() || ciudad.equals("Ingrese ciudad del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La ciudad del proveedor es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtCiudadProveedor.requestFocus(); return;
    }
    if (telefono.isEmpty() || telefono.equals("Ingrese Teléfono del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El teléfono del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtTelefonoProveedor.requestFocus(); return;
    }
    if (ruc.isEmpty() || ruc.equals("Ingrese RUC del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El RUC del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRUCProveedor.requestFocus(); return;
    }
    if (ruc.length() != 11) {
        javax.swing.JOptionPane.showMessageDialog(this, "El RUC del proveedor debe tener 11 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRUCProveedor.requestFocus(); return;
    }

    try {
        SERVICE.ProveedorService servicio = new SERVICE.ProveedorService();
        servicio.registrarProveedor(nombre, contacto, direccion, ciudad, telefono, ruc);

        javax.swing.JOptionPane.showMessageDialog(this, "Proveedor registrado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();
        
        if (txtBusqProveedor.getText().equals("Ingrese nombre del Proveedor")) {
            llenarProveedores("");
        } else {
            llenarProveedores(txtBusqProveedor.getText());
        }

    } catch (Exception e) {
        String titulo = e.getMessage().contains("ya existe") ? "Duplicado" : "Error";
        int tipoIcono = e.getMessage().contains("ya existe") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
        if (titulo.equals("Duplicado")) txtnombProveedor.requestFocus();
    }
    }//GEN-LAST:event_btnRegProvMouseClicked

    private void btnActProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActProvMouseClicked
    
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden actualizar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

 
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un proveedor para modificar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (filas.length > 1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione solo un proveedor para modificar", "Selección inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int fila = filas[0];
    Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("ProveedorID"));
    
    if (idObj == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo obtener el ID del proveedor", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    int proveedorID = Integer.parseInt(idObj.toString());

  
    String nombre    = txtnombProveedor.getText().trim();
    String contacto  = txtnombContacto.getText().trim();
    String direccion = txtDireccionProveedor.getText().trim();
    String ciudad    = txtCiudadProveedor.getText().trim();
    String telefono  = txtTelefonoProveedor.getText().trim();
    String ruc       = txtRUCProveedor.getText().trim();

 
    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombProveedor.requestFocus(); return;
    }
    if (contacto.isEmpty() || contacto.equals("Ingrese nombre del Contacto")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre de contacto del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombContacto.requestFocus(); return;
    }
    if (direccion.isEmpty() || direccion.equals("Ingrese dirección del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La dirección del proveedor es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtDireccionProveedor.requestFocus(); return;
    }
    if (ciudad.isEmpty() || ciudad.equals("Ingrese ciudad del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La ciudad del proveedor es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtCiudadProveedor.requestFocus(); return;
    }
    if (telefono.isEmpty() || telefono.equals("Ingrese Teléfono del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El teléfono del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtTelefonoProveedor.requestFocus(); return;
    }
    if (ruc.isEmpty() || ruc.equals("Ingrese RUC del Proveedor")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El RUC del proveedor es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRUCProveedor.requestFocus(); return;
    }
    if (ruc.length() != 11) {
        javax.swing.JOptionPane.showMessageDialog(this, "El RUC del proveedor debe tener 11 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtRUCProveedor.requestFocus(); return;
    }

    try {

        SERVICE.ProveedorService servicio = new SERVICE.ProveedorService();
        servicio.actualizarProveedor(proveedorID, nombre, contacto, direccion, ciudad, telefono, ruc);


        javax.swing.JOptionPane.showMessageDialog(this, "Proveedor actualizado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtBusqProveedor.getText().equals("Ingrese nombre del Proveedor")) {
            llenarProveedores("");
        } else {
            llenarProveedores(txtBusqProveedor.getText());
        }

    } catch (Exception e) {
        String titulo = e.getMessage().contains("Ya existe") ? "Duplicado" : "Error";
        int tipoIcono = e.getMessage().contains("Ya existe") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
    }
    }//GEN-LAST:event_btnActProvMouseClicked

    private void btnEliminaProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminaProvMouseClicked
        // 1. Validar administrador
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden eliminar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 2. Validar selección
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un proveedor para eliminar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el(los) proveedor(es) seleccionado(s)?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
    if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    try {
        // 3. Recopilar IDs
        java.util.List<Integer> idsAEliminar = new java.util.ArrayList<>();
        for (int fila : filas) {
            Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("ProveedorID"));
            if (idObj != null) {
                idsAEliminar.add(Integer.parseInt(idObj.toString()));
            }
        }

        // 4. Delegar al Servicio
        SERVICE.ProveedorService servicio = new SERVICE.ProveedorService();
        int eliminados = servicio.eliminarProveedores(idsAEliminar);

        // 5. Mostrar éxito
        javax.swing.JOptionPane.showMessageDialog(this, eliminados + " proveedor(es) eliminado(s)", "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtBusqProveedor.getText().equals("Ingrese nombre del Proveedor")) {
            llenarProveedores("");
        } else {
            llenarProveedores(txtBusqProveedor.getText());
        }

    } catch (Exception e) {
        // Error si el proveedor está amarrado a una factura
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminaProvMouseClicked

    private void txtRUCProveedorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUCProveedorFocusGained
        if (txtRUCProveedor.getText().equals("Ingrese RUC del Proveedor")) {
            setTextProgrammatically(txtRUCProveedor, "");
            txtRUCProveedor.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtRUCProveedorFocusGained

    private void txtRUCProveedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRUCProveedorFocusLost
        if (txtRUCProveedor.getText().isEmpty()) {
            setTextProgrammatically(txtRUCProveedor, "Ingrese RUC del Proveedor");
            txtRUCProveedor.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtRUCProveedorFocusLost

    private void txtRUCProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRUCProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCProveedorActionPerformed

    private void txtRUCProveedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRUCProveedorKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRUCProveedorKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(registrarProveedorF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarProveedorF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarProveedorF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarProveedorF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarProveedorF().setVisible(true);
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
        // Delegar búsqueda al servicio
        SERVICE.ProveedorService servicio = new SERVICE.ProveedorService();
        java.util.List<java.util.Map<String, Object>> proveedores = servicio.buscarProveedoresPorNombre(where);
        
        // Enviar a la vista
        DAO.GenericDAO.llenarJTable(tablaEntrada, proveedores);
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar proveedores: " + e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}

    private void limpiarCampos() {
        txtnombProveedor.setText("Ingrese nombre del Proveedor");
        txtnombProveedor.setForeground(Color.lightGray);
        txtnombContacto.setText("Ingrese nombre del Contacto");
        txtnombContacto.setForeground(Color.lightGray);
        txtDireccionProveedor.setText("Ingrese dirección del Proveedor");
        txtDireccionProveedor.setForeground(Color.lightGray);
        setTextProgrammatically(txtCiudadProveedor, "Ingrese ciudad del Proveedor");
        txtCiudadProveedor.setForeground(Color.lightGray);
        setTextProgrammatically(txtTelefonoProveedor, "Ingrese Teléfono del Proveedor");
        txtTelefonoProveedor.setForeground(Color.lightGray);
    }
    
    public static void setTextProgrammatically(JTextField field, String text) {
        AbstractDocument doc = (AbstractDocument) field.getDocument();
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, true);
        field.setText(text);
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualizar;
    private javax.swing.JLabel btnActProv;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminaProv;
    private javax.swing.JLabel btnRegProv;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound12;
    private Clases.PanelRound panelRound13;
    private Clases.PanelRound panelRound14;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextField txtBusqProveedor;
    private javax.swing.JTextField txtCiudadProveedor;
    private javax.swing.JTextField txtDireccionProveedor;
    private javax.swing.JTextField txtRUCProveedor;
    private javax.swing.JTextField txtTelefonoProveedor;
    private javax.swing.JTextField txtnombContacto;
    private javax.swing.JTextField txtnombProveedor;
    private javax.swing.JTextField userTxt7;
    // End of variables declaration//GEN-END:variables
}
