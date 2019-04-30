
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import java.util.*;

public class Pong extends Application
{
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;
    
    private int score = 0;
    
    private GameLoop loop;
    private GraphicsContext gc;
    
    private List<Ball> ballList;
    private Paddle paddle1, paddle2;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        Group root = new Group();
        Scene scene = new Scene(root);
        theStage.setScene(scene);

        Canvas canvas = new Canvas(Pong.SCREEN_WIDTH, Pong.SCREEN_HEIGHT);
        root.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();
        
        ballList = new ArrayList<Ball>();
        Ball ball = new Ball(0, 0, 20, gc, this, 1);
        ballList.add(ball);
        
        paddle1 = new Paddle(25, gc, this);
        paddle2 = new Paddle(Pong.SCREEN_WIDTH-(25+Paddle.PADDLE_WIDTH), gc, this);

        loop = new GameLoop(gc, this);
        loop.start();
        
        scene.setOnMouseMoved(new MouseMoveHandler(this));

        scene.setOnMouseClicked(new MouseClickHandler(this));    
        
        theStage.setTitle("Amazing Pong");
        theStage.show();
    }
    
    public void incScore() {
        score++;
    }
    
    public void decScore() {
        score--;
    }
    
    public void setScore(int score) {
        this.score = score;
    }
    
    public int getScore() {
        return score;
    }
    
    public Ball addBall(int x, int y, int nummer) {
        Ball newBall = new Ball(x, y, 20, gc, this, nummer);
        ballList.add(newBall);
        return newBall;
    }
    
    public Paddle getPaddle1() {
        return paddle1;
    }
    
    public Paddle getPaddle2() {
        return paddle2;
    }
    
    public List<Ball> getBalls() {
        return ballList;
    }
}
