package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import net.dermetfan.gdx.physics.box2d.PositionController;

public class Slinshottwo extends Species {
    private final Sprite sprite;
    private Birds bird;

    public Slinshottwo(World world, float x, float y, float width, float height, String path) {
        super(world,1000);
        sprite = new Sprite(new Texture(path));
        BodyDef bodydef = new BodyDef();
        bodydef.type = BodyDef.BodyType.StaticBody;
        bodydef.position.set(x, y);
        this.body = world.createBody(bodydef);
        MassData massData = new MassData();
        massData.mass = 4.0f;
        this.body.setMassData(massData);
        PolygonShape rectangle = new PolygonShape();
        rectangle.setAsBox(width / 2, height / 2);
        FixtureDef fixturedef = new FixtureDef();
        fixturedef.shape = rectangle;
        fixturedef.restitution = 0.2f;
        body.createFixture(fixturedef);
        sprite.setSize(width, height);
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        body.setUserData("slingshot");
    }

    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setPosition(body.getPosition().x- sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);

        sprite.draw(spritebatch);

    }
}
