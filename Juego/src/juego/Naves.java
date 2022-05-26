
package juego;


public class Naves extends InternalFrameImagen {

    
    public Naves() {
        initComponents();
        setImage("../image/fondo_principal.jpg");
    }
    
    public static String colo = "azul";

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        menu = new javax.swing.JButton();
        blanco = new javax.swing.JLabel();
        amarillo = new javax.swing.JLabel();
        azul = new javax.swing.JLabel();
        white = new javax.swing.JRadioButton();
        yellow = new javax.swing.JRadioButton();
        blue = new javax.swing.JRadioButton();

        setBorder(null);

        menu.setText("<--");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        blanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nw.png"))); // NOI18N

        amarillo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ny.png"))); // NOI18N

        azul.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nb.png"))); // NOI18N

        buttonGroup1.add(white);
        white.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                whiteActionPerformed(evt);
            }
        });

        buttonGroup1.add(yellow);
        yellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowActionPerformed(evt);
            }
        });

        buttonGroup1.add(blue);
        blue.setSelected(true);
        blue.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                blueStateChanged(evt);
            }
        });
        blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(azul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(amarillo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(blanco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(blue)
                        .addGap(174, 174, 174)
                        .addComponent(yellow)
                        .addGap(177, 177, 177)
                        .addComponent(white)
                        .addGap(190, 190, 190))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(menu)
                        .addGap(297, 297, 297)
                        .addComponent(blue))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(amarillo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(azul))
                                .addGap(33, 33, 33))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(blanco)
                                .addGap(41, 41, 41)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(white)
                            .addComponent(yellow))))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // Al clickar en <--:
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed

    private void blueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_blueStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_blueStateChanged

    private void blueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueActionPerformed
        // Al clickar en azul:
        if(blue.isSelected()){
            colo = "azul";
        }
    }//GEN-LAST:event_blueActionPerformed

    private void yellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowActionPerformed
        // Al clickar en azul:
        if(yellow.isSelected()){
            colo = "amarillo";
        }
    }//GEN-LAST:event_yellowActionPerformed

    private void whiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_whiteActionPerformed
        // Al clickar en azul:
        if(white.isSelected()){
            colo = "blanco";
        }
    }//GEN-LAST:event_whiteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amarillo;
    private javax.swing.JLabel azul;
    private javax.swing.JLabel blanco;
    private javax.swing.JRadioButton blue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton menu;
    private javax.swing.JRadioButton white;
    private javax.swing.JRadioButton yellow;
    // End of variables declaration//GEN-END:variables
}
