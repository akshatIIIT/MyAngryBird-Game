package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;


class LevelHandler implements Screen{
    static ArrayList<Species> every;
    static ArrayList<Birds> everybird;
    static ArrayList<Screen> resuming;
    static ArrayList<BlastAnimation> all_animations;
    static ArrayList<Species> destroyed_objects;
    static int index;
    private int previndex=0;
    public static String score="0";
    private BitmapFont font;
    private GlyphLayout layout;
    private Wood wood1;
    private Wood wood2;
    private Wood wood3;
    private Wood wood4;
    private Wood wood5;
    private Wood wood6;
    private Wood wood7;
    private Wood wood8;
    private Wood wood9;
    private Wood wood10;
    private Wood wood11;
    private Wood wood12;
    private Wood wood13;
    private Wood wood14;
    private Wood wood15;
    private Wood wood16;
    private Wood wood17;
    private Wood wood18;
    private Wood wood19;
    private Wood wood20;
    private Wood wood21;
    private Wood wood22;
    private Wood wood23;
    private Wood wood24;
    private Wood wood25;
    private Wood wood26;
    private Wood wood27;
    private Wood wood28;
    private Wood wood29;
    private Wood wood30;
    private Wood wood31;
    private Wood wood32;
    private Wood wood33;
    private Wood wood34;
    private Wood wood35;
    private Wood wood36;
    private Wood wood37;
    private Wood wood38;
    private Birds bird1;
    private Birds bird2;
    private Birds bird3;
    private Pigs pig1;
    private Pigs pig2;
    private Pigs pig3;
    private Pigs pig4;
    private Pigs pig5;
    private Pigs pig6;
    private Pigs pig7;
    private Pigs pig8;
    private Pigs pig9;
    private Pigs pig10;
    private Pigs pig11;
    private Pigs pig12;
    private Slingshot sling1;
    private Slinshottwo sling2;
    private Rocks rock1;
    private Rocks rock2;
    private Rocks rock3;
    private Rocks rock4;
    private Rocks rock5;
    private Rocks rock6;
    private Rocks rock7;
    private Rocks rock8;
    private Sprite background;
    private final SpriteBatch spritebatch;
    private Sprite sprite;
    private Sprite sprite1;
    private final Species ground;
    ArrayList<Species> objects =new ArrayList<Species>();
    private float WorldWidth;
    private float WorldHeight;
    private OrthographicCamera camera;
     private Rectangle rectangle;
     private game GAME;
     private int currentLevel;
     private Box2DDebugRenderer debugRenderer;
     private World world;
     private Rectangle rect;
     private InputMultiplexer inputmultiplexer;
     private float timer = 0;
    public LevelHandler(String path, float WorldWidth,float WorldHeight,game GAME,int currentLevel){
        spritebatch=new SpriteBatch();
        every = new ArrayList<>();
        resuming=new ArrayList<>();
        font=new BitmapFont();
        layout=new GlyphLayout();
        everybird=new ArrayList<>();
        destroyed_objects = new ArrayList<>();
        this.WorldWidth=WorldWidth;
        this.WorldHeight=WorldHeight;
        index = 0;
        debugRenderer = new Box2DDebugRenderer();
        background=new Sprite(new Texture(path));
        world = new World(new Vector2(0, -10f), false);
        world.setContactFilter((fixture, fixture1) -> {
            if(fixture.getBody().getUserData() == null || fixture1.getBody().getUserData() == null){
                return true;
            }
            else if(fixture.getBody().getUserData().equals("bird") && fixture1.getBody().getUserData().equals("slingshot") || fixture.getBody().getUserData().equals("slingshot") && fixture1.getUserData().equals("bird")){
                return false;
            } else if(fixture.getBody().getUserData().equals("bird") && fixture1.getBody().getUserData().equals("body") || fixture.getBody().getUserData().equals("body") && fixture1.getBody().getUserData().equals("bird")){
                return false;
            }
            return true;
        });
        bird1= new Birds(world,1,120,105,"bird.png");
        everybird.add(bird1);
        bird2= new Birds(world,1,75,100,"yellow.png");
        everybird.add(bird2);
        bird3= new Birds(world,1,60,100,"black.png");
        everybird.add(bird3);

        this.currentLevel=currentLevel;
        if(currentLevel==1){
            wood1=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.68), 97.5F,false,15,75,"glass.png");
            wood2=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.785), 97.5F,false,15,75,"glass.png");
            wood3=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.72),144,true,18,99,"glass.png");
            wood4=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.69), 190.5F,false,15,75,"glass.png");
            wood5=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.77), 190.5F,false,15,75,"glass.png");
            wood6=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.73), 235.5F,true,15,60,"planknew.png");
            pig1=new Pigs(world,(float) (WorldWidth*0.73),80);
            pig2=new Pigs(world,(float) (WorldWidth*0.73),264);
            rock1=new Rocks(world,(float) (WorldWidth*0.725),168);
        }
        else if(currentLevel==2){
            wood7=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.60), 97.5F,false,15,75,"planknew.png");
            wood8=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.63), 97.5F,false,15,75,"planknew.png");
            wood9=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.66),97.5F,false,15,75,"planknew.png");
            wood10=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.80), 97.5F,false,15,75,"planknew.png");
            wood11=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.83), 97.5F,false,15,75,"planknew.png");
            wood12=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.86), 97.5F,false,15,75,"planknew.png");
            wood13=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.65),150,true,15,90,"planknew.png");
            wood14=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.81),150,true,15,90,"planknew.png");
            wood15=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.68),187.5F,false,15,75,"glass.png");
            wood16=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.78), 187.5F,false,15,75,"glass.png");
            wood17=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.73),232.5F,true,15,90,"planknew.png");
            pig3=new Pigs(world,(float) (WorldWidth*0.73),170);
            pig4=new Pigs(world,(float) (WorldWidth*0.73),80);
            pig5=new Pigs(world,(float) (WorldWidth*0.73),261);
            rock2=new Rocks(world,(float) (WorldWidth*0.60),165);
            rock3=new Rocks(world,(float) (WorldWidth*0.86),165);
        }
        else{
            wood18=new Wood(world,WorldWidth,WorldHeight,322, 97.5F,false,15,55,"planknew.png");
            wood19=new Wood(world,WorldWidth,WorldHeight,382, 97.5F,false,15,55,"planknew.png");
            wood20=new Wood(world,WorldWidth,WorldHeight,445,97.5F,false,15,55,"planknew.png");
            wood21=new Wood(world,WorldWidth,WorldHeight,507, 97.5F,false,18,55,"planknew.png");
            wood22=new Wood(world,WorldWidth,WorldHeight,569, 97.5F,false,17,55,"planknew.png");
            wood23=new Wood(world,WorldWidth,WorldHeight,627, 97.5F,false,15,55,"planknew.png");
            wood24=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.55),131F,true,18,65,"planknew.png");
            wood25=new Wood(world,WorldWidth,WorldHeight,415,131F,true,18,65,"planknew.png");
            wood26=new Wood(world,WorldWidth,WorldHeight,475,131F,true,18,65,"planknew.png");
            wood27=new Wood(world,WorldWidth,WorldHeight,537,131F,true,18,65,"planknew.png");
            wood28=new Wood(world,WorldWidth,WorldHeight,597,131F,true,18,65,"planknew.png");
            wood29=new Wood(world,WorldWidth,WorldHeight,382, 168F,false,15,55,"glass.png");
            wood30=new Wood(world,WorldWidth,WorldHeight,445, 168F,false,15,55,"glass.png");
            wood31=new Wood(world,WorldWidth,WorldHeight,507,168F,false,15,55,"glass.png");
            wood32=new Wood(world,WorldWidth,WorldHeight,569, 168F,false,18,55,"glass.png");
            wood33=new Wood(world,WorldWidth,WorldHeight,412,203F,true,18,70,"glass.png");
            wood34=new Wood(world,WorldWidth,WorldHeight,475,203F,true,18,70,"glass.png");
            wood35=new Wood(world,WorldWidth,WorldHeight,537,203F,true,18,70,"glass.png");
            wood36=new Wood(world,WorldWidth,WorldHeight,445, 234F,false,15,55,"planknew.png");
            wood37=new Wood(world,WorldWidth,WorldHeight,507, 234F,false,15,55,"planknew.png");
            wood38=new Wood(world,WorldWidth,WorldHeight,(float) (WorldWidth*0.746),270F,true,17,65,"planknew.png");
            pig6=new Pigs(world,(float) (WorldWidth*0.55),80);
            pig7=new Pigs(world,(float) (WorldWidth*0.746),80);
            pig8=new Pigs(world,(float) (WorldWidth*0.94),80);
            pig9=new Pigs(world,415,155);
            pig10=new Pigs(world,537,155);
            pig11=new Pigs(world,(float) (WorldWidth*0.746),227);
            pig12=new Pigs(world,(float) (WorldWidth*0.746),297);
            rock4=new Rocks(world,415,80);
            rock5=new Rocks(world,537,80);
            rock6=new Rocks(world,(float) (WorldWidth*0.746),150);
            rock7=new Rocks(world,415,225);
            rock8=new Rocks(world,537,225);
        }
        ground= new Surface(world, WorldWidth,60);
        camera= new OrthographicCamera(WorldWidth,WorldHeight);
        camera.position.set(WorldWidth/2,WorldHeight/2,0);
        camera.update();


        sling2=new Slinshottwo(world,120,105,17,45,"slingpart.png");
        this.GAME=GAME;
        inputmultiplexer=new InputMultiplexer();
        Pause();
