package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Usuario;
import javax.swing.JComponent;

public class Principal extends javax.swing.JFrame {
    
    private Usuario usuario;
    private Form_Dashboard formDashboard;
    private Form_Categorias formCategorias;
    private Form_Productos formProductos;
    private Form_Proveedores formProveedores;
    private Form_Existencias formExistencias;
    private Form_Ventas formVentas;
    private Form_Usuarios formUsuarios;

    public Principal(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        formDashboard = new Form_Dashboard();
        formCategorias = new Form_Categorias();
        formProductos = new Form_Productos();
        formProveedores = new Form_Proveedores();
        formExistencias = new Form_Existencias(usuario);
        formVentas = new Form_Ventas(usuario);
        formUsuarios = new Form_Usuarios();
        menu.initMoving(Principal.this);
        menu.setUserLbl(usuario.getUsuario());
        menu.addEventMenuSelected((int index) -> {
            switch (index) {
                case 0 -> {
                    formDashboard.cargarDatos();
                    setForm(formDashboard);
                }
                case 1 -> {
                    formUsuarios.cargarDatos();
                    setForm(formUsuarios);
                }
                case 2 -> {
                    formCategorias.cargarDatos();
                    setForm(formCategorias);
                }
                case 3 -> {
                    formProductos.cargarDatos();
                    setForm(formProductos);
                }
                case 4 -> {
                    formProveedores.cargarDatos();
                    setForm(formProveedores);
                }
                case 5 -> {
                    formExistencias.cargarDatos();
                    setForm(formExistencias);
                }
                case 6 -> {
                    formVentas.cargarDatos();
                    setForm(formVentas);
                }
                case 7 -> {
                    System.exit(0);
                }
                default -> {
                }
            }
        });
        setForm(formDashboard);
    }
    
    private void setForm(JComponent com){
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder1 = new com.mycompany.gestioninventario.igu.PanelBorder();
        mainPanel = new javax.swing.JPanel();
        menu = new com.mycompany.gestioninventario.igu.Menu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBorder1.setBackground(new java.awt.Color(255, 255, 255));

        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 945, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
            .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private com.mycompany.gestioninventario.igu.Menu menu;
    private com.mycompany.gestioninventario.igu.PanelBorder panelBorder1;
    // End of variables declaration//GEN-END:variables
}
