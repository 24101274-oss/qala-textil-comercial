package UI;

import BEAN.MaxLengthFilter;
import BEAN.PhoneFilter;
import BEAN.FixedDigitsFilter;
import BEAN.PassportFilter;
import DAO.GenericDAO;
import UTIL.DocumentFlags;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import BEAN.Usuario;


public class registroClienteF extends javax.swing.JFrame {
    Usuario user;
    int xMouse, yMouse;
    public registroClienteF() {
        initComponents();
        SetImageLabel(ie, "icons/buscarCliente.png");
        SetImageLabel(iconem, "icons/qt.png");
        
        SetImageLabel(iconCancelar, "icons/x.png");
        SetImageLabel(iconEliminar, "icons/trash.png");
        SetImageLabel(iconGuardar, "icons/check.png");
        
        SetImageLabel(iconlupa, "icons/phone.png");
        
        
        SetImageLabel(iconlupa, "icons/lupa.png");
        
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        
        ((AbstractDocument) txtnombCliente.getDocument())
                .setDocumentFilter(new MaxLengthFilter(100));
        
        ((AbstractDocument) txtdocCliente.getDocument())
                .setDocumentFilter(new FixedDigitsFilter(8));
        
        ((AbstractDocument) txtnumCliente.getDocument())
                .setDocumentFilter(new PhoneFilter(20));
        
        ((AbstractDocument) txtdirecCliente.getDocument())
                .setDocumentFilter(new MaxLengthFilter(200));
        
        ((AbstractDocument) txtmailCliente.getDocument())
                .setDocumentFilter(new MaxLengthFilter(100));
        
        cmbTipDoc.addActionListener(e -> actualizarFiltroDocumento());
        
        llenarClientes("");
        configurarSeleccionTabla();
        
        txtbusqCliente.getDocument().addDocumentListener(new DocumentListener() {
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
                if (txtbusqCliente.getText().equals("Ingrese Nombre del Cliente")) {
                    llenarClientes("");
                } else {
                    llenarClientes(txtbusqCliente.getText());
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
        txtmailCliente = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        txtnombCliente = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        txtnumCliente = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        txtdirecCliente = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        txtdocCliente = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        cmbTipDoc = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        iconlupa = new javax.swing.JLabel();
        txtbusqCliente = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        panelRound10 = new Clases.PanelRound();
        iconEliminar = new javax.swing.JLabel();
        btnEliminarCliente = new javax.swing.JLabel();
        panelRound12 = new Clases.PanelRound();
        iconGuardar = new javax.swing.JLabel();
        btnRegCliente = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        iconCancelar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();
        panelRound14 = new Clases.PanelRound();
        iconEliminar1 = new javax.swing.JLabel();
        btnActCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(ie, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 100, 80));
        jPanel2.add(iconem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 0, 110, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Cliente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 2020, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel2.setText("EMAIL");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, 35));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("DOCUMENTO");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel14.setText("TELÉFONO");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 90, 35));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel4.setText("DIRECCIÓN");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setText("CLIENTE");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 35));

        txtmailCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtmailCliente.setForeground(java.awt.Color.lightGray);
        txtmailCliente.setText("Ingrese correo del Cliente");
        txtmailCliente.setBorder(null);
        txtmailCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtmailClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtmailClienteFocusLost(evt);
            }
        });
        txtmailCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmailClienteActionPerformed(evt);
            }
        });
        txtmailCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmailClienteKeyPressed(evt);
            }
        });
        jPanel3.add(txtmailCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 300, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, 310, 30));

        txtnombCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtnombCliente.setForeground(java.awt.Color.lightGray);
        txtnombCliente.setText("Ingrese nombre del Cliente");
        txtnombCliente.setBorder(null);
        txtnombCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnombClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnombClienteFocusLost(evt);
            }
        });
        txtnombCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombClienteActionPerformed(evt);
            }
        });
        txtnombCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnombClienteKeyPressed(evt);
            }
        });
        jPanel3.add(txtnombCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 300, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 310, 30));

        txtnumCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtnumCliente.setForeground(java.awt.Color.lightGray);
        txtnumCliente.setText("Ingrese número de teléfono");
        txtnumCliente.setBorder(null);
        txtnumCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtnumClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtnumClienteFocusLost(evt);
            }
        });
        txtnumCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumClienteActionPerformed(evt);
            }
        });
        txtnumCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnumClienteKeyPressed(evt);
            }
        });
        jPanel3.add(txtnumCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 300, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, 310, 30));

        txtdirecCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdirecCliente.setForeground(java.awt.Color.lightGray);
        txtdirecCliente.setText("Ingrese Dirección del Cliente");
        txtdirecCliente.setBorder(null);
        txtdirecCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdirecClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdirecClienteFocusLost(evt);
            }
        });
        txtdirecCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdirecClienteActionPerformed(evt);
            }
        });
        txtdirecCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdirecClienteKeyPressed(evt);
            }
        });
        jPanel3.add(txtdirecCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 300, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 310, 30));

        txtdocCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtdocCliente.setForeground(java.awt.Color.lightGray);
        txtdocCliente.setText("Ingrese Documento del Cliente");
        txtdocCliente.setBorder(null);
        txtdocCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtdocClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdocClienteFocusLost(evt);
            }
        });
        txtdocCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocClienteActionPerformed(evt);
            }
        });
        txtdocCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdocClienteKeyPressed(evt);
            }
        });
        jPanel3.add(txtdocCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 300, 30));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 310, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel5.setText("TIPO DE DOCUMENTO");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 35));

        cmbTipDoc.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        cmbTipDoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DNI", "RUC", "Pasaporte" }));
        cmbTipDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        cmbTipDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmbTipDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipDocActionPerformed(evt);
            }
        });
        jPanel3.add(cmbTipDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 160, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 640, 410));

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
                "ID Cliente", "Nombre", "Documento", "Teléfono", "Dirección", "Email"
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

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 1000, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 24)); // NOI18N
        jLabel12.setText("BUSCAR");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 35));
        jPanel5.add(iconlupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 30));

        txtbusqCliente.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtbusqCliente.setForeground(java.awt.Color.lightGray);
        txtbusqCliente.setText("Ingrese Nombre del Cliente");
        txtbusqCliente.setBorder(null);
        txtbusqCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtbusqClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbusqClienteFocusLost(evt);
            }
        });
        txtbusqCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusqClienteActionPerformed(evt);
            }
        });
        txtbusqCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbusqClienteKeyPressed(evt);
            }
        });
        jPanel5.add(txtbusqCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 300, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 310, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 180, 1080, 350));

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound10.add(iconEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnEliminarCliente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnEliminarCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarCliente.setText("Eliminar Cliente");
        btnEliminarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarClienteMouseExited(evt);
            }
        });
        panelRound10.add(btnEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));

        jPanel1.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 600, 180, -1));

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound12.add(iconGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnRegCliente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnRegCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegCliente.setText("Registrar Cliente");
        btnRegCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegClienteMouseExited(evt);
            }
        });
        panelRound12.add(btnRegCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel1.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, 190, -1));

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound13.add(iconCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

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
        panelRound13.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 40));

        jPanel1.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1750, 600, 140, 40));

        panelRound14.setBackground(new java.awt.Color(255, 187, 92));
        panelRound14.setRoundBottomLeft(15);
        panelRound14.setRoundBottomRight(15);
        panelRound14.setRoundTopLeft(15);
        panelRound14.setRoundTopRight(15);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound14.add(iconEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        btnActCliente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnActCliente.setForeground(new java.awt.Color(255, 255, 255));
        btnActCliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActCliente.setText("Actualizar Cliente");
        btnActCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActClienteMouseExited(evt);
            }
        });
        panelRound14.add(btnActCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel1.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 600, 190, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2020, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmailClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmailClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailClienteActionPerformed

    private void txtmailClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmailClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmailClienteKeyPressed

    private void txtnombClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombClienteActionPerformed

    private void txtnombClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombClienteKeyPressed

    private void txtbusqClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusqClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusqClienteActionPerformed

    private void txtbusqClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusqClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusqClienteKeyPressed

    private void txtnumClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumClienteActionPerformed

    private void txtnumClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnumClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumClienteKeyPressed

    private void txtdirecClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdirecClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdirecClienteActionPerformed

    private void txtdirecClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdirecClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdirecClienteKeyPressed

    private void txtdocClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocClienteActionPerformed

    private void txtdocClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdocClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdocClienteKeyPressed

    private void btnRegClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClienteMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnRegClienteMouseEntered

    private void btnRegClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClienteMouseExited
        panelRound12.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnRegClienteMouseExited

    private void btnActClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActClienteMouseEntered
        panelRound14.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnActClienteMouseEntered

    private void btnActClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActClienteMouseExited
        panelRound14.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnActClienteMouseExited

    private void btnEliminarClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnEliminarClienteMouseEntered

    private void btnEliminarClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseExited
        panelRound10.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnEliminarClienteMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        panelRound13.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void txtnombClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombClienteFocusGained
        if (txtnombCliente.getText().equals("Ingrese nombre del Cliente")) {
            txtnombCliente.setText("");
            txtnombCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtnombClienteFocusGained

    private void txtnombClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnombClienteFocusLost
        if (txtnombCliente.getText().isEmpty()) {
            txtnombCliente.setText("Ingrese nombre del Cliente");
            txtnombCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtnombClienteFocusLost

    private void txtdocClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdocClienteFocusGained
        if (txtdocCliente.getText().equals("Ingrese Documento del Cliente")) {
            setTextProgrammatically(txtdocCliente, "");
            txtdocCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtdocClienteFocusGained

    private void txtdocClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdocClienteFocusLost
        if (txtdocCliente.getText().isEmpty()) {
            setTextProgrammatically(txtdocCliente, "Ingrese Documento del Cliente");
            txtdocCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtdocClienteFocusLost

    private void txtnumClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnumClienteFocusGained
        if (txtnumCliente.getText().equals("Ingrese número de teléfono")) {
            setTextProgrammatically(txtnumCliente, "");
            txtnumCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtnumClienteFocusGained

    private void txtnumClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtnumClienteFocusLost
        if (txtnumCliente.getText().isEmpty()) {
            setTextProgrammatically(txtnumCliente, "Ingrese número de teléfono");
            txtnumCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtnumClienteFocusLost

    private void txtdirecClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdirecClienteFocusGained
        if (txtdirecCliente.getText().equals("Ingrese Dirección del Cliente")) {
            txtdirecCliente.setText("");
            txtdirecCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtdirecClienteFocusGained

    private void txtdirecClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdirecClienteFocusLost
        if (txtdirecCliente.getText().isEmpty()) {
            txtdirecCliente.setText("Ingrese Dirección del Cliente");
            txtdirecCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtdirecClienteFocusLost

    private void txtmailClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmailClienteFocusGained
        if (txtmailCliente.getText().equals("Ingrese correo del Cliente")) {
            setTextProgrammatically(txtmailCliente, "");
            txtmailCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtmailClienteFocusGained

    private void txtmailClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtmailClienteFocusLost
        if (txtmailCliente.getText().isEmpty()) {
            setTextProgrammatically(txtmailCliente, "Ingrese correo del Cliente");
            txtmailCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtmailClienteFocusLost

    private void txtbusqClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbusqClienteFocusGained
        if (txtbusqCliente.getText().equals("Ingrese Nombre del Cliente")) {
            txtbusqCliente.setText("");
            txtbusqCliente.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtbusqClienteFocusGained

    private void txtbusqClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbusqClienteFocusLost
        if (txtbusqCliente.getText().isEmpty()) {
            txtbusqCliente.setText("Ingrese Nombre del Cliente");
            txtbusqCliente.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtbusqClienteFocusLost

    private void cmbTipDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipDocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipDocActionPerformed

    private void btnRegClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegClienteMouseClicked
        String nombre     = txtnombCliente.getText().trim();
    String documento  = txtdocCliente.getText().trim();
    String telefono   = txtnumCliente.getText().trim();
    String direccion  = txtdirecCliente.getText().trim();
    String email      = txtmailCliente.getText().trim();
    String tipoDoc    = cmbTipDoc.getSelectedItem().toString();

    // 1. Validaciones visuales básicas y de placeholders
    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombCliente.requestFocus(); return;
    }
    if (tipoDoc == null || tipoDoc.isBlank()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        cmbTipDoc.requestFocus(); return;
    }
    if (documento.isEmpty() || documento.equals("Ingrese Documento del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El documento del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtdocCliente.requestFocus(); return;
    }

    // 2. Validación de extensión según el tipo de documento
    switch (tipoDoc) {
        case "DNI" -> {
            if (documento.length() != 8) {
                javax.swing.JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        case "RUC" -> {
            if (documento.length() != 11) {
                javax.swing.JOptionPane.showMessageDialog(this, "El RUC debe tener exactamente 11 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        case "Pasaporte" -> {
            if (documento.length() < 6 || documento.length() > 12) {
                javax.swing.JOptionPane.showMessageDialog(this, "El pasaporte debe tener entre 6 y 12 caracteres", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        default -> {
            javax.swing.JOptionPane.showMessageDialog(this, "Tipo de documento no válido", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            cmbTipDoc.requestFocus(); return;
        }
    }

    if (telefono.isEmpty() || telefono.equals("Ingrese número de teléfono")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El teléfono del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnumCliente.requestFocus(); return;
    }
    if (direccion.isEmpty() || direccion.equals("Ingrese Dirección del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La dirección del cliente es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtdirecCliente.requestFocus(); return;
    }
    if (email.isEmpty() || email.equals("Ingrese correo del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El correo electrónico del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtmailCliente.requestFocus(); return;
    }
    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El correo electrónico ingresado no es válido", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtmailCliente.requestFocus(); return;
    }

    try {
        // 3. Delegamos el trabajo de validación de base de datos e inserción al Servicio
        SERVICE.ClienteService servicio = new SERVICE.ClienteService();
        servicio.registrarCliente(nombre, tipoDoc, documento, telefono, direccion, email);

        // 4. Si no hay excepciones, mostramos éxito
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente registrado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtbusqCliente.getText().equals("Ingrese Nombre del Cliente")) {
            llenarClientes("");
        } else {
            llenarClientes(txtbusqCliente.getText());
        }

    } catch (Exception e) {
        // Atrapamos mensajes personalizados de duplicados enviados por el servicio
        String titulo = e.getMessage().contains("duplicado") || e.getMessage().contains("Ya existe") ? "Duplicado" : "Error";
        int tipoIcono = titulo.equals("Duplicado") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
        txtdocCliente.requestFocus();
    }
    }//GEN-LAST:event_btnRegClienteMouseClicked

    private void btnActClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActClienteMouseClicked
        // 1. Validar permisos de administrador
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden actualizar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    // 2. Validar selección de la tabla
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un cliente para modificar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (filas.length > 1) {
        javax.swing.JOptionPane.showMessageDialog(this, "Seleccione solo un cliente para modificar", "Selección inválida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int fila = filas[0];
    Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("ClienteID"));

    if (idObj == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo obtener el ID del cliente", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        return;
    }
    int clienteID = Integer.parseInt(idObj.toString());

    // 3. Obtener textos
    String nombre    = txtnombCliente.getText().trim();
    String documento = txtdocCliente.getText().trim();
    String telefono  = txtnumCliente.getText().trim();
    String direccion = txtdirecCliente.getText().trim();
    String email     = txtmailCliente.getText().trim();
    String tipoDoc   = cmbTipDoc.getSelectedItem().toString();

    // 4. Validaciones visuales y de formato
    if (nombre.isEmpty() || nombre.equals("Ingrese nombre del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El nombre del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnombCliente.requestFocus(); return;
    }
    if (tipoDoc == null || tipoDoc.isBlank()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un tipo de documento", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        cmbTipDoc.requestFocus(); return;
    }
    if (documento.isEmpty() || documento.equals("Ingrese Documento del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El documento del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtdocCliente.requestFocus(); return;
    }

    switch (tipoDoc) {
        case "DNI" -> {
            if (documento.length() != 8) {
                javax.swing.JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        case "RUC" -> {
            if (documento.length() != 11) {
                javax.swing.JOptionPane.showMessageDialog(this, "El RUC debe tener exactamente 11 dígitos", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        case "Pasaporte" -> {
            if (documento.length() < 6 || documento.length() > 12) {
                javax.swing.JOptionPane.showMessageDialog(this, "El pasaporte debe tener entre 6 y 12 caracteres", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
                txtdocCliente.requestFocus(); return;
            }
        }
        default -> {
            javax.swing.JOptionPane.showMessageDialog(this, "Tipo de documento no válido", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
            cmbTipDoc.requestFocus(); return;
        }
    }

    if (telefono.isEmpty() || telefono.equals("Ingrese número de teléfono")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El teléfono del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtnumCliente.requestFocus(); return;
    }
    if (direccion.isEmpty() || direccion.equals("Ingrese Dirección del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "La dirección del cliente es obligatoria", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtdirecCliente.requestFocus(); return;
    }
    if (email.isEmpty() || email.equals("Ingrese correo del Cliente")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El correo electrónico del cliente es obligatorio", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtmailCliente.requestFocus(); return;
    }
    if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
        javax.swing.JOptionPane.showMessageDialog(this, "El correo electrónico ingresado no es válido", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        txtmailCliente.requestFocus(); return;
    }

    try {
        // 5. Enviar al SERVICIO seguro
        SERVICE.ClienteService servicio = new SERVICE.ClienteService();
        servicio.actualizarCliente(clienteID, nombre, tipoDoc, documento, telefono, direccion, email);

        // 6. Éxito y recarga visual
        javax.swing.JOptionPane.showMessageDialog(this, "Cliente actualizado correctamente", "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtbusqCliente.getText().equals("Ingrese Nombre del Cliente")) {
            llenarClientes("");
        } else {
            llenarClientes(txtbusqCliente.getText());
        }

    } catch (Exception e) {
        String titulo = e.getMessage().contains("Ya existe") ? "Duplicado" : "Error";
        int tipoIcono = titulo.equals("Duplicado") ? javax.swing.JOptionPane.WARNING_MESSAGE : javax.swing.JOptionPane.ERROR_MESSAGE;
        
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), titulo, tipoIcono);
    }
    }//GEN-LAST:event_btnActClienteMouseClicked

    private void btnEliminarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarClienteMouseClicked
        // 1. Validar administrador
    if(user.getRolID() != 1){
        javax.swing.JOptionPane.showMessageDialog(this, "Solo los administradores pueden eliminar", "Permiso no concedido", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // 2. Validar selección
    int[] filas = tablaEntrada.getSelectedRows();
    if (filas.length == 0) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un cliente para eliminar", "Selección requerida", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    int confirmacion = javax.swing.JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el(los) cliente(s) seleccionado(s)?", "Confirmar eliminación", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);
    if (confirmacion != javax.swing.JOptionPane.YES_OPTION) {
        return;
    }

    try {
        // 3. Recopilar IDs
        java.util.List<Integer> idsAEliminar = new java.util.ArrayList<>();
        for (int fila : filas) {
            Object idObj = tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel().getColumnIndex("ClienteID"));
            if (idObj != null) {
                idsAEliminar.add(Integer.parseInt(idObj.toString()));
            }
        }

        // 4. Delegar al Servicio
        SERVICE.ClienteService servicio = new SERVICE.ClienteService();
        int eliminados = servicio.eliminarClientes(idsAEliminar);

        // 5. Mostrar éxito
        javax.swing.JOptionPane.showMessageDialog(this, eliminados + " cliente(s) eliminado(s)", "Resultado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        limpiarCampos();

        if (txtbusqCliente.getText().equals("Ingrese Nombre del Cliente")) {
            llenarClientes("");
        } else {
            llenarClientes(txtbusqCliente.getText());
        }

    } catch (Exception e) {
        // Error si el cliente está amarrado a una factura/salida
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarClienteMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

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
            java.util.logging.Logger.getLogger(registroClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registroClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registroClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registroClienteF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroClienteF().setVisible(true);
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
    
    private void llenarClientes(String where) {
    try {
        
        SERVICE.ClienteService servicio = new SERVICE.ClienteService();
        java.util.List<java.util.Map<String, Object>> clientes = servicio.buscarClientesPorNombre(where);
        
        
        DAO.GenericDAO.llenarJTable(tablaEntrada, clientes);
        
    } catch (Exception e) {
        
        javax.swing.JOptionPane.showMessageDialog(this, 
            "Error al cargar la lista de clientes: " + e.getMessage(), 
            "Error", 
            javax.swing.JOptionPane.ERROR_MESSAGE);
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
            
            String tipdoc = String.valueOf(
                tablaEntrada.getValueAt(
                    fila,
                    tablaEntrada.getColumnModel()
                        .getColumnIndex("TipoDocumento")
                )
            );
            cmbTipDoc.setSelectedItem(tipdoc);

            txtnombCliente.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Nombre")).toString()
            );
            txtnombCliente.setForeground(Color.black);

            setTextProgrammatically(txtdocCliente,
                String.valueOf(tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Documento")).toString()
                ));
            txtdocCliente.setForeground(Color.black);
            
            setTextProgrammatically(txtnumCliente,
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Telefono")).toString()
            );
            txtnumCliente.setForeground(Color.black);

            txtdirecCliente.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Direccion")).toString()
            );
            txtdirecCliente.setForeground(Color.black);

            setTextProgrammatically(txtmailCliente,
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Email")).toString()
            );
            txtmailCliente.setForeground(Color.black);
        });
    }
    
    public static void setTextProgrammatically(JTextField field, String text) {
        AbstractDocument doc = (AbstractDocument) field.getDocument();
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, true);
        field.setText(text);
        doc.putProperty(DocumentFlags.PROGRAMMATIC_CHANGE, false);
    }
    
    private void limpiarCampos() {
        txtnombCliente.setText("Ingrese nombre del Cliente");
        txtnombCliente.setForeground(Color.lightGray);

        setTextProgrammatically(
            txtdocCliente,
            "Ingrese Documento del Cliente"
        );
        txtdocCliente.setForeground(Color.lightGray);

        setTextProgrammatically(
            txtnumCliente,
            "Ingrese Teléfono del Cliente"
        );
        txtnumCliente.setForeground(Color.lightGray);

        txtdirecCliente.setText("Ingrese Dirección del Cliente");
        txtdirecCliente.setForeground(Color.lightGray);

        txtmailCliente.setText("Ingrese Correo del Cliente");
        txtmailCliente.setForeground(Color.lightGray);

        cmbTipDoc.setSelectedIndex(0);
    }
    
    private void actualizarFiltroDocumento() {

    AbstractDocument doc =
        (AbstractDocument) txtdocCliente.getDocument();

    setTextProgrammatically(txtdocCliente, "");

    String tipo = cmbTipDoc.getSelectedItem().toString();

    switch (tipo) {

        case "DNI" -> 
            doc.setDocumentFilter(new FixedDigitsFilter(8));

        case "RUC" -> 
            doc.setDocumentFilter(new FixedDigitsFilter(11));

        case "Pasaporte" -> 
            doc.setDocumentFilter(new PassportFilter(12));

        default -> 
            doc.setDocumentFilter(null);
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActCliente;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminarCliente;
    private javax.swing.JLabel btnRegCliente;
    private javax.swing.JComboBox<String> cmbTipDoc;
    private javax.swing.JLabel iconCancelar;
    private javax.swing.JLabel iconEliminar;
    private javax.swing.JLabel iconEliminar1;
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
    private javax.swing.JTextField txtbusqCliente;
    private javax.swing.JTextField txtdirecCliente;
    private javax.swing.JTextField txtdocCliente;
    private javax.swing.JTextField txtmailCliente;
    private javax.swing.JTextField txtnombCliente;
    private javax.swing.JTextField txtnumCliente;
    // End of variables declaration//GEN-END:variables
}
