import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Block {

    private Rectangle block;
    private Rectangle back;

    private int x;
    private int y;

    public Block() {
       // this.block = block;
        block = new Rectangle(980, 300, 50, 80);
        block.fill();

    }

    public void move() throws InterruptedException {
        block.translate(-5, 0);
        Thread.sleep(5);
        block.fill();
        if (block.getX() < -40) {
            block.translate(980, 0);
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