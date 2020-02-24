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
<<<<<<< HEAD
       // this.block = block;
        block = new Rectangle(300, 400, 20, 80);
=======
        this.block = block;
        block = new Rectangle(800,300,100,60);
>>>>>>> master
        block.fill();
        block.setColor(Color.RED);
        //pillar = new Picture(500, 371, "pillar.png");
        //pillar.draw();

    }

    public void move() throws InterruptedException {
        block.translate(-5, 0);
        Thread.sleep(15);
        if (block.getX() < -40) {
            block.translate(980, 0);
        }
    }

    public void  blocks() {
        Rectangle LongBlock = new Rectangle(800, 380, 100,60);
        Rectangle lowLongBlock = new Rectangle(800,380,100,30);
        Rectangle highLongBlock = new Rectangle(800,410,100,60);
        Rectangle highShortBlock = new Rectangle(800,410,30,60);
        Rectangle regularBlock = new Rectangle(800, 371, 30, 60);


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