//        ViewScore();
        sling1=new Slingshot(world,120,100,17,80,"slingshot.png",inputmultiplexer,camera,everybird.get(0));
        sling1.slingShotAction();
        Gdx.input.setInputProcessor(inputmultiplexer);
        all_animations = new ArrayList<>();
        world.setContactListener(new CollisionUpdate());
    }
    private void drawScore() {
        spritebatch.begin();
        layout.setText(font, score);
        float textX = WorldWidth * 0.18f - layout.width;
        float textY = WorldHeight * 0.91f;
        font.draw(spritebatch, layout, textX, textY);
        spritebatch.end();
    }
    public InputMultiplexer getInputmultiplexer(){
        return this.inputmultiplexer;
    }
    public void level1(){
        System.out.println(quantity());
        timer += Gdx.graphics.getDeltaTime();
        if(every.stream().noneMatch(s -> s instanceof Birds)){
            loosing loose=new loosing(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(loose);
        }
        else if(quantity()){
            winning win=new winning(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(win);
        }
        layout.setText(font,score);
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        spritebatch.setProjectionMatrix(camera.combined);
        background.setSize(WorldWidth, WorldHeight);
        Background(spritebatch);
        spritebatch.begin();
//        font.draw(layout);
        sprite.draw(spritebatch);
//        sprite1.draw(spritebatch);
//        ground.Render(spritebatch);
//        bird1.Render(spritebatch);
//        bird2.Render(spritebatch);
//        wood1.Render(spritebatch);
//        wood2.Render(spritebatch);
//        wood3.Render(spritebatch);
//        wood4.Render(spritebatch);
//        wood5.Render(spritebatch);
//        wood6.Render(spritebatch);
//        pig1.Render(spritebatch);
//        pig2.Render(spritebatch);
//        sling1.Render(spritebatch);
//        sling2.Render(spritebatch);
//        rock.Render(spritebatch);
        ArrayList<BlastAnimation> array=new ArrayList();
        for(BlastAnimation animation : all_animations){
            if(!animation.isAnimationFinished()){
                animation.update(timer);
                spritebatch.draw(animation.getFrame(), animation.getX(), animation.getY());
            }
            else{
                array.add(animation);
            }
        }
        all_animations.removeAll(array);
        for(Species s:every){
            s.Render(spritebatch);
        }
        //System.out.println(destroyed_objects.size());
        for(Species s:destroyed_objects){
            Vector2 position = s.body.getPosition().cpy();
            all_animations.add(new BlastAnimation(position.x, position.y));
        }

        every.removeAll(destroyed_objects);
        spritebatch.end();
        if(index<3 && index>previndex && !every.isEmpty()){
            sling1.setbird((Birds) every.get(0));
            previndex=index;
        }
        drawScore();
        for(Species species : destroyed_objects){
            world.destroyBody(species.body);
        }
        destroyed_objects.clear();
//        debugRenderer.render(world, camera.combined);
    }
    public void level2(){
        timer += Gdx.graphics.getDeltaTime();
        if(everybird.isEmpty()){
            loosing loose=new loosing(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(loose);
        }
        else  if(quantity()){
            winning win=new winning(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(win);
        }
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        spritebatch.setProjectionMatrix(camera.combined);
        background.setSize(WorldWidth, WorldHeight);
        Background(spritebatch);
        spritebatch.begin();
        sprite.draw(spritebatch);
//        sprite1.draw(spritebatch);
//        ground.Render(spritebatch);
//        bird1.Render(spritebatch);
//        bird2.Render(spritebatch);
//        wood1.Render(spritebatch);
//        wood2.Render(spritebatch);
//        wood3.Render(spritebatch);
//        wood4.Render(spritebatch);
//        wood5.Render(spritebatch);
//        wood6.Render(spritebatch);
//        pig1.Render(spritebatch);
//        pig2.Render(spritebatch);
//        sling1.Render(spritebatch);
//        sling2.Render(spritebatch);
//        rock.Render(spritebatch);
        ArrayList<BlastAnimation> array=new ArrayList();
        for(BlastAnimation animation : all_animations){
            if(!animation.isAnimationFinished()){
                animation.update(timer);
                spritebatch.draw(animation.getFrame(), animation.getX(), animation.getY());
            }
            else{
                array.add(animation);
            }
        }
        all_animations.removeAll(array);
        for(Species s:every){
            s.Render(spritebatch);
        }
        //System.out.println(destroyed_objects.size());
        for(Species s:destroyed_objects){
            Vector2 position = s.body.getPosition().cpy();
            all_animations.add(new BlastAnimation(position.x, position.y));
        }
        System.out.println(every.size());
        every.removeAll(destroyed_objects);
        spritebatch.end();
        if(index<3 && index>previndex && !every.isEmpty()){
            sling1.setbird((Birds) every.get(0));
            previndex=index;
        }
        drawScore();
        for(Species species : destroyed_objects){
            world.destroyBody(species.body);
        }
        destroyed_objects.clear();
//        debugRenderer.render(world, camera.combined);
    }
    public void level3(){
        timer += Gdx.graphics.getDeltaTime();
        if(every.stream().noneMatch(s -> s instanceof Birds)){
            loosing loose=new loosing(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(loose);
        }
        else if(quantity()){
            winning win=new winning(GAME,WorldWidth,WorldHeight,currentLevel);
            GAME.setScreen(win);
        }
        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        spritebatch.setProjectionMatrix(camera.combined);
        background.setSize(WorldWidth, WorldHeight);
        Background(spritebatch);
        spritebatch.begin();
        sprite.draw(spritebatch);
//        sprite1.draw(spritebatch);
//        ground.Render(spritebatch);
//        bird1.Render(spritebatch);
//        bird2.Render(spritebatch);
//        wood1.Render(spritebatch);
//        wood2.Render(spritebatch);
//        wood3.Render(spritebatch);
//        wood4.Render(spritebatch);
//        wood5.Render(spritebatch);
//        wood6.Render(spritebatch);
//        pig1.Render(spritebatch);
//        pig2.Render(spritebatch);
//        sling1.Render(spritebatch);
//        sling2.Render(spritebatch);
//        rock.Render(spritebatch);
        ArrayList<BlastAnimation> array=new ArrayList();
        for(BlastAnimation animation : all_animations){
            if(!animation.isAnimationFinished()){
                animation.update(timer);
                spritebatch.draw(animation.getFrame(), animation.getX(), animation.getY());
            }
            else{
                array.add(animation);
            }
        }
        all_animations.removeAll(array);
        for(Species s:every){
            s.Render(spritebatch);
        }
        //System.out.println(destroyed_objects.size());
        for(Species s:destroyed_objects){
            Vector2 position = s.body.getPosition().cpy();
            all_animations.add(new BlastAnimation(position.x, position.y));
        }
        System.out.println(every.size());
        every.removeAll(destroyed_objects);
        spritebatch.end();
        if(index<3 && index>previndex && !every.isEmpty()){
            sling1.setbird((Birds) every.get(0));
            previndex=index;
        }
        drawScore();
        for(Species species : destroyed_objects){
            world.destroyBody(species.body);
        }
        destroyed_objects.clear();
//        debugRenderer.render(world, camera.combined);
    }
    public void updateLevel(){

    }
    public void Background(SpriteBatch spriteBatch) {
        // Draw the background image
        spriteBatch.begin();
        background.draw(spriteBatch);
        spriteBatch.end();
    }
    public void Pause(){
        sprite=new Sprite(new Texture("pauseAI.png"));
        sprite.setSize(40,40);
//        sprite.setPosition((int) (WorldWidth- sprite.getWidth()/2-40), (int) (WorldHeight- sprite.getHeight()/2-40));
        sprite.setPosition((float) (WorldWidth*0.85),(float) (WorldHeight*0.88));
        rectangle=new Rectangle((int) sprite.getX(),(int) sprite.getY(),(int) sprite.getWidth(), (int) sprite.getHeight());
        resuming.add(this);
        inputmultiplexer.addProcessor(new InputAdapter() {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
                if (rectangle.contains(Worldcoordinates.x, Worldcoordinates.y)) {
                    GAME.setScreen(new pauseScreen(GAME,WorldWidth,WorldHeight,currentLevel));
                    return true;
                }
                return false;
            }
        });
    }
//    public void ViewScore(){
//        sprite1=new Sprite(new Texture("viewScore.png"));
//        sprite1.setSize(40,30);
////        sprite.setPosition((int) (WorldWidth/2- sprite.getWidth()/2), (int) (WorldHeight- sprite.getHeight()/2));
//        sprite1.setPosition((float) (WorldWidth*0.01),(float) (WorldHeight*0.80));
//        rect=new Rectangle((int) sprite1.getX(),(int) sprite1.getY(),(int) sprite1.getWidth(), (int) sprite1.getHeight());
//        inputmultiplexer.addProcessor(new InputAdapter() {
//            @Override
//            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//                Vector3 Worldcoordinates = camera.unproject(new Vector3( screenX, screenY,0));
//                if (rect.contains(Worldcoordinates.x, Worldcoordinates.y)) {
//                    GAME.setScreen(new Score(WorldWidth,WorldHeight));
//                    return true;
//                }
//                return false;
//            }
//        });
//    }

    @Override
    public void show() {

    }
    @Override
    public void render(float v) {
        if(currentLevel==1){
            level1();
        }
        else if(currentLevel==2){
            level2();
        }
        else{
            level3();
        }
    }
    private boolean quantity(){
        boolean isalive=true;
        for(Species s:every){
            if(s instanceof Pigs){
                isalive=false;
                return isalive;
            }
        }
        return isalive;
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
