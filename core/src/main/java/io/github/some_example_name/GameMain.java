package io.github.some_example_name;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import net.dermetfan.gdx.physics.box2d.PositionController;

import java.util.ArrayList;

// {@link com.badlogic.gdx.ApplicationListener}
public class GameMain extends ApplicationAdapter{
    static ArrayList<Screen> record=new ArrayList<>();
    Sprite sprite;
    SpriteBatch batch;
    game Game;
    newGameScreen NEW;
    loadGameScreen Continue;
    public void create() {
        batch=new SpriteBatch();
        Game=new game();
        Game.create();
//        NEW= new newGameScreen();
//        Continue=new loadGameScreen();
    }
    public void resize(int width, int height) {
        Game.resize(width,height);
    }

    public void render() {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Game.render();
//        NEW.Render(batch);
//        Continue.Render(batch);
    }
    public void pause() {
    }
    public void resume() {
    }
    public void dispose() {
        batch.dispose();
    }
}


