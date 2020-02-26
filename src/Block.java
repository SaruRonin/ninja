import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Block {

    private Picture block;

    public Block() {
        block = blocks();
        block.draw();


    }

    public void move() throws InterruptedException {
        block.translate(-5, 0);
        Thread.sleep(15);
        if (block.getX()  < -10) {
            block.delete();

        }
    }

    public Picture  blocks() {
       int block = (int) Math.floor(Math.random() * 6);
       Picture LongBlock = new Picture(800,360,"resources/pictures/LongBlock.png");
        Picture lowLongBlock = new Picture(800,360,"resources/pictures/lowLongBlock.png");
        Picture highLongBlock = new Picture(800,320,"resources/pictures/HighLongBlock.png");
        Picture highShortBlock = new Picture(800,320,"resources/pictures/highShortBlock.png");
        Picture regularBlock = new Picture(800,360,"resources/pictures/regularBlock.png");
        Picture standardBlock = new Picture(800,320,"resources/pictures/standardBlock.png");


        //Rectangle LongBlock = new Rectangle(800, 360, 100, 60);
        //Rectangle lowLongBlock = new Rectangle(800, 360, 100, 30);
        //Rectangle highLongBlock = new Rectangle(800, 320, 100, 60);
        //Rectangle highShortBlock = new Rectangle(800, 320, 30, 60);
        //Rectangle regularBlock = new Rectangle(800, 360, 30, 60);
        //Rectangle standardBlock = new Rectangle(800, 320, 20, 80);

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