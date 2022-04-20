package Tetris;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class GameForm extends javax.swing.JFrame {

    
    private GameArea ga;
    private Game g;
    public GameForm() {
        initComponents();
        ga = new GameArea(GameAreaPlaceholder,10);
        this.add(ga);
        Control();
       
    }
    
    public void Control() {
        
        InputMap im = this.getRootPane().getInputMap();
        ActionMap am = this.getRootPane().getActionMap();
    
        im.put(KeyStroke.getKeyStroke("RIGHT"), "right");
        im.put(KeyStroke.getKeyStroke("LEFT"), "left");
        im.put(KeyStroke.getKeyStroke("UP"), "up");
        im.put(KeyStroke.getKeyStroke("DOWN"), "down");
        
        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockRight();
                //System.out.println("Right");
            }
        });
        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockLeft();
                //System.out.println("Left");
            }
        });
        am.put("up", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.rotateBlock();
                //System.out.println("Up");
            }
        });
        am.put("down", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ga.moveBlockDown();
                //System.out.println("Down");
            }
        });
    }
    
    public void startGame() {
        
        ga.intBackgroundArray();
        g = new Game(ga,this);
        g.start();
    }
    
    public void scoreUpdate(int score){
        ScoreDisplay.setForeground(Color.cyan);
        ScoreDisplay.setText("Score: "+score);
    }
    
    public void levelUpdate(int level){
        LevelDisplay.setForeground(Color.cyan);
        LevelDisplay.setText("Level: "+level);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        MAINButton = new javax.swing.JButton();
        GameAreaPlaceholder = new javax.swing.JPanel();
        LevelDisplay = new javax.swing.JLabel();
        ScoreDisplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MAINButton.setBackground(new java.awt.Color(0, 204, 204));
        MAINButton.setFont(new java.awt.Font("hooge 05_54", 1, 14)); // NOI18N
        MAINButton.setText("MAIN MENU");
        MAINButton.setFocusable(false);
        MAINButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MAINButtonActionPerformed(evt);
            }
        });
        jPanel1.add(MAINButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        GameAreaPlaceholder.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GameAreaPlaceholder.setPreferredSize(new java.awt.Dimension(200, 400));

        javax.swing.GroupLayout GameAreaPlaceholderLayout = new javax.swing.GroupLayout(GameAreaPlaceholder);
        GameAreaPlaceholder.setLayout(GameAreaPlaceholderLayout);
        GameAreaPlaceholderLayout.setHorizontalGroup(
            GameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        GameAreaPlaceholderLayout.setVerticalGroup(
            GameAreaPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jPanel1.add(GameAreaPlaceholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 33, -1, -1));

        LevelDisplay.setFont(new java.awt.Font("hooge 05_54", 1, 14)); // NOI18N
        LevelDisplay.setText("Level:  1");
        jPanel1.add(LevelDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 78, 161, 26));

        ScoreDisplay.setFont(new java.awt.Font("hooge 05_54", 1, 14)); // NOI18N
        ScoreDisplay.setText("SCORE: 0");
        jPanel1.add(ScoreDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 39, 170, 33));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MAINButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MAINButtonActionPerformed
        
        g.interrupt();
        this.setVisible(false);
        Tetris.showStart();
    }//GEN-LAST:event_MAINButtonActionPerformed

   
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel GameAreaPlaceholder;
    private javax.swing.JLabel LevelDisplay;
    private javax.swing.JButton MAINButton;
    private javax.swing.JLabel ScoreDisplay;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
