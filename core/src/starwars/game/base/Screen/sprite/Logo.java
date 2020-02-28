package starwars.game.base.Screen.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;

public class Logo extends Sprite {

    private static final float V_Len = 0.01f;

    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;

    public Logo(Texture region) {
        super(new TextureRegion(region));
        touch = new Vector2();
        v = new Vector2();
        buf = new Vector2();

    }

    @Override
    public void update(float delta) {
        buf.set(touch);
        if(buf.sub(pos).len() > V_Len){
            pos.add(v);
        }else {
            pos.set(touch);
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.3f);
    }

    @Override
    public void touchDown(Vector2 touch, int pointer, int button) {
        System.out.println("работает тач лого");
        this.touch.set(touch);
        v.set(touch.sub(pos).setLength(V_Len));
    }
}
