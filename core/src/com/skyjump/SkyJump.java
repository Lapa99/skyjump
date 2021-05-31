package com.skyjump;

import com.badlogic.gdx.Game;
import com.skyjump.screen.MenuScreen;

public class SkyJump extends Game {
	
	@Override
	public void create () {
		setScreen(new MenuScreen());
	}

}
