package starwars.game.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import pool.BulletPool;
import pool.EnemyPool;
import pool.ExplosionPool;
import starwars.game.sprite.Background;
import starwars.game.sprite.Background2;
import starwars.game.sprite.Galaxy;
import starwars.game.base.BaseScreen;
import starwars.game.sprite.MainShip;
import starwars.game.math.Rect;
import utils.EnemiesEmitter;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 2;

    private Texture bg;

    private TextureAtlas atlasStars;
    private TextureAtlas atlasShip;
    private TextureAtlas atlasEnemyShip;

    private BulletPool bulletPool;
    private EnemyPool enemyPool;
    private ExplosionPool explosionPool;

    private Music music;
    private Sound bulletSound;
    private Sound explosionSound;

    private EnemiesEmitter enemiesEmitter;


    private MainShip ship;

    private starwars.game.sprite.Background background;
    private starwars.game.sprite.Background2 background2;
    private starwars.game.sprite.Galaxy[] galaxys;

    public GameScreen() {

    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.jpg");
        background = new Background(bg);
        background2 = new Background2(bg);
        galaxys = new starwars.game.sprite.Galaxy[STAR_COUNT];
        atlasStars = new TextureAtlas(Gdx.files.internal("galaxy/hot.atlas"));
        bulletSound = Gdx.audio.newSound(Gdx.files.internal("sounds/bullet.wav"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("sounds/explosion.wav"));
        for (int i = 0; i < STAR_COUNT; i++) {
            galaxys[i] = new starwars.game.sprite.Galaxy(atlasStars);
        }
        atlasShip = new TextureAtlas(Gdx.files.internal("ships/Ship.atlas"));
        atlasEnemyShip = new TextureAtlas(Gdx.files.internal("textures/mainAtlas.tpack"));
        bulletPool = new BulletPool();
        explosionPool = new ExplosionPool(atlasEnemyShip, explosionSound);
        enemyPool = new EnemyPool(bulletPool, explosionPool, bulletSound, worldBounds);
        enemiesEmitter = new EnemiesEmitter(atlasEnemyShip, enemyPool, worldBounds);
        ship = new MainShip(atlasShip, bulletPool, explosionPool);
        music = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        music.setLooping(true);
        music.play();
    }

    @Override
    public void render(float delta) {
        update(delta);
        freeAllDestroyed();
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        background2.resize(worldBounds);
        for(starwars.game.sprite.Galaxy galaxy : galaxys){
            galaxy.resize(worldBounds);
        }
        ship.resize(worldBounds);
    }

    @Override
    public void pause() {
        music.pause();
    }

    @Override
    public void resume() {
        music.play();
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlasStars.dispose();
        atlasShip.dispose();
        bulletPool.dispose();
        explosionPool.dispose();
        enemyPool.dispose();
        atlasEnemyShip.dispose();
        music.dispose();
        bulletSound.dispose();
        explosionSound.dispose();
        ship.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(Vector2 touch, int pointer) {
        ship.touchDragged(touch, pointer);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        return super.touchUp(touch, pointer, button);
    }

    private void update(float delta){
        for(starwars.game.sprite.Galaxy galaxy : galaxys){
            galaxy.update(delta);
        }
        background.update(delta);
        background2.update(delta);
        ship.update(delta);
        bulletPool.updateActiveSprites(delta);
        explosionPool.updateActiveSprites(delta);
        enemyPool.updateActiveSprites(delta);
        enemiesEmitter.generate(delta);
    }

    private void freeAllDestroyed(){
        bulletPool.freeAllDestroyedActiveObjects();
        enemyPool.freeAllDestroyedActiveObjects();
        explosionPool.freeAllDestroyedActiveObjects();
    }

    private void draw(){
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        background2.draw(batch);
        for(Galaxy galaxy : galaxys){
            galaxy.draw(batch);
        }
        ship.draw(batch);
        bulletPool.drawActiveSprites(batch);
        enemyPool.drawActiveSprites(batch);
        explosionPool.drawActiveSprites(batch);
        batch.end();
    }

}
