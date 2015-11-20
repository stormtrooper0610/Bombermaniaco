/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Functionality.Bombermaniac;
import static Functionality.Globals.instance;
import Functionality.MP3;
import Functionality.Music;
import Functionality.Chronometer;
import Objects.Balloon;
import Objects.Barrell;
import Objects.Element;
import Objects.Hero;
import java.awt.event.KeyEvent;
import static java.lang.Thread.State.RUNNABLE;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.xml.bind.JAXBElement;

/**
 *
 * @author Daniel-PC
 */

public class GameEasy extends javax.swing.JFrame {

    Chronometer chrono;
    int timerCount;
    Hero hero;
    Music music;
    Thread musicThread;
    MP3 mp3;

    public GameEasy() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(970, 790);

        //creates and plays the music
        mp3 = new MP3("/Sounds/hard.mp3");
        instance.setMusic(mp3);
        instance.getMusic().play();
        chrono = new Chronometer(timerlbl) {
        };
        instance.setChrono(chrono);
        instance.setFrame(this);
        //MapPainter map=new MapPainter();

        //instance.setMap(map);
        try {
            instance.getCurrentMatrix().fill();
            instance.paintFrame2();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameEasy.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButton1.setLocation(0, 0);
        timerlbl.setLocation(0, 10);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        timerlbl = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bombermaniac!--EASY");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        jLabel2.setText("Time:");

        timerlbl.setFont(new java.awt.Font("Ravie", 1, 14)); // NOI18N
        timerlbl.setText("000");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(timerlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(616, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timerlbl))
                .addContainerGap(405, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed


    }//GEN-LAST:event_formKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean placed = false;
        chrono.run();
        while (!placed) {
            int line = Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
            int column = Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
            if (instance.getCurrentMatrix().getMatrix()[line][column].getClass().getSimpleName().equals("EmptySpace")) {
                hero = new Hero(column, line, this);
                instance.getCurrentMatrix().getMatrix()[line][column] = hero;
                instance.setHeroPositionX(column);
                instance.setHeroPositionY(line);
                hero.start();
                placed = true;
                //jLabel1.setText("X: "+hero.getPositionX());
                //jLabel2.setText("Y: "+hero.getPositionY());

            }
        }
        boolean finished = false;
        while (!finished) {

            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Balloon tempBalloon;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if (instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Balloon")) {
                        tempBalloon = (Balloon) instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBalloon.setHero(hero);
                        if (instance.getCurrentMatrix().getMatrix()[row][col].getState() == RUNNABLE) {
                            instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                        }
                        instance.getCurrentMatrix().getMatrix()[row][col].start();

                    }
                }
            }

            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Barrell tempBarrell;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if (instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Barrell")) {
                        tempBarrell = (Barrell) instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBarrell.setHero(hero);
                        instance.getCurrentMatrix().getMatrix()[row][col].start();

                    }
                }
            }
            finished = true;

        }
        instance.getFrame().repaint();

        //jButton1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        hero.move(instance.getCurrentMatrix().getMatrix(), evt);
        try {
            instance.paintFrame2();
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameMedium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyTyped

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
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameEasy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel timerlbl;
    // End of variables declaration//GEN-END:variables
}
