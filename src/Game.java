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
// When ninja is jumping up it is moving up
            if (ninja.isJumping()) {
                ninja.moveUp();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
// When ninja is falling down on top of a block he stays on top and travels with him left
            } else if(ninja.onTopOfBlock(block) && !ninja.isJumping()){
                ninja.moveLeftwithBlock(-1);
                }else {
// Ninja is falling down

                ninja.moveDown();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ninja.hitsHead(block);
            ninja.frontHitsBlock(block);
        }

    }


}
