package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;

import javax.swing.*;

public class Rocks extends Species implements UPDATEINTERFACE{
    //public int health=120;
    public Rocks( World world,float x,float y){
        super(world, 40);
        sprite=new Sprite(new TextureRegion(new Texture("angry-icon.png")),2,580,32,27);
        BodyDef bodydef=new BodyDef();
        bodydef.type= BodyDef.BodyType.DynamicBody;
        bodydef.position.set(x,y);
        this.body=world.createBody(bodydef);
        MassData massData = new MassData();
        massData.mass = 1.0f;
        this.body.setMassData(massData);
        CircleShape shape= new CircleShape();
        shape.setRadius(15);
        FixtureDef fixturedef=new FixtureDef();
        fixturedef.shape=shape;
        fixturedef.restitution = 0.1f;
        body.createFixture(fixturedef);
        sprite.setSize(30,30);
        sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
    }
    @Override
    public void updateTexture(Texture texture){

    }

    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setPosition(body.getPosition().x- sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        sprite.draw(spritebatch);
        if(this.health<=0){
            //world.destroyBody(this.body);
            LevelHandler.destroyed_objects.add(this);
        }
    }
}
