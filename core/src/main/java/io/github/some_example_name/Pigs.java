package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

public class Pigs extends Species implements UPDATEINTERFACE{
    private boolean isAlive=true;
    private Sprite sprite;
    public Pigs(World world,float x,float y){
        super(world,10);
        sprite =new Sprite(new TextureRegion(new Texture("angry-icon.png")),41,11,126,144);
        BodyDef bodydef=new BodyDef();
        bodydef.type= BodyDef.BodyType.DynamicBody;
        bodydef.position.set(x,y);
        this.body=world.createBody(bodydef);
        MassData massData = new MassData();
        massData.mass = 2.0f;
        CircleShape shape=new CircleShape();
        shape.setRadius(20);
        massData.I= (float) ((massData.mass*(Math.pow(shape.getRadius(),2)))/2);
        this.body.setMassData(massData);
        FixtureDef fixturedef=new FixtureDef();
        fixturedef.shape=shape;
        fixturedef.restitution = 0.5f;
        body.createFixture(fixturedef);
        sprite.setSize(40,40);
        sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
    }

    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        sprite.setPosition(body.getPosition().x- sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        sprite.setRotation(body.getAngle()* MathUtils.radiansToDegrees);

        sprite.draw(spritebatch);
        if(this.health<=0 || body.getPosition().y < 0){
            //world.destroyBody(this.body);
            LevelHandler.destroyed_objects.add(this);
        }
    }

    @Override
    public void updateTexture(Texture texture){

    }

    public void setisAlive(){
        this.isAlive=false;
    }
    public boolean getisAlive(){
        return this.isAlive;
    }
}
