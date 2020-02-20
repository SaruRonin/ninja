import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Ninja implements KeyboardHandler {

    private boolean isJumping;
    private Rectangle rectangle;
    private boolean alive;

    public Ninja() {
        isJumping = false;
        rectangle = new Rectangle(75, 480, 50, 25);
        rectangle.fill();
        initKeyboard();
        alive = true;
    }

    public void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent upArrowPressed = new KeyboardEvent();
        upArrowPressed.setKey(KeyboardEvent.KEY_UP);
        upArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrowPressed);
    }

    public void jump() {
        isJumping = true;
    }

    public void fall() {

        isJumping = false;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void moveUp() {
        if (reachedMaxHeight()){
            fall();
            return;
        }
        rectangle.translate(0, -5);
    }

    public void moveDown() {
        if(reachedFloor()){
            return;
        }
        rectangle.translate(0, 5);
    }

    public boolean reachedFloor(){
        return rectangle.getY() >= 480;
    }

    public boolean reachedMaxHeight() {
        return rectangle.getY() <= 280;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                jump();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public int getX(){
        return rectangle.getX();
    }

    public int getY(){
        return rectangle.getY();
    }
    public int getWidth(){
        return rectangle.getWidth();
    }

    public int getHeight(){
        return rectangle.getHeight();
    }

    public boolean isAlive(){
        return alive;
    }

    public void dies(){
        alive = false;
    }

    public void hitsHead(Block block){
        boolean y1Y12 = getY() >= block.getY() && getY() <= block.getY() + block.getHeight();//
        boolean x1X12 = getX() >= block.getX() && getX() <= block.getX() + block.getWidth();
        boolean x2X12 = getX() + getWidth() >= block.getX() && getX() + getWidth() <= block.getX() + getWidth();

        if(y1Y12 && ((x1X12 || x2X12) )){
            dies();

        }
    }


}
