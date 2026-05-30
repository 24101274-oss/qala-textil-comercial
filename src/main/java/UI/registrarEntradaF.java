package UI;

import BEAN.MaxLengthFilter;
import BEAN.PriceFilter;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMaterialLighterIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import DAO.GenericDAO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import BEAN.Usuario;

import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;


public class registrarEntradaF extends javax.swing.JFrame {
    private java.util.List<Map<String, Object>> detalleEntrada;
    Usuario user;
    public registrarEntradaF() {
        initComponents();
        InitIcons();
        InitStyles();
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        llenarCmbProveedor();
        txtObs.setLineWrap(true);
        txtObs.setWrapStyleWord(true);
        detalleEntrada = new java.util.ArrayList<>();
        
        ((AbstractDocument) txtNfactura.getDocument())
                .setDocumentFilter(new MaxLengthFilter(50));
        
        ((AbstractDocument) txtObs.getDocument())
                .setDocumentFilter(new MaxLengthFilter(255));
        
        ((AbstractDocument) txtCant.getDocument())
                .setDocumentFilter(new PriceFilter());
        
        txtCodBarra.getDocument().addDocumentListener(new DocumentListener() {
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
                actualizarUnidadYCostoPorCodigoBarra(txtCodBarra.getText());
            }
        });
    }
    public void setUsuario(Usuario u) {
        user = u;
        jTextField1.setText(user.getUsername());
    }
    private void InitIcons(){
        SetImageLabel(ie, "icons/box.png");
        SetImageLabel(iconUser, "icons/user2.png");
        SetImageLabel(prov, "icons/Supplie.png");
        SetImageLabel(nFac, "icons/iconFac.png");
        SetImageLabel(jLabel4, "icons/lupa.png");
        SetImageLabel(jLabel9, "icons/lupa.png");
        SetImageLabel(mas, "icons/mas.png");
        SetImageLabel(mas1, "icons/mas.png");
        SetImageLabel(mas2, "icons/mas.png");
        SetImageLabel(folder, "icons/folder.png");
        SetImageLabel(iconem, "icons/qt.png");
        SetImageLabel(iconmat, "icons/material.png");
        SetImageLabel(iconun, "icons/unidad.png");
        SetImageLabel(iconcan, "icons/stock.png");
        SetImageLabel(iconCancelar, "icons/x.png");
        SetImageLabel(iconEliminar, "icons/trash.png");
        SetImageLabel(iconGuardar, "icons/check.png");
    }
    private void InitStyles(){
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ie = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        iconem = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        jlabel3 = new javax.swing.JLabel();
        prov = new javax.swing.JLabel();
        nFac = new javax.swing.JLabel();
        cmbProvE = new javax.swing.JComboBox<>();
        panelRound3 = new Clases.PanelRound();
        mas = new javax.swing.JLabel();
        btntxtAñadirProv = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNfactura = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btntxtBuscarProv = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        folder = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        panelRound10 = new Clases.PanelRound();
        iconEliminar = new javax.swing.JLabel();
        btntxtEliminar = new javax.swing.JLabel();
        panelRound11 = new Clases.PanelRound();
        jLabel26 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        panelRound12 = new Clases.PanelRound();
        iconGuardar = new javax.swing.JLabel();
        btntxtGuardarEntrada = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        iconCancelar = new javax.swing.JLabel();
        btntxtCancelar = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        iconmat = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCant = new javax.swing.JTextField();
        panelRound4 = new Clases.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        btntxtBuscarMat = new javax.swing.JLabel();
        panelRound5 = new Clases.PanelRound();
        mas1 = new javax.swing.JLabel();
        btntxtAgMatEntrada = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCodBarra = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUnd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCostUni = new javax.swing.JTextField();
        panelRound6 = new Clases.PanelRound();
        btntxtAgMat = new javax.swing.JLabel();
        mas2 = new javax.swing.JLabel();
        iconcan = new javax.swing.JLabel();
        iconun = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(239, 240, 235));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Nueva Entrada");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(ie, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(203, 203, 203)
                .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addGap(8, 8, 8)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(iconem, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);

        jlabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jlabel3.setText("N° Factura");

        cmbProvE.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        cmbProvE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Proveedor", "Proveedor 2" }));
        cmbProvE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));
        cmbProvE.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelRound3.setBackground(new java.awt.Color(255, 187, 92));
        panelRound3.setRoundBottomLeft(15);
        panelRound3.setRoundBottomRight(15);
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);

        mas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtAñadirProv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntxtAñadirProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtAñadirProv.setText("Añadir");
        btntxtAñadirProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtAñadirProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtAñadirProvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtAñadirProvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtAñadirProvMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
            .addComponent(btntxtAñadirProv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtAñadirProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel7.setText("Información de Proveedor");

        txtNfactura.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        jPanel6.setBackground(new java.awt.Color(255, 187, 92));
        jPanel6.setPreferredSize(new java.awt.Dimension(46, 16));

        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtBuscarProv.setFont(new java.awt.Font("Roboto SemiCondensed", 1, 12)); // NOI18N
        btntxtBuscarProv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtBuscarProv.setText("Buscar");
        btntxtBuscarProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtBuscarProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtBuscarProvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtBuscarProvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtBuscarProvMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btntxtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(btntxtBuscarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(prov, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbProvE, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(82, 82, 82)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jlabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nFac, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nFac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbProvE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel6.setText("Observación");

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
                "CodigoBarra", "Nombre", "Unidad", "CostoUnitario", "Cantidad", "SubTotal"
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);

        iconEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtEliminar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btntxtEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtEliminar.setText("Eliminar");
        btntxtEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtEliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtEliminarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addComponent(btntxtEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btntxtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelRound11.setBackground(new java.awt.Color(222, 225, 229));
        panelRound11.setRoundBottomLeft(15);
        panelRound11.setRoundBottomRight(15);
        panelRound11.setRoundTopLeft(15);
        panelRound11.setRoundTopRight(15);

        jLabel26.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(2, 0, 0));
        jLabel26.setText("Total :");

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(222, 225, 229));
        jTextField12.setBorder(null);
        jTextField12.setDisabledTextColor(new java.awt.Color(33, 114, 180));
        jTextField12.setEnabled(false);

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(110, 110, 110))
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jTextField12))
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);

        iconGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtGuardarEntrada.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btntxtGuardarEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtGuardarEntrada.setText("Guardar");
        btntxtGuardarEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtGuardarEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtGuardarEntradaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtGuardarEntradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtGuardarEntradaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtGuardarEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(120, 120, 120))
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtGuardarEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);

        iconCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtCancelar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btntxtCancelar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtCancelar.setText("Cancelar");
        btntxtCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtCancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtCancelarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
        panelRound13.setLayout(panelRound13Layout);
        panelRound13Layout.setHorizontalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(120, 120, 120))
        );
        panelRound13Layout.setVerticalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel2.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel8.setText("Información del Material");

        txtCant.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        panelRound4.setBackground(new java.awt.Color(255, 187, 92));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtBuscarMat.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        btntxtBuscarMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtBuscarMat.setText("Buscar");
        btntxtBuscarMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtBuscarMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtBuscarMatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtBuscarMatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtBuscarMatMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addGap(100, 100, 100))
            .addComponent(btntxtBuscarMat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtBuscarMat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound5.setBackground(new java.awt.Color(255, 187, 92));
        panelRound5.setRoundBottomLeft(15);
        panelRound5.setRoundBottomRight(15);
        panelRound5.setRoundTopLeft(15);
        panelRound5.setRoundTopRight(15);

        mas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btntxtAgMatEntrada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntxtAgMatEntrada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtAgMatEntrada.setText("Agregar");
        btntxtAgMatEntrada.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtAgMatEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtAgMatEntradaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtAgMatEntradaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtAgMatEntradaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btntxtAgMatEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mas1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btntxtAgMatEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mas1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel12.setText("Código de Barra del Producto");

        txtCodBarra.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 0, 16)); // NOI18N
        jLabel13.setText("Unidad");

        txtUnd.setEditable(false);
        txtUnd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel14.setText("Costo Unitario S/");

        txtCostUni.setEditable(false);
        txtCostUni.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        panelRound6.setBackground(new java.awt.Color(255, 187, 92));
        panelRound6.setRoundBottomLeft(15);
        panelRound6.setRoundBottomRight(15);
        panelRound6.setRoundTopLeft(15);
        panelRound6.setRoundTopRight(15);

        btntxtAgMat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntxtAgMat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btntxtAgMat.setText("Agregar");
        btntxtAgMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btntxtAgMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntxtAgMatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btntxtAgMatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btntxtAgMatMouseExited(evt);
            }
        });

        mas2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mas2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btntxtAgMat, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(mas2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btntxtAgMat, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(172, 172, 172))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(iconmat, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addComponent(txtCodBarra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(44, 44, 44)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUnd)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                        .addGap(12, 12, 12)
                        .addComponent(iconun, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCostUni)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                        .addGap(15, 15, 15)))
                .addGap(60, 60, 60)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCant)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(iconcan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .addGap(65, 65, 65)))
                .addGap(40, 40, 40)
                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                        .addGap(5, 5, 5))
                    .addComponent(iconmat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(iconcan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtUnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCostUni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCant, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(iconun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(50, 50, 50)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtObs);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(panelRound13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(110, 110, 110)
                                .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(100, 100, 100)
                                .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(170, 170, 170)
                                .addComponent(panelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(8, 8, 8)))
                        .addGap(132, 132, 132))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(folder, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(167, 167, 167))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(folder, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1322, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btntxtAgMatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseExited
        panelRound6.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtAgMatMouseExited

    private void btntxtAgMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseEntered
        panelRound6.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtAgMatMouseEntered

    private void btntxtAgMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseClicked
        registrarMaterialF frame = new registrarMaterialF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_btntxtAgMatMouseClicked

    private void btntxtAgMatEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatEntradaMouseExited
        panelRound5.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtAgMatEntradaMouseExited

    private void btntxtAgMatEntradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatEntradaMouseEntered
        panelRound5.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtAgMatEntradaMouseEntered

    private void btntxtBuscarMatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarMatMouseExited
        panelRound4.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtBuscarMatMouseExited

    private void btntxtBuscarMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarMatMouseEntered
        panelRound4.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtBuscarMatMouseEntered

    private void btntxtBuscarMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarMatMouseClicked
        buscarMaterialF frame = new buscarMaterialF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_btntxtBuscarMatMouseClicked

    private void btntxtCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtCancelarMouseExited
        panelRound13.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtCancelarMouseExited

    private void btntxtCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtCancelarMouseEntered

    private void btntxtGuardarEntradaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtGuardarEntradaMouseExited
        panelRound12.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtGuardarEntradaMouseExited

    private void btntxtGuardarEntradaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtGuardarEntradaMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtGuardarEntradaMouseEntered

    private void btntxtEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtEliminarMouseExited
        panelRound10.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtEliminarMouseExited

    private void btntxtEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtEliminarMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtEliminarMouseEntered

    private void btntxtBuscarProvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarProvMouseExited
        jPanel6.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtBuscarProvMouseExited

    private void btntxtBuscarProvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarProvMouseEntered
        jPanel6.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtBuscarProvMouseEntered

    private void btntxtBuscarProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtBuscarProvMouseClicked
        buscarProveedorF frame = new buscarProveedorF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_btntxtBuscarProvMouseClicked

    private void btntxtAñadirProvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAñadirProvMouseExited
        panelRound3.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtAñadirProvMouseExited

    private void btntxtAñadirProvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAñadirProvMouseEntered
        panelRound3.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtAñadirProvMouseEntered

    private void btntxtAñadirProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAñadirProvMouseClicked
        registrarProveedorF frame = new registrarProveedorF();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                llenarCmbProveedor();
            }
        });
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_btntxtAñadirProvMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btntxtAgMatEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatEntradaMouseClicked
        String codigoIngresado = txtCodBarra.getText().trim();
        String cantStr = txtCant.getText().trim();

        if (codigoIngresado.isEmpty() || cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Debe ingresar código de barra y cantidad",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        double cantidad;

        try {
            cantidad = Double.parseDouble(cantStr);
            if (cantidad <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Cantidad inválida",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        java.util.List<Map<String, Object>> resultado =
            GenericDAO.select(
                "Material",
                "CodigoBarra = ?",
                codigoIngresado
            );

        if (resultado.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No existe material con ese código de barra",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        Map<String, Object> material = resultado.get(0);

        String codigoBarra = material.get("CodigoBarra").toString();
        String nombre = material.get("Nombre").toString();
        String unidad = material.get("UnidadMedida").toString();

        double costoUnitario =
            Double.parseDouble(material.get("Precio").toString());

        boolean encontrado = false;

        for (Map<String, Object> filaExistente : detalleEntrada) {

            if (codigoBarra.equals(filaExistente.get("CodigoBarra").toString())) {

                double cantidadActual =
                    Double.parseDouble(filaExistente.get("Cantidad").toString());

                double nuevaCantidad = cantidadActual + cantidad;

                filaExistente.put("Cantidad", nuevaCantidad);
                filaExistente.put(
                    "SubTotal",
                    nuevaCantidad * costoUnitario
                );

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {

            double total = costoUnitario * cantidad;

            Map<String, Object> fila = new LinkedHashMap<>();
            fila.put("CodigoBarra", codigoBarra);
            fila.put("Nombre", nombre);
            fila.put("Unidad", unidad);
            fila.put("CostoUnitario", costoUnitario);
            fila.put("Cantidad", cantidad);
            fila.put("SubTotal", total);

            detalleEntrada.add(fila);
        }

        GenericDAO.llenarJTable(tablaEntrada, detalleEntrada);

        calcularTotalGeneral();

        txtCodBarra.setText("");
        txtCant.setText("");
        txtUnd.setText("");
        txtCostUni.setText("");
        txtCodBarra.requestFocus();
    }//GEN-LAST:event_btntxtAgMatEntradaMouseClicked

    private void btntxtEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtEliminarMouseClicked
        int[] filas = tablaEntrada.getSelectedRows();

        if (filas.length == 0) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar al menos un detalle para eliminar",
                "Selección requerida",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar el(los) detalle(s) seleccionado(s)?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        java.util.Arrays.sort(filas);

        for (int i = filas.length - 1; i >= 0; i--) {
            detalleEntrada.remove(filas[i]);
        }

        GenericDAO.llenarJTable(tablaEntrada, detalleEntrada);
        calcularTotalGeneral();

        JOptionPane.showMessageDialog(this,
            filas.length + " detalle(s) eliminado(s)",
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_btntxtEliminarMouseClicked

    private void btntxtCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btntxtCancelarMouseClicked

    private void btntxtGuardarEntradaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtGuardarEntradaMouseClicked
        if (txtNfactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No ha ingresado el número de factura",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (detalleEntrada == null || detalleEntrada.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "No hay materiales en el detalle",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nombreProveedor = cmbProvE.getSelectedItem().toString();

        List<Map<String, Object>> prov =
            GenericDAO.select(
                "Proveedor",
                "Nombre = ?",
                nombreProveedor
            );

        if (prov.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Proveedor no válido",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int proveedorID = Integer.parseInt(
            prov.get(0).get("ProveedorID").toString()
        );

        int usuarioID = user.getUsuarioID();
        String numeroFactura = txtNfactura.getText().trim();

        if (numeroFactura.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "El número de factura es obligatorio",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Map<String, Object>> facturaEntrada =
            GenericDAO.select(
                "Entrada",
                "NumeroFactura = ?",
                numeroFactura
            );

        List<Map<String, Object>> facturaSalida =
            GenericDAO.select(
                "Salida",
                "NumeroFactura = ?",
                numeroFactura
            );

        if (!facturaEntrada.isEmpty() || !facturaSalida.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "El número de factura ya existe en el sistema",
                "Factura duplicada",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        BigDecimal totalCompra =
            new BigDecimal(jTextField12.getText().trim());

        Timestamp fechaEntrada =
            new Timestamp(System.currentTimeMillis());

        LinkedHashMap<String, Object> entradaData = new LinkedHashMap<>();
        entradaData.put("ProveedorID", proveedorID);
        entradaData.put("UsuarioID", usuarioID);
        entradaData.put("NumeroFactura", numeroFactura);
        entradaData.put("FechaEntrada", fechaEntrada);
        entradaData.put("TotalCompra", totalCompra);
        entradaData.put("Observaciones", txtObs.getText().trim());

        int entradaID =
            GenericDAO.insertAndReturnID("Entrada", entradaData);

        if (entradaID <= 0) {
            JOptionPane.showMessageDialog(this,
                "No se pudo registrar la entrada",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Map<String, Object> fila : detalleEntrada) {

            String codigoBarra = fila.get("CodigoBarra").toString();
            BigDecimal cantidad = new BigDecimal(fila.get("Cantidad").toString());

            List<Map<String, Object>> mat =
                GenericDAO.select(
                    "Material",
                    "CodigoBarra = ?",
                    codigoBarra
                );

            if (mat.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                    "No existe material con código de barra: " + codigoBarra,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int materialID = Integer.parseInt(
                mat.get(0).get("MaterialID").toString()
            );

            BigDecimal stockActual = new BigDecimal(
                mat.get(0).get("StockActual").toString()
            );

            LinkedHashMap<String, Object> detalleData = new LinkedHashMap<>();
            detalleData.put("EntradaID", entradaID);
            detalleData.put("MaterialID", materialID);
            detalleData.put("Cantidad", cantidad);
            detalleData.put("CostoUnitario", fila.get("CostoUnitario"));

            GenericDAO.insert("DetalleEntrada", detalleData);

            BigDecimal nuevoStock = stockActual.add(cantidad);

            LinkedHashMap<String, Object> stockData = new LinkedHashMap<>();
            stockData.put("StockActual", nuevoStock);

            GenericDAO.update(
                "Material",
                stockData,
                "MaterialID = ?",
                materialID
            );
        }

        JOptionPane.showMessageDialog(this,
            "Entrada registrada correctamente",
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);

        detalleEntrada.clear();
        GenericDAO.llenarJTable(tablaEntrada, detalleEntrada);
        this.dispose();
    }//GEN-LAST:event_btntxtGuardarEntradaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatMTMaterialLighterIJTheme.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarEntradaF().setVisible(true);
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
    
    private void llenarCmbProveedor() {
        List<Map<String, Object>> proveedores =
            GenericDAO.select(
                "Proveedor",
                "1 = ?",
                1
            );
        GenericDAO.llenarComboDesdeTabla(cmbProvE, proveedores, "Nombre");
    }
    
    private void actualizarUnidadYCostoPorCodigoBarra(String codigoBarra) {
        if (codigoBarra == null || codigoBarra.trim().isEmpty()) {
            txtUnd.setText("");
            txtCostUni.setText("");
            return;
        }

        java.util.List<Map<String, Object>> resultado =
            GenericDAO.select(
                "Material",
                "CodigoBarra = ?",
                codigoBarra.trim()
            );
        if (resultado.isEmpty()) {
            txtUnd.setText("");
            txtCostUni.setText("");
            return;
        }

        Map<String, Object> material = resultado.get(0);

        Object unidad = material.get("UnidadMedida");
        Object costo = material.get("Precio");

        txtUnd.setText(unidad != null ? unidad.toString() : "");
        txtCostUni.setText(costo != null ? costo.toString() : "");
    }
    
    private void calcularTotalGeneral() {

        double totalGeneral = 0.0;

        if (detalleEntrada == null || detalleEntrada.isEmpty()) {
            jTextField12.setText("0.00");
            return;
        }

        for (Map<String, Object> fila : detalleEntrada) {

            Object totalObj = fila.get("SubTotal");

            if (totalObj != null) {
                totalGeneral += Double.parseDouble(totalObj.toString());
            }
        }

        jTextField12.setText(String.format("%.2f", totalGeneral));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btntxtAgMat;
    private javax.swing.JLabel btntxtAgMatEntrada;
    private javax.swing.JLabel btntxtAñadirProv;
    private javax.swing.JLabel btntxtBuscarMat;
    private javax.swing.JLabel btntxtBuscarProv;
    private javax.swing.JLabel btntxtCancelar;
    private javax.swing.JLabel btntxtEliminar;
    private javax.swing.JLabel btntxtGuardarEntrada;
    private javax.swing.JComboBox<String> cmbProvE;
    private javax.swing.JLabel folder;
    private javax.swing.JLabel iconCancelar;
    private javax.swing.JLabel iconEliminar;
    private javax.swing.JLabel iconGuardar;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel iconcan;
    private javax.swing.JLabel iconem;
    private javax.swing.JLabel iconmat;
    private javax.swing.JLabel iconun;
    private javax.swing.JLabel ie;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel mas;
    private javax.swing.JLabel mas1;
    private javax.swing.JLabel mas2;
    private javax.swing.JLabel nFac;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound11;
    private Clases.PanelRound panelRound12;
    private Clases.PanelRound panelRound13;
    private Clases.PanelRound panelRound3;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    private Clases.PanelRound panelRound6;
    private javax.swing.JLabel prov;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextField txtCant;
    private javax.swing.JTextField txtCodBarra;
    private javax.swing.JTextField txtCostUni;
    private javax.swing.JTextField txtNfactura;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtUnd;
    // End of variables declaration//GEN-END:variables
}
