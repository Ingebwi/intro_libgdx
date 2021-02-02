package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ingeborgwilsher.mygdx.game.Ex1;
import ingeborgwilsher.mygdx.game.Pong;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Pong.WIDTH;
		config.height = Pong.HEIGHT;
		config.title = Pong.TITLE;
		new LwjglApplication(new Ex1(), config);
	}
}
