import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MouseClickHandler implements EventHandler<MouseEvent>
{
    private Pong game;
    
    public MouseClickHandler(Pong game) {
        this.game = game;
    }
    
    public void handle(MouseEvent e) {
        game.addBall((int)e.getX(), (int)e.getY(), game.getBalls().size()+1);
    }

}

