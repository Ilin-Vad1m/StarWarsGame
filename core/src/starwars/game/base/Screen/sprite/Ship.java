package starwars.game.base.Screen.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;

public class Ship extends Sprite {

    private static final float V_Len = 0.0075f;
    private static final float P_Len = 0.05f;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 buf;
    private Vector2 end;
    private boolean pressed;
    private Rect worldBounds;


    public Ship(TextureAtlas atlas) {
        super(atlas.findRegion("MainShip"), 1, 2, 2);
        touch = new Vector2();
        v = new Vector2();
        buf = new Vector2();
        end = new Vector2();
    }

    @Override
    public void update(float delta) {
        buf.set(touch);
        if(pressed){
            pos.add(v);
            end.set(buf);
            pressed = false;
        }
        if(getRight() > worldBounds.getRight() + P_Len){
            setRight(worldBounds.getRight() + P_Len);
            stop();
        }
        if(getLeft() < worldBounds.getLeft()  - P_Len){
            setLeft(worldBounds.getLeft()  - P_Len);
            stop();
        }
        if(getBottom() < worldBounds.getBottom()){
            setBottom(worldBounds.getBottom());
            stop();
        }
        if(getTop() > worldBounds.getTop()){
            setTop(worldBounds.getTop());
            stop();
        }
    }

    private void stop() {
        v.setZero();
    }


    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
        setHeightProportion(0.09f);
        setBottom(worldBounds.getBottom()  + 0.05f);
    }

    @Override
    public void touchDragged(Vector2 touch, int pointer) {
        this.touch.set(touch);
            v.set(touch.sub(end).setLength(V_Len));
            end.set(this.touch);
            pressed = true;

    }
}
