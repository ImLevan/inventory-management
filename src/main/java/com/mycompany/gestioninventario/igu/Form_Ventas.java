package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Controladora;
import com.mycompany.gestioninventario.logica.Usuario;
import com.mycompany.gestioninventario.logica.Venta;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Form_Ventas extends javax.swing.JPanel {

    Usuario usuario;
    Controladora control = null;

    public Form_Ventas(Usuario usuario) {
        this.usuario = usuario;
        control = new Controladora();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        spTable = new javax.swing.JScrollPane();
        table = new com.mycompany.gestioninventario.igu.TableGeneral();
        editButton = new javax.swing.JButton();
        btnVerDetalles = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Facturación");

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));

        btnAgregar.setBackground(new java.awt.Color(0, 153, 255));
        btnAgregar.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        btnAgregar.setText("Nueva factura");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Monto total", "Vendido por"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(102, 102, 102));
        table.setSelectionBackground(new java.awt.Color(102, 102, 102));
        spTable.setViewportView(table);

        editButton.setBackground(new java.awt.Color(0, 153, 255));
        editButton.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        editButton.setText("Editar");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        btnVerDetalles.setBackground(new java.awt.Color(255, 153, 0));
        btnVerDetalles.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        btnVerDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnVerDetalles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mostrar.png"))); // NOI18N
        btnVerDetalles.setText("Ver detalles");
        btnVerDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetallesActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 51, 102));
        deleteButton.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar.png"))); // NOI18N
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVerDetalles)
                        .addGap(42, 42, 42)
                        .addComponent(editButton)
                        .addGap(42, 42, 42)
                        .addComponent(deleteButton))
                    .addGroup(contentPanelLayout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(spTable, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbTitle))
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1126, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void cargarDatos() {
        table.setRowCount(0);

        List<Venta> listaVentas = control.traerVentas();

        if (listaVentas != null) {
            for (Venta venta : listaVentas) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String fechaFormateada = venta.getFecha().format(formatter);
                Object[] objeto = {
                    venta.getId(),
                    fechaFormateada,
                    "$" + venta.getMontoTotal(),
                    venta.getVenta_usuario().getUsuario(),};

                table.addRow(objeto);
            }
        }
    }

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        CargarVenta pantallaVenta = new CargarVenta(usuario);
        pantallaVenta.setFormVentasReference(this);
        pantallaVenta.setVisible(true);
        pantallaVenta.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        if(table.getRowCount() > 0){
            if(table.getSelectedRow() != -1){
                int num_venta= Integer.parseInt (String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));

                ModificarVenta pantallaModif = new ModificarVenta(usuario, num_venta);
                pantallaModif.setFormVentasReference(this);
                pantallaModif.setVisible(true);
                pantallaModif.setLocationRelativeTo(null);

            }
            else{
                MostrarMensaje.mostrarMensaje("No se seleccionó ninguna venta", "Error", "Error al editar");
            }
        }
        else{
            MostrarMensaje.mostrarMensaje("No hay nada para editar en la tabla", "Error", "Error al editar");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void btnVerDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetallesActionPerformed
        if (table.getRowCount() > 0) {
            if (table.getSelectedRow() != -1) {
                int num_venta = Integer.parseInt(String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));

                DetallesVenta pantallaDetalles = new DetallesVenta(num_venta);
                pantallaDetalles.setVisible(true);
                pantallaDetalles.setLocationRelativeTo(null);
                
            } else {
                MostrarMensaje.mostrarMensaje("No se seleccionó ninguna venta", "Error", "Error al ver detalles");
            }
        } else {
            MostrarMensaje.mostrarMensaje("No hay nada para ver en la tabla", "Error", "Error al ver detalles");
        }
    }//GEN-LAST:event_btnVerDetallesActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if(table.getRowCount() > 0){
            if(table.getSelectedRow() != -1){
                int num_venta = Integer.parseInt (String.valueOf(table.getValueAt(table.getSelectedRow(), 0)));
                control.borrarVenta(num_venta);

                MostrarMensaje.mostrarMensaje("Venta eliminada con exito", "Info", "Borrado de venta");
                cargarDatos();
            }
            else{
                MostrarMensaje.mostrarMensaje("No se seleccionó ninguna venta", "Error", "Error al eliminar");
            }
        }
        else{
            MostrarMensaje.mostrarMensaje("No hay nada para eliminar en la tabla", "Error", "Error al eliminar");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnVerDetalles;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JScrollPane spTable;
    private com.mycompany.gestioninventario.igu.TableGeneral table;
    // End of variables declaration//GEN-END:variables
}
