package starwars.game.sprite;
import com.badlogic.gdx.audio.Sound;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
;
import pool.BulletPool;
import pool.ExplosionPool;
import starwars.game.base.Ship;
import starwars.game.math.Rect;



public class EnemyShip extends Ship {

    public EnemyShip(BulletPool bulletPool, ExplosionPool explosionPool,
                     Sound shootSound, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.shootSound = shootSound;
        this.worldBounds = worldBounds;
        this.v = new Vector2();
        this.v0 = new Vector2(0, 0.5f);
        this.bulletV = new Vector2();
        this.bulletPos = new Vector2();
    }

    @Override
    public void update(float delta) {
        bulletPos.set(pos.x, getBottom());
        super.update(delta);
        if(getTop() > worldBounds.getTop()){
            this.v0.set(0,0);
        }
        if (getBottom() < worldBounds.getBottom()) {
            destroy();
        }
    }

    public void set(TextureRegion[] regions,
                    Vector2 v0,
                    TextureRegion bulletRegion,
                    float bulletHeight,
                    float bulletVY,
                    int damage,
                    float reloadInterval,
                    float height,
                    int hp
                    ){
                            this.regions = regions;
                            this.v0.set(v0);
                            this.bulletRegion = bulletRegion;
                            this.bulletHeight = bulletHeight;
                            this.bulletV.set(0, bulletVY);
                            this.damage = damage;
                            this.reloadInterval = reloadInterval;
                            this.reloadTimer = reloadInterval;
                            setHeightProportion(height);
                            this.hp = hp;
                            v.set(v0);
    }
}
