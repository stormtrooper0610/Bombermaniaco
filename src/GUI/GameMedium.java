/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Functionality.Bombermaniac;
import Functionality.Chronometer;
import static Functionality.Globals.instance;
import Functionality.MP3;
<<<<<<< HEAD
import Objects.Balloon;
import Objects.Barrell;
import Objects.Hero;
import javax.swing.JFrame;
=======
import Functionality.MapPainter;
import Functionality.Music;
import Functionality.Timer;
import Objects.Balloon;
import Objects.Barrell;
import Objects.Hero;
import java.awt.Graphics;
import javax.swing.JFrame;
import static java.lang.Thread.State.RUNNABLE;
>>>>>>> origin/master
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel-PC
 */
public class GameMedium extends javax.swing.JFrame {

    Chronometer chrono;
    int timerCount;
    Hero hero;
    Thread musicThread;
    MP3 mp3;
    public GameMedium() throws MalformedURLException {
        initComponents();
<<<<<<< HEAD
        setResizable(false);
=======
        //setResizable(false);
>>>>>>> origin/master
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(970, 790);
        
        
<<<<<<< HEAD
        mp3=new MP3("/Sounds/hard.mp3");
=======
        //creates and plays the music
        String path="E:\\DATOS\\TEC\\IV Semestre\\POO\\PROYECTO FINAL\\Bombermaniaco\\src\\Sounds\\medium.mp3";
        mp3=new MP3(path);
>>>>>>> origin/master
        instance.setMusic(mp3);
        instance.getMusic().play();
        chrono=new Chronometer(timerlbl) {};
        instance.setChrono(chrono);
        
<<<<<<< HEAD
        //MapPainter map=new MapPainter();
        
=======
        newTimer=new Timer(timerlbl);
        newTimer.start();
        
        //MapPainter map=new MapPainter();
        
>>>>>>> origin/master
        //instance.setMap(map);
        instance.setPanel(jPanel1);
        instance.setFrame(this);
        instance.getCurrentMatrix().fill();
        //map.setBounds(0, 6, 800, 600);
        //map.repaint();
        //System.out.println(map.getHeight()+"x"+map.getWidth());
        instance.paintFrame();
        //instance.getFrame().add(map);
        //map.repaint();
        
        //this.getContentPane().add(jPanel1,BorderLayout.CENTER);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
=======
        jButton1 = new javax.swing.JButton();
>>>>>>> origin/master
        jLabel2 = new javax.swing.JLabel();
        timerlbl = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOMBERMANIAC!");
        getContentPane().setLayout(null);
<<<<<<< HEAD

        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("Time:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 240, 50, 20);

        timerlbl.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        timerlbl.setText("000");
        getContentPane().add(timerlbl);
        timerlbl.setBounds(70, 240, 50, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(130, 10, 600, 460);
=======
>>>>>>> origin/master

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });
        getContentPane().add(jButton1);
<<<<<<< HEAD
        jButton1.setBounds(30, 180, 57, 23);
=======
        jButton1.setBounds(659, 455, 57, 23);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("Time:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 450, 50, 20);

        timerlbl.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        timerlbl.setText("jLabel3");
        getContentPane().add(timerlbl);
        timerlbl.setBounds(70, 450, 79, 20);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 720, 430);
>>>>>>> origin/master

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean placed=false;
        chrono.run();
        while(!placed){
        int line=Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
        int column=Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
           if(instance.getCurrentMatrix().getMatrix()[line][column].getClass().getSimpleName().equals("EmptySpace")){
               hero=new Hero(column, line,this);
               instance.getCurrentMatrix().getMatrix()[line][column]=hero;
               instance.setHeroPositionX(column);
               instance.setHeroPositionY(line);
               hero.start();
               placed=true;
               //jLabel1.setText("X: "+hero.getPositionX());
               //jLabel2.setText("Y: "+hero.getPositionY());
               
           }
        }
        boolean finished=false;
        while(!finished){
        
            
            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Balloon tempBalloon;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if(instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Balloon")){
                        tempBalloon=(Balloon)instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBalloon.setHero(hero);
                        if(instance.getCurrentMatrix().getMatrix()[row][col].isAlive()){
                            instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                        }
                        instance.getCurrentMatrix().getMatrix()[row][col].start();
                        


                    }
                }
            }
            
            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Barrell tempBarrell;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if(instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Barrell")){
                        tempBarrell=(Barrell)instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBarrell.setHero(hero);
                        if(instance.getCurrentMatrix().getMatrix()[row][col].isAlive()){
                            instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                        }
                        instance.getCurrentMatrix().getMatrix()[row][col].start();
                        

                    }
                }
            }
            finished=true;
            
        }
<<<<<<< HEAD
        instance.getFrame().repaint();
        
=======
>>>>>>> origin/master
        //jButton1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        hero.move(instance.getCurrentMatrix().getMatrix(), evt);
        try {
            instance.paintFrame();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameMedium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1KeyPressed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameMedium().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GameMedium.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel timerlbl;
    // End of variables declaration//GEN-END:variables
}
