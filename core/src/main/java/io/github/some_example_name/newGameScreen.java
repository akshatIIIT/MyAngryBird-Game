package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import java.util.logging.Level;
class newGameScreen implements Screen {
    private final Stage stage;
    private final ImageButton level_1;
    private final ImageButton level_2;
    private final ImageButton level_3;
    private final ImageButton backButton;
    private final Sprite background;
    private final SpriteBatch spritebatch;
    private final game GAME;
    public int LEVEL;
    private final Sound mouseClick;
    private final Sound levelsound;
    LevelHandler handlelevel;
    public newGameScreen(game GAME,float WorldWidth,float WorldHeight){
        this.GAME=GAME;
        stage = new Stage(new StretchViewport(WorldWidth,WorldHeight));
        spritebatch=new SpriteBatch();
        Gdx.input.setInputProcessor(stage);

        background=new Sprite(new Texture("bichka.jpg"));
        level_1=createButton("level1.jpeg");
        level_2=createButton("level2.jpeg");
        level_3=createButton("level3.jpeg");
        backButton=createButton("Exit (2).png");

        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        mouseClick = Gdx.audio.newSound(Gdx.files.internal("./sounds/mouseClick.mp3"));
        levelsound = Gdx.audio.newSound(Gdx.files.internal("./sounds/LevelSound.wav"));

        level_1.setSize(stage.getViewport().getWorldWidth()*0.16f,stage.getViewport().getWorldHeight()*0.16f);
        level_2.setSize(stage.getViewport().getWorldWidth()*0.16f,stage.getViewport().getWorldHeight()*0.16f);
        level_3.setSize(stage.getViewport().getWorldWidth()*0.16f,stage.getViewport().getWorldHeight()*0.16f);
        backButton.setSize(stage.getViewport().getWorldWidth()*0.1f,stage.getViewport().getWorldHeight()*0.1f);

        level1_button();
        level2_button();
        level3_button();
        back_Button();

        stage.addActor(level_1);
        stage.addActor(level_2);
        stage.addActor(level_3);
        stage.addActor(backButton);
        Loading();
    }
    private ImageButton createButton(String texturePath) {
        Texture buttonTexture = new Texture(Gdx.files.internal(texturePath));
        TextureRegionDrawable upDrawable = new TextureRegionDrawable(buttonTexture);
        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        buttonStyle.up = upDrawable;
        return new ImageButton(buttonStyle);
    }
    public void Loading(){
        for(Actor actor: stage.getActors()){
            actor.setTouchable(Touchable.disabled);
        }
        stage.getActors().get(stage.getActors().size-1).setTouchable(Touchable.enabled);
        stage.getActors().get(0).setTouchable(Touchable.enabled);
//        rest.loading();
    }
public void level1_button(){
    level_1.setPosition(80, 200);
    level_1.addListener(new ClickListener(){
        public void clicked(InputEvent event, float x, float y) {
            mouseClick.play();
            handlelevel = new LevelHandler("lvl1Back.png", stage.getWidth(), stage.getHeight(), GAME, 1);
            GAME.setScreen(handlelevel);
            long levelSoundId = levelsound.play();
            // Schedule the sound to stop after 5 seconds
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    levelsound.stop(levelSoundId);
                }
            }, 5);

            System.out.println("level_1 button is pressed");
        }
    });
}
    public void level2_button() {
        level_2.setPosition(260, 200);
        level_2.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                mouseClick.play();
                handlelevel=new LevelHandler("lvl2Back.png", stage.getWidth(), stage.getHeight(),GAME,2);
                GAME.setScreen(handlelevel);
                long levelSoundId = levelsound.play();
                // Schedule the sound to stop after 5 seconds
                Timer.schedule(new Timer.Task() {
                    @Override
                    public void run() {
                        levelsound.stop(levelSoundId);
                    }
                }, 5);
                System.out.println("level_2 button is pressed");
            }
        });
    }
    public void level3_button() {
        level_3.setPosition(440, 200);
        level_3.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                    mouseClick.play();
                    handlelevel=new LevelHandler("lvl3Back.png", stage.getWidth(), stage.getHeight(),GAME,3);
                    GAME.setScreen(handlelevel);
                    long levelSoundId = levelsound.play();
                    Timer.schedule(new Timer.Task() {
                        @Override
                        public void run() {
                            levelsound.stop(levelSoundId);
                        }
                    }, 5);  // 5 seconds delay
                    System.out.println("level_3 button is pressed");
            }
        });
    }
    public void back_Button(){
        backButton.setPosition(500,400);
        backButton.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x,float y){
                GAME.setScreen(GameMain.record.get(0));
                Gdx.input.setInputProcessor(((Options) GameMain.record.get(0)).getStage());
//                return true;
            }
//            return false;
        });
    }
    public void Background(SpriteBatch spriteBatch){
        spriteBatch.begin();
        background.draw(spriteBatch);
        spriteBatch.end();
    }
    public Stage getStage(){
        return this.stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
            this.Background(spritebatch);  // Draw the background
            // Let the stage render the buttons automatically
            stage.act();  // Update the stage (handles input events)
            stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width,height);
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

    public void dispose() {
        stage.dispose();
        spritebatch.dispose();
        mouseClick.dispose();
        levelsound.dispose();
    }
}
