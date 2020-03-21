package starwars.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;

public class Background extends Sprite {

    private static final float POS_BOT = -0.5f;
    private static final float SET_TOP = 1.5f;
    private final Vector2 v;

    public Background(Texture region) {
        super(new TextureRegion(region));
        v = new Vector2();
        v.set(0, -0.1f);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(1.1f);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        if(getTop() < POS_BOT){
            setTop(SET_TOP);
        }
    }
}
