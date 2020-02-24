import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Rectangle block;
    private Rectangle back;
    private Picture pillar;

    private int x;
    private int y;

    public Block() {
        block = blocks();
        block.fill();
        block.setColor(Color.RED);


    }

    public void move() throws InterruptedException {
        block.translate(-5, 0);
        Thread.sleep(15);
        if (block.getX()  < -10) {
            block.delete();

        }
    }

    public Rectangle  blocks() {
       int block = (int) Math.floor(Math.random() * 6);
        Rectangle LongBlock = new Rectangle(800, 360, 100, 60);
        Rectangle lowLongBlock = new Rectangle(800, 360, 100, 30);
        Rectangle highLongBlock = new Rectangle(800, 320, 100, 60);
        Rectangle highShortBlock = new Rectangle(800, 320, 30, 60);
        Rectangle regularBlock = new Rectangle(800, 360, 30, 60);
        Rectangle standardBlock = new Rectangle(800, 320, 20, 80);

       if (block == 1){
            return LongBlock;
        } else if(block == 2) {
            return lowLongBlock;
        }else if(block ==3) {
            return highLongBlock;
        }else if(block == 4) {
            return highShortBlock;
        }else if(block == 5) {
            return regularBlock;
        } else {
            return standardBlock;


        }


    }

    public int getX(){
        return block.getX();
    }

    public int getY(){
        return block.getY();
    }

    public int getWidth(){
        return block.getWidth();
    }

    public int getHeight(){
        return block.getHeight();
    }

    }