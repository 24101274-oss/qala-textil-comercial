package UI;
import UTIL.MaxLengthFilter;
import UTIL.PriceFilter;
import BEAN.Usuario;
import DAO.GenericDAO;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMaterialLighterIJTheme;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;
import java.sql.*;
import UTIL.dbBean;
import SERVICE.ClienteService;

public class registrarSalidaF extends javax.swing.JFrame {
    private java.util.List<Map<String, Object>> detalleSalida;
    Usuario user;
    public registrarSalidaF() {
        initComponents();
        InitIcons();
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        llenarCmbtipSalida();
        
        txtObs.setLineWrap(true);
        txtObs.setWrapStyleWord(true);
        
        detalleSalida = new java.util.ArrayList<>();
        
        ((AbstractDocument) txtfacSalida.getDocument())
                .setDocumentFilter(new MaxLengthFilter(50));
        
        ((AbstractDocument) txtObs.getDocument())
                .setDocumentFilter(new MaxLengthFilter(255));
        
        ((AbstractDocument) txtcantSalida.getDocument())
                .setDocumentFilter(new PriceFilter());
        
        txtmatSalida.getDocument().addDocumentListener(new DocumentListener() {
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
                actualizarUnidadYCostoPorCodigoBarra(txtmatSalida.getText());
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
        SetImageLabel(lupita, "icons/lupa.png");
        SetImageLabel(mas, "icons/mas.png");
        SetImageLabel(jLabel9, "icons/lupa.png");
        SetImageLabel(folder, "icons/folder.png");
        SetImageLabel(iconem, "icons/qt.png");
        SetImageLabel(iconmat, "icons/boxout.png");
        SetImageLabel(iconcan, "icons/stock.png");
        SetImageLabel(iconCancelar, "icons/x.png");
        SetImageLabel(iconEliminar, "icons/trash.png");
        SetImageLabel(iconGuardar, "icons/check.png");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        iconUser = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        iconem = new javax.swing.JLabel();
        panelRound1 = new Clases.PanelRound();
        jlabel3 = new javax.swing.JLabel();
        cmbtipSalida = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtdestSalida = new javax.swing.JTextField();
        ie = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        txtfacSalida = new javax.swing.JTextField();
        panelRound8 = new Clases.PanelRound();
        mas = new javax.swing.JLabel();
        btnAñadirCiente = new javax.swing.JLabel();
        panelRound7 = new Clases.PanelRound();
        lupita = new javax.swing.JLabel();
        btnBuscarCiente = new javax.swing.JLabel();
        folder = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        iconmat = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtcantSalida = new javax.swing.JTextField();
        panelRound4 = new Clases.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        btnBuscarMaterial = new javax.swing.JLabel();
        panelRound5 = new Clases.PanelRound();
        btnAgregarMaterial = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtmatSalida = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtstockSalida = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtprecioSalida = new javax.swing.JTextField();
        iconcan = new javax.swing.JLabel();
        panelRound6 = new Clases.PanelRound();
        btntxtAgMat = new javax.swing.JLabel();
        mas2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        panelRound10 = new Clases.PanelRound();
        iconEliminar = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        panelRound11 = new Clases.PanelRound();
        jLabel26 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        panelRound12 = new Clases.PanelRound();
        iconGuardar = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        iconCancelar = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 133, 58));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registrar Nueva Salida");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(226, 232, 240));
        jTextField1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 104), 2, true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(208, 208, 208)
                .addComponent(iconUser, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(iconem, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addComponent(iconUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(iconem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 177, 116), 4, true));
        panelRound1.setRoundBottomLeft(25);
        panelRound1.setRoundBottomRight(25);
        panelRound1.setRoundTopLeft(25);
        panelRound1.setRoundTopRight(25);

        jlabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jlabel3.setText("Observación");

        cmbtipSalida.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        cmbtipSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        cmbtipSalida.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel7.setText("Información de Salida");

        txtdestSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        txtdestSalida.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtdestSalidaFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 1, 16)); // NOI18N
        jLabel6.setText("Tipo de Salida");

        jlabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jlabel4.setText("Cliente / Destinatario");

        jlabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jlabel5.setText("N° Factura");

        txtfacSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));

        panelRound8.setBackground(new java.awt.Color(244, 179, 87));
        panelRound8.setRoundBottomLeft(15);
        panelRound8.setRoundBottomRight(15);
        panelRound8.setRoundTopLeft(15);
        panelRound8.setRoundTopRight(15);

        mas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnAñadirCiente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnAñadirCiente.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirCiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAñadirCiente.setText("Añadir Cliente");
        btnAñadirCiente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAñadirCiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAñadirCienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAñadirCienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAñadirCienteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound8Layout = new javax.swing.GroupLayout(panelRound8);
        panelRound8.setLayout(panelRound8Layout);
        panelRound8Layout.setHorizontalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAñadirCiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(152, Short.MAX_VALUE)))
        );
        panelRound8Layout.setVerticalGroup(
            panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAñadirCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelRound8Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(mas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(8, Short.MAX_VALUE)))
        );

        panelRound7.setBackground(new java.awt.Color(244, 179, 87));
        panelRound7.setRoundBottomLeft(15);
        panelRound7.setRoundBottomRight(15);
        panelRound7.setRoundTopLeft(15);
        panelRound7.setRoundTopRight(15);

        btnBuscarCiente.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnBuscarCiente.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarCiente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarCiente.setText("Buscar Cliente");
        btnBuscarCiente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarCiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarCienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarCienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarCienteMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound7Layout = new javax.swing.GroupLayout(panelRound7);
        panelRound7.setLayout(panelRound7Layout);
        panelRound7Layout.setHorizontalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lupita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnBuscarCiente, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
        );
        panelRound7Layout.setVerticalGroup(
            panelRound7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lupita, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnBuscarCiente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtObs.setColumns(20);
        txtObs.setRows(5);
        txtObs.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtObs);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(ie, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(folder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(684, 684, 684))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(897, 897, 897))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(cmbtipSalida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(248, 248, 248)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(txtdestSalida)
                                .addGap(52, 52, 52))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(58, 58, 58)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelRound8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelRound7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(txtfacSalida)
                                .addGap(5, 5, 5))
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jlabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(102, 102, 102))))))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                    .addContainerGap(33, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(folder, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                .addGap(15, 15, 15)))
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(panelRound8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbtipSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdestSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfacSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jlabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                .addGap(55, 55, 55))
            .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                    .addContainerGap(198, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(221, 177, 116), 4, true));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel2.setText("Cantidad");

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 20)); // NOI18N
        jLabel8.setText("Información del Material");

        txtcantSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        panelRound4.setBackground(new java.awt.Color(255, 187, 92));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setRoundTopLeft(15);
        panelRound4.setRoundTopRight(15);

        btnBuscarMaterial.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnBuscarMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarMaterial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBuscarMaterial.setText("Buscar");
        btnBuscarMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscarMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMaterialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBuscarMaterialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBuscarMaterialMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(btnBuscarMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnBuscarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound5.setBackground(new java.awt.Color(255, 187, 92));
        panelRound5.setRoundBottomLeft(15);
        panelRound5.setRoundBottomRight(15);
        panelRound5.setRoundTopLeft(15);
        panelRound5.setRoundTopRight(15);

        btnAgregarMaterial.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnAgregarMaterial.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMaterial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAgregarMaterial.setText("Agregar");
        btnAgregarMaterial.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMaterialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMaterialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMaterialMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregarMaterial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnAgregarMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel12.setText("Producto / Material");

        txtmatSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("Stock Actual");

        txtstockSalida.setEditable(false);
        txtstockSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel14.setText("Precio S/");

        txtprecioSalida.setEditable(false);
        txtprecioSalida.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(186, 151, 113), 2, true));

        panelRound6.setBackground(new java.awt.Color(255, 187, 92));
        panelRound6.setRoundBottomLeft(15);
        panelRound6.setRoundBottomRight(15);
        panelRound6.setRoundTopLeft(15);
        panelRound6.setRoundTopRight(15);

        btntxtAgMat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntxtAgMat.setForeground(new java.awt.Color(255, 255, 255));
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
                .addContainerGap(106, Short.MAX_VALUE))
            .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btntxtAgMat, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(iconmat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(666, 666, 666))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(74, 74, 74))
                            .addComponent(txtmatSalida))
                        .addGap(30, 30, 30)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstockSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(112, 112, 112)
                                .addComponent(iconcan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                .addGap(248, 248, 248))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtprecioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(txtcantSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(261, 261, 261)
                    .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(801, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(iconmat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(35, 35, 35))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(iconcan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtprecioSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcantSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtmatSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtstockSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRound5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(54, 54, 54)
                    .addComponent(panelRound6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(55, 55, 55)))
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
                "Código", "Producto / Material", "UND", "Cant.", "Costo Unit.", "SubTotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, true
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
            .addComponent(jScrollPane1)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))
        );

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);

        btnEliminar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminar.setText("Eliminar");
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

        javax.swing.GroupLayout panelRound10Layout = new javax.swing.GroupLayout(panelRound10);
        panelRound10.setLayout(panelRound10Layout);
        panelRound10Layout.setHorizontalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound10Layout.setVerticalGroup(
            panelRound10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound11.setBackground(new java.awt.Color(222, 225, 229));
        panelRound11.setRoundBottomLeft(15);
        panelRound11.setRoundBottomRight(15);
        panelRound11.setRoundTopLeft(15);
        panelRound11.setRoundTopRight(15);

        jLabel26.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(2, 0, 0));
        jLabel26.setText("Total :");

        txtTotal.setEditable(false);
        txtTotal.setBackground(new java.awt.Color(222, 225, 229));
        txtTotal.setBorder(null);
        txtTotal.setDisabledTextColor(new java.awt.Color(33, 114, 180));
        txtTotal.setEnabled(false);

        javax.swing.GroupLayout panelRound11Layout = new javax.swing.GroupLayout(panelRound11);
        panelRound11.setLayout(panelRound11Layout);
        panelRound11Layout.setHorizontalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(txtTotal))
            .addGroup(panelRound11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(110, 110, 110))
        );
        panelRound11Layout.setVerticalGroup(
            panelRound11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);

        btnGuardar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuardarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelRound12Layout = new javax.swing.GroupLayout(panelRound12);
        panelRound12.setLayout(panelRound12Layout);
        panelRound12Layout.setHorizontalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(iconGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRound12Layout.setVerticalGroup(
            panelRound12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panelRound12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);

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

        javax.swing.GroupLayout panelRound13Layout = new javax.swing.GroupLayout(panelRound13);
        panelRound13.setLayout(panelRound13Layout);
        panelRound13Layout.setHorizontalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelRound13Layout.setVerticalGroup(
            panelRound13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(iconCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(130, 130, 130))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelRound13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(130, 130, 130)
                        .addComponent(panelRound10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(130, 130, 130)
                        .addComponent(panelRound11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(170, 170, 170)
                        .addComponent(panelRound12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelRound13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelRound12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1391, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1027, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void btnBuscarCienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCienteMouseEntered
        panelRound7.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnBuscarCienteMouseEntered

    private void btnBuscarCienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCienteMouseExited
        panelRound7.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnBuscarCienteMouseExited

    private void btnBuscarMaterialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMaterialMouseEntered
        panelRound4.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnBuscarMaterialMouseEntered

    private void btnBuscarMaterialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMaterialMouseExited
        panelRound4.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnBuscarMaterialMouseExited

    private void btnAgregarMaterialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMaterialMouseEntered
        panelRound5.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnAgregarMaterialMouseEntered

    private void btnAgregarMaterialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMaterialMouseExited
        panelRound5.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnAgregarMaterialMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        panelRound13.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        panelRound10.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnGuardarMouseEntered

    private void btnGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseExited
        panelRound12.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnGuardarMouseExited

    private void btnBuscarCienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarCienteMouseClicked
        buscarClienteF frame = new buscarClienteF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_btnBuscarCienteMouseClicked

    private void btnBuscarMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMaterialMouseClicked
        buscarMaterialF frame = new buscarMaterialF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_btnBuscarMaterialMouseClicked

    private void btnAñadirCienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirCienteMouseClicked
        registroClienteF frame = new registroClienteF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_btnAñadirCienteMouseClicked

    private void btnAñadirCienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirCienteMouseEntered
        panelRound8.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnAñadirCienteMouseEntered

    private void btnAñadirCienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAñadirCienteMouseExited
        panelRound8.setBackground(new Color(244,179,87));
    }//GEN-LAST:event_btnAñadirCienteMouseExited

    private void txtdestSalidaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtdestSalidaFocusLost
        String nombreCliente = txtdestSalida.getText().trim();
    
    // Si está vacío, no hacemos nada
    if (nombreCliente.isEmpty()) {
        return;
    }
    
    try {
        // Delegamos la búsqueda a nuestra fachada (Servicio)
        SERVICE.ClienteService servicio = new SERVICE.ClienteService();
        java.util.List<java.util.Map<String, Object>> clienteExistente = servicio.buscarClientePorNombreExacto(nombreCliente);

        // Si la lista está vacía, el cliente no existe
        if (clienteExistente.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "El cliente ingresado no existe en el sistema",
                "Cliente no encontrado",
                javax.swing.JOptionPane.WARNING_MESSAGE);
        }
        
    } catch (Exception e) {
        // Atrapamos si hay algún error de base de datos
        javax.swing.JOptionPane.showMessageDialog(this,
            "Error al verificar el cliente: " + e.getMessage(),
            "Error",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_txtdestSalidaFocusLost

    private void btntxtAgMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseClicked
        registrarMaterialF frame = new registrarMaterialF();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_btntxtAgMatMouseClicked

    private void btntxtAgMatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseEntered
        panelRound6.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btntxtAgMatMouseEntered

    private void btntxtAgMatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntxtAgMatMouseExited
        panelRound6.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btntxtAgMatMouseExited

    private void btnAgregarMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMaterialMouseClicked
        String codigoIngresado = txtmatSalida.getText().trim();
    String cantStr = txtcantSalida.getText().trim();

    // 1. Validaciones básicas de la UI
    if (codigoIngresado.isEmpty() || cantStr.isEmpty()) {
        javax.swing.JOptionPane.showMessageDialog(this, "Debe ingresar código de barra y cantidad", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    double cantidad;
    try {
        cantidad = Double.parseDouble(cantStr);
        if (cantidad <= 0) throw new NumberFormatException();
    } catch (NumberFormatException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Cantidad inválida", "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 2. Pedimos al MaterialService que busque el material de forma segura
        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        Map<String, Object> material = servicio.buscarMaterialPorCodigoBarra(codigoIngresado);

        // 3. Extraemos los datos
        String codigoBarra = material.get("CodigoBarra").toString();
        String nombre = material.get("Nombre").toString();
        String unidad = material.get("UnidadMedida").toString();
        double costoUnitario = Double.parseDouble(material.get("Precio").toString());

        boolean encontrado = false;

        // 4. Lógica de la tabla temporal
        for (Map<String, Object> filaExistente : detalleSalida) {
            if (codigoBarra.equals(filaExistente.get("CodigoBarra").toString())) {
                double cantidadActual = Double.parseDouble(filaExistente.get("Cantidad").toString());
                double nuevaCantidad = cantidadActual + cantidad;

                filaExistente.put("Cantidad", nuevaCantidad);
                filaExistente.put("SubTotal", nuevaCantidad * costoUnitario);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            double total = costoUnitario * cantidad;
            Map<String, Object> fila = new java.util.LinkedHashMap<>();
            fila.put("CodigoBarra", codigoBarra);
            fila.put("Nombre", nombre);
            fila.put("Unidad", unidad);
            fila.put("PrecioUnitario", costoUnitario);
            fila.put("Cantidad", cantidad);
            fila.put("SubTotal", total);
            detalleSalida.add(fila);
        }

        // 5. Refrescamos UI
        DAO.GenericDAO.llenarJTable(tablaEntrada, detalleSalida);
        calcularTotalGeneral();

        txtmatSalida.setText("");
        txtcantSalida.setText("");
        txtstockSalida.setText("");
        txtprecioSalida.setText("");
        txtmatSalida.requestFocus();

    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage(), "Validación", javax.swing.JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregarMaterialMouseClicked

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
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
            detalleSalida.remove(filas[i]);
        }

        GenericDAO.llenarJTable(tablaEntrada, detalleSalida);
        calcularTotalGeneral();

        JOptionPane.showMessageDialog(this,
            filas.length + " detalle(s) eliminado(s)",
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }//GEN-LAST:event_btnEliminarMouseClicked

    private void btnGuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarMouseClicked
        // 1. Validaciones visuales rápidas
    if (txtfacSalida.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "No ha ingresado el número de factura", "Validación", JOptionPane.WARNING_MESSAGE);
        return;
    }
    if (detalleSalida == null || detalleSalida.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No hay materiales en el detalle", "Validación", JOptionPane.WARNING_MESSAGE);
        return;
    }

    try {
        // 2. Extraemos los valores de la ventana
        int usuarioID = user.getUsuarioID(); 
        String numeroFactura = txtfacSalida.getText().trim();
        String tipoSalida = cmbtipSalida.getSelectedItem().toString();
        String nombreCliente = txtdestSalida.getText().trim();
        BigDecimal totalVenta = new BigDecimal(txtTotal.getText().trim());
        String observaciones = txtObs.getText().trim();

        // 3. Enviamos todo a la Fachada (Service)
        SERVICE.SalidaService servicio = new SERVICE.SalidaService();
        servicio.registrarSalidaCompleta(usuarioID, numeroFactura, tipoSalida, nombreCliente, totalVenta, observaciones, detalleSalida);

        // 4. Si el servicio no lanzó error, mostramos éxito
        JOptionPane.showMessageDialog(this, "Salida registrada correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        detalleSalida.clear();
        DAO.GenericDAO.llenarJTable(tablaEntrada, detalleSalida);
        this.dispose();

    } catch (Exception e) {
        // Atrapamos cualquier error de base de datos o stock y lo mostramos
        JOptionPane.showMessageDialog(this, e.getMessage(), "Error o Validación", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMTMaterialLighterIJTheme.setup();
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarSalidaF().setVisible(true);
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
    
    private void llenarCmbtipSalida() {
    try {
        // Pedimos la lista al Servicio
        SERVICE.SalidaService servicio = new SERVICE.SalidaService();
        java.util.List<java.util.Map<String, Object>> tipSalida = servicio.obtenerTiposDeSalida();
        
        // Llenamos el combo
        DAO.GenericDAO.llenarComboDesdeTabla(cmbtipSalida, tipSalida, "Descripcion");
        
    } catch (Exception e) {
        System.out.println("Error al cargar los tipos de salida: " + e.getMessage());
    }
}
    
    private void actualizarUnidadYCostoPorCodigoBarra(String codigoBarra) {
    if (codigoBarra == null || codigoBarra.trim().isEmpty()) {
        txtstockSalida.setText("");
        txtprecioSalida.setText("");
        return;
    }

    try {
        // Reutilizamos el MaterialService que ya tiene este método listo
        SERVICE.MaterialService servicio = new SERVICE.MaterialService();
        java.util.Map<String, Object> material = servicio.buscarMaterialPorCodigoBarra(codigoBarra.trim());

        // Extraemos el stock y el costo
        Object stock = material.get("StockActual");
        Object costo = material.get("Precio");

        txtstockSalida.setText(stock != null ? stock.toString() : "");
        txtprecioSalida.setText(costo != null ? costo.toString() : "");

    } catch (Exception e) {
        // Si el servicio no encuentra el material (tira excepción), limpiamos las cajas
        txtstockSalida.setText("");
        txtprecioSalida.setText("");
    }
}
    
    private void calcularTotalGeneral() {

        double totalGeneral = 0.0;

        if (detalleSalida == null || detalleSalida.isEmpty()) {
            txtTotal.setText("0.00");
            return;
        }

        for (Map<String, Object> fila : detalleSalida) {

            Object totalObj = fila.get("SubTotal");

            if (totalObj != null) {
                totalGeneral += Double.parseDouble(totalObj.toString());
            }
        }

        txtTotal.setText(String.format("%.2f", totalGeneral));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAgregarMaterial;
    private javax.swing.JLabel btnAñadirCiente;
    private javax.swing.JLabel btnBuscarCiente;
    private javax.swing.JLabel btnBuscarMaterial;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel btnGuardar;
    private javax.swing.JLabel btntxtAgMat;
    private javax.swing.JComboBox<String> cmbtipSalida;
    private javax.swing.JLabel folder;
    private javax.swing.JLabel iconCancelar;
    private javax.swing.JLabel iconEliminar;
    private javax.swing.JLabel iconGuardar;
    private javax.swing.JLabel iconUser;
    private javax.swing.JLabel iconcan;
    private javax.swing.JLabel iconem;
    private javax.swing.JLabel iconmat;
    private javax.swing.JLabel ie;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel lupita;
    private javax.swing.JLabel mas;
    private javax.swing.JLabel mas2;
    private Clases.PanelRound panelRound1;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound11;
    private Clases.PanelRound panelRound12;
    private Clases.PanelRound panelRound13;
    private Clases.PanelRound panelRound4;
    private Clases.PanelRound panelRound5;
    private Clases.PanelRound panelRound6;
    private Clases.PanelRound panelRound7;
    private Clases.PanelRound panelRound8;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtcantSalida;
    private javax.swing.JTextField txtdestSalida;
    private javax.swing.JTextField txtfacSalida;
    private javax.swing.JTextField txtmatSalida;
    private javax.swing.JTextField txtprecioSalida;
    private javax.swing.JTextField txtstockSalida;
    // End of variables declaration//GEN-END:variables
}
