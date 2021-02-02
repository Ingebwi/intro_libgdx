package ingeborgwilsher.mygdx.game.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import ingeborgwilsher.mygdx.game.Ex1;

public class Helicopter {


    private Texture heliTexture;
    private Sprite hc;
    private Vector2 pos;
    private Vector2 speed;
    private  float speedX = -2f;
    private  float speedY = 2f;
    private Texture spritesheet;
    private Animation helicopterAnimation;
    private Rectangle bounds;



    public Helicopter(){
        heliTexture = new Texture("heli1.png");
        hc = new Sprite(heliTexture);
        spritesheet = new Texture("spritesheet1.png");
        helicopterAnimation = new Animation(spritesheet, 4, 0.1f);
        pos = new Vector2(Gdx.graphics.getWidth()/2 - spritesheet.getWidth()/8, Gdx.graphics.getHeight()/2);
        speed = new Vector2(0, 0);
        speed.set(speedX, speedY);
        bounds = new Rectangle(pos.x, pos.y, heliTexture.getWidth()/4, heliTexture.getHeight());

    }


    //Double constructor for when creating more than one helicopters.
    public Helicopter(float x_pos, float y_pos, float x_speed, float y_speed, int n){
        heliTexture = new Texture("heli1.png");
        hc = new Sprite(heliTexture);
        spritesheet = new Texture("spritesheet1.png");
        helicopterAnimation = new Animation(spritesheet, 4, 0.1f);

        //Randomized for each helicopter.
        pos = new Vector2(x_pos, y_pos);
        speed = new Vector2(x_speed, y_speed);
        if(speed.x > 0){
            helicopterAnimation.flip();
        }
        if(n > 1){
            bounds = new Rectangle(pos.x, pos.y, 2*spritesheet.getWidth()/(4*n), 2*spritesheet.getHeight()/n);
        }
        else{
            bounds = new Rectangle(pos.x, pos.y, spritesheet.getWidth()/4, spritesheet.getHeight());
        }


    }






//Method for Task1;
//Is updated for task3;


    public void moveRandomly(float dt){
        //Should probably scl with deltatime
        if (pos.x > Gdx.graphics.getWidth() - heliTexture.getWidth() || pos.x < 0 ) {
            speed.x = -speed.x;
            hc.flip(true, false);
        }

        if (pos.y > Gdx.graphics.getHeight() - heliTexture.getHeight() || pos.y < 0)  {
            speed.y = -speed.y;
        }


        //Move the helicopter according to the speed.
        pos.x += speed.x;
        pos.y += speed.y;


    }


    //TODO: Should probably make a couple of help-methods, eg to check bounds.
    //Animation move, will change direction at click - changes the direction towards the click.

    public void move(float dt){
        helicopterAnimation.update(dt);
        //method of "bouncing" of edges
        if (pos.x > Gdx.graphics.getWidth() - heliTexture.getWidth() || pos.x < 0 ) {
            speed.x = -speed.x;
            helicopterAnimation.flip();

        }

        if (pos.y > Gdx.graphics.getHeight() - heliTexture.getHeight() || pos.y < 0)  {
            speed.y = -speed.y;
        }

        //Methods for click;

        if(Gdx.input.isTouched()){


            if(Gdx.input.getX()>pos.x){
                if(speed.x < 0){
                    helicopterAnimation.flip();
                }
                speed.set(2, speed.y);

                //helicopterAnimation.getFrame().flip(true, false);
//                hc.setFlip(true, false);


            }

            else{
                //Check if it is a directional change; and if so - flip the helicopter.
                if(speed.x > 0){
                    helicopterAnimation.flip();
                }
                speed.set(-2, speed.y);
                //helicopterAnimation.getFrame().flip(true, false);
//                hc.setFlip(false, false);


            }

            if (Ex1.HEIGHT - Gdx.input.getY() > pos.y){
                speed.set(speed.x, 2);
            }
            else{
                speed.set(speed.x, -2);

            }

        }

        pos.add(speed.x, speed.y);

    }

    public void turnAround(){
        pos.x = - pos.x;
        pos.y = - pos.y;
        helicopterAnimation.flip();
    }




    public void moveAtRandom(float dt){

        helicopterAnimation.update(dt);
        //method of "bouncing" of edges
        if (pos.x > Gdx.graphics.getWidth() - bounds.getWidth() || pos.x < 0 ) {
            speed.x = -speed.x;
            helicopterAnimation.flip();
        }

        if (pos.y > Gdx.graphics.getHeight() - bounds.getHeight() || pos.y < 0)  {
            speed.y = -speed.y;
        }

        pos.x += speed.x;
        pos.y += speed.y;
    }

    //TODO: Method for resizing --> 4 Helicopters => Each Helicopter is 1/4th of the size


    public Rectangle getBounds() {
        return bounds;
    }

    public TextureRegion getTexture(){
        return helicopterAnimation.getFrame();
    }

    public Vector2 getSpeed(){
        return speed;
    }

    public Vector2 getPos(){
        return pos;
    }


    public Sprite getSprite(){
        return hc;
    }

    public Animation getHelicopterAnimation(){
        return helicopterAnimation;
    }


    public void updateBounds(){
        bounds.setPosition(pos.x, pos.y);
    }



    public boolean collides(Rectangle helicopter){
        return helicopter.overlaps(bounds);
    }

    public Texture getSpritesheet(){
        return spritesheet;
    }


}
