package starwars.game;


import com.badlogic.gdx.Game;
import starwars.game.base.Screen.MenuScreen;

public class StarWarsGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
