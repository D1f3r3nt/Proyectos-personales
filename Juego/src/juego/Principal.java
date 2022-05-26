
package juego;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;



public class Principal extends javax.swing.JFrame {

        
    public Principal() {
        initComponents();
        AudioClip sonido;
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("../sound/menu_sound.wav"));
        sonido.play();
        setIconImage(new ImageIcon(getClass().getResource("../image/icono.png")).getImage());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon icon = new ImageIcon(getClass().getResource("/image/fondo_principal.jpg"));
        Image img =icon.getImage();
        escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(img,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        jugar = new javax.swing.JButton();
        ayuda = new javax.swing.JButton();
        naves = new javax.swing.JButton();
        creditos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        escritorio.setPreferredSize(new java.awt.Dimension(800, 500));

        jugar.setText("Jugar");
        jugar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        ayuda.setText("Ayuda");
        ayuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ayuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayudaActionPerformed(evt);
            }
        });

        naves.setText("Naves");
        naves.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        naves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navesActionPerformed(evt);
            }
        });

        creditos.setText("Creditos");
        creditos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        creditos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditosActionPerformed(evt);
            }
        });

        escritorio.setLayer(jugar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(ayuda, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(naves, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(creditos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(336, 336, 336)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jugar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                    .addComponent(ayuda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(naves, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creditos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(354, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ayuda, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(naves, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(creditos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // Al clickar en jugar:
        Play ply = new Play();
        escritorio.add(ply);
        ply.show();
        ply.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); //para quitar los bordes
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ply.getUI()).setNorthPane(null); //para quitar el titulo
        try {
            ply.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jugarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Al iniciarse el ejecutable:
         this.pack();//para que se vean bien los elemento de la ventana
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        //para obtener las dimensiones de la pantalla
        Dimension dimen = this.getSize();
        //igual pero para la ventana
        this.setLocation(
            (pantalla.width - dimen.width) / 2,
            (pantalla.height - dimen.height) / 2);
        this.setVisible(true);
        //Poner la musica:
        
    }//GEN-LAST:event_formWindowOpened

    private void creditosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditosActionPerformed
        // Al clickar en creditos:
        Creditos crd = new Creditos();
        escritorio.add(crd);
        crd.show();
        crd.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); //para quitar los bordes
        ((javax.swing.plaf.basic.BasicInternalFrameUI)crd.getUI()).setNorthPane(null); //para quitar el titulo
        try {
            crd.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_creditosActionPerformed

    private void ayudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ayudaActionPerformed
        // Al clickar en ayuda:
        Ayuda ayu = new Ayuda();
        escritorio.add(ayu);
        ayu.show();
        ayu.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); //para quitar los bordes
        ((javax.swing.plaf.basic.BasicInternalFrameUI)ayu.getUI()).setNorthPane(null); //para quitar el titulo
        try {
            ayu.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ayudaActionPerformed

    private void navesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_navesActionPerformed
         // Al clickar en naves:
        Naves nav = new Naves();
        escritorio.add(nav);
        nav.show();
        nav.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0)); //para quitar los bordes
        ((javax.swing.plaf.basic.BasicInternalFrameUI)nav.getUI()).setNorthPane(null); //para quitar el titulo
        try {
            nav.setMaximum(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_navesActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ayuda;
    private javax.swing.JButton creditos;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jugar;
    private javax.swing.JButton naves;
    // End of variables declaration//GEN-END:variables
}
