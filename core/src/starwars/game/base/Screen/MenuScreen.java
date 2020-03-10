package starwars.game.base.Screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.BaseScreen;
import starwars.game.base.ScaledButton;
import starwars.game.base.Screen.sprite.Background;
import starwars.game.base.Screen.sprite.Background3;
import starwars.game.base.Screen.sprite.Background4;
import starwars.game.base.Screen.sprite.ButtonExit;
import starwars.game.base.Screen.sprite.ButtonOptions;
import starwars.game.base.Screen.sprite.ButtonPlay;
import starwars.game.base.Screen.sprite.MenuNameGame;
import starwars.game.base.Screen.sprite.Star;
import starwars.game.math.Rect;

public class MenuScreen extends BaseScreen {

    private final Game game;


    private static final int STAR_COUNT = 128;

    private Texture bg;
    private Texture bg2;

    private TextureAtlas atlasStars;
    private TextureAtlas atlasMenu;


    private Background3 background;
    private Background4 background2;
    private MenuNameGame menuNameGame;
    private Star[] stars;

    private ButtonExit buttonExit;
    private ButtonPlay buttonPlay;
    private ButtonOptions buttonOptions;


    public MenuScreen(Game game) {
        this.game = game;
    }


    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/spce.jpg");
        bg2 = new Texture("textures/space2.jpg");
        background = new Background3(bg);
        background2 = new Background4(bg2);
        stars = new Star[STAR_COUNT];
        atlasStars = new TextureAtlas(Gdx.files.internal("stars/stars.atlas"));
        for (int i = 0; i < STAR_COUNT; i++) {
            stars[i] = new Star(atlasStars);
        }
        atlasMenu = new TextureAtlas(Gdx.files.internal("menu/Menu.atlas"));
        buttonExit = new ButtonExit(atlasMenu);
        buttonPlay = new ButtonPlay(atlasMenu, game);
        buttonOptions = new ButtonOptions(atlasMenu);
        menuNameGame = new MenuNameGame(atlasMenu);

    }

    @Override

    public void render(float delta) {
        super.render(delta);
         update(delta);
         draw();

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        bg2.dispose();
        atlasStars.dispose();
        atlasMenu.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        background2.resize(worldBounds);
        for(Star star : stars){
            star.resize(worldBounds);
        }

        buttonExit.resize(worldBounds);
        buttonPlay.resize(worldBounds);
        buttonOptions.resize(worldBounds);
        menuNameGame.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        buttonExit.touchDown(touch, pointer, button);
        buttonPlay.touchDown(touch, pointer, button);
        buttonOptions.touchDown(touch, pointer, button);
        return false;

    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        buttonExit.touchUp(touch, pointer, button);
        buttonPlay.touchUp(touch, pointer, button);
        buttonOptions.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta){
        for(Star star : stars){
            star.update(delta);
        }

        background.update(delta);
        background2.update(delta);
    }

    private void draw(){
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        background2.draw(batch);
        menuNameGame.draw(batch);
        for(Star star : stars){
            star.draw(batch);
        }
        buttonExit.draw(batch);
        buttonPlay.draw(batch);
        buttonOptions.draw(batch);
        batch.end();
    }
}
