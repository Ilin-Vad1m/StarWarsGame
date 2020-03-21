package starwars.game.sprite;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import pool.BulletPool;
import pool.ExplosionPool;
import starwars.game.base.Ship;
import starwars.game.math.Rect;

public class MainShip extends Ship {

    private static final float V_Len = 0.0095f;
    private static final float P_Len = 0.05f;

    private Vector2 touch;
    private Vector2 buf;
    private Vector2 end;

    private boolean pressed;
    public MainShip(TextureAtlas atlas, BulletPool bulletPool, ExplosionPool explosionPool) {
        super(atlas.findRegion("MainShips"), 1, 2, 2);
        touch = new Vector2();
        buf = new Vector2();
        end = new Vector2();
        this.v = new Vector2();
        this.v0 = new Vector2(0.5f, 0);
        this.bulletV = new Vector2(0, 0.5f);
        this.bulletPos = new Vector2();
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.bulletRegion = atlas.findRegion("bulletMainShip2.1");
        this.bulletHeight = 0.02f;
        this.reloadInterval = 0.2f;
        this.damage = 1;
        this.hp = 100;
        this.shootSound = Gdx.audio.newSound(Gdx.files.internal("sounds/laser.wav"));
    }

    @Override
    public void update(float delta) {
        bulletPos.set(pos.x, getTop());
        super.update(delta);
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
