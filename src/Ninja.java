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
    private boolean onTopOfBlock;
    private int x;
    private int y;
    private Picture picture;


    public Ninja() {
        isJumping = false;
        //rectangle = new Rectangle(75, 406, 25, 25);
       // rectangle.fill();
        picture = new Picture(75, 386, "small itachi running.gif");
        picture.draw();
        initKeyboard();
        alive = true;
        onTopOfBlock = false;
    }

    public void initKeyboard() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent upArrowPressed = new KeyboardEvent();
        upArrowPressed.setKey(KeyboardEvent.KEY_UP);
        upArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(upArrowPressed);
        KeyboardEvent rightArrowPressed = new KeyboardEvent();
        rightArrowPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rightArrowPressed);
        KeyboardEvent leftArrowPressed = new KeyboardEvent();
        leftArrowPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftArrowPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(leftArrowPressed);
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

    public void moveRight(){
        rectangle.translate(5, 0);
    }

    public void moveLeft(){
        rectangle.translate(-5, 0);
    }

    public void moveLeftwithBlock(int x){
        rectangle.translate(x, 0);
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
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
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
    // Ninja hits front side with backside block
    public void frontHitsBlock(Block block){
        boolean frontBetweenLeftRightBlock = getX() + getWidth() > block.getX() && getX() + getWidth() < block.getX() + block.getWidth();
        boolean topBetweenTopBottomBlock = getY() > block.getY() && getY() < block.getY() + block.getHeight();
        boolean bottomBetweenTopBottomBlock = getY() + getHeight() > block.getY() && getY() + getHeight() < block.getY() + block.getHeight();
        if(frontBetweenLeftRightBlock && ((topBetweenTopBottomBlock || bottomBetweenTopBottomBlock))){
            dies();
        }
    }

    // Ninja hits head on bottom of block
    public void hitsHead(Block block){
        boolean headTopBetweenTopBottomBlock = getY() >= block.getY() && getY() <= block.getY() + block.getHeight();//
        boolean leftSideBetweenLeftRightBlock = getX() >= block.getX() && getX() <= block.getX() + block.getWidth();
        boolean rightSideBetweenLeftRightBlock = getX() + getWidth() >= block.getX() && getX() + getWidth() <= block.getX() + getWidth();
        if(headTopBetweenTopBottomBlock && ((leftSideBetweenLeftRightBlock || rightSideBetweenLeftRightBlock) && isJumping == true)){
            dies();
        }
    }

    public boolean onTopOfBlock(Block block){
        boolean leftSideBetweenLeftRightBlock = getX() >= block.getX() && getX() <= block.getX() + block.getWidth();
        boolean rightSideBetweenLeftRightBlock = getX() + getWidth() >= block.getX() && getX() + getWidth() <= block.getX() + getWidth();
       if(getY() + getHeight() == block.getY() && (leftSideBetweenLeftRightBlock || rightSideBetweenLeftRightBlock) && isJumping == false){
           System.out.println("On top of block");
            return true;
       }
       return false;
    }


}
