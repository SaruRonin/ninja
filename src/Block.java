import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Block {

    private Rectangle block;
    public static int BLOCK_WIDTH = 50;
    public static int BLOCK_HEIGHT = 50;
    private int x;
    private int y;
    private Color blockColor;

    public Block() {
        block = new Rectangle(Game.WIDTH + 2 * BLOCK_WIDTH, Game.HEIGHT -  BLOCK_HEIGHT , BLOCK_WIDTH, BLOCK_HEIGHT);
        block.fill();
    }

    public Block(Color color) {
        block = new Rectangle(Game.WIDTH + 2 * BLOCK_WIDTH, Game.HEIGHT -  BLOCK_HEIGHT - Game.MARGIN,BLOCK_WIDTH, BLOCK_HEIGHT);
        block.setColor(color);
        block.fill();
    }

    public Block(int x, int y, Color color) {
        block = new Rectangle(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
        block.setColor(color);
        block.fill();
    }

    public Block(int x, int y, int width, int height, Color color) {
        block = new Rectangle(x, y, width, height);
        block.setColor(color);
        block.fill();
    }

    public void move() throws InterruptedException {
        block.translate(-1, 0);
        Thread.sleep(5);
        while(getX() > - (Game.MARGIN + block.getWidth() )){

        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }



    }