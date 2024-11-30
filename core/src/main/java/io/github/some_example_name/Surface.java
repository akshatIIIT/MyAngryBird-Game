package io.github.some_example_name;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;

public class Surface extends Species{
    public Surface(World world, float worldwidth, float worldheight){
        super(world,100000);
        Sprite s = new Sprite(new Texture("gr.png"));
        s.setSize(worldwidth, 125);
        this.sprite = s;
        BodyDef bodydef=new BodyDef();
        bodydef.position.set(worldwidth/2,34);
        bodydef.type= BodyDef.BodyType.StaticBody;
        this.body=world.createBody(bodydef);
        MassData massData = new MassData();
        massData.mass = 5.0f;
        this.body.setMassData(massData);
        FixtureDef fixturedef=new FixtureDef();
        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(worldwidth/2, 34);
        fixturedef.shape = polygonShape;
        fixturedef.density = 0.0f;
        body.createFixture(fixturedef);
        sprite.setPosition(body.getPosition().x-sprite.getWidth()/2,body.getPosition().y- sprite.getHeight()/2);
    }
    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setPosition(body.getPosition().x- sprite.getWidth()/2,body.getPosition().y-sprite.getHeight()/2);
        sprite.draw(spritebatch);
    }
}
