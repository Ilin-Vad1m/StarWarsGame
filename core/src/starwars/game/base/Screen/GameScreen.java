package starwars.game.base.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.BaseScreen;
import starwars.game.base.Screen.sprite.Background;
import starwars.game.base.Screen.sprite.Background2;
import starwars.game.base.Screen.sprite.Galaxy;
import starwars.game.base.Screen.sprite.Ship;
import starwars.game.math.Rect;

public class GameScreen extends BaseScreen {

    private static final int STAR_COUNT = 2;

    private Texture bg;

    private TextureAtlas atlasStars;
    private TextureAtlas atlasShip;


    private Ship ship;
    private Background background;
    private Background2 background2;
    private Galaxy[] galaxys;

    public GameScreen() {

    }

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.jpg");
        background = new Background(bg);
        background2 = new Background2(bg);
        galaxys = new Galaxy[STAR_COUNT];
        atlasStars = new TextureAtlas(Gdx.files.internal("galaxy/hot.atlas"));
        for (int i = 0; i < STAR_COUNT; i++) {
            galaxys[i] = new Galaxy(atlasStars);
        }
        atlasShip = new TextureAtlas(Gdx.files.internal("ships/Ship.pack"));
        ship = new Ship(atlasShip);
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        background2.resize(worldBounds);
        for(Galaxy galaxy : galaxys){
            galaxy.resize(worldBounds);
        }
        ship.resize(worldBounds);
    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        atlasStars.dispose();
        atlasShip.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return super.keyDown(keycode);
    }

    @Override
    public boolean keyUp(int keycode) {
        return super.keyUp(keycode);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
//        ship.touchDown(touch, pointer, button);
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
        for(Galaxy galaxy : galaxys){
            galaxy.update(delta);
        }
        ship.update(delta);
        background.update(delta);
        background2.update(delta);

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
        batch.end();
    }

}
