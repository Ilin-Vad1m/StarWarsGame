package starwars.game.base.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.BaseScreen;
import starwars.game.base.Screen.sprite.Background;
import starwars.game.base.Screen.sprite.Logo;
import starwars.game.math.Rect;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Texture lg;
    private Background background;
    private Logo logo;



    @Override
    public void show() {
        super.show();
        lg = new Texture("images.jpg");
        bg = new Texture("bg.jpg");
        background = new Background(bg);
        logo = new Logo(lg);
    }

    @Override

    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        logo.update(delta);
        batch.begin();
        logo.draw(batch);
        background.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        lg.dispose();
        bg.dispose();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {

        logo.touchDown(touch, pointer, button);

        return false;
    }
}
