package ingeborgwilsher.mygdx.game.statesPong;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import ingeborgwilsher.mygdx.game.Pong;

public class MenuState extends State{

    Texture field;
    Texture playBtn;


    public MenuState(GameStateManager gsm) {
        super(gsm);
        field = new Texture("field.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }


    }

    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(field,  0,Pong.HEIGHT / 3, Pong.WIDTH, Pong.HEIGHT / 3);
        sb.draw(playBtn, Pong.WIDTH/2 - playBtn.getWidth()/2, Pong.HEIGHT/2 - playBtn.getHeight()/2);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
