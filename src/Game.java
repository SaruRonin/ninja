import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle field;

    public void init(){
        field = new Rectangle(10,10,1000,500);
        field.draw();
    }
}
