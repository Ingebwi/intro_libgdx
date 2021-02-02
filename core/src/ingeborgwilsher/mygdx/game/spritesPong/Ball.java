package ingeborgwilsher.mygdx.game.spritesPong;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import ingeborgwilsher.mygdx.game.Pong;

public class Ball {


    private Texture texture;
    private Vector3 position;
    private Vector3 velocity;
    private Rectangle rectangle;
    private float minY; //min postition in y-direction
    private float maxY; //max position in y-direction
    private float minX;
    private float maxX;
    int height = 20;
    int width = 20;

    public Ball(int x, int y){
        position = new Vector3(x, y, 0);
        velocity = new Vector3(150 ,100, 0);
        texture = new Texture("ball.png");
        minY = Pong.HEIGHT / 3 + 3;
        maxY = Pong.HEIGHT * 2/3 - 3;
        minX = 0;
        maxX = Pong.WIDTH;
        rectangle = new Rectangle(x, y, height, width);
    }

    public int update(float dt){
        int score = 0;
        if (position.y < minY || position.y + height > maxY) {
            velocity.y = - velocity.y;
        }
        else if (position.x < minX || position.x + height > maxX){
            if (position.x < minX){
                score = 1 ;//left player gets one point
            }
            else{
                score = -1; //right player gets one point
            }
            velocity.x = - velocity.x;
            position = new Vector3(Pong.WIDTH /2 - 10, Pong.HEIGHT / 2, 0);


        }
        velocity.scl(dt);
        position.add(velocity.x, velocity.y, 0);
        rectangle.setPosition(getPosition().x, getPosition().y);
        velocity.scl(1/dt);

        return score;


    }

    public Texture getTexture() {

        return texture;
    }

    public Vector3 getPosition() {
        return position;
    }

    public Vector3 getVelocity() {
        return velocity;
    }

    public boolean collides(Rectangle paddle){
        return rectangle.overlaps(paddle);
    }

    public void changeDirection(){
        velocity.x = - velocity.x;
    }
}
