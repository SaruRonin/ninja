import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {



    private Picture background;
    private Ninja ninja;
    private Block block;
    private boolean dead = false;


    public void init() throws InterruptedException {
        background = new Picture(0, 0, "resources/pictures/background.png");
        background.draw();
        ninja = new Ninja(this);
        block = new Block();
        Sound sound = new Sound();
        sound.playMusic("Resources/Sound/fantasyIntro.au");


    }

    public void restart() throws InterruptedException {
        dead = false;
        start();
    }

    public void start() throws InterruptedException {

        while (ninja.isAlive()) {
            if ( block.getX() == -40){
                block = new Block();
            }
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
