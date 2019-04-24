


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class Ball
{
    private int x, y, vx, vy;
    private GraphicsContext gc;
    private Pong game;
    
    private int size;
    private int nummer;

    public Ball(int x, int y, int size, GraphicsContext gc, Pong game, int nummer)
    {
        this.x = x;
        this.y = y;
        vx = 5;
        vy = 5;
        this.size = size;
        this.gc = gc;
        this.game = game;
        this.nummer = nummer;
        
    }
    
    public void update() {
        this.x += vx;
        this.y += vy;
        
        if (collision().equals("X")) {
            vx *= -1;
        }
        if (collision().equals("Y")) {
            vy *= -1;
        }
        if (collision().equals("left")) {
            game.decScore();
            vx *= -1;
        }
        if (collision().equals("right")) {
            game.incScore();
            vx *= -1;
        }
        
        gc.setFill(Color.WHITE);
        gc.setStroke(Color.BLACK);
        gc.fillOval(x, y, size, size);
        gc.strokeOval(x, y, size, size);
        
        gc.setFill(Color.BLACK);
        gc.fillText(""+nummer, x+(size/2)-4, y+(size/2)+4);
    }
    
    public String collision() {
        //Kollision links
        if (x <= 0) return "left";
        //Kollision rechts
        if (x >= Pong.SCREEN_WIDTH - size) return "right";
        //Kollision oben
        if (y <= 0) return "Y";
        //Kollision unten
        if (y >= Pong.SCREEN_HEIGHT - size) return "Y";
        
        Paddle paddle1 = game.getPaddle1();
        
        gc.fillText("P1.y= "+paddle1.getY(), 5, 30);
        
        if (y >= paddle1.getY() && y <= paddle1.getY()+Paddle.PADDLE_HEIGHT) {
        
            if (vx > 0) {
                //Ball von links
                if ((x + size) == paddle1.getX()) return "X";
            }
            else {
                //Ball von rechts
                if ((paddle1.getX()+Paddle.PADDLE_WIDTH) == x) return "X";
            }
        }
        if (x >=  paddle1.getX() && x <= paddle1.getX()+Paddle.PADDLE_WIDTH) {
            if (vy > 0) {
                //Ball von oben
                if ((y + size) == paddle1.getY()) return "Y";
            }
            else {
                //Ball von unten
                if ((paddle1.getY() + Paddle.PADDLE_HEIGHT) == y) return "Y";
            }
        }
        return "keine";
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getSize() {
        return size;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
}
