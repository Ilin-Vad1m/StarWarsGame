package starwars.game.sprite;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;


import starwars.game.Screen.GameScreen;
import starwars.game.base.ScaledButton;
import starwars.game.math.Rect;

public class ButtonPlay extends ScaledButton {

    private static final float PADDING = 0.05f;

    private final Game game;

    public ButtonPlay(TextureAtlas atlas, Game game) {
        super(atlas.findRegion("btn11"));
        this.game = game;
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.35f);
        setTop(worldBounds.getTop() - 0.56f);

    }

    @Override
    public void action() {
        game.setScreen(new GameScreen());
    }
}
