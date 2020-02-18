import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Rectangle field;
    private Rectangle ground;
    private Ninja ninja = new Ninja();


    public void init() {
        field = new Rectangle(10, 10, 1000, 500);
        field.setColor(Color.GREEN);
        field.draw();

    }

    public void start() {

        while (true) {

            if (ninja.isJumping()) {
                ninja.moveUp();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } else {

                ninja.moveDown();
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
