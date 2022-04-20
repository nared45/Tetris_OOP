package Tetris;

import javax.swing.JOptionPane;

public class Tetris {

    private static GameForm gf;
    private static Start sf;
    
    

    public static void start() {
        gf.setVisible(true);
        gf.startGame();
    }
   
    
    public static void showStart(){
        sf.setVisible(true);
    }
    
    public static void gameOver(){
        
        JOptionPane.showMessageDialog(null, "The Game is over!", "GameOver", JOptionPane.INFORMATION_MESSAGE);
        sf.setVisible(true);
        gf.setVisible(false);
        
    }
    
   

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gf = new GameForm();
                sf = new Start();

                sf.setVisible(true);
            }
        });

    }
}
