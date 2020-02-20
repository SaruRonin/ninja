import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Rectangle field;
    private Picture background;
    private Ninja ninja;
    private Block block;
    private Block pillar;
    private boolean dead = false;


    public void init() {

        //field = new Rectangle(10, 10, 1000, 500);
        background = new Picture(0,0,"background.png");
        background.draw();
        //field.setColor(Color.GREEN);
        //field.fill();
        ninja = new Ninja();
        block = new Block();



    }

    public void start() {

        while (true) {
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
        }
    }
}
