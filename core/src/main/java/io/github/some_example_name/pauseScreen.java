package io.github.some_example_name;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import net.dermetfan.gdx.Multiplexer;

import java.awt.*;

import static io.github.some_example_name.GameMain.record;
import static io.github.some_example_name.LevelHandler.resuming;

public class pauseScreen implements Screen {
    static public boolean value=true;
    private Rectangle RETRY;
    private Rectangle RESUME;
    private Rectangle BACK;
    private Sprite RETRYsprite;
    private Sprite RESUMEsprite;
    private Sprite BACKsprite;
    private OrthographicCamera camera;
    private Sprite background;
    private SpriteBatch spritebatch;
    private InputMultiplexer multiplexer;
    private game GAME;
    private int currentLevel;
    public pauseScreen(game game, float worldWidth, float worldHeight,int currentLevel) {
        this.currentLevel=currentLevel;
        multiplexer=new InputMultiplexer();
        RETRY(worldWidth,worldHeight);
        RESUME(worldWidth,worldHeight);
        BACK(worldWidth,worldHeight);
        camera= new OrthographicCamera(worldWidth,worldHeight);
        camera.position.set(worldWidth/2,worldHeight/2,0);
        background=new Sprite(new Texture("bichka.jpg"));
        background.setSize(worldWidth,worldHeight);
        spritebatch=new SpriteBatch();
        Gdx.input.setInputProcessor(multiplexer);
        this.GAME=game;
    }
    public void RETRY(float worldWidth,float worldHeight){
        RETRYsprite =new Sprite(new TextureRegion(new Texture("bgicons.png"),53,330,31,28));
        RETRYsprite.setSize(70,70);
        RETRYsprite.setPosition(worldWidth/2-RETRYsprite.getWidth()/2,worldHeight/2-RETRYsprite.getHeight()/2);
        RETRY=new Rectangle((int) RETRYsprite.getX(), (int) RETRYsprite.getY(), (int) RETRYsprite.getWidth(), (int) RETRYsprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
                if (RETRY.contains(Worldcoordinates.x, Worldcoordinates.y)) {
//                    Screen s=new loadGameScreen(GAME,worldWidth,worldHeight);
                      if(currentLevel==1){
                          Screen s=new LevelHandler("lvl1Back.png", camera.viewportWidth, camera.viewportHeight,GAME,1);
                          GAME.setScreen(s);
                      }
                      else if(currentLevel==2){
                          Screen s=new LevelHandler("lvl2Back.png", camera.viewportWidth, camera.viewportHeight,GAME,2);
                          GAME.setScreen(s);
                      }
                      else{
                          Screen s=new LevelHandler("lvl3Back.png", camera.viewportWidth, camera.viewportHeight,GAME,3);
                          GAME.setScreen(s);
                      }
//                    ((loadGameScreen) s).LEVEL = currentLevel;
                    return true;
                }
                return false;
            }
        });
    }
    public void RESUME(float worldWidth,float worldHeight){
        RESUMEsprite =new Sprite(new TextureRegion(new Texture("bgicons.png"),54,138,28,29));
        RESUMEsprite.setSize(70,70);
        RESUMEsprite.setPosition(worldWidth/4-RESUMEsprite.getWidth()/2,worldHeight/2-RESUMEsprite.getHeight()/2);
        RESUME=new Rectangle((int) RESUMEsprite.getX(), (int) RESUMEsprite.getY(),(int) RESUMEsprite.getWidth(), (int) RESUMEsprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
                if (RESUME.contains(Worldcoordinates.x, Worldcoordinates.y)) {
                    Gdx.input.setInputProcessor(((LevelHandler) resuming.get(0)).getInputmultiplexer());
                    GAME.setScreen(resuming.get(0));
                    System.out.println("true");
                    return true;
                }
                return false;
            }
        });
    }
    public void BACK(float worldWidth,float worldHeight){
        BACKsprite =new Sprite(new TextureRegion(new Texture("bgicons.png"),129,173,28,26));
        BACKsprite.setSize(70,70);
        BACKsprite.setPosition(worldWidth*0.75f -RETRYsprite.getWidth()/2,worldHeight/2-RETRYsprite.getHeight()/2);
        BACK=new Rectangle((int) BACKsprite.getX(), (int) BACKsprite.getY(),(int) BACKsprite.getWidth(), (int) BACKsprite.getHeight());
        multiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
                if (BACK.contains(Worldcoordinates.x, Worldcoordinates.y)) {
                    if(value){
                        for(Screen screen:record){
                            if(screen instanceof newGameScreen){
//                                ((newGameScreen)screen).LEVEL=0;
                                GAME.setScreen(screen);
                                resuming.clear();
                                Gdx.input.setInputProcessor((((newGameScreen) screen).getStage()));
                                System.out.println(Gdx.input.getInputProcessor().getClass().getSimpleName());
                                break;
                            }
                        }
                    }
                    else{
                        for(Screen screen:record){
                            if(screen instanceof loadGameScreen){
                                resuming.clear();
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
        RETRYsprite.draw(spritebatch);
        RESUMEsprite.draw(spritebatch);
        BACKsprite.draw(spritebatch);
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
