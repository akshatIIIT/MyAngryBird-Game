package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.awt.*;

import static io.github.some_example_name.GameMain.record;
import static io.github.some_example_name.LevelHandler.score;


public class winning implements Screen {
    private boolean saving=false;
    private Rectangle next;
    private Rectangle retry;
    private Rectangle exit;
    private Sprite retrysprite;
    private Sprite nextsprite;
    private Sprite exitsprite;
    private SpriteBatch spritebatch;
    private Sprite sprite;
    private InputMultiplexer multiplexer;
    private game GAME;
    private OrthographicCamera camera;
    private int currentLevel;
    private Sprite background;
    private float worldWidth;
    private float worldHeight;
    public winning(game game,float worldWidth,float worldHeight,int currentLevel){
        this.currentLevel=currentLevel;
        multiplexer=new InputMultiplexer();
        RETRY(worldWidth,worldHeight);
        NEXT(worldWidth,worldHeight);
        EXIT(worldWidth,worldHeight);
        camera= new OrthographicCamera(worldWidth,worldHeight);
        camera.position.set(worldWidth/2,worldHeight/2,0);
        background=new Sprite(new Texture("bichka.jpg"));
        background.setSize(worldWidth,worldHeight);
        spritebatch=new SpriteBatch();
        Gdx.input.setInputProcessor(multiplexer);
        this.GAME=game;
    }

    public void RETRY(float worldWidth,float worldHeight) {
        retrysprite = new Sprite(new TextureRegion(new Texture("bgicons.png"), 53, 330, 31, 28));
        retrysprite.setSize(70, 70);
        retrysprite.setPosition(worldWidth/4-retrysprite.getWidth()/2,worldHeight/2-retrysprite.getHeight()/2);
        retry = new Rectangle((int) retrysprite.getX(), (int) retrysprite.getY(), (int) retrysprite.getWidth(), (int) retrysprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3(screenX, screenY, 0));
                if (retry.contains(Worldcoordinates.x, Worldcoordinates.y)) {
//                    Screen s=new loadGameScreen(GAME,worldWidth,worldHeight);
                    if (currentLevel == 1) {
                        Screen s = new LevelHandler("lvl1Back.png", camera.viewportWidth, camera.viewportHeight, GAME, 1);
                        GAME.setScreen(s);
                    } else if (currentLevel == 2) {
                        Screen s = new LevelHandler("lvl2Back.png", camera.viewportWidth, camera.viewportHeight, GAME, 2);
                        GAME.setScreen(s);
                    } else {
                        Screen s = new LevelHandler("lvl3Back.png", camera.viewportWidth, camera.viewportHeight, GAME, 3);
                        GAME.setScreen(s);
                    }
//                    ((loadGameScreen) s).LEVEL = currentLevel;
                    return true;
                }
                return false;
            }
        });
    }

    public void NEXT(float worldWidth,float worldHeight) {
        nextsprite = new Sprite(new TextureRegion(new Texture("bgicons.png"), 129,173,29,26));
        nextsprite.setSize(70, 70);
        nextsprite.setPosition(worldWidth/2-nextsprite.getWidth()/2,worldHeight/2-nextsprite.getHeight()/2);
        next = new Rectangle((int) nextsprite.getX(), (int) nextsprite.getY(), (int) nextsprite.getWidth(), (int) nextsprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3(screenX, screenY, 0));
                if (next.contains(Worldcoordinates.x, Worldcoordinates.y)) {
//                    Screen s=new loadGameScreen(GAME,worldWidth,worldHeight);
                    if(currentLevel == 1) {
                        Screen s = new LevelHandler("lvl2Back.png", camera.viewportWidth, camera.viewportHeight, GAME, 2);
                        GAME.setScreen(s);
                    }
                    else if(currentLevel==2){
                        Screen s = new LevelHandler("lvl3Back.png", camera.viewportWidth, camera.viewportHeight, GAME, 3);
                        GAME.setScreen(s);
                    }
//                    ((loadGameScreen) s).LEVEL = currentLevel;
                    return true;
                }
                return false;
            }
        });
    }
    public void EXIT(float worldWidth,float worldHeight){
        exitsprite =new Sprite(new TextureRegion(new Texture("bgicons.png"), 129, 98, 26, 26));
        exitsprite.setSize(70,70);
        exitsprite.setPosition(worldWidth*0.75f -exitsprite.getWidth()/2,worldHeight/2-exitsprite.getHeight()/2);
        next=new Rectangle((int) exitsprite.getX(), (int) exitsprite.getY(),(int) exitsprite.getWidth(), (int) exitsprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
                if (next.contains(Worldcoordinates.x, Worldcoordinates.y)) {
//                    Screen s=new loadGameScreen(GAME,worldWidth,worldHeight);
//                    ((loadGameScreen) s).LEVEL =0;
//                    GAME.setScreen(s);
                    if(pauseScreen.value){
                        for(Screen screen:record){
                            if(screen instanceof newGameScreen){
//                                ((newGameScreen)screen).LEVEL=0;
                                GAME.setScreen(screen);
                                Gdx.input.setInputProcessor((((newGameScreen) screen).getStage()));
                                System.out.println(Gdx.input.getInputProcessor().getClass().getSimpleName());
                                break;
                            }
                        }
                    }
                    else{
                        for(Screen screen:record){
                            if(screen instanceof loadGameScreen){
//                                ((loadGameScreen)screen).LEVEL=0;
                                GAME.setScreen(screen);
                                Gdx.input.setInputProcessor((((loadGameScreen) screen).getStage()));
                                break;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
        camera.update();
        spritebatch.setProjectionMatrix(camera.combined);
        spritebatch.begin();
        background.draw(spritebatch);
        retrysprite.draw(spritebatch);
        exitsprite.draw(spritebatch);
        nextsprite.draw(spritebatch);
        spritebatch.end();
        if(!saving){
            Restore rst=new Restore();
            rst.Saving(this.currentLevel,score);
        }
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

    }
}
