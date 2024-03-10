package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Controladora;
import com.mycompany.gestioninventario.logica.Existencia;
import com.mycompany.gestioninventario.logica.ExistenciaCantidad;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
import com.mycompany.gestioninventario.logica.Usuario;
import com.mycompany.gestioninventario.logica.Venta;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class ModificarVenta extends javax.swing.JFrame {

    Usuario usuario;
    Controladora control = null;
    Form_Ventas formVentas;
    Venta venta;
    float montoTotal;
    int cantTotal;

    public ModificarVenta(Usuario usuario, int num_venta) {
        this.usuario = usuario;
        control = new Controladora();
        initComponents();
        this.venta = control.traerVenta(num_venta);
        cargarExistencias();
        montoTotal = 0;
        cantTotal = 0;
        cargarDatosDeVenta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        spTable = new javax.swing.JScrollPane();
        prodTable = new com.mycompany.gestioninventario.igu.TableGeneral();
        txtPrecio = new javax.swing.JTextField();
        lbPrecio = new javax.swing.JLabel();
        lbCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnAgrCuenta = new javax.swing.JButton();
        lbProdTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbCuentaTitle = new javax.swing.JLabel();
        spTable1 = new javax.swing.JScrollPane();
        cuentaTable = new com.mycompany.gestioninventario.igu.TableGeneral();
        btnPagar = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        txtCantidadTotal = new javax.swing.JTextField();
        txtMontoTotal = new javax.swing.JTextField();
        lbCantidadTotal = new javax.swing.JLabel();
        lbMontoTotal = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lbTitle.setText("Modificar factura");

        addPanel.setBackground(new java.awt.Color(255, 255, 255));

        prodTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categ", "Prod", "Proveedor", "Stock", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        prodTable.setGridColor(new java.awt.Color(102, 102, 102));
        prodTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        spTable.setViewportView(prodTable);

        txtPrecio.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtPrecio.setEnabled(false);
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        lbPrecio.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lbPrecio.setText("Precio");

        lbCantidad.setText("Cantidad");

        txtCantidad.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        btnAgrCuenta.setBackground(new java.awt.Color(0, 153, 255));
        btnAgrCuenta.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnAgrCuenta.setForeground(new java.awt.Color(255, 255, 255));
        btnAgrCuenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/derarrow.png"))); // NOI18N
        btnAgrCuenta.setText("Agregar a cuenta");
        btnAgrCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgrCuentaActionPerformed(evt);
            }
        });

        lbProdTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbProdTitle.setForeground(new java.awt.Color(0, 153, 255));
        lbProdTitle.setText("Productos a elegir");

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(addPanelLayout.createSequentialGroup()
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbPrecio)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(67, 67, 67)
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbCantidad)
                                    .addGroup(addPanelLayout.createSequentialGroup()
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAgrCuenta))))))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(lbProdTitle)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lbProdTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPrecio)
                    .addComponent(lbCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgrCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbCuentaTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbCuentaTitle.setForeground(new java.awt.Color(51, 153, 0));
        lbCuentaTitle.setText("Cuenta");

        cuentaTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Precio", "Cant", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cuentaTable.setGridColor(new java.awt.Color(102, 102, 102));
        cuentaTable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        spTable1.setViewportView(cuentaTable);

        btnPagar.setBackground(new java.awt.Color(51, 153, 0));
        btnPagar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(255, 255, 255));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pagar.png"))); // NOI18N
        btnPagar.setText("Modificar pago");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 51, 102));
        deleteButton.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar.png"))); // NOI18N
        deleteButton.setText("Eliminar item");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        txtCantidadTotal.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        txtCantidadTotal.setEnabled(false);

        txtMontoTotal.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        txtMontoTotal.setEnabled(false);

        lbCantidadTotal.setText("Cantidad total");

        lbMontoTotal.setText("Monto total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(lbCuentaTitle)
                                .addGap(243, 243, 243))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(btnPagar)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(spTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCantidadTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCantidadTotal, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMontoTotal))
                        .addGap(142, 142, 142))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCuentaTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbCantidadTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbMontoTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCerrar.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/x.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(addPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbTitle)
                .addGap(446, 446, 446)
                .addComponent(btnCerrar)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTitle)
                    .addComponent(btnCerrar))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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

    public void setFormVentasReference(Form_Ventas formVentas) {
        this.formVentas = formVentas;
    }

    private void cargarExistencias() {
        prodTable.setRowCount(0);

        List<Existencia> listaExistencias = control.traerExistencias();

        if (listaExistencias != null) {
            for (Existencia existencia : listaExistencias) {
                Object[] objeto = {
                    existencia.getId(),
                    existencia.getExistencia_producto().getProducto_categoria().getNombre(),
                    existencia.getExistencia_producto().getNombre(),
                    existencia.getExistencia_proveedor().getNombre(),
                    existencia.getStockActual(),
                    existencia.getPrecioVenta(),};

                prodTable.addRow(objeto);
            }
        }
    }

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed
        String precioNumber = txtPrecio.getText();
        int length = precioNumber.length();

        if (Character.isDigit(evt.getKeyChar()) || evt.getKeyChar() == '.') {
            if (length < 16 || (evt.getKeyChar() == '.' && !precioNumber.contains("."))) {
                txtPrecio.setEditable(true);
            } else {
                txtPrecio.setEditable(false);
            }
        } else {
            if (evt.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE || evt.getExtendedKeyCode() == KeyEvent.VK_DELETE) {
                txtPrecio.setEditable(true);
            } else {
                txtPrecio.setEditable(false);
            }
        }
    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Verificar si ya hay un punto y evitar agregar otro
        if (c == '.' && txtPrecio.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtCantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyReleased
        if (prodTable.getRowCount() > 0) {
            if (prodTable.getSelectedRow() != -1 && !txtCantidad.getText().equals("")) {
                float precio_existencia = Float.parseFloat(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 5)));
                txtPrecio.setText(String.valueOf(precio_existencia * Integer.parseInt(txtCantidad.getText())));
            } else {
                MostrarMensaje.mostrarMensaje("Debe seleccionar algún producto para elegir la cantidad", "Error", "Error al elegir la cantidad");
            }
        } else {
            MostrarMensaje.mostrarMensaje("No hay nada para agregar a la cuenta", "Error", "Error al agregar a la cuenta");
        }
    }//GEN-LAST:event_txtCantidadKeyReleased

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();

        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnAgrCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgrCuentaActionPerformed
        if (prodTable.getRowCount() > 0) {
            if (prodTable.getSelectedRow() != -1) {
                int stock_existencia = Integer.parseInt(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 4)));

                if (stock_existencia >= Integer.parseInt(txtCantidad.getText())) {
                    agregarExistenciaACuenta();
                    limpiarInputs();
                } else {
                    MostrarMensaje.mostrarMensaje("La cantidad elegida no debe ser mayor al stock del producto", "Error", "Error al agregar a la cuenta");
                }
            } else {
                MostrarMensaje.mostrarMensaje("Debe seleccionar algun producto para agregar a al cuenta", "Error", "Error al agregar a la cuenta");
            }
        } else {
            MostrarMensaje.mostrarMensaje("No hay nada para agregar a la cuenta", "Error", "Error al agregar a la cuenta");
        }
    }//GEN-LAST:event_btnAgrCuentaActionPerformed

    private void limpiarVentaInputs() {
        montoTotal = 0;
        cantTotal = 0;
        txtMontoTotal.setText(String.valueOf(montoTotal));
        txtCantidadTotal.setText(String.valueOf(cantTotal));
    }

    private void agregarExistenciaACuenta() {
        if (!txtCantidad.getText().equals("0")) {
            int idExistenciaSeleccionada = Integer.parseInt(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 0)));

            // Verificar si la existencia ya está en la cuentaTable
            if (!existenciaYaAgregada(idExistenciaSeleccionada)) {
                // Obtener información del producto seleccionado en prodTable
                int id = Integer.parseInt(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 0)));
                String nombre = String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 2));
                float precio = Float.parseFloat(String.valueOf(prodTable.getValueAt(prodTable.getSelectedRow(), 5)));
                int cantidad = Integer.parseInt(txtCantidad.getText());
                float total = precio * cantidad;

                // Crear un objeto que represente una fila en cuentaTable
                Object[] cuentaRow = {id, nombre, precio, cantidad, total};

                // Añadir el objeto como una nueva fila a cuentaTable
                cuentaTable.addRow(cuentaRow);

                actualizarTxtsTotales(cantidad, total);
            } else {
                MostrarMensaje.mostrarMensaje("Esta existencia ya ha sido agregada a la cuenta", "Error", "Error al agregar a la cuenta");
            }
        } else {
            MostrarMensaje.mostrarMensaje("La cantidad debe ser mayor a 0", "Error", "Error al agregar a la cuenta");
            txtCantidad.setText("");
        }
    }

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // Verificar si hay elementos en la cuentaTable
        if (cuentaTable.getRowCount() > 0) {
            // Crear una lista para almacenar la información de existencias y cantidades
            List<ExistenciaCantidad> existenciasCantidad = new ArrayList<>();

            // Obtener la información de la cuentaTable
            for (int i = 0; i < cuentaTable.getRowCount(); i++) {
                int idExistencia = Integer.parseInt(String.valueOf(cuentaTable.getValueAt(i, 0)));
                int cantidad = Integer.parseInt(String.valueOf(cuentaTable.getValueAt(i, 3)));

                // Crear un objeto ExistenciaCantidad y agregarlo a la lista
                existenciasCantidad.add(new ExistenciaCantidad(idExistencia, cantidad));
            }

            // Pasar la lista a la controladora
            control.modificarVenta(venta, usuario, montoTotal, existenciasCantidad);

            formVentas.cargarDatos();
            limpiarVentaInputs();
            MostrarMensaje.mostrarMensaje("Venta realizada con éxito", "Info", "Venta correcta");
            this.dispose();
        } else {
            MostrarMensaje.mostrarMensaje("No hay elementos en la cuenta para pagar", "Error", "Error al pagar");
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (cuentaTable.getRowCount() > 0) {
            if (cuentaTable.getSelectedRow() != -1) {
                restarTxts();
                cuentaTable.removeRow(cuentaTable.getSelectedRow());

                MostrarMensaje.mostrarMensaje("Existencia eliminada con exito", "Info", "Borrado de existencia");
            } else {
                MostrarMensaje.mostrarMensaje("No se seleccionó ninguna existencia", "Error", "Error al eliminar");
            }
        } else {
            MostrarMensaje.mostrarMensaje("No hay nada para eliminar en la tabla", "Error", "Error al eliminar");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cargarDatosDeVenta() {
        List<Rel_existencia_venta> existencias = venta.getVenta_rel();
        
        for(Rel_existencia_venta existencia : existencias){
            int id = existencia.getRel_existencia().getId();
            String nombre = existencia.getRel_existencia().getExistencia_producto().getNombre();
            float precio = existencia.getPrecioUnidad();
            int cantidad = existencia.getCantidad();
            float total = precio * cantidad;
            Object[] cuentaRow = {id, nombre, precio, cantidad, total};
            
            cantTotal += cantidad;
            cuentaTable.addRow(cuentaRow);
        }   
        
        montoTotal = venta.getMontoTotal();
        txtMontoTotal.setText(String.valueOf(montoTotal));
        txtCantidadTotal.setText(String.valueOf(cantTotal));
    }

    private void restarTxts() {
        float total = Float.parseFloat(String.valueOf(cuentaTable.getValueAt(cuentaTable.getSelectedRow(), 4)));
        int cantidad = Integer.parseInt(String.valueOf(cuentaTable.getValueAt(cuentaTable.getSelectedRow(), 3)));

        cantTotal -= cantidad;
        montoTotal -= total;

        txtCantidadTotal.setText(String.valueOf(cantTotal));
        txtMontoTotal.setText(String.valueOf(montoTotal));
    }

    private void actualizarTxtsTotales(int cantidad, float precioTotal) {
        cantTotal += cantidad;
        montoTotal += precioTotal;

        txtCantidadTotal.setText(String.valueOf(cantTotal));
        txtMontoTotal.setText(String.valueOf(montoTotal));
    }

    private boolean existenciaYaAgregada(int idExistencia) {
        // Verificar si la existencia ya está en la cuentaTable
        for (int i = 0; i < cuentaTable.getRowCount(); i++) {
            int idExistenciaEnCuenta = Integer.parseInt(String.valueOf(cuentaTable.getValueAt(i, 0)));
            if (idExistencia == idExistenciaEnCuenta) {
                return true; // La existencia ya está en la cuentaTable
            }
        }
        return false; // La existencia no está en la cuentaTable
    }

    private void limpiarInputs() {
        txtPrecio.setText("");
        txtCantidad.setText("");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton btnAgrCuenta;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnPagar;
    private com.mycompany.gestioninventario.igu.TableGeneral cuentaTable;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCantidad;
    private javax.swing.JLabel lbCantidadTotal;
    private javax.swing.JLabel lbCuentaTitle;
    private javax.swing.JLabel lbMontoTotal;
    private javax.swing.JLabel lbPrecio;
    private javax.swing.JLabel lbProdTitle;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel mainPanel;
    private com.mycompany.gestioninventario.igu.TableGeneral prodTable;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadTotal;
    private javax.swing.JTextField txtMontoTotal;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables

}
