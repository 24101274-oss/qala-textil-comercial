/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import BEAN.Usuario;
import java.awt.Color;

public class registrar extends javax.swing.JPanel {
    Usuario user;
    
    public registrar() {
        initComponents();
        InitStyles();
    }
    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        texto1.putClientProperty("FlatLaf.style", "font: bold 14 $light.font");
        texto1.setForeground(Color.black);
        texto2.putClientProperty("FlatLaf.style", "font: bold 14 $light.font");
        texto2.setForeground(Color.black);
        texto3.putClientProperty("FlatLaf.style", "font: bold 14 $light.font");
        texto3.setForeground(Color.black);
        texto4.putClientProperty("FlatLaf.style", "font: bold 14 $light.font");
        texto4.setForeground(Color.black);
        texto5.putClientProperty("FlatLaf.style", "font: bold 14 $light.font");
        texto5.setForeground(Color.black);
    }
    public void setUsuario(Usuario u) {
        user = u;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        texto1 = new javax.swing.JLabel();
        texto2 = new javax.swing.JLabel();
        texto3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        texto4 = new javax.swing.JLabel();
        texto5 = new javax.swing.JLabel();
        regProv = new javax.swing.JButton();
        regUsuario = new javax.swing.JButton();
        regMat = new javax.swing.JButton();
        regCatMat = new javax.swing.JButton();
        regCliente = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        title.setText("Registrar");

        texto1.setText("Registrar Nueva Categoría de Material");

        texto2.setText("Registrar Nuevo Material");

        texto3.setText("Registrar Nuevo Proveedor");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        texto4.setText("Registrar Nuevo Cliente");

        texto5.setText("Registrar Nuevo Usuario");

        regProv.setBackground(new java.awt.Color(255, 161, 27));
        regProv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regProv.setForeground(new java.awt.Color(255, 255, 255));
        regProv.setText("Proveedor");
        regProv.setBorder(null);
        regProv.setBorderPainted(false);
        regProv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        regProv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regProvMouseClicked(evt);
            }
        });

        regUsuario.setBackground(new java.awt.Color(255, 161, 27));
        regUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regUsuario.setForeground(new java.awt.Color(255, 255, 255));
        regUsuario.setText("Usuario");
        regUsuario.setBorder(null);
        regUsuario.setBorderPainted(false);
        regUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        regUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regUsuarioMouseClicked(evt);
            }
        });

        regMat.setBackground(new java.awt.Color(255, 161, 27));
        regMat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regMat.setForeground(new java.awt.Color(255, 255, 255));
        regMat.setText("Material");
        regMat.setBorder(null);
        regMat.setBorderPainted(false);
        regMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        regMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMatMouseClicked(evt);
            }
        });

        regCatMat.setBackground(new java.awt.Color(255, 161, 27));
        regCatMat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regCatMat.setForeground(new java.awt.Color(255, 255, 255));
        regCatMat.setText("Categoría de Material");
        regCatMat.setBorder(null);
        regCatMat.setBorderPainted(false);
        regCatMat.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        regCatMat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regCatMatMouseClicked(evt);
            }
        });

        regCliente.setBackground(new java.awt.Color(255, 161, 27));
        regCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        regCliente.setForeground(new java.awt.Color(255, 255, 255));
        regCliente.setText("Cliente");
        regCliente.setBorder(null);
        regCliente.setBorderPainted(false);
        regCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        regCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(80, 80, 80))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(60, 60, 60))
                            .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(regProv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(regCatMat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)))
                        .addGap(70, 70, 70))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30))
                    .addComponent(regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(texto5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addComponent(regUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(250, 250, 250))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(texto1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(regCatMat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(texto2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(12, 12, 12)
                                .addComponent(regMat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(texto3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(regProv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(texto4, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addGap(24, 24, 24)
                                .addComponent(regCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(texto5, javax.swing.GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
                                .addGap(14, 14, 14)
                                .addComponent(regUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)))
                        .addGap(39, 39, 39)))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void regClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regClienteMouseClicked
        registroClienteF frame = new registroClienteF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_regClienteMouseClicked

    private void regCatMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regCatMatMouseClicked
        registrarCatMatF frame = new registrarCatMatF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }//GEN-LAST:event_regCatMatMouseClicked

    private void regMatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMatMouseClicked
        registrarMaterialF frame = new registrarMaterialF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_regMatMouseClicked

    private void regUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regUsuarioMouseClicked
        registroUsuarioF frame = new registroUsuarioF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_regUsuarioMouseClicked

    private void regProvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regProvMouseClicked
        registrarProveedorF frame = new registrarProveedorF();
        frame.setLocationRelativeTo(null); // centra la ventana
        frame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        frame.setUsuario(user);
        frame.setVisible(true);
    }//GEN-LAST:event_regProvMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton regCatMat;
    private javax.swing.JButton regCliente;
    private javax.swing.JButton regMat;
    private javax.swing.JButton regProv;
    private javax.swing.JButton regUsuario;
    private javax.swing.JLabel texto1;
    private javax.swing.JLabel texto2;
    private javax.swing.JLabel texto3;
    private javax.swing.JLabel texto4;
    private javax.swing.JLabel texto5;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
