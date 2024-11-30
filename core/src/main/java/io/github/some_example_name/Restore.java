package io.github.some_example_name;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Json;

import java.util.Map;


public class Restore{
    private Json js;
    private com.badlogic.gdx.Preferences preferences=Gdx.app.getPreferences("database");
    public Restore(){
        js=new Json();
    }
    public void Saving(int level,String score){
        wrapper wr=new wrapper();
        wr.setvalue(String.valueOf(level),Integer.parseInt(score));
        String jsonData = js.toJson(Integer.parseInt(score));
        preferences.putString(String.valueOf(level), jsonData);
        preferences.flush();

    }
    public Preferences getPreferences(){
        return this.preferences;
    }

//    public Map<String, Integer> loading(int level){
//        String sr=preferences.getString(String.valueOf(level),"{}");
//        wrapper wr=js.fromJson(wrapper.class,sr);
//        return wr.mapping;
//    }
}
