package starwars.game.base;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import starwars.game.math.Rect;

public class Sprite extends Rect {

    protected  float angle; // угол поворота
    protected float scale = 1f; //скалирование
    protected TextureRegion[] regions; // массив текстур
    protected int frame; // текущая текстура

    public Sprite(TextureRegion region) {
        if(region == null){
            throw new RuntimeException("Не задана текстура");
        }
        regions = new TextureRegion[1];
        regions[0] = region;
    }

    public void draw(SpriteBatch batch){
        batch.draw(
                regions[frame],
                getLeft(), getBottom(),
                halfWidth, halfHeight,
                getWidth(), getHeight(),
                scale, scale,
                angle
        );
    }

    public void  setHeightProportion(float height){

        setHeight(height);
        float aspect = regions[frame].getRegionWidth() / (float) regions[frame].getRegionHeight();
        setWidth(height * aspect);

    }

    public void resize(Rect worldBounds){};

    public void touchDown(Vector2 touch, int pointer, int button){};

    public void touchUp(Vector2 touch, int pointer, int button){};

    public void touchDragged(Vector2 touch, int pointer){};

    public void update(float delta){};

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }


}
