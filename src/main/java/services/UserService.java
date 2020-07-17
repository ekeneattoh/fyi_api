package services;

import java.util.HashMap;

public class UserService {

    public String registerUser(HashMap<String, String> user_info){

        String email = user_info.get("email");
        String password = user_info.get("password");
        String firstname = user_info.get("firstname");
        String lastname = user_info.get("lastname");
        String type = user_info.get("type");

        //create a new user

        //save the user info in the db

        return "OK";
    }
}
