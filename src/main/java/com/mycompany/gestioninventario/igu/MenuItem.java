package com.mycompany.gestioninventario.igu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuItem extends javax.swing.JPanel {

    private boolean selected;
    private boolean over;
    
    public MenuItem(Model_Menu data) {
        initComponents();
        setOpaque(false);
        if(data.getType() == Model_Menu.MenuType.MENU){
            lbIcon.setIcon(data.toIcon());
            lbName.setText(data.getName());
        }else if (data.getType() == Model_Menu.MenuType.TITLE){
            lbIcon.setText(data.getName());
            lbIcon.setFont(new Font("sansserif", 1, 12));
            lbName.setVisible(false);
        }else{
            lbName.setText(" ");
        }
    }
    
    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public void setOver(boolean over){
        this.over = over;
        repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIcon = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();

        lbIcon.setForeground(new java.awt.Color(255, 255, 255));
        lbIcon.setText("jLabel1");

        lbName.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lbName.setText("Menu Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbName, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lbIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    protected void paintComponent(Graphics grphcs) {
        if(selected || over){
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(selected){
                g2.setColor(new Color(180, 180, 180, 80));
            }else{
                g2.setColor(new Color(0, 0, 0, 40));
            }
            g2.fillRoundRect(10, 0, getWidth()-20, getHeight(), 5, 5);
        }
        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
