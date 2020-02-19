import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Rectangle field;
    private Rectangle ground;
    private Ninja ninja = new Ninja();
    private Block block = new Block();
    //private boolean dead = false;


    public void init() {
        field = new Rectangle(10, 10, 1000, 500);
        field.setColor(Color.GREEN);

    }

    public void start() {

        while (ninja.isAlive()) {
            try {
                block.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (ninja.isJumping()) {
                ninja.moveUp();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                ninja.moveDown();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ninja.hitsHead(block);
        }

    }


}
