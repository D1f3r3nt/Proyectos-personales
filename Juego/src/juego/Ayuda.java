
package juego;


public class Ayuda extends InternalFrameImagen {

    
    public Ayuda() {
        initComponents();
         setImage("../image/fondo_principal.jpg");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBorder(null);

        menu.setText("<--");
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("SpaceWar se trata de un juego arcade.\n\nReglas:\n\n\t-Al inicar partida se generara automaticamente un enemigo, el cual \n\ttiene ciertas caraterísticas, ya sea su vida o su fuerza.\n\n\t-Existen tres tipos de enemigos.\n\n\t-Al estar en la pantalla de juego vas a tener que seleccionar un tipo de\n\tataque (1,2,3), al iniciar solo estara disponible el nivel 1 el cual cada\n\tvez que lo uses te otorgara puntos de fuerza el ataque nivel 2, se podra\n\tusar cuando hayas acumulado dos puntos de fuerza y el ataque de nivel 3\n\tlo podras usar cuando hayas acumulado tres puntos de fuerza. Solo podras\n\tacumular un maximo de 6 puntos de fuerza.\n\t\n\t-Tu puedes realizar un disparo sin elegir el tipo de ataque i te contara\n\tun punto de fuerza, pero no le haras daño al enemigo i el podra hacertelo \n\ta ti.\n\n\t-Cuando vayas a realizar un atque, primero tienes que seleccionar el \n\ttipo de ataque, despues se cargara la barra de poder y tienes que intentar\n\tacercarte lo maximo posible al borde derecho.\n\n\t-Cuando mas te acerques al limite derecho tus ataques tendran mas fuerza\n\ty lo podras saber con el mensaje (Perfecto, Excelente, LEYENDA), en caso\n\tde sacar un Penosos o Bien el enemigo podrá esquibar tu ataque.\n\n\n\t-Cuidado!!, cada vez que uses un ataque de nivel 2 o 3 se te restaran \n\tlos puntos de fuerza correspondientes.\n\n\t-Cada vez que ejecutas un disparo el enemigo tambien lo hará y hay una \n\tcierta probabilidad de que te de el enemigo (entre 25% o 33%) dependiendo\n\tdel enemigo.\n\t\n\t-Si pierdes o ganas directamente se acabará la partida.\n\nOtros:\n\n\t-En la sección NAVES del menu podras elegir el color de tu nave.");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // Al clickar en <--:
        this.dispose();
    }//GEN-LAST:event_menuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton menu;
    // End of variables declaration//GEN-END:variables
}
