package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

public class Wood extends Species implements UPDATEINTERFACE{
    private int durability;
    private Sprite sprite;
    private SpriteBatch spritebatch;
    //public int health=100;
    public Wood( World world,float WorldWidth,float WorldHeight,float x,float y,boolean orientation,float width,float height,String path){
        super(world, 30);
        sprite=new Sprite(new Texture(path));
        BodyDef bodydef=new BodyDef();
        bodydef.type= BodyDef.BodyType.DynamicBody;
        bodydef.position.set(x,y);
        this.body=world.createBody(bodydef);
        MassData massData = new MassData();
        massData.mass = 1.0f;
        massData.I= (float) ((massData.mass*(Math.pow(height,2)))/12);
        this.body.setMassData(massData);
        PolygonShape rectangle=new PolygonShape();
        rectangle.setAsBox(width/2,height/2);
        FixtureDef fixturedef=new FixtureDef();
        fixturedef.shape=rectangle;
        fixturedef.restitution = 0.2f;
        fixturedef.friction= 0.5F;
        body.createFixture(fixturedef);
        sprite.setSize(width+5,height+3);
        sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        if(orientation){
            this.body.setTransform(body.getPosition().x,body.getPosition().y, (float) (Math.PI/2));
            sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
            sprite.setRotation(90);
            sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        }
    }
    @Override
    public void updateTexture(Texture texture){

    }
    public void Render(SpriteBatch spritebatch){
        sprite.setOrigin(sprite.getWidth()/2,sprite.getHeight()/2);
        sprite.setRotation((float) (body.getAngle()* MathUtils.radiansToDegrees));
        sprite.setPosition(body.getPosition().x- sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        sprite.draw(spritebatch);
        if(this.health<=0){
            //world.destroyBody(this.body);
            LevelHandler.destroyed_objects.add(this);
        }
    }
    public void setdurability(int durability){
        this.durability=durability;
    }
    public int getdurability(){

        return this.durability;
    }

}
