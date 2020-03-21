package starwars.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;

public class Background4 extends Sprite {
    private static final float POS_LEFT = 0.375f;
    private static final float SET_LEFT = - 1.125f;

    private Vector2 v;


    public Background4(Texture region) {
        super(new TextureRegion(region));
        v = new Vector2();
        v.set(0.01f, 0);
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(1f);
        setLeft(SET_LEFT);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);

        if(getLeft() > POS_LEFT){
            setLeft(SET_LEFT);
        }
    }
}
