package ingeborgwilsher.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ingeborgwilsher.mygdx.game.sprites.Helicopter;

public class State1 {

    //State for task1

    private Helicopter hc;


    public State1(){
        hc = new Helicopter();
    }



    public void update(SpriteBatch batch){
        hc.moveRandomly(Gdx.graphics.getDeltaTime());
        batch.draw(getHc().getSprite(), getHc().getPos().x, getHc().getPos().y);
    }


    public Helicopter getHc() {
        return hc;
    }
}
