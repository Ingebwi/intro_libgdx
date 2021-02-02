package ingeborgwilsher.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import java.util.Random;

import ingeborgwilsher.mygdx.game.sprites.Helicopter;


public class State3 {

    private static final int HELICOPTER_COUNT = 4;
    private static Texture HELI = new Texture("heli1.png");

    private Array<Helicopter> helicopters;
    public Random rand;
    private BitmapFont font;



    public State3(){
        helicopters = new Array<Helicopter>();
        rand = new Random();
        font = new BitmapFont();

        //Satser på at de ulike helikopterene ikke blir laget på samme sted, hehe.

        for(int i = 1; i <= HELICOPTER_COUNT; i++){
            int x_pos = Gdx.graphics.getWidth()/2 - HELI.getWidth()/2;
            int y_pos = rand.nextInt(Gdx.graphics.getHeight() - HELI.getHeight() - 20) + HELI.getHeight();
            int x_speed = rand.nextInt(5) + 2; //Setter krav om minimumsfart = 2 i både x- og y-retning
            int y_speed = rand.nextInt(5) + 2;
            Helicopter temp = new Helicopter(x_pos, y_pos, x_speed, y_speed, HELICOPTER_COUNT);
            helicopters.add(temp);
        }

    }

    public void update(SpriteBatch batch){
        for(int i = 0; i <= HELICOPTER_COUNT-1; i ++){
            Helicopter temp =  helicopters.get(i);
            temp.moveAtRandom(Gdx.graphics.getDeltaTime());
            temp.updateBounds();
            draw(temp, batch);



            for(int j = i+1; j < HELICOPTER_COUNT; j++){
                if(temp.collides(helicopters.get(j).getBounds())){
                    temp.turnAround();
                    helicopters.get(j).turnAround();

                }

            }

        }



    }



    //The code is scaling the helicopters, so that if you add more helicopters,
    public void draw(Helicopter heli, SpriteBatch batch){
        if(HELICOPTER_COUNT > 1){
            batch.draw(heli.getHelicopterAnimation().getFrame(), heli.getPos().x , heli.getPos().y, (2*heli.getSpritesheet().getWidth()/(4*HELICOPTER_COUNT)), 2*heli.getSpritesheet().getHeight()/(HELICOPTER_COUNT));
        }
        else{
            batch.draw(heli.getHelicopterAnimation().getFrame(), heli.getPos().x, heli.getPos().y);
        }
    }






}
