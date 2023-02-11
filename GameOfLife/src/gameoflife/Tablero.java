/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gameoflife;
//Aqui importamos las librerias que utilizamos.
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mario Moreno
 */
public class Tablero extends javax.swing.JFrame {

    final int wid = 50, hei = 50; //Constantes para dfinir el tamaño del tablero, mientras mas grande el numero mas pequeña seera la celula.
    boolean[][] currentMove = new boolean[hei][wid];
    boolean[][] nextMove = new boolean[hei][wid];
    boolean play;
    Image offScrimg;
    Graphics offScrGraph;
    //Constructor de clase con un metodo para correr el juego.
    public Tablero() {
        initComponents();
        offScrimg = createImage(panel1.getWidth(), panel1.getHeight());
        offScrGraph = offScrimg.getGraphics();
        Timer time = new Timer();
        TimerTask task = new TimerTask(){
            
            @Override
            public void run(){
                int contador, contDos;
                if(play){
                    for(contador=0; contador<hei; contador++){
                        for(contDos=0; contDos<wid; contDos++){
                            nextMove[contador][contDos] = decide(contador,contDos);
                        }
                    }
                    for(contador=0; contador<hei; contador++){
                        System.arraycopy(nextMove[contador], 0, currentMove[contador], 0, wid);
                    }
                    paint();
                }
            }
        };
        time.scheduleAtFixedRate(task,0,100);
        paint();
    }
//Metodo que decide el curso o camino que tomara nuestro grupo de celulas.
    private boolean decide(int i, int j){
        int vecinos=0;
        if(j>0){
            if(currentMove[i][j-1]){
                vecinos++;
            }
            if(i>0){
                if(currentMove[i-1][j-1]){
                    vecinos++;
                }
            }
            if(i<hei-1){
                if(currentMove[i+1][j-1]){
                    vecinos++;
                }
            }
        }
        if(j<wid-1){
            if(currentMove[i][j+1]){
                vecinos++;
            }
            if(i>0){
                if(currentMove[i-1][j+1]){
                    vecinos++;
                }
            }
            if(i>hei-1){
                if(currentMove[i+1][j-1]){
                    vecinos++;
                }
            }
        }
        if(i>0){
            if(currentMove[i-1][j]){
                vecinos++;
            }
        }
        if(i<hei-1){
            if(currentMove[i+1][j]){
                vecinos++;
            }
        }
        if(vecinos==3){
            return true;
        }
        return currentMove[i][j] && vecinos==2;
    }
    
    private void paint(){
        int contUno, contDos;
        offScrGraph.setColor(panel1.getBackground());
        offScrGraph.fillRect(0,0,panel1.getWidth(),panel1.getHeight());
        
        for(contUno=0; contUno<hei; contUno++){
            for(contDos=0; contDos<wid; contDos++){
                if(currentMove[contUno][contDos]){
                    offScrGraph.setColor(Color.RED);
                    
                    int x = contDos*panel1.getWidth()/wid;
                    int y = contUno*panel1.getHeight()/hei;
                    offScrGraph.fillRect(x,y,panel1.getWidth()/wid, panel1.getHeight()/hei);
                }
            }
        }
        offScrGraph.setColor(Color.BLACK);
        for(contUno=1; contUno<hei; contUno++){
            int y = contUno*panel1.getHeight()/hei;
            offScrGraph.drawLine(0, y, panel1.getWidth(), y);
        }
        for(contDos=1; contDos<wid; contDos++){
            int x = contDos*panel1.getWidth()/wid;
            offScrGraph.drawLine(x,0,x,panel1.getHeight());
        }
        panel1.getGraphics().drawImage(offScrimg,0,0,panel1);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jugar = new javax.swing.JButton();
        clean = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(51, 51, 51));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });
        panel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 405, Short.MAX_VALUE)
        );

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        clean.setText("Borrar");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:
        int j = wid*evt.getX()/panel1.getWidth();
        int i = wid*evt.getY()/panel1.getHeight();
        currentMove[i][j]=!currentMove[i][j];
        paint();
    }//GEN-LAST:event_panel1MouseClicked

    private void panel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panel1ComponentResized
        // TODO add your handling code here:
        offScrimg=createImage(panel1.getWidth(),panel1.getHeight());
        offScrGraph = offScrimg.getGraphics();
        paint();
    }//GEN-LAST:event_panel1ComponentResized

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed
        // TODO add your handling code here:
        play = !play;
        if(play){
            jugar.setText("PAUSA");
        }else{
            jugar.setText("JUGAR");
        }
        paint();
    }//GEN-LAST:event_jugarActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        // TODO add your handling code here:
        currentMove = new boolean[hei][wid];
        paint();
    }//GEN-LAST:event_cleanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Tablero().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clean;
    private javax.swing.JButton jugar;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables
}
