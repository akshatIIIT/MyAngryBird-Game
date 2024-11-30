package io.github.some_example_name;

import java.util.HashMap;
import java.util.Map;

public class wrapper {
    public Map<String,Integer> mapping;
    public wrapper(){
        mapping=new HashMap<>();
    }
    public int getvalue(String key){
        return mapping.get(key);
    }
    public void setvalue(String key,int value){
        mapping.put(key,value);
    }
}
