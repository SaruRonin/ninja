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
        this.block = block;
        //block = new Rectangle(800, 371, 30, 60);
        //block.fill();
        pillar = new Picture(500, 371, "pillar.png");
        pillar.draw();

    }

    public void move() throws InterruptedException {
        pillar.translate(-5, 0);
        Thread.sleep(15);
        if (pillar.getX() < -40) {
            pillar.translate(980, 0);
        }
    }

    public void  blocks() {
        Rectangle LongBlock = new Rectangle(800, 380, 100,60);
        Rectangle lowLongBlock = new Rectangle(800,380,100,30);
        Rectangle highLongBlock = new Rectangle(800,410,100,60);
        Rectangle highShortBlock = new Rectangle(800,410,30,60);


    }

    }