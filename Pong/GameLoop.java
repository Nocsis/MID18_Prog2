
import javafx.scene.canvas.GraphicsContext;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;
public class GameLoop extends AnimationTimer
{
    private GraphicsContext gc;

    private Pong game;
    private int vx, vy;
    
    private long lastUpdateTime = System.nanoTime();

    public GameLoop(GraphicsContext gc, Pong game) {
        this.gc = gc;
        this.game = game;
        
        
    }

    public void handle(long currentNanoTime) {
        //long diff = currentNanoTime - lastUpdateTime;
        //if ((diff/1e6) < 15) return;

        gc.clearRect(0, 0, Pong.SCREEN_WIDTH, Pong.SCREEN_HEIGHT);
        gc.setFill(Color.BLACK);
        gc.fillText("SCORE: " + game.getScore(), 5, 20);
        
        gc.fillRect(Pong.SCREEN_WIDTH/2, 0, 1, Pong.SCREEN_HEIGHT);
        
        for(Ball ball : game.getBalls()) {
            ball.update();
        }
        game.getPaddle1().update();
        game.getPaddle2().update();
        
        lastUpdateTime = currentNanoTime;
    }
}