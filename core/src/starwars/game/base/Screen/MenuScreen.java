package starwars.game.base.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.BaseScreen;
import starwars.game.base.Screen.sprite.Background;
import starwars.game.math.Rect;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Texture bg;

    private Vector2 pos;

    private Background background;



    @Override
    public void show() {
        super.show();
        img = new Texture("images.jpg");
        bg = new Texture("bg.jpg");
        pos = new Vector2(0,0);
        background = new Background(bg);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.draw(img, pos.x, pos.y, 0.5f, 0.5f);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
        bg.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        return super.touchDown(touch, pointer, button);

    }
}
