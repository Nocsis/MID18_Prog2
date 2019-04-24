import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class MouseMoveHandler implements EventHandler<MouseEvent>
{
    private Pong game;
    
    public MouseMoveHandler(Pong game) {
        this.game = game;
    }
    
    public void handle(MouseEvent e) {
        game.getPaddle1().setY((int)e.getY());
    }

}
