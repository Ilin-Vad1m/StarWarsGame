package starwars.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import starwars.game.base.ScaledButton;
import starwars.game.math.Rect;

public class ButtonExit extends ScaledButton {

    private static final float PADDING = 0.05f;


    public ButtonExit(TextureAtlas atlas) {
        super(atlas.findRegion("BTN"));
    }


    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.25f);
        setLeft(worldBounds.getLeft());
        setBottom(worldBounds.getBottom() - PADDING);
    }

    @Override
    public void action() {
        Gdx.app.exit();
    }
}
