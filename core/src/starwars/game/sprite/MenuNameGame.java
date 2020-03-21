package starwars.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;

public class MenuNameGame extends Sprite {
    public MenuNameGame (TextureAtlas atlas) {
        super(atlas.findRegion("Name"));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.45f);
        setTop(worldBounds.getTop() - 0.06f);
    }
}
