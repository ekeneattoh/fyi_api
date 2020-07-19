package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiStringMessage {

    private String data;

    public ApiStringMessage(){
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }
}
