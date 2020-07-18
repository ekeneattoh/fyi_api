package models;

import java.time.Instant;
import java.util.HashMap;

import org.apache.commons.lang3.RandomStringUtils;

public abstract class User {

    private final String email;
    private final String password;
    private final String firstname;
    private final String lastname;
    private String username;
    private String account_type;

    private final HashMap<String, String> user_info = new HashMap<String, String>();

    public User(String email, String password, String firstname,
                String lastname, String account_type ){
         this.email = email;
         this.password = password;
         this.firstname = firstname;
         this.lastname = lastname;
         this.account_type = account_type;
    }

    public HashMap<String, String> getUserInfo() {

        user_info.put("user_email", email);
        user_info.put("password", password);
        user_info.put("firstname", firstname);
        user_info.put("lastname", lastname);
        user_info.put("username", username);
        user_info.put("account_type", account_type);

        return user_info;
    }

    public void setUserName(){


        this.username = this.firstname + this.lastname + String.valueOf( (Instant.now().getEpochSecond()) );
    }

    public String getUsername(){
        return this.username;
    }

    public void setAccountType(String account_type){

        this.account_type = account_type;
    }

    public String getAccountType(){

        return this.account_type;
    }

}
