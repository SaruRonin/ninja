import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ninja implements KeyboardHandler {

    private boolean isJumping;
    private Rectangle rectangle;
    private boolean alive;
    private Picture picture;



    public Ninja() {
        isJumping = false;
        //rectangle = new Rectangle(75, 406, 25, 25);
       // rectangle.fill();
        picture = new Picture(75, 386, "small itachi running.gif");
        picture.draw();
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
        picture.translate(0, -5);
    }

    public void moveDown() {
        if(reachedFloor()){
            return;
        }
        picture.translate(0, 5);
    }

    public boolean reachedFloor(){
        return picture.getY() >= 386;
    }

    public boolean reachedMaxHeight() {
        return picture.getY() <= 250;
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
        return picture.getX();
    }

    public int getY(){
        return picture.getY();
    }
    public int getWidth(){
        return picture.getWidth();
    }

    public int getHeight(){
        return picture.getHeight();
    }

    public boolean isAlive(){
        return alive;
    }

    public void dies(){
        alive = false;
    }

    public void hits(Block block){
        boolean y1Y12 = getY() >= block.getY() && getY() <= block.getY() + block.getHeight();//
        boolean x1X12 = getX() >= block.getX() && getX() <= block.getX() + block.getWidth();
        boolean x2X12 = getX() + getWidth() >= block.getX() && getX() + getWidth() <= block.getX() + getWidth();


        if(y1Y12 && ((x1X12 || x2X12) )){
            dies();


        }
    }
}
