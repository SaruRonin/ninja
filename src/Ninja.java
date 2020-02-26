import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ninja implements KeyboardHandler {

    private boolean isJumping;
    private boolean alive;
    private boolean onTopOfBlock;
    private Game game;

    Picture frame1 =  new Picture(75, 360, "resources/pictures/NinjaRunning_Frame01_50px.png");
    Picture frame2 = new Picture(75, 360, "resources/pictures/NinjaRunning_Frame02_50px.png");
    //Picture frame3 = new Picture(75, 386, "resources/pictures/NinjaRunning_Frame03_50px.png");
    //Picture frame4 = new Picture(75, 386, "resources/pictures/NinjaRunning_Frame04_50px.png");
    //Picture frame5 = new Picture(75, 386, "resources/pictures/NinjaRunning_Frame05_50px.png");
    //Picture frame6 = new Picture(75, 386, "resources/pictures/NinjaRunning_Frame06_50px.png");




    public Ninja(Game game) throws InterruptedException {
        this.game =game;
        isJumping = false;
        initKeyboard();
        alive = true;
        onTopOfBlock = false;
        running();
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
        KeyboardEvent rPressed = new KeyboardEvent();
        rPressed.setKey(KeyboardEvent.KEY_R);
        rPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(rPressed);
    }

    public void running() throws InterruptedException {
        while (alive && !isJumping) {
            //Thread.sleep(10);
            frame1.draw();
            //Thread.sleep(10);
            //frame1.delete();
            //frame2.draw();
            //Thread.sleep(10);
            //frame2.delete();
            //frame3.draw();
            //Thread.sleep(10);
            //frame3.delete();
            //frame4.draw();
            //Thread.sleep(10);
            //frame4.delete();
            //frame5.draw();
            //Thread.sleep(10);
            //frame5.delete();
            //frame6.draw();
            //Thread.sleep(10);
            //frame6.delete();
        }
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
        frame1.delete();
        frame2.draw();
        if (reachedMaxHeight()){
            fall();
            return;
        }
        frame2.translate(0, -5);

    }


    public void moveDown() throws InterruptedException {
        if(reachedFloor()){
            frame2.delete();
            frame1.draw();
            return;
        }
        frame2.translate(0, 5);

    }

    public void moveRight(){
        if(!alive){
            return;
        }
        frame2.translate(10, 0);
        frame1.translate(10,0);
    }

    public void moveLeft(){
        if(!alive){
            return;
        }
        frame2.translate(-10, 0);
        frame1.translate(-10,0);
    }

    public void moveLeftwithBlock(int x){
        frame2.translate(x, 0);
        frame1.translate(x,0);
    }

    public boolean reachedFloor(){
        return frame2.getY() >= 360;

    }



    public boolean reachedMaxHeight() {
        return frame2.getY() <= 250;
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
            /*case KeyboardEvent.KEY_R:
                try {
                    game.restart();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/


        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    public int getX(){
        return frame2.getX();


    }

    public int getY(){
        return frame2.getY();
    }
    public int getWidth(){
        return frame2.getWidth();
    }

    public int getHeight(){
        return frame2.getHeight();
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
