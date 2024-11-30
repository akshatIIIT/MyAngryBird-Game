package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.joints.MouseJoint;
import com.badlogic.gdx.physics.box2d.joints.MouseJointDef;
import com.badlogic.gdx.physics.box2d.joints.RopeJoint;
import com.badlogic.gdx.physics.box2d.joints.RopeJointDef;

public class Slingshot extends Species {
    private final Sprite sprite;
    private Birds bird;
    private InputMultiplexer inputmultiplexer;
    private OrthographicCamera camera;
    private MouseJoint mouseJoint;
    private Body staticAnchorBody; // Anchor body for the rope joint
    private RopeJoint ropeJoint;
    public Slingshot(World world, float x, float y, float width, float height, String path, InputMultiplexer inputmultiplexer, OrthographicCamera camera, Birds bird) {
        super(world,1000);
        this.bird = bird;
        this.bird.body.setType(BodyDef.BodyType.StaticBody); // Initial body type
        this.inputmultiplexer = inputmultiplexer;
        this.camera = camera;
        sprite = new Sprite(new Texture(path));
        sprite.setSize(width, height);
        sprite.setPosition(x - width / 2, y - height / 2);
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
        rectangle.dispose();
        body.setUserData("slingshot");
        BodyDef anchorDef = new BodyDef();
        anchorDef.type = BodyDef.BodyType.StaticBody;
        anchorDef.position.set(bird.body.getPosition());
        staticAnchorBody = world.createBody(anchorDef);
    }
    public void setbird(Birds bird){
        this.bird=bird;
        this.bird.body.setType(BodyDef.BodyType.StaticBody);
        this.bird.body.setTransform(120,105,this.bird.body.getAngle());
        slingShotAction();
    }
    @Override
    void Render(SpriteBatch spritebatch) {
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.draw(spritebatch);
    }

    public void slingShotAction() {
        if (bird != null) {
            RopeJointDef ropeJointDef = new RopeJointDef();
            ropeJointDef.bodyA = bird.body;
            ropeJointDef.bodyB = staticAnchorBody;
            ropeJointDef.localAnchorA.set(0, 0);
            ropeJointDef.localAnchorB.set(0, 0);
            ropeJointDef.maxLength = 30f; // Adjusted max length for better flexibility
            ropeJoint = (RopeJoint) world.createJoint(ropeJointDef);
            inputmultiplexer.addProcessor(new InputAdapter() {
                private Vector2 screenToWorld(int screenX, int screenY) {
                    Vector3 unprojected = camera.unproject(new Vector3(screenX, screenY, 0));
                    return new Vector2(unprojected.x, unprojected.y);
                }
                @Override
                public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                    Vector2 vect = screenToWorld(screenX, screenY);
                    if (bird.body.getWorldCenter().dst(vect) <= bird.body.getFixtureList().get(0).getShape().getRadius()) {
                        bird.body.setType(BodyDef.BodyType.DynamicBody); // Set to dynamic on drag
                        MouseJointDef mouseJointDef = new MouseJointDef();
                        mouseJointDef.bodyA = staticAnchorBody;
                        mouseJointDef.bodyB = bird.body;
                        mouseJointDef.target.set(vect);
                        mouseJointDef.maxForce = 20000f; // Higher force for better control
                        mouseJoint = (MouseJoint) world.createJoint(mouseJointDef);
                    }
                    return true;
                }
                @Override
                public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                    if (mouseJoint != null) {
                        if (bird.body.getWorldCenter().dst(staticAnchorBody.getWorldCenter()) <= 4) {
                            // Snap back to the original position
                            world.destroyJoint(mouseJoint);
                            bird.body.setTransform(staticAnchorBody.getPosition(), bird.body.getAngle());
                            bird.body.setType(BodyDef.BodyType.StaticBody);
                        } else {

                            bird.body.setType(BodyDef.BodyType.DynamicBody);
                            Vector2 force = staticAnchorBody.getWorldCenter().sub(bird.body.getWorldCenter()).nor().scl(500);
                            bird.body.applyLinearImpulse(force, bird.body.getWorldCenter(), true);
                            world.destroyJoint(mouseJoint);
                            world.destroyJoint(ropeJoint);
                            bird.islaunched=true;
                            inputmultiplexer.removeProcessor(this);
                        }
                        mouseJoint = null;
                    }
                    return true;
                }
                @Override
                public boolean touchDragged(int screenX, int screenY, int pointer) {
                    if (mouseJoint != null) {
                        Vector2 target = screenToWorld(screenX, screenY);
                        mouseJoint.setTarget(target); // Update target
                    }
                    return true;
                }
            });
        }
    }
}
