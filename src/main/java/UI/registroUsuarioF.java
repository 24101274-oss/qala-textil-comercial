/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;
import BEAN.MaxLengthFilter;
import BEAN.Usuario;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.AbstractDocument;


public class registroUsuarioF extends javax.swing.JFrame {
    Usuario user;
    int xMouse, yMouse;
    public registroUsuarioF() {
        initComponents();
        SetImageLabel(ie, "icons/buscarCliente.png");
        SetImageLabel(iconem, "icons/qt.png");
        
        SetImageLabel(iconCancelar, "icons/x.png");
        SetImageLabel(iconEliminar, "icons/trash.png");
        SetImageLabel(iconGuardar, "icons/check.png");
        
        SetImageLabel(iconlupa, "icons/phone.png");
        SetImageLabel(actualizar, "icons/actualizar.png");
        
        SetImageLabel(iconlupa, "icons/lupa.png");
        
        personalizarHeader(tablaEntrada, new Color(251,183,82), new Color(255, 255, 255), new Font("tablaEntrada", Font.BOLD, 14));
        tablaEntrada.setRowHeight(25);
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        tablaEntrada.setDragEnabled(false);
        tablaEntrada.setDropMode(DropMode.USE_SELECTION);
        
        ((AbstractDocument) userTxt.getDocument())
                .setDocumentFilter(new MaxLengthFilter(50));
        
        ((AbstractDocument) passTxt.getDocument())
                .setDocumentFilter(new MaxLengthFilter(72));
        
        llenarUsuarios("");
        configurarSeleccionTabla();
        
        txtBusqUsuario.getDocument().addDocumentListener(new DocumentListener() {
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
                if (txtBusqUsuario.getText().equals("Ingrese nombre de Usuario")) {
                    llenarUsuarios("");
                } else {
                    llenarUsuarios(txtBusqUsuario.getText());
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
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        passTxt = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        userTxt = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEntrada = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        iconlupa = new javax.swing.JLabel();
        txtBusqUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panelRound10 = new Clases.PanelRound();
        btnEliminarUsuario = new javax.swing.JLabel();
        iconEliminar = new javax.swing.JLabel();
        panelRound12 = new Clases.PanelRound();
        btnRegUsuario = new javax.swing.JLabel();
        iconGuardar = new javax.swing.JLabel();
        panelRound13 = new Clases.PanelRound();
        btnCancelar = new javax.swing.JLabel();
        iconCancelar = new javax.swing.JLabel();
        panelRound14 = new Clases.PanelRound();
        btnActUsuario = new javax.swing.JLabel();
        actualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(ie, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 80));
        jPanel2.add(iconem, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 110, 90));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 128, 47));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Registro de Usuario");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1630, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel13.setText("CONTRASEÑA");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, 35));

