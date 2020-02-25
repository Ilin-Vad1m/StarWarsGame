package starwars.game.Base.Screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import starwars.game.Base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 touch;
    private Vector2 v;
    private Vector2 pos;
    private static final float V_LEN = 1f;
    private Vector2 buf;


    @Override
    public void show() {
        super.show();
        img = new Texture("images.jpg");
        touch = new Vector2();
        v = new Vector2();
        pos = new Vector2(0,0);
        buf = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        buf.set(touch);
        if(buf.sub(pos).len() > V_LEN) {
            pos.add(v);
        }else {
            pos.set(touch);
        }
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        img.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
       super.touchDown(screenX, screenY, pointer, button);
        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
        v.set(touch.cpy().sub(pos).setLength(V_LEN));
        System.out.println("touchX = " + touch.x + " touchY = " + touch.y);
        System.out.println(pos.y + img.getHeight());
        return false;

    }
}
