import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ninja {

    private boolean isJumping;
    private Rectangle ninjaBlock;
    private int x;
    private int y;
    public static int WIDTH = 50;
    public static int HEIGHT = 50;

    public Ninja(int x, int y) {
        this.x = x;
        this.y = y;
        ninjaBlock = new Rectangle(x, y, WIDTH,  HEIGHT);
        ninjaBlock.fill();
    }

    public int getHeight(){
        return HEIGHT;
    }

    public int getWIDTH(){
        return WIDTH;
    }

    public void jump() {
        for(int i = 0; i < 10; i++){
            ninjaBlock.translate(0, -2);
        }
        for(int i = 0; i < 10; i++){
            ninjaBlock.translate(0, 2);
        }
    }

    public void fall() {
        isJumping = false;
        ninjaBlock.translate(0, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hitHead(Block block){
        return false;
    }
}
