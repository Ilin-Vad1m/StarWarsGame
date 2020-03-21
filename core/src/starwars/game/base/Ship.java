package starwars.game.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import pool.BulletPool;
import pool.ExplosionPool;
import starwars.game.math.Rect;
import starwars.game.sprite.Bullet;
import starwars.game.sprite.Explosion;

public class Ship extends Sprite {

    protected float bulletHeight;
    protected int damage;

    protected int hp;

    protected Vector2 v;
    protected Vector2 v0;
    protected Rect worldBounds;

    protected BulletPool bulletPool;
    protected ExplosionPool explosionPool;
    protected TextureRegion bulletRegion;
    protected Vector2 bulletV;
    protected Vector2 bulletPos;

    protected float reloadTimer;
    protected float reloadInterval;

    protected Sound shootSound;

    public Ship() {
    }

    public Ship(TextureRegion region, int rows, int cols, int frames) {
        super(region, rows, cols, frames);
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            shoot();
        }
    }

    public void dispose(){
        shootSound.dispose();
    }

    @Override
    public void destroy() {
        super.destroy();
        boom();
    }

    protected void shoot(){
        shootSound.play(0.7f);
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, bulletPos, bulletV, bulletHeight, worldBounds, damage);
    }

    protected void boom(){
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
    }

}
