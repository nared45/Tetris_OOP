package Tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Thread {

    private GameArea ga;
    private GameForm gf;
    private int score;
    private int level = 1;
    private int scorePerLevel = 1000;
    private int Bonus = 200;
    private int pause = 300;
    private int speedPerLevel = 50;

    public Game(GameArea ga, GameForm gf) {
        this.ga = ga;
        this.gf = gf;

        gf.scoreUpdate(score);
        gf.levelUpdate(level);
    }

    @Override
    public void run() {
        int line = 0;
        while (true) {

            ga.spawBlock();

            while (ga.moveBlockDown()) {
                try {
                    Thread.sleep(pause);
                } catch (InterruptedException ex) {
                    return;
                }
            }

            if (ga.isBlockOutOfBounds()) {
                Tetris.gameOver();
                break;
            }

            ga.moveBlockToBg();
            line = ga.clearLines();
            
            if (line == 1) {
                System.out.println(line);
                score += 100;
            }
            
            if (line > 1) {
                System.out.println(line);
                score += (line * 100) + Bonus;
            }
            
            gf.scoreUpdate(score);

            int lvl = score / scorePerLevel + 1;
            if (lvl > level) {
                level = lvl;
                gf.levelUpdate(level);
                pause -= speedPerLevel;
                Bonus += 250; 
            }
        }
    }
}
