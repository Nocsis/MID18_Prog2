
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Paddle
{  
    public static final int PADDLE_WIDTH = 20;
    public static final int PADDLE_HEIGHT = 60;
    
    private int x, y, vy;
    private GraphicsContext gc;
    private Pong game;
    
    public Paddle(int x, GraphicsContext gc, Pong game) {
        this.x = x;
        this.gc = gc;
        this.game = game;
        
        y = (Pong.SCREEN_HEIGHT/2)-(PADDLE_WIDTH/2);
        vy = 5;
    }
    
    public void update() {
        //y += vy;
        
        if(y >= Pong.SCREEN_HEIGHT-PADDLE_HEIGHT || y <= 0) {
            vy *= -1;
        }
        
        gc.setFill(Color.BLACK);
        gc.fillRect(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
}
