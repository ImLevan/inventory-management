package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Controladora;
import com.mycompany.gestioninventario.logica.Usuario;

public class ModificarUsuario extends javax.swing.JFrame {
    
    Controladora control = null;
    Usuario usuario;
    Form_Usuarios formUsuarios;

    public ModificarUsuario(int num_usuario) {
        control = new Controladora();
        initComponents();
        cargarDatos(num_usuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        lbUsuario = new javax.swing.JLabel();
        lbContrasenia = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        txtContrasenia = new javax.swing.JPasswordField();
        chkVerContrasenia = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 51));
        lbTitle.setText("Modificar información del usuario");

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-filled.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 102, 0));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar cambios");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtUsuario.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        lbUsuario.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbUsuario.setText("Usuario");

        lbContrasenia.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbContrasenia.setText("Contraseña");

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        lbNombre.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbNombre.setText("Nombre");

        txtContrasenia.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        chkVerContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        chkVerContrasenia.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        chkVerContrasenia.setText("Ver contraseña");
        chkVerContrasenia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkVerContraseniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(27, 27, 27)
                        .addComponent(btnCancelar)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                        .addComponent(lbNombre)
                                        .addComponent(lbUsuario)
                                        .addComponent(txtUsuario)
                                        .addComponent(chkVerContrasenia)
                                        .addComponent(txtContrasenia))
                                    .addComponent(lbContrasenia)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainPanelLayout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(21, 30, Short.MAX_VALUE))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbTitle)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addComponent(lbUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbNombre)
                .addGap(4, 4, 4)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkVerContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setFormUsuariosReference(Form_Usuarios formUsuarios) {
        this.formUsuarios = formUsuarios;
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreUsuario = txtUsuario.getText();
        String contrasenia = txtContrasenia.getText();
        String nombre = txtNombre.getText();

        control.modificarUsuario(usuario, nombreUsuario, contrasenia, nombre);

        formUsuarios.cargarDatos();
        MostrarMensaje.mostrarMensaje("Edición realizada con éxito", "Info", "Edición correcta");

        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void chkVerContraseniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkVerContraseniaActionPerformed
        toggleMostrarContrasenia();
    }//GEN-LAST:event_chkVerContraseniaActionPerformed

    private void toggleMostrarContrasenia() {
        if (chkVerContrasenia.isSelected()) {
            txtContrasenia.setEchoChar((char) 0); // Muestra el texto de la contraseña
        } else {
            txtContrasenia.setEchoChar('\u2022'); // Oculta el texto de la contraseña
        }
    }
    
    private void cargarDatos(int num_usuario) {
        this.usuario = control.traerUsuario(num_usuario);
        
        txtUsuario.setText(usuario.getUsuario());
        txtContrasenia.setText(usuario.getContrasena());
        txtNombre.setText(usuario.getNombre());                       
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkVerContrasenia;
    private javax.swing.JLabel lbContrasenia;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
