package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

class game extends Game {
    @Override
    public void create() {
        Screen menu=new Options(this);
        GameMain.record.add(menu);
        this.setScreen(menu);
    }

    public void render(){
        this.getScreen().render(Gdx.graphics.getDeltaTime());
    }
    public void resize(int width,int height){
        this.getScreen().resize(width,height);
    }
}
