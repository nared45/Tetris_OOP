package ll;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Mishandle_picture extends JFrame implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel mishandle = new JPanel();
    JLabel button = new JLabel();
    JLabel textField = new JLabel();
    JLabel imageField = new JLabel();
    JButton[] buttons = new JButton[24];
    ImageIcon[] img_btn = new ImageIcon[24];
    
    private String Flo = "Pic" + File.separator;
    private String p1 = Flo + "dcd.png";
    private String p2 = Flo + "po.png";
    private String p3 = Flo + "wall.png";
    
    private int p=0;
    boolean player1_turn;
    int count;

    public Mishandle_picture() throws InterruptedException{
        setTitle("Background Color for JFrame ");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        add(button);
        setLayout(new BorderLayout());
        
            if (p == 0) {
                setContentPane(new JLabel(new ImageIcon(p1)));
            }
            if (p == 1) {
                setContentPane(new JLabel(new ImageIcon(p2)));
            }
            if (p == 2) {
                setContentPane(new JLabel(new ImageIcon(p3)));
            }
        

        setLayout(new GridLayout(6, 6));

//        button.setLayout(new GridLayout(3, 3));
        for (int i = 0; i < 24; i++) {
            buttons[i] = new JButton();
            button.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 20));
            buttons[i].setText(i+1+"");
            buttons[i].setForeground(Color.cyan);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            buttons[i].setBackground(Color.red);
            buttons[i].setBackground(Color.black);
            buttons[i].setSize(300, 300);
            add(buttons[i]);
        }
        
        int Time = 10;
        int i;
        for (i = Time; i> 0;i--){
           
                Thread.sleep(1000);
                setTitle("Background Color for JFrame Time : "+i);
        }
        
        Thread.sleep(60);
        JOptionPane.showMessageDialog(null, "Time out!", "TimeOut", JOptionPane.INFORMATION_MESSAGE);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jb = (JButton) e.getSource();
        jb.setVisible(false);
        count++;
        if (count == 24) {
           
            JOptionPane.showMessageDialog(null, "The Game is over!", "GameOver", JOptionPane.INFORMATION_MESSAGE);
            
        }
         p++;
    }

    public static void main(String[] args) throws Exception{
        Mishandle_picture m = new Mishandle_picture();
        m.setVisible(true);
    }
}