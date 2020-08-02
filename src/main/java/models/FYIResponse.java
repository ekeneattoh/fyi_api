package models;

public class FYIResponse {

    private String data;

    public FYIResponse(String data){
        this.data = data;
    }

    public void setData(String data){
        this.data = data;
    }

    public String getData(){
        return this.data;
    }
}
