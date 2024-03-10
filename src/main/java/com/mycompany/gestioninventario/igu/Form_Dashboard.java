package com.mycompany.gestioninventario.igu;

import com.mycompany.gestioninventario.logica.Controladora;
import java.awt.Color;
import javax.swing.ImageIcon;

public final class Form_Dashboard extends javax.swing.JPanel {
    
    Controladora control = null;

    public Form_Dashboard() {
        initComponents();
        control = new Controladora();   
        cargarDatos();
    }
    
    
    public void cargarDatos(){
        String cantProveedores = Integer.toString(control.traerProveedores().size());
        String cantProductos = Integer.toString(control.traerProductos().size());
        String cantCategorias = Integer.toString(control.traerCategorias().size());
        String cantExTotales = Integer.toString(control.existenciasTotales());
        String cantExVendidas = Integer.toString(control.existenciasVendidas());
        String cantExActuales= Integer.toString(control.existenciasActuales());
        String cantFacturas= Integer.toString(control.traerVentas().size());
        String importeVendido = Float.toString(control.importeVendido());
        String beneficioVenta = Float.toString(control.beneficioNeto());
        String gananciasTotales = Float.toString(control.gananciasActuales());
        
        Color card1BackgroundColor = new Color(102, 102, 185);
        Color card1IconColor = new Color(102, 102, 205);
        Color card2BackgroundColor = new Color(27, 153, 139);
        Color card2IconColor = new Color(15, 87, 78);
        Color card3BackgroundColor = new Color(250, 203, 15);
        Color card3IconColor = new Color(200, 161, 4);
        Color card4BackgroundColor = new Color(35, 201, 255);
        Color card4IconColor = new Color(0, 153, 204);
        Color card5BackgroundColor = new Color(255, 51, 109);
        Color card5IconColor = new Color(224, 0, 64);
        Color card6BackgroundColor = new Color(67, 110, 177);
        Color card6IconColor = new Color(43, 69, 112);
        Color card7BackgroundColor = new Color(103, 120, 162);
        Color card7IconColor = new Color(70, 82, 114);
        Color card8BackgroundColor = new Color(255, 78, 51);
        Color card8IconColor = new Color(184, 24, 0);
        Color card9BackgroundColor = new Color(93, 50, 51);
        Color card9IconColor = new Color(66, 36, 36);
        Color card10BackgroundColor = new Color(89, 34, 82);
        Color card10IconColor = new Color(59, 22, 54);
        
        card1.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardProveedores.png")), "Proveedores", cantProveedores), card1BackgroundColor, card1IconColor);
        card2.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardProductos.png")), "Productos", cantProductos), card2BackgroundColor, card2IconColor);
        card3.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardCategorias.png")), "Categorias", cantCategorias), card3BackgroundColor, card3IconColor);
        card4.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardExTotales.png")), "Existencia total", cantExTotales), card6BackgroundColor, card6IconColor);
        card5.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardExVendidas.png")), "Existencia vendida", cantExVendidas), card5BackgroundColor, card5IconColor);
        card6.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardExActuales.png")), "Existencia actual", cantExActuales), card4BackgroundColor, card4IconColor);
        card7.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardFacturas.png")), "Facturas", cantFacturas), card7BackgroundColor, card7IconColor);
        card8.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardVendidas.png")), "Importe vendido", "$" + importeVendido), card8BackgroundColor, card8IconColor);
        card9.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardBeneficioNeto.png")), "Beneficio venta", "$" + beneficioVenta), card9BackgroundColor, card9IconColor);
        card10.setData(new Model_Card(new ImageIcon(getClass().getResource("/icons/cardGanancias.png")), "Ganancias totales", "$" + gananciasTotales), card10BackgroundColor, card10IconColor);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        cardsPanel = new javax.swing.JPanel();
        card1 = new com.mycompany.gestioninventario.igu.Card();
        card2 = new com.mycompany.gestioninventario.igu.Card();
        card3 = new com.mycompany.gestioninventario.igu.Card();
        card4 = new com.mycompany.gestioninventario.igu.Card();
        card5 = new com.mycompany.gestioninventario.igu.Card();
        card6 = new com.mycompany.gestioninventario.igu.Card();
        card7 = new com.mycompany.gestioninventario.igu.Card();
        card8 = new com.mycompany.gestioninventario.igu.Card();
        card9 = new com.mycompany.gestioninventario.igu.Card();
        card10 = new com.mycompany.gestioninventario.igu.Card();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(102, 102, 102));
        lbTitle.setText("Dashboard");

        cardsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout cardsPanelLayout = new javax.swing.GroupLayout(cardsPanel);
        cardsPanel.setLayout(cardsPanelLayout);
        cardsPanelLayout.setHorizontalGroup(
            cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(cardsPanelLayout.createSequentialGroup()
                            .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(cardsPanelLayout.createSequentialGroup()
                                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                    .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(cardsPanelLayout.createSequentialGroup()
                                    .addComponent(card10, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(60, 60, 60)
                            .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(cardsPanelLayout.createSequentialGroup()
                            .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(54, 54, 54)
                            .addComponent(card8, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(card9, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardsPanelLayout.setVerticalGroup(
            cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardsPanelLayout.createSequentialGroup()
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(cardsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cardsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addContainerGap(946, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbTitle)
                .addGap(18, 18, 18)
                .addComponent(cardsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.gestioninventario.igu.Card card1;
    private com.mycompany.gestioninventario.igu.Card card10;
    private com.mycompany.gestioninventario.igu.Card card2;
    private com.mycompany.gestioninventario.igu.Card card3;
    private com.mycompany.gestioninventario.igu.Card card4;
    private com.mycompany.gestioninventario.igu.Card card5;
    private com.mycompany.gestioninventario.igu.Card card6;
    private com.mycompany.gestioninventario.igu.Card card7;
    private com.mycompany.gestioninventario.igu.Card card8;
    private com.mycompany.gestioninventario.igu.Card card9;
    private javax.swing.JPanel cardsPanel;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
