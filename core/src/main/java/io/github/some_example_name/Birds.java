package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static io.github.some_example_name.LevelHandler.*;
import static java.lang.Math.PI;

public class Birds extends Species implements UPDATEINTERFACE {
    public int health = 5;
    private String url;
    public boolean islaunched=false;
    private Sprite sprite;
    public Birds(World world, int health, float x, float y, String url) {
        super(world, 100);
        this.health = health;
        sprite = new Sprite(new Texture(url));
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.DynamicBody;
        bodydef.position.set(x, y);
        this.body = world.createBody(bodydef);
        MassData massData = new MassData();
//        massData.mass = 1.0f;
//        this.body.setMassData(massData);
        CircleShape shape = new CircleShape();
        shape.setRadius(5);
        FixtureDef fixturedef = new FixtureDef();
        fixturedef.density = 0.05F;
        fixturedef.shape = shape;
        fixturedef.restitution = 0.5f;
        body.createFixture(fixturedef);
        sprite.setSize(10, 10);
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        body.setUserData("bird");

    }

    @Override
    public void updateTexture(Texture texture) {

    }

    public void launch() {

    }

    public void activateSpecialAbility() {

    }


    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setOrigin(sprite.getWidth() / 2, sprite.getHeight() / 2);
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.setRotation(body.getAngle() * MathUtils.radiansToDegrees);
        sprite.draw(spritebatch);
        if (this.health <= 0 || this.body.getPosition().y <= 0 || (this.islaunched && (this.body.getAngularVelocity() <=2) && (this.body.getLinearVelocity().len()<=2))){
            //System.out.println(true);
            LevelHandler.destroyed_objects.add(this);
            LevelHandler.index++;
        }
    }
}
