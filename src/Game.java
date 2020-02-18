import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle field;

    private Block block;
    private Ninja ninja;
    private boolean dead = false;

    public void init() {
        field = new Rectangle(10, 10, 1000, 500);
        field.draw();
        block = new Block();
        ninja = new Ninja();
    }

    public void start() throws InterruptedException {
        while (!dead) {
            block.move();
        }
    }

    public void move() throws InterruptedException {
            ninja.jump();
            Thread.sleep(20);
            ninja.jump();
            Thread.sleep(20);
            ninja.jump();
            Thread.sleep(20);
            ninja.fall();
            Thread.sleep(20);
            ninja.fall();
            Thread.sleep(20);
            ninja.fall();
            Thread.sleep(20);
    }
}



