package starwars.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import starwars.game.base.ScaledButton;

import starwars.game.math.Rect;

public class ButtonOptions extends ScaledButton {

    private static final float PADDING = 0.05f;


    public ButtonOptions(TextureAtlas atlas) {
        super(atlas.findRegion("BTN"));

    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setRight(worldBounds.getRight());
        setBottom(worldBounds.getBottom() - PADDING);
    }

    @Override
    public void action() {
//ddd
    }

//    @Override
//    public void action() {
//        game.setScreen(new GameScreen());
//    }
}
