package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import static io.github.some_example_name.GameMain.record;

class Options implements Screen {
    private final Stage stage;  // Scene2D stage to handle input and rendering
    private final ImageButton new_game;  // Button for New Game
    private final ImageButton load_game;  // Button for Load Game
    private final ImageButton exit;  // Button for Exit
    private final Sprite background;  // Background image
    private final SpriteBatch spritebatch;
    private final game GAME;

    private final Sound mouseClick;
    private final Sound introSound;
    long id;
    public Options(game GAME) {
        // Set up the stage for buttons
        this.GAME=GAME;
        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
        spritebatch=new SpriteBatch();
        Gdx.input.setInputProcessor(stage);
        // Load background texture
        background = new Sprite(new Texture("HIGH SCORE.jpg"));
        // Create buttons with textures
        new_game = createButton("short.jpg");
        load_game = createButton("shortu.png");
        exit = createButton("chotu.png");
        // Set button size relative to screen
        background.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        new_game.setSize(Gdx.graphics.getWidth() * 0.20f, Gdx.graphics.getHeight() * 0.07f);
        load_game.setSize(Gdx.graphics.getWidth() * 0.20f, Gdx.graphics.getHeight() * 0.07f);
        exit.setSize(Gdx.graphics.getWidth() * 0.20f, Gdx.graphics.getHeight() * 0.07f);

        mouseClick = Gdx.audio.newSound(Gdx.files.internal("./sounds/mouseClick.mp3"));
        introSound = Gdx.audio.newSound(Gdx.files.internal("./sounds/IntroSound.mp3"));
        long id=introSound.play();
        // Initialize button methods
        New_Game();
        Load_Game();
        Exit();
        // Add buttons to the stage
        stage.addActor(new_game);
        stage.addActor(load_game);
        stage.addActor(exit);
    }
// Helper method to create an ImageButton
    private ImageButton createButton(String texturePath) {
        Texture buttonTexture = new Texture(Gdx.files.internal(texturePath));
        return new ImageButton(new TextureRegionDrawable(buttonTexture));
    }
    // Separate method for the New Game button
    public void New_Game() {
        // Set position for the New Game button
        new_game.setPosition(250, 85);
        // Add listener for New Game button
        new_game.addListener(new ClickListener() {
            public void clicked(InputEvent event, float x, float y){
                mouseClick.play();
                introSound.stop(id);
                System.out.println("New Game button clicked!");
                pauseScreen.value=true;
                Screen tc=new newGameScreen(GAME,stage.getViewport().getWorldWidth(),stage.getViewport().getWorldHeight());
                record.add(tc);
                GAME.setScreen(tc);
            }
//                return true;

//            return false;
        });
    }
    // Separate method for the Load Game button
    public void Load_Game() {
        // Set position for the Load Game button
        load_game.setPosition(250, 45);
        // Add listener for Load Game button
        load_game.addListener(new ClickListener(){
            public void clicked(InputEvent event,float x, float y){
                mouseClick.play();
                introSound.stop(id);
                System.out.println("Load Game button clicked!");
                pauseScreen.value=false;
                for(Screen screen :record){
                    if(screen instanceof loadGameScreen){
                        Gdx.input.setInputProcessor(((loadGameScreen) screen).getStage());
                        GAME.setScreen(screen);
//                        return true;
                    }
                }
                Screen st=new loadGameScreen(GAME,stage.getViewport().getWorldWidth(),stage.getViewport().getWorldHeight());
                record.add(st);
                GAME.setScreen(st);
            }
        });
    }
    // Separate method for the Exit button
    public void Exit() {
        // Set position for the Exit button
        exit.setPosition(250, 5);
        // Add listener for Exit button
        exit.addListener(new ClickListener() {
            public void clicked(InputEvent event,float x,float y){
                System.out.println("Exit button clicked!");
                Gdx.app.exit();  // Exit the game
            }
        });
    }


    public void Background(SpriteBatch spriteBatch) {
        // Draw the background image
        spriteBatch.begin();
        background.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float v) {
            this.Background(spritebatch);  // Draw the background

            // Let the stage render the buttons automatically
            stage.act();  // Update the stage (handles input events)
            stage.draw();  // Draw the buttons (ImageButtons)
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
    public Stage getStage(){
        return this.stage;
    }


    public void dispose() {
        stage.dispose();
        mouseClick.dispose();
        introSound.dispose();
        spritebatch.dispose();

    }
}
