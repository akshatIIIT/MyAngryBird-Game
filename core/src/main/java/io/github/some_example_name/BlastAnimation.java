package io.github.some_example_name;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BlastAnimation {
    private Animation<Sprite> animation;
    private Sprite sprite1 = new Sprite(new Texture("angry-icon.png"), 387, 777, 92, 87);
    private Sprite sprite2 = new Sprite(new Texture("angry-icon.png"), 40, 836, 112, 109);
    private Sprite sprite3 = new Sprite(new Texture("angry-icon.png"), 314, 157, 132, 130);
    private float timer = 0;
    private float x, y;

    public BlastAnimation(float x, float y){
        sprite1.setSize(50, 50);
        sprite2.setSize(50, 50);
        sprite3.setSize(50, 50);
        animation = new Animation<>(0.2f, sprite1, sprite2, sprite3);
        this.x = x;
        this.y = y;
    }

    public void update(float deltatime){
        timer += deltatime;
    }

    public Sprite getFrame(){
        return animation.getKeyFrame(timer);
    }

    public boolean isAnimationFinished(){
        return animation.isAnimationFinished(timer);
    }

    public float getX(){
        return x - animation.getKeyFrame(timer).getWidth()/2;
    }

    public float getY(){
        return y - animation.getKeyFrame(timer).getHeight()/2;
    }
}
