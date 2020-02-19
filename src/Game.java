import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    public static int WIDTH = 1000;
    public static int HEIGHT = 500;
    public static int MARGIN = 10;
    private int GRASS_HEIGHT = 50;
    private int NINJA_X_START = 50;

    private Rectangle field;
    private Block block;
    private Ninja ninja;
    private Block grass;
    private boolean dead = false;

    public void init() {
        field = new Rectangle(MARGIN,MARGIN, WIDTH, HEIGHT);
        grass = new Block(MARGIN, HEIGHT + MARGIN - GRASS_HEIGHT, WIDTH, GRASS_HEIGHT, Color.GREEN);
        field.draw();

        block = new Block(WIDTH + MARGIN, HEIGHT - GRASS_HEIGHT - Block.BLOCK_HEIGHT + MARGIN, Color.BLUE);
        ninja = new Ninja(NINJA_X_START, HEIGHT - Ninja.HEIGHT - GRASS_HEIGHT + MARGIN);
    }

    public void start() throws InterruptedException {
        while (!dead) {
            block.move();
            ninja.jump();
        }
    }

    public void move() throws InterruptedException {

    }



}



