package ingeborgwilsher.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ingeborgwilsher.mygdx.game.sprites.Helicopter;
import ingeborgwilsher.mygdx.game.states.State1;
import ingeborgwilsher.mygdx.game.states.State2;
import ingeborgwilsher.mygdx.game.states.State3;


public class Ex1 extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Helicopter";



	private SpriteBatch batch; //Should only have one of these; very heavy file!!

//	private State1 state1;
//	private State2 state2;
	private State3 state3;



	
	@Override
	public void create () {
		batch = new SpriteBatch();
//		state1 = new State1();
//		state2 = new State2();
		state3 = new State3();

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(253, 0, 253, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		batch.begin();
//		state1.update(batch);
//		state2.update(batch);
		state3.update(batch);
		batch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
