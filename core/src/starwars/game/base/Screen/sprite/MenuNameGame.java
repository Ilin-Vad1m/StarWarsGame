package starwars.game.base.Screen.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

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
