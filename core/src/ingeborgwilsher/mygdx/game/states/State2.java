package ingeborgwilsher.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;



import ingeborgwilsher.mygdx.game.sprites.Helicopter;

public class State2 {

    private Helicopter hc;
    private BitmapFont font;



    public State2(){
        hc = new Helicopter();
        font = new BitmapFont();
    }






    public void handleInput(){
        hc.move(Gdx.graphics.getDeltaTime());

    }


    public void update(SpriteBatch batch){
        handleInput();
        draw(batch);


    }

    public Helicopter getHc(){
        return hc;
    }



    public void draw(SpriteBatch batch){
        font.draw(batch,"[" + hc.getPos().x + ", " + hc.getPos().y + "]",20,780);
        batch.draw(getHc().getHelicopterAnimation().getFrame(), getHc().getPos().x , getHc().getPos().y);
    }
}
