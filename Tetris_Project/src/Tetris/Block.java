package Tetris;

import java.awt.Color;
import java.util.Random;

public class Block {

    private int shape[][];
    private Color color;
    private int x, y;
    private int[][][] shapes;
    private int currentRotation;
    
    private Color[] BlockColor = {Color.GREEN,Color.RED,Color.BLUE,Color.ORANGE,Color.cyan,Color.yellow,Color.MAGENTA};


    public Block(int[][] shape) {
        this.shape = shape;
        
        intShape();
    }
    
     private void intShape() {
        shapes = new int[4][][];

        for (int i = 0; i < 4; i++) {
            int r = shape[0].length;
            int c = shape.length;

            shapes[i] = new int[r][c];

            for (int Y = 0; Y < r; Y++) {
                for (int X = 0; X < c; X++) {
                    shapes[i][Y][X] = shape[c - X - 1][Y];
                }
            }
            shape = shapes[i];
        }
    }

    @SuppressWarnings("empty-statement")
    public void spawn(int GridWidth) {
        
        Random r = new Random();
        
        currentRotation = r.nextInt(shapes.length);
        currentRotation = r.nextInt(shapes.length);
        shape = shapes[currentRotation];
        
        y = -getHigh();
        x = r.nextInt(GridWidth - getWidth());
        
        color = BlockColor [r.nextInt(BlockColor.length)];
    }

    public int[][] getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public int getHigh() {
        return shape.length;
    }

    public int getWidth() {
        return shape[0].length;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void rotateBlcok() {
        currentRotation++;
        if (currentRotation > 3) {
            currentRotation = 0;
        }
        shape = shapes[currentRotation];
    }
    
    public void setX(int newX){
        x = newX;
    }
    
    public void setY(int newY){
        y = newY;
    }

    public int getBottom() {
        return y + getHigh();
    }
    
    public int getLeft() {
        return x;
    }
    
    public int getRight() {
        return x + getWidth();
    }
}
