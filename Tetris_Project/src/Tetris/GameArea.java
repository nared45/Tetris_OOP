package Tetris;

import TetrisBlock.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class GameArea extends JPanel {

    private int GridRows;
    private int GridColumns;
    private int GridCellSize;
    private Color[][] background; // when block is bottom it's will background

    private Block block;

    private Block[] blocks;

    public GameArea(JPanel placeholder, int columns) {
        //placeholder.setVisible(false);
        this.setBounds(placeholder.getBounds());
        this.setBackground(placeholder.getBackground());
        this.setBorder(placeholder.getBorder());

        GridColumns = columns;
        GridCellSize = this.getBounds().width / GridColumns;
        GridRows = this.getBounds().height / GridCellSize;

        blocks = new Block[]{new IShape(), new JShape(), new LShape(), new OShape(), new SShape(), new TShape(), new ZShape()};

    }
    
    public void intBackgroundArray() {
        
        background = new Color[GridRows][GridColumns];
    }

    public boolean isBlockOutOfBounds() {
        if (block.getY() < 0) {
            block = null;
            return true;
        }
        return false;
    }

    public boolean moveBlockDown() {
        if (bottomCheck() == false) {
            return false;
        }
        block.moveDown();
        repaint();
        return true;
    }

    public void moveBlockRight() {

        if (block == null) {
            return;
        }

        if (!checkRight()) {
            return;
        }
        block.moveRight();
        repaint();
    }

    public void moveBlockLeft() {
        if (block == null) {
            return;
        }
        if (!checkLeft()) {
            return;
        }
        block.moveLeft();
        repaint();
    }

    public void dropBlock() {
        if (block == null) {
            return;
        }
        while (bottomCheck()) {
            block.moveDown();
        }
        repaint();
    }

    public void rotateBlock() {
        if (block == null) {
            return;
        }

        block.rotateBlcok();

        if (block.getLeft() < 0) {
            block.setX(0);
        }
        if (block.getRight() >= GridColumns) {
            block.setX(GridColumns - block.getWidth());
        }
        if (block.getBottom() >= GridRows) {
            block.setY(GridRows - block.getHigh());
        }

        repaint();
    }

    public void spawBlock() {
        Random r = new Random();
        block = blocks[r.nextInt(blocks.length)];
        block.spawn(GridColumns);
    }

    public boolean bottomCheck() {
        if (block.getBottom() == GridRows) {
            return false;
        }

        int[][] shape = block.getShape();
        int h = block.getHigh();
        int w = block.getWidth();

        for (int col = 0; col < w; col++) {
            for (int row = h - 1; row >= 0; row--) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX();
                    int y = row + block.getY() + 1;
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    private boolean checkLeft() {
        if (block.getLeft() == 0) {
            return false;
        }

        int[][] shape = block.getShape();
        int h = block.getHigh();
        int w = block.getWidth();

        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX() - 1;
                    int y = row + block.getY();
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    private boolean checkRight() {
        if (block.getRight() == GridColumns) {
            return false;
        }

        int[][] shape = block.getShape();
        int h = block.getHigh();
        int w = block.getWidth();

        for (int row = 0; row < h; row++) {
            for (int col = w - 1; col >= 0; col--) {
                if (shape[row][col] != 0) {
                    int x = col + block.getX() + 1;
                    int y = row + block.getY();
                    if (y < 0) {
                        break;
                    }
                    if (background[y][x] != null) {
                        return false;
                    }
                    break;
                }
            }
        }

        return true;
    }

    public int clearLines() {

        Boolean LineFilled;
        int lineClear = 0;

        for (int r = GridRows - 1; r >= 0; r--) {
            LineFilled = true;

            for (int c = 0; c < GridColumns; c++) {
                if (background[r][c] == null) {
                    LineFilled = false;
                    break;
                }
            }

            if (LineFilled) {
                lineClear++;
                LoopClearLine(r);
                shiftDown(r);
                LoopClearLine(0);

                r++;
                repaint();
            }
        }
        
            return lineClear;
    }

    private void LoopClearLine(int r) {
        for (int i = 0; i < GridColumns; i++) {
            background[r][i] = null;
        }
    }

    private void shiftDown(int r) {
        for (int row = r; row > 0; row--) {
            for (int col = 0; col < GridColumns; col++) {
                background[row][col] = background[row - 1][col];
            }
        }
    }

    public void moveBlockToBg() {
        int[][] shape = block.getShape();
        int h = block.getHigh();
        int w = block.getWidth();

        int xPos = block.getX();
        int yPos = block.getY();

        Color color = block.getColor();

        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if (shape[r][c] == 1) {
                    background[r + yPos][c + xPos] = color;
                }
            }
        }
    }

    private void DrawBlock(Graphics g) {
        int h = block.getHigh();
        int w = block.getWidth();
        Color c = block.getColor();
        int[][] shape = block.getShape();
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (shape[row][col] == 1) {
                    int x = (block.getX() + col) * GridCellSize;
                    int y = (block.getY() + row) * GridCellSize;
                    g.setColor(c); // color block
                    g.fillRect(x, y, GridCellSize, GridCellSize); // insert block
                    g.setColor(Color.BLACK); //color line 
                    g.drawRect(x, y, GridCellSize, GridCellSize); //draw line
                }
            }
        }
    }

    public void drawBackGround(Graphics g) {

        Color color;
        for (int r = 0; r < GridRows; r++) {
            for (int c = 0; c < GridColumns; c++) {
                color = background[r][c];
                if (color != null) {
                    int x = c * GridCellSize;
                    int y = r * GridCellSize;

                    GridSquareDraw(g, color, x, y);
                }
            }
        }
    }

    private void GridSquareDraw(Graphics g, Color color, int x, int y) {
        g.setColor(color); // color block
        g.fillRect(x, y, GridCellSize, GridCellSize); // insert block
        g.setColor(Color.BLACK); //color line 
        g.drawRect(x, y, GridCellSize, GridCellSize); //draw line
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBackGround(g);
        DrawBlock(g);
    }
}
