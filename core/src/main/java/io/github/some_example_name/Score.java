package io.github.some_example_name;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

public class Score implements Screen {
    private OrthographicCamera camera;
    private Sprite sprite;
    private SpriteBatch spritebatch;
    public Score(float WorldWidth, float WorldHeight){
        sprite =new Sprite(new Texture("Untitled.png"));
        camera= new OrthographicCamera(WorldWidth,WorldHeight);
        sprite.setSize(WorldWidth,WorldHeight);
        camera.position.set(WorldWidth/2,WorldHeight/2,0);
        spritebatch= new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        camera.update();
        spritebatch.setProjectionMatrix(camera.combined);
        spritebatch.begin();
        sprite.draw(spritebatch);
        spritebatch.end();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        spritebatch.dispose();
    }
}
