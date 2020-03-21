package starwars.game.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import starwars.game.base.Sprite;
import starwars.game.math.Rect;
import starwars.game.math.Rnd;

public class Galaxy extends Sprite {

    private final Vector2 v;
    private Rect worldBounds;

    public Galaxy(TextureAtlas atlas) {            //добавить остальные хот
        super(atlas.findRegion("hotpng.com"));
        v = new Vector2();
        v.set(Rnd.nextFloat(-0.005f, 0.005f), Rnd.nextFloat(-0.1f, -0.01f));
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.4f);
        float posX = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float posY = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(posX, posY);
        this.worldBounds = worldBounds;
    }

    @Override
    public void update(float delta) {
        pos.mulAdd(v, delta);

        if(getRight() < worldBounds.getLeft()){
            setLeft(worldBounds.getRight());
        }
        if(getLeft() > worldBounds.getRight()){
            setRight(worldBounds.getLeft());
        }
        if(getTop() < worldBounds.getBottom()){
            setBottom(worldBounds.getTop());
        }
        if(getBottom() > worldBounds.getTop()){
            setTop(worldBounds.getBottom());
        }
    }
}


