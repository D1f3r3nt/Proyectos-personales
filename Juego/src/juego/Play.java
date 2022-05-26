
package juego;



import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Play extends InternalFrameImagen {
    //Ponemos todas las fotos
    ImageIcon nave_azul = new ImageIcon(getClass().getResource("../image/nb.png"));
    ImageIcon nave_amarilla = new ImageIcon(getClass().getResource("../image/ny.png"));
    ImageIcon nave_blanca = new ImageIcon(getClass().getResource("../image/nw.png"));
    ImageIcon nave_azul_plus = new ImageIcon(getClass().getResource("../image/nb+.png"));
    ImageIcon nave_amarilla_plus = new ImageIcon(getClass().getResource("../image/ny+.png"));
    ImageIcon nave_blanca_plus = new ImageIcon(getClass().getResource("../image/nw+.png"));
    ImageIcon nave_enemiga1 = new ImageIcon(getClass().getResource("../image/enem_l.png"));
    ImageIcon nave_enemiga1_esquivando_azul = new ImageIcon(getClass().getResource("../image/I_back_b.png"));
    ImageIcon nave_enemiga1_esquivando_blanco = new ImageIcon(getClass().getResource("../image/I_back_w.png"));
    ImageIcon nave_enemiga1_esquivando_amarillo = new ImageIcon(getClass().getResource("../image/I_back_y.png"));
    ImageIcon nave_enemiga2 = new ImageIcon(getClass().getResource("../image/enem_II.png"));
    ImageIcon nave_enemiga2_esquivando_azul = new ImageIcon(getClass().getResource("../image/II_back_b.png"));
    ImageIcon nave_enemiga2_esquivando_blanco = new ImageIcon(getClass().getResource("../image/II_back_w.png"));
    ImageIcon nave_enemiga2_esquivando_amarillo = new ImageIcon(getClass().getResource("../image/II_back_y.png"));
    ImageIcon nave_enemiga3 = new ImageIcon(getClass().getResource("../image/enem_III.png"));
    ImageIcon nave_enemiga3_esquivando_azul = new ImageIcon(getClass().getResource("../image/III_back_b.png"));
    ImageIcon nave_enemiga3_esquivando_blanco = new ImageIcon(getClass().getResource("../image/III_back_w.png"));
    ImageIcon nave_enemiga3_esquivando_amarillo = new ImageIcon(getClass().getResource("../image/III_back_y.png"));
    //Llamamos a la variable global
    String type = Naves.colo;
    //Iniciamos el reloj
    Reloj miTimer =new Reloj(); //crea la cuenta
    //iniciamos las banderas de los ataques
    boolean shoot_1 = false;  
    boolean shoot_2 = false;       
    boolean shoot_3 = false;
    String enemigo = "";
    //Creamos el Random
    Random aleatorio = new Random(System.currentTimeMillis()); //creamos el aleatorio
    public Play() {
        initComponents();
        //Ponemos fondo de pantalla
        setImage("../image/fondo_guerra.jpg");
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JButton();
        ship = new javax.swing.JLabel();
        enemy = new javax.swing.JLabel();
        carga = new javax.swing.JProgressBar();
        shoot = new javax.swing.JButton();
        vida_b = new javax.swing.JProgressBar();
        vida_l = new javax.swing.JLabel();
        enemy_life_b = new javax.swing.JProgressBar();
        enemy_life_l = new javax.swing.JLabel();
        mensaje = new javax.swing.JLabel();
        tres = new javax.swing.JButton();
        dos = new javax.swing.JButton();
        uno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        puntos = new javax.swing.JLabel();

        setBackground(java.awt.Color.lightGray);
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(800, 500));
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        menu.setBackground(java.awt.Color.lightGray);
        menu.setText("<--");
        menu.setBorder(null);
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });

        ship.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        ship.setForeground(new java.awt.Color(255, 255, 255));
        ship.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ship.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/nb.png"))); // NOI18N

        enemy.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        enemy.setForeground(new java.awt.Color(255, 255, 255));
        enemy.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        enemy.setMaximumSize(new java.awt.Dimension(150, 150));

        carga.setMaximum(150);
        carga.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cargaStateChanged(evt);
            }
        });

        shoot.setText("SHOOT");
        shoot.setBorder(null);
        shoot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        shoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shootActionPerformed(evt);
            }
        });

        vida_b.setValue(100);
        vida_b.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                vida_bStateChanged(evt);
            }
        });

        vida_l.setForeground(new java.awt.Color(255, 255, 255));
        vida_l.setText("100/100");

        enemy_life_b.setValue(100);
        enemy_life_b.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                enemy_life_bStateChanged(evt);
            }
        });

        enemy_life_l.setForeground(new java.awt.Color(255, 255, 255));
        enemy_life_l.setText("100/100");

        mensaje.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mensaje.setForeground(new java.awt.Color(255, 255, 255));

        tres.setText("3");
        tres.setBorder(null);
        tres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tresActionPerformed(evt);
            }
        });

        dos.setText("2");
        dos.setBorder(null);
        dos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosActionPerformed(evt);
            }
        });

        uno.setText("1");
        uno.setBorder(null);
        uno.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unoActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Puntos de fuerza:");

        puntos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        puntos.setForeground(new java.awt.Color(255, 255, 255));
        puntos.setText("0");
        puntos.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                puntosHierarchyChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(128, 128, 128)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(vida_b, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vida_l)
                                    .addComponent(puntos)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(ship, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(423, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carga, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shoot, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(enemy_life_b, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(enemy_life_l)
                        .addGap(70, 70, 70))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(enemy, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(enemy_life_b, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enemy_life_l))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(puntos)))
                            .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uno, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(dos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tres, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(ship, javax.swing.GroupLayout.PREFERRED_SIZE, 119, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vida_b, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vida_l, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(carga, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        // Al clickar en menu:
        int res = JOptionPane.showConfirmDialog(null, "Se perdera esta partida, ¿estas seguro de salir?", "ADVERTENCIA", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(res == 0){
            this.dispose();
        }else{
            
        }
        
    }//GEN-LAST:event_menuActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // Al iniciarse el juego:
        dos.setVisible(false);
        tres.setVisible(false);
        miTimer.creaTimer(); //se activa al abrirse el jFrame
        miTimer.Stop();
        miTimer.Reset();
        
        //Elegimos el enemigo
        int ale = aleatorio.nextInt(3);
        
        //colocamos el tipo de nave
        if(type.equals("azul")){
            ship.setIcon(nave_azul);
        }else  if(type.equals("amarillo")){
            ship.setIcon(nave_amarilla);
        }else  if(type.equals("blanco")){
            ship.setIcon(nave_blanca);
        }
        
        //Establecemos la vida
        if(ale == 0){
            enemy.setIcon(nave_enemiga1);
            enemy_life_l.setText("100/100");
            enemy_life_b.setMaximum(100);
            enemy_life_b.setValue(100);
            enemigo = "uno";
        }else if(ale == 1){
            enemy.setIcon(nave_enemiga2);
            enemy_life_l.setText("200/200");
            enemy_life_b.setMaximum(200);
            enemy_life_b.setValue(200);
            enemigo = "dos";
        }else if(ale == 2){
            enemy.setIcon(nave_enemiga3);
            enemy_life_l.setText("400/400");
            enemy_life_b.setMaximum(400);
            enemy_life_b.setValue(400);
            enemigo = "tres";
        }
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void unoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unoActionPerformed
        // Al clickar en uno:
        //colocamos el tipo de nave
        if(type.equals("azul")){
            ship.setIcon(nave_azul_plus);
        }else  if(type.equals("amarillo")){
            ship.setIcon(nave_amarilla_plus);
        }else  if(type.equals("blanco")){
            ship.setIcon(nave_blanca_plus);
        }
        //colocamos al enemigo
        if(enemigo.equals("uno")){
                
                    enemy.setIcon(nave_enemiga1);
                
        }else if(enemigo.equals("dos")){
                
                    enemy.setIcon(nave_enemiga2);
                
        }else if(enemigo.equals("tres")){
                
                    enemy.setIcon(nave_enemiga3);
                
        }
        shoot_1 = true;
        miTimer.Stop();
        miTimer.Reset();
        miTimer.Start();
    }//GEN-LAST:event_unoActionPerformed

    private void shootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shootActionPerformed
        // Al disparar:
        miTimer.Stop();
        //Hacemos los diferentes dipos de ataque junto a sus daños
        if(carga.getValue() <= 100){
            mensaje.setText("Penoso!!"); //mensaje
            //colocamos el tipo de nave
            if(enemigo.equals("uno")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga1_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga1_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga1_esquivando_blanco);
                }
            }else if(enemigo.equals("dos")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga2_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga2_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga2_esquivando_blanco);
                }
            }else if(enemigo.equals("tres")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga3_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga3_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga3_esquivando_blanco);
                }
            }
            
        }else if(carga.getValue() > 100 && carga.getValue() < 125){
            mensaje.setText("Bien"); //mensaje
            //colocamos el tipo de nave
            if(enemigo.equals("uno")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga1_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga1_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga1_esquivando_blanco);
                }
            }else if(enemigo.equals("dos")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga2_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga2_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga2_esquivando_blanco);
                }
            }else if(enemigo.equals("tres")){
                if(type.equals("azul")){
                    enemy.setIcon(nave_enemiga3_esquivando_azul);
                }else  if(type.equals("amarillo")){
                    enemy.setIcon(nave_enemiga3_esquivando_amarillo);
                }else  if(type.equals("blanco")){
                    enemy.setIcon(nave_enemiga3_esquivando_blanco);
                }
            }
            
        }else if(carga.getValue() >= 125 && carga.getValue() < 140){
            mensaje.setText("Perfecto"); //mensaje
            
            //Empieza los tipos de ataque
            int valor = 0;
            if(shoot_1){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-25);
            }else if(shoot_2){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-50);
            }else if(shoot_3){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-100);
            }
            
        }else if(carga.getValue() >= 140 && carga.getValue() < 150){
            mensaje.setText("Excelente!");//mensaje
            
            //Empieza los tipos de ataque
            int valor = 0;
            if(shoot_1){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-50);
            }else if(shoot_2){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-100);
            }else if(shoot_3){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-200);
            }
        }else if(carga.getValue() == 150){
            mensaje.setText("LEYENDA!!!!");//mensaje
            
            //Empieza los tipos de ataque
            int valor = 0;
            if(shoot_1){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-100);
            }else if(shoot_2){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-200);
            }else if(shoot_3){
                valor = enemy_life_b.getValue();
                enemy_life_b.setValue(valor-400);
            }
        }
        //Nos atacan
        int ale_1 = aleatorio.nextInt(3);
        int ale_2 = aleatorio.nextInt(4);
        String rec = enemy_life_l.getText();
        String[] vida_o = rec.split("/");
        int p = vida_b.getValue();
        if(ale_1 == 0){
            if("100".equals(vida_o[1])){
                vida_b.setValue(p-25);
            }else if("200".equals(vida_o[1])){
                vida_b.setValue(p-35);
            }  
        }else if(ale_2 == 0){
             if("400".equals(vida_o[1])){
                vida_b.setValue(p-50);
            }
        }
        //recuento
        if(shoot_1 = true){
            String points = puntos.getText();
            int pun = Integer.parseInt(points);
            if(pun < 6){
                puntos.setText(String.valueOf(pun+1));
            }
            //enseñamos
            if(pun < 1){
                dos.setVisible(false);
                tres.setVisible(false);
            }else if(pun == 1){
                dos.setVisible(true);
                tres.setVisible(false);
            }else if(pun >= 2){
                dos.setVisible(true);
                tres.setVisible(true);
            }
        }
        
        //borramos las banderas
        shoot_1 = false;
        shoot_2 = false;
        shoot_3 = false;
        
        //colocamos el tipo de nave
        if(type.equals("azul")){
            ship.setIcon(nave_azul);
        }else  if(type.equals("amarillo")){
            ship.setIcon(nave_amarilla);
        }else  if(type.equals("blanco")){
            ship.setIcon(nave_blanca);
        }
    }//GEN-LAST:event_shootActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
    
    }//GEN-LAST:event_formInternalFrameActivated

    private void cargaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cargaStateChanged
        // Al moverse carga:
        if(carga.getValue() >= 150){
            miTimer.Reset();
            miTimer.Start();
        }
    }//GEN-LAST:event_cargaStateChanged

    private void dosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosActionPerformed
        // Al clickar en dos:
        //colocamos el tipo de nave
        if(type.equals("azul")){
            ship.setIcon(nave_azul_plus);
        }else  if(type.equals("amarillo")){
            ship.setIcon(nave_amarilla_plus);
        }else  if(type.equals("blanco")){
            ship.setIcon(nave_blanca_plus);
        }
        //colocamos al enemigo
        if(enemigo.equals("uno")){
                
                    enemy.setIcon(nave_enemiga1);
                
        }else if(enemigo.equals("dos")){
                
                    enemy.setIcon(nave_enemiga2);
                
        }else if(enemigo.equals("tres")){
                
                    enemy.setIcon(nave_enemiga3);
                
        }
        String points = puntos.getText();
        int pun = Integer.parseInt(points);
        int pop = pun-2;
        puntos.setText(String.valueOf(pop));
        shoot_2 = true;
        miTimer.Stop();
        miTimer.Reset();
        miTimer.Start();
    }//GEN-LAST:event_dosActionPerformed

    private void tresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tresActionPerformed
        // Al clickar en tres:
        //colocamos el tipo de nave
        if(type.equals("azul")){
            ship.setIcon(nave_azul_plus);
        }else  if(type.equals("amarillo")){
            ship.setIcon(nave_amarilla_plus);
        }else  if(type.equals("blanco")){
            ship.setIcon(nave_blanca_plus);
        }
        //colocamos al enemigo
        if(enemigo.equals("uno")){
                
                    enemy.setIcon(nave_enemiga1);
                
        }else if(enemigo.equals("dos")){
                
                    enemy.setIcon(nave_enemiga2);
                
        }else if(enemigo.equals("tres")){
                
                    enemy.setIcon(nave_enemiga3);
                
        }
        String points = puntos.getText();
        int pun = Integer.parseInt(points);
        int pop = pun-3;
        puntos.setText(String.valueOf(pop));
        shoot_3 = true;
        miTimer.Stop();
        miTimer.Reset();
        miTimer.Start();
    }//GEN-LAST:event_tresActionPerformed

    private void enemy_life_bStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_enemy_life_bStateChanged
        // Al cambiar la vida del enemigo:
        int vida_e = enemy_life_b.getValue();
        String rec = enemy_life_l.getText();
        String[] vida_o = rec.split("/");
        enemy_life_l.setText(vida_e+"/"+vida_o[1]);
        if(vida_e <= 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Has ganado :)", "VICTORIA", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
                
    }//GEN-LAST:event_enemy_life_bStateChanged

    private void vida_bStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_vida_bStateChanged
        // Al cambiar mi vida:
        int vida_e = vida_b.getValue();
        vida_l.setText(vida_e+"/100");
        if(vida_e <= 0){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Has perdido :(", "DERROTA", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        }
    }//GEN-LAST:event_vida_bStateChanged

    private void puntosHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_puntosHierarchyChanged
        // Al cambiar el texto:
        String points = puntos.getText();
        int poi = Integer.parseInt(points);
        
    }//GEN-LAST:event_puntosHierarchyChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JProgressBar carga;
    private javax.swing.JButton dos;
    private javax.swing.JLabel enemy;
    private javax.swing.JProgressBar enemy_life_b;
    private javax.swing.JLabel enemy_life_l;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JButton menu;
    private javax.swing.JLabel puntos;
    private javax.swing.JLabel ship;
    private javax.swing.JButton shoot;
    private javax.swing.JButton tres;
    private javax.swing.JButton uno;
    private javax.swing.JProgressBar vida_b;
    private javax.swing.JLabel vida_l;
    // End of variables declaration//GEN-END:variables
}