        jLabel14.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel14.setText("PERMISOS");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 35));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel4.setText("ESTADO");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, -1, 35));

        jLabel15.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jLabel15.setText("USUARIO");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 35));

        jComboBox1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "No Activo" }));
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 160, 40));

        jComboBox2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Trabajador" }));
        jComboBox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(193, 167, 130), 2, true));
        jComboBox2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 160, 40));

        passTxt.setForeground(new java.awt.Color(204, 204, 204));
        passTxt.setText("********");
        passTxt.setBorder(null);
        passTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passTxtFocusLost(evt);
            }
        });
        passTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passTxtMousePressed(evt);
            }
        });
        passTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passTxtKeyPressed(evt);
            }
        });
        jPanel3.add(passTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 410, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 410, 20));

        userTxt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        userTxt.setForeground(new java.awt.Color(204, 204, 204));
        userTxt.setText("Ingrese nombre de Usuario");
        userTxt.setBorder(null);
        userTxt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userTxtFocusLost(evt);
            }
        });
        userTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userTxtMousePressed(evt);
            }
        });
        userTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTxtActionPerformed(evt);
            }
        });
        userTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userTxtKeyPressed(evt);
            }
        });
        jPanel3.add(userTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 410, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 410, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 530, 350));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(251, 223, 183), 4, true));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaEntrada.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablaEntrada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Usuario", "Nombre", "Rol", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaEntrada.setRowHeight(25);
        tablaEntrada.setSelectionBackground(new java.awt.Color(250, 222, 182));
        tablaEntrada.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaEntrada);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 710, 240));

        jLabel12.setFont(new java.awt.Font("Segoe UI Symbol", 1, 18)); // NOI18N
        jLabel12.setText("BUSCAR :");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, 35));
        jPanel5.add(iconlupa, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 40, 30));

        txtBusqUsuario.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtBusqUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtBusqUsuario.setText("Ingrese nombre de Usuario");
        txtBusqUsuario.setBorder(null);
        txtBusqUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBusqUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBusqUsuarioFocusLost(evt);
            }
        });
        txtBusqUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtBusqUsuarioMousePressed(evt);
            }
        });
        txtBusqUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusqUsuarioActionPerformed(evt);
            }
        });
        txtBusqUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusqUsuarioKeyPressed(evt);
            }
        });
        jPanel5.add(txtBusqUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 410, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 410, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 180, 790, 350));

        panelRound10.setBackground(new java.awt.Color(255, 187, 92));
        panelRound10.setRoundBottomLeft(15);
        panelRound10.setRoundBottomRight(15);
        panelRound10.setRoundTopLeft(15);
        panelRound10.setRoundTopRight(15);
        panelRound10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarUsuarioMouseExited(evt);
            }
        });
        panelRound10.add(btnEliminarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 40));
        panelRound10.add(iconEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jPanel1.add(panelRound10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 590, 180, -1));

        panelRound12.setBackground(new java.awt.Color(255, 187, 92));
        panelRound12.setRoundBottomLeft(15);
        panelRound12.setRoundBottomRight(15);
        panelRound12.setRoundTopLeft(15);
        panelRound12.setRoundTopRight(15);
        panelRound12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnRegUsuario.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        btnRegUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnRegUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRegUsuario.setText("Registrar Usuario");
        btnRegUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegUsuarioMouseExited(evt);
            }
        });
        panelRound12.add(btnRegUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));
        panelRound12.add(iconGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jPanel1.add(panelRound12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 590, 190, -1));

        panelRound13.setBackground(new java.awt.Color(255, 187, 92));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setRoundTopLeft(15);
        panelRound13.setRoundTopRight(15);
        panelRound13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        panelRound13.add(iconCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 20, 20));

        jPanel1.add(panelRound13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 590, 190, 40));

        panelRound14.setBackground(new java.awt.Color(255, 187, 92));
        panelRound14.setRoundBottomLeft(15);
        panelRound14.setRoundBottomRight(15);
        panelRound14.setRoundTopLeft(15);
        panelRound14.setRoundTopRight(15);
        panelRound14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnActUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnActUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnActUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnActUsuario.setText("Actualizar Usuario");
        btnActUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnActUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActUsuarioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActUsuarioMouseExited(evt);
            }
        });
        panelRound14.add(btnActUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));
        panelRound14.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jPanel1.add(panelRound14, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 590, 190, -1));

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1629, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void txtBusqUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBusqUsuarioMousePressed
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese  nombre de Usuario");
            userTxt.setForeground(Color.gray);
        }
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
        if (txtBusqUsuario.getText().equals("Ingrese  nombre de Usuario")) {
            txtBusqUsuario.setText("");
            txtBusqUsuario.setForeground(Color.black);
        
        }
    }//GEN-LAST:event_txtBusqUsuarioMousePressed

    private void txtBusqUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusqUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusqUsuarioActionPerformed

    private void txtBusqUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusqUsuarioKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            getFocusOwner().transferFocus();
        }
    }//GEN-LAST:event_txtBusqUsuarioKeyPressed

    private void passTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese su nombre de usuario");
            userTxt.setForeground(Color.gray);
        }
        if (txtBusqUsuario.getText().isEmpty()) {
            txtBusqUsuario.setText("Ingrese  nombre de Usuario");
            txtBusqUsuario.setForeground(Color.gray);
        
        }
        
    }//GEN-LAST:event_passTxtMousePressed

    private void passTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passTxtKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER){
            getFocusOwner().transferFocus();
        }
    }//GEN-LAST:event_passTxtKeyPressed

    private void userTxtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTxtMousePressed
        if (String.valueOf(passTxt.getPassword()).isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.gray);
        }
        if (userTxt.getText().equals("Ingrese  nombre de Usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
        if (txtBusqUsuario.getText().isEmpty()) {
            txtBusqUsuario.setText("Ingrese  nombre de Usuario");
            txtBusqUsuario.setForeground(Color.gray);
        
        }
    }//GEN-LAST:event_userTxtMousePressed

    private void userTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtActionPerformed

    private void userTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTxtKeyPressed

    private void btnRegUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegUsuarioMouseEntered
        panelRound12.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnRegUsuarioMouseEntered

    private void btnRegUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegUsuarioMouseExited
        panelRound12.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnRegUsuarioMouseExited

    private void btnActUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActUsuarioMouseEntered
        panelRound14.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnActUsuarioMouseEntered

    private void btnActUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActUsuarioMouseExited
        panelRound14.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnActUsuarioMouseExited

    private void btnEliminarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseEntered
        panelRound10.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnEliminarUsuarioMouseEntered

    private void btnEliminarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseExited
        panelRound10.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnEliminarUsuarioMouseExited

    private void btnCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseEntered
        panelRound13.setBackground(new Color(255,161,27));
    }//GEN-LAST:event_btnCancelarMouseEntered

    private void btnCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseExited
        panelRound13.setBackground(new Color(255,187,92));
    }//GEN-LAST:event_btnCancelarMouseExited

    private void userTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTxtFocusGained
        if (userTxt.getText().equals("Ingrese nombre de Usuario")) {
            userTxt.setText("");
            userTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_userTxtFocusGained

    private void userTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userTxtFocusLost
        if (userTxt.getText().isEmpty()) {
            userTxt.setText("Ingrese nombre de Usuario");
            userTxt.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_userTxtFocusLost

    private void passTxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTxtFocusGained
        if (passTxt.getText().equals("********")) {
            passTxt.setText("");
            passTxt.setForeground(Color.black);
        }
    }//GEN-LAST:event_passTxtFocusGained

    private void passTxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passTxtFocusLost
        if (passTxt.getText().isEmpty()) {
            passTxt.setText("********");
            passTxt.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_passTxtFocusLost

    private void txtBusqUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqUsuarioFocusGained
        if (txtBusqUsuario.getText().equals("Ingrese nombre de Usuario")) {
            txtBusqUsuario.setText("");
            txtBusqUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtBusqUsuarioFocusGained

    private void txtBusqUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBusqUsuarioFocusLost
        if (txtBusqUsuario.getText().isEmpty()) {
            txtBusqUsuario.setText("Ingrese nombre de Usuario");
            txtBusqUsuario.setForeground(Color.lightGray);
        }
    }//GEN-LAST:event_txtBusqUsuarioFocusLost

    private void btnRegUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegUsuarioMouseClicked
        String username = userTxt.getText().trim();
        String passwordPlano = passTxt.getText().trim();
        String nombreRol = jComboBox2.getSelectedItem() != null
                ? jComboBox2.getSelectedItem().toString()
                : "";
        String estadoTexto = jComboBox1.getSelectedItem() != null
                ? jComboBox1.getSelectedItem().toString()
                : "";
        if(user.getRolID() != 1 && nombreRol.equals("Administrador")){
            JOptionPane.showMessageDialog(this,
                "Solo los administradores pueden crear cuentas de administrador",
                "Permiso no concedido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (username.isEmpty() || username.equals("Ingrese nombre de Usuario")) {
            JOptionPane.showMessageDialog(this,
                "El nombre de usuario es obligatorio",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            userTxt.requestFocus();
            return;
        }

        if (passwordPlano.isEmpty() || passwordPlano.equals("********")) {
            JOptionPane.showMessageDialog(this,
                "La contraseña es obligatoria",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            passTxt.requestFocus();
            return;
        }

        if (passwordPlano.length() < 6) {
            JOptionPane.showMessageDialog(this,
                "La contraseña debe tener al menos 6 caracteres",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            passTxt.requestFocus();
            return;
        }

        if (nombreRol.isBlank()) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar un rol",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            jComboBox2.requestFocus();
            return;
        }

        if (estadoTexto.isBlank()) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar el estado del usuario",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            jComboBox1.requestFocus();
            return;
        }

        int estado = estadoTexto.equalsIgnoreCase("Activo") ? 1 : 0;

        java.util.List<Map<String, Object>> usuarioExistente =
            GenericDAO.select(
                "Usuario",
                "Username = ?",
                username
            );

        if (!usuarioExistente.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Ya existe un usuario con ese nombre",
                "Usuario duplicado",
                JOptionPane.WARNING_MESSAGE);
            userTxt.requestFocus();
            return;
        }

        java.util.List<Map<String, Object>> rol =
            GenericDAO.select(
                "Rol",
                "NombreRol = ?",
                nombreRol
            );

        if (rol.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "El rol seleccionado no existe",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int rolID = Integer.parseInt(rol.get(0).get("RolID").toString());

        String hash = org.mindrot.jbcrypt.BCrypt.hashpw(
            passwordPlano,
            org.mindrot.jbcrypt.BCrypt.gensalt()
        );

        java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
        data.put("Username", username);
        data.put("Password", hash);
        data.put("RolID", rolID);
        data.put("Estado", estado);

        int filas = GenericDAO.insert("Usuario", data);

        if (filas > 0) {
            JOptionPane.showMessageDialog(this,
                "Usuario registrado correctamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "No se pudo registrar el usuario",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
        llenarUsuarios("");
    }//GEN-LAST:event_btnRegUsuarioMouseClicked

    private void btnActUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActUsuarioMouseClicked
        if(user.getRolID() != 1){
            JOptionPane.showMessageDialog(this,
                "Solo los administradores pueden actualizar",
                "Permiso no concedido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        int[] filas = tablaEntrada.getSelectedRows();

        if (filas.length == 0) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar un usuario para modificar",
                "Selección requerida",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (filas.length > 1) {
            JOptionPane.showMessageDialog(this,
                "Seleccione solo un usuario para modificar",
                "Selección inválida",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        int fila = filas[0];

        Object idObj = tablaEntrada.getValueAt(
            fila,
            tablaEntrada.getColumnModel().getColumnIndex("UsuarioID")
        );

        if (idObj == null) {
            JOptionPane.showMessageDialog(this,
                "No se pudo obtener el ID del usuario",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int usuarioID = Integer.parseInt(idObj.toString());

        String username = userTxt.getText().trim();
        String passwordPlano = passTxt.getText().trim();
        String nombreRol = jComboBox2.getSelectedItem().toString();
        String estadoTxt = jComboBox1.getSelectedItem().toString();

        if (username.isEmpty() || username.equals("Ingrese nombre de Usuario")) {
            JOptionPane.showMessageDialog(this,
                "El nombre de usuario es obligatorio",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            userTxt.requestFocus();
            return;
        }

        if (nombreRol == null || nombreRol.isBlank()) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar un rol",
                "Validación",
                JOptionPane.WARNING_MESSAGE);
            jComboBox2.requestFocus();
            return;
        }

        java.util.List<Map<String, Object>> rolRes =
            GenericDAO.select(
                "Rol",
                "NombreRol = ?",
                nombreRol
            );

        if (rolRes.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Rol no válido",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rolID = Integer.parseInt(rolRes.get(0).get("RolID").toString());

        int estado = estadoTxt.equalsIgnoreCase("Activo") ? 1 : 0;

        java.util.List<Map<String, Object>> duplicado =
            GenericDAO.select(
                "Usuario",
                "Username = ? AND UsuarioID <> ?",
                username,
                usuarioID
            );

        if (!duplicado.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Ya existe otro usuario con ese nombre",
                "Usuario duplicado",
                JOptionPane.WARNING_MESSAGE);
            userTxt.requestFocus();
            return;
        }

        java.util.LinkedHashMap<String, Object> data = new java.util.LinkedHashMap<>();
        data.put("Username", username);
        data.put("RolID", rolID);
        data.put("Estado", estado);

        if (!passwordPlano.isEmpty() && !passwordPlano.equals("********")) {

            if (passwordPlano.length() < 6) {
                JOptionPane.showMessageDialog(this,
                    "La contraseña debe tener al menos 6 caracteres",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
                passTxt.requestFocus();
                return;
            }

            String hash = org.mindrot.jbcrypt.BCrypt.hashpw(
                passwordPlano,
                org.mindrot.jbcrypt.BCrypt.gensalt()
            );

            data.put("Password", hash);
        }

        int filasAfectadas =
            GenericDAO.update(
                "Usuario",
                data,
                "UsuarioID = ?",
                usuarioID
            );

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(this,
                "Usuario actualizado correctamente",
                "Éxito",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "No se pudo actualizar el usuario",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }

        limpiarCampos();
        llenarUsuarios("");
    }//GEN-LAST:event_btnActUsuarioMouseClicked

    private void btnEliminarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioMouseClicked
        if(user.getRolID() != 1){
            JOptionPane.showMessageDialog(this,
                "Solo los administradores pueden eliminar",
                "Permiso no concedido",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        int[] filas = tablaEntrada.getSelectedRows();

        if (filas.length == 0) {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar al menos un usuario para eliminar",
                "Selección requerida",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (int fila : filas) {

            Object idObj = tablaEntrada.getValueAt(
                fila,
                tablaEntrada.getColumnModel().getColumnIndex("UsuarioID")
            );

            if (idObj != null) {
                int usuarioID = Integer.parseInt(idObj.toString());

                if (usuarioID == user.getUsuarioID()) {
                    JOptionPane.showMessageDialog(this,
                        "No se puede eliminar el usuario actualmente logueado",
                        "Operación no permitida",
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Está seguro de eliminar el(los) usuario(s) seleccionado(s)?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        int eliminados = 0;

        for (int fila : filas) {

            Object idObj = tablaEntrada.getValueAt(
                fila,
                tablaEntrada.getColumnModel().getColumnIndex("UsuarioID")
            );

            if (idObj != null) {
                int usuarioID = Integer.parseInt(idObj.toString());
                eliminados += GenericDAO.delete(
                    "Usuario",
                    "UsuarioID = ?",
                    usuarioID
                );
            }
        }

        JOptionPane.showMessageDialog(this,
            eliminados + " usuario(s) eliminado(s)",
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE);

        limpiarCampos();
        llenarUsuarios("");
    }//GEN-LAST:event_btnEliminarUsuarioMouseClicked

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registroUsuarioF().setVisible(true);
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
    
    private void llenarUsuarios(String where) {
        java.util.List<Map<String, Object>> usuarios =
            GenericDAO.selectQuery(
                "select UsuarioID, Username, RolID, Estado from Usuario where Username like ?",
                "%" + where + "%"
            );
        GenericDAO.llenarJTable(tablaEntrada, usuarios);
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

            userTxt.setText(
                tablaEntrada.getValueAt(fila, tablaEntrada.getColumnModel()
                    .getColumnIndex("Username")).toString()
            );
            userTxt.setForeground(Color.black);
            
            String permID = String.valueOf(
                tablaEntrada.getValueAt(
                    fila,
                    tablaEntrada.getColumnModel()
                        .getColumnIndex("RolID")
                )
            );
            
            java.util.List<Map<String, Object>> perms =
            GenericDAO.select(
                "Rol",
                "RolID = ?",
                permID
            );
            jComboBox2.setSelectedItem(perms.get(0).get("NombreRol"));
            
            String estado = String.valueOf(
                tablaEntrada.getValueAt(
                    fila,
                    tablaEntrada.getColumnModel()
                        .getColumnIndex("Estado")
                )).equals("1") ?
                    "Activo" : "No Activo";
            jComboBox1.setSelectedItem(estado);
        });
    }
    
    private void limpiarCampos() {
        userTxt.setText("Ingrese nombre de Usuario");
        userTxt.setForeground(Color.lightGray);
        
        passTxt.setText("********");
        passTxt.setForeground(Color.lightGray);

        jComboBox2.setSelectedIndex(0);
        jComboBox1.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel actualizar;
    private javax.swing.JLabel btnActUsuario;
    private javax.swing.JLabel btnCancelar;
    private javax.swing.JLabel btnEliminarUsuario;
    private javax.swing.JLabel btnRegUsuario;
    private javax.swing.JLabel iconCancelar;
    private javax.swing.JLabel iconEliminar;
    private javax.swing.JLabel iconGuardar;
    private javax.swing.JLabel iconem;
    private javax.swing.JLabel iconlupa;
    private javax.swing.JLabel ie;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private Clases.PanelRound panelRound10;
    private Clases.PanelRound panelRound12;
    private Clases.PanelRound panelRound13;
    private Clases.PanelRound panelRound14;
    private javax.swing.JPasswordField passTxt;
    private javax.swing.JTable tablaEntrada;
    private javax.swing.JTextField txtBusqUsuario;
    private javax.swing.JTextField userTxt;
    // End of variables declaration//GEN-END:variables
}
