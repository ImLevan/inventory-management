package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Categoria;
import com.mycompany.gestioninventario.logica.Controladora;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CargarProducto extends javax.swing.JFrame {
    
    Controladora control = null;
    Form_Productos formProductos;

    public CargarProducto() {
        control = new Controladora();
        initComponents();
        cargarCategoriasEnComboBox();
        escucharTxts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();
        txtMarca = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        lbNombre = new javax.swing.JLabel();
        lbMarca = new javax.swing.JLabel();
        lbDescripcion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 51));
        lbTitle.setText("Información del producto");

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/productos.png"))); // NOI18N

        btnGuardar.setBackground(new java.awt.Color(0, 102, 0));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
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

        txtNombre.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        cmbCategoria.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        txtMarca.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        txtDescripcion.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        lbNombre.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbNombre.setText("Nombre");

        lbMarca.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbMarca.setText("Marca");

        lbDescripcion.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbDescripcion.setText("Descripción");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTitle)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lbIcon)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbNombre)
                                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                        .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                                        .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                                    .addComponent(lbMarca)
                                    .addComponent(lbDescripcion))))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar)
                        .addGap(13, 13, 13))))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreCategoria = (String) cmbCategoria.getSelectedItem();
        Categoria categoriaSeleccionada = control.traerCategoriaPorNombre(nombreCategoria);
        String nombre = txtNombre.getText();
        String marca = txtMarca.getText();
        String descripcion = txtDescripcion.getText();

        control.guardarProducto(categoriaSeleccionada, nombre, marca, descripcion);

        formProductos.cargarDatos();
        MostrarMensaje.mostrarMensaje("Carga realizada con éxito", "Info", "Carga correcta");
        
        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void setFormProductosReference(Form_Productos formProductos) {
        this.formProductos = formProductos;
    }
    
    private void escucharTxts(){
        txtNombre.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }
        });
        
        txtMarca.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }
        });
        
        txtDescripcion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                habilitarBotonSiCamposLlenos();
            }
        });
    }
    
    private void habilitarBotonSiCamposLlenos() {
        boolean camposLlenos = !txtNombre.getText().isEmpty() && !txtMarca.getText().isEmpty() && !txtDescripcion.getText().isEmpty();
        btnGuardar.setEnabled(camposLlenos);
    } 
    
    private void cargarCategoriasEnComboBox() {
        List<Categoria> categorias = control.traerCategorias();

        // Limpiar el JComboBox
        cmbCategoria.removeAllItems();

        
        for (Categoria categoria : categorias) {
            cmbCategoria.addItem(categoria.getNombre());
            
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMarca;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
