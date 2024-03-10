package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Categoria;
import com.mycompany.gestioninventario.logica.Controladora;
import com.mycompany.gestioninventario.logica.Producto;
import com.mycompany.gestioninventario.logica.Proveedor;
import com.mycompany.gestioninventario.logica.Usuario;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CargarExistencia extends javax.swing.JFrame {
    
    Controladora control = null;
    Form_Existencias formExistencias;
    Usuario usuario;

    public CargarExistencia(Usuario usuario) {
        this.usuario = usuario;
        control = new Controladora();
        initComponents();
        cargarComboBox();
        cargarFecha();
        escucharTxts();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtCantidad = new javax.swing.JTextField();
        lbProveedor = new javax.swing.JLabel();
        lbCantidad = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbProducto = new javax.swing.JComboBox<>();
        lbProducto = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        lbPrecioCompra = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        lbPrecioVenta = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        lbNota = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(51, 51, 51));
        lbTitle.setText("Agregar al inventario");

        btnGuardar.setBackground(new java.awt.Color(0, 102, 0));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Agregar");
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

        txtCantidad.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        lbProveedor.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbProveedor.setText("Proveedor");

        lbCantidad.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbCantidad.setText("Cantidad");

        lbCategoria.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbCategoria.setText("Categoria");

        cmbCategoria.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        cmbProducto.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        cmbProducto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductoItemStateChanged(evt);
            }
        });

        lbProducto.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbProducto.setText("Producto");

        cmbProveedor.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        txtFecha.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        lbFecha.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbFecha.setText("Fecha");

        txtPrecioCompra.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtPrecioCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioCompraKeyTyped(evt);
            }
        });

        lbPrecioCompra.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbPrecioCompra.setText("Precio compra");

        txtPrecioVenta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtPrecioVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioVentaKeyTyped(evt);
            }
        });

        lbPrecioVenta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbPrecioVenta.setText("Precio venta");

        txtNota.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N

        lbNota.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbNota.setText("Nota");

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
                                .addGap(26, 26, 26)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbCategoria)
                                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbProveedor))
                                            .addComponent(lbCantidad)
                                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtCantidad, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cmbProveedor, javax.swing.GroupLayout.Alignment.LEADING, 0, 263, Short.MAX_VALUE)))
                                        .addGap(44, 44, 44)
                                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbNota)
                                                .addComponent(txtNota))
                                            .addComponent(lbFecha)
                                            .addComponent(lbProducto)
                                            .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbPrecioVenta)
                                            .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbPrecioCompra))))
                        .addContainerGap(46, Short.MAX_VALUE))
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
                .addGap(24, 24, 24)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lbCategoria)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainPanelLayout.createSequentialGroup()
                                        .addComponent(lbProducto)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbProveedor)
                                    .addComponent(lbFecha))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addComponent(lbPrecioCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(lbPrecioVenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(lbCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(lbNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
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

    public void setFormExistenciasReference(Form_Existencias formExistencias) {
        this.formExistencias = formExistencias;
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String nombreCategoria = (String) cmbCategoria.getSelectedItem();
        Categoria categoriaSeleccionada = control.traerCategoriaPorNombre(nombreCategoria);
        String nombreProducto = (String) cmbProducto.getSelectedItem();
        Producto productoSeleccionado = control.traerProductoPorNombre(nombreProducto);
        String nombreProveedor = (String) cmbProveedor.getSelectedItem();
        Proveedor proveedorSeleccionado = control.traerProveedorPorNombre(nombreProveedor);
        String fecha = txtFecha.getText();
        Float precioCompra = Float.valueOf(txtPrecioCompra.getText());
        Float precioVenta = Float.valueOf(txtPrecioVenta.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());
        String nota = txtNota.getText();

        control.guardarExistencia(categoriaSeleccionada, productoSeleccionado, proveedorSeleccionado, fecha, precioCompra, precioVenta, cantidad, nota, usuario);

        formExistencias.cargarDatos();
        MostrarMensaje.mostrarMensaje("Carga realizada con éxito", "Info", "Carga correcta");

        this.dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtPrecioCompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyPressed
        String precioNumber = txtPrecioCompra.getText();
        int length = precioNumber.length();

        if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') {
            if (length < 16 || (evt.getKeyChar() == '.' && !precioNumber.contains("."))) {
                txtPrecioCompra.setEditable(true);
            } else {
                txtPrecioCompra.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtPrecioCompra.setEditable(true);
            } else {
                txtPrecioCompra.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtPrecioCompraKeyPressed

    private void txtPrecioCompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioCompraKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Verificar si ya hay un punto y evitar agregar otro
        if (c == '.' && txtPrecioCompra.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioCompraKeyTyped

    private void txtPrecioVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyPressed
        String precioNumber = txtPrecioCompra.getText();
        int length = precioNumber.length();

        if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') {
            if (length < 16 || (evt.getKeyChar() == '.' && !precioNumber.contains("."))) {
                txtPrecioVenta.setEditable(true);
            } else {
                txtPrecioVenta.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtPrecioVenta.setEditable(true);
            } else {
                txtPrecioVenta.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtPrecioVentaKeyPressed

    private void txtPrecioVentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioVentaKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Verificar si ya hay un punto y evitar agregar otro
        if (c == '.' && txtPrecioVenta.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioVentaKeyTyped

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            // Obtener la categoría seleccionada
            String categoriaSeleccionada = (String) cmbCategoria.getSelectedItem();
            if(!categoriaSeleccionada.equals("-")){
                // Habilitar el ComboBox de productos y cargar los productos
                cmbProducto.setEnabled(true);
                cargarProductosEnComboBoxPorCategoria(categoriaSeleccionada, cmbProducto);
            }else {
                // Deshabilitar el ComboBox de productos
                cmbProducto.setEnabled(false);
            }
        }
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbProductoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductoItemStateChanged

    }//GEN-LAST:event_cmbProductoItemStateChanged

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();

        if(!Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void cargarComboBox() {
        cmbCategoria.removeAllItems();
        cmbCategoria.addItem("-");
        List<Categoria> categorias = control.traerCategorias();
        for (Categoria categoria : categorias) {
            cmbCategoria.addItem(categoria.getNombre());
        }
        cmbProducto.removeAllItems();
        List<Producto> productos = control.traerProductos();
        for (Producto producto : productos) {
            cmbProducto.addItem(producto.getNombre());
            
        }
        cmbProveedor.removeAllItems();
        List<Proveedor> proveedores = control.traerProveedores();
        for (Proveedor proveedor : proveedores) {
            cmbProveedor.addItem(proveedor.getNombre());
        }
    }

    private void cargarProductosEnComboBoxPorCategoria(String categoria, javax.swing.JComboBox<String> cmbBox) {
        cmbBox.removeAllItems();
        List<Producto> productos = control.traerProductos();
        for (Producto producto : productos) {
            if (producto.getProducto_categoria().getNombre().equals(categoria)) {
                cmbBox.addItem(producto.getNombre());
            }
        }
    }

    private void cargarFecha() {
        // Obtener la fecha y hora actual
        LocalDateTime fechaHoy = LocalDateTime.now();

        // Formatear la fecha y el mes como un String "Año/Mes/Día"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = fechaHoy.format(formatter);
        txtFecha.setText(fechaFormateada);
    }

    private void escucharTxts() {
        txtFecha.getDocument().addDocumentListener(new DocumentListener() {
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

        txtPrecioCompra.getDocument().addDocumentListener(new DocumentListener() {
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

        txtPrecioVenta.getDocument().addDocumentListener(new DocumentListener() {
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

        txtCantidad.getDocument().addDocumentListener(new DocumentListener() {
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

        txtNota.getDocument().addDocumentListener(new DocumentListener() {
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
        boolean camposLlenos = !txtFecha.getText().isEmpty() && !txtPrecioCompra.getText().isEmpty() && !txtPrecioVenta.getText().isEmpty() && !txtCantidad.getText().isEmpty() && !txtNota.getText().isEmpty();
        btnGuardar.setEnabled(camposLlenos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbProveedor;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbNota;
    private javax.swing.JLabel lbPrecioCompra;
    private javax.swing.JLabel lbPrecioVenta;
    private javax.swing.JLabel lbProducto;
    private javax.swing.JLabel lbProveedor;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNota;
    private javax.swing.JTextField txtPrecioCompra;
    private javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables

}
