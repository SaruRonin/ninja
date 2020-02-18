import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ninja {

    private boolean isJumping;
    private Rectangle ninja;
    private int x;
    private int y;

    public Ninja() {
        this.ninja = ninja;
        this.isJumping = isJumping;

        ninja = new Rectangle(30, 420, 25, 25);
        ninja.fill();

    }

    public void jump() {
        isJumping = true;
        ninja.translate(0, -2);
    }

    public void fall() {
        isJumping = false;
        ninja.translate(0, 2);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
