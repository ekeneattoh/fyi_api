package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiMessage {

    private Object data;

    public ApiMessage(){
    }

    public void setData(String data){
        this.data = data;
    }

    public void setData(HashMap<String, String> data){

        this.data = data;
    }

    public void setData(ArrayList<String> data){
        this.data = data;
    }

    public Object getData(){
        return this.data;
    }
}
