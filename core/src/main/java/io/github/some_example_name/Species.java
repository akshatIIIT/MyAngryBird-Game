package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import static io.github.some_example_name.LevelHandler.every;

abstract public class Species {
    public int health;
    protected Texture texture;
    protected Body body;
    protected Sprite sprite;
    protected World world;
    public Species(World world, int health){
        this.world=world;
        this.health = health;
        every.add(this);
    }

    abstract void Render(SpriteBatch spritebatch);

}
