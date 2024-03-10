package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Controladora;
import com.mycompany.gestioninventario.logica.Rel_existencia_venta;
import com.mycompany.gestioninventario.logica.Venta;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DetallesVenta extends javax.swing.JFrame {

    private int idFactura;
    private Controladora control = null;

    public DetallesVenta(int idFactura) {
        this.idFactura = idFactura;
        control = new Controladora();
        initComponents();
        cargarDatos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        spTable1 = new javax.swing.JScrollPane();
        cuentaTable = new com.mycompany.gestioninventario.igu.TableGeneral();
        txtCantidadTotal = new javax.swing.JTextField();
        txtMontoTotal = new javax.swing.JTextField();
        lbCantidadTotal = new javax.swing.JLabel();
        lbMontoTotal = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbNumero = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        txtCantidadTotal.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        txtCantidadTotal.setEnabled(false);

        txtMontoTotal.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        txtMontoTotal.setEnabled(false);

        lbCantidadTotal.setText("Cantidad total");

        lbMontoTotal.setText("Monto total");

        lbTitle.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbTitle.setText("Pago de factura Nº:");

        lbNumero.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        btnCerrar.setBackground(new java.awt.Color(255, 51, 51));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/x.png"))); // NOI18N
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 992, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCerrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCantidadTotal)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMontoTotal))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbTitle)
                        .addComponent(lbNumero))
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(spTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbCantidadTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMontoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cargarDatos() {
        cuentaTable.setRowCount(0);
        Venta venta = control.traerVenta(idFactura);
        
        List<Rel_existencia_venta> listaExistencias = venta.getVenta_rel();

        if(listaExistencias != null){
            for (Rel_existencia_venta existencia : listaExistencias) {
                
                Object[] objeto = {
                    existencia.getRel_existencia().getId(),
                    existencia.getRel_existencia().getExistencia_producto().getNombre(),
                    "$" + existencia.getPrecioUnidad(),
                    existencia.getCantidad(),
                    existencia.getCantidad() * existencia.getPrecioUnidad()
                };

                cuentaTable.addRow(objeto);
            }
            
            cargarInputs();
            lbNumero.setText(String.valueOf(idFactura));
        }
    }
    
    private void cargarInputs(){
        int cantTotal = 0;
        float montoTotal = 0;
        
        for (int i = 0; i < cuentaTable.getRowCount(); i++) {
            cantTotal += Integer.parseInt(String.valueOf(cuentaTable.getValueAt(i, 3)));
            montoTotal += Float.parseFloat(String.valueOf(cuentaTable.getValueAt(i, 4)));
        }
        
        txtCantidadTotal.setText(String.valueOf(cantTotal));
        txtMontoTotal.setText("$" + String.valueOf(montoTotal));
    }

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private com.mycompany.gestioninventario.igu.TableGeneral cuentaTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCantidadTotal;
    private javax.swing.JLabel lbMontoTotal;
    private javax.swing.JLabel lbNumero;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JScrollPane spTable1;
    private javax.swing.JTextField txtCantidadTotal;
    private javax.swing.JTextField txtMontoTotal;
    // End of variables declaration//GEN-END:variables
}
