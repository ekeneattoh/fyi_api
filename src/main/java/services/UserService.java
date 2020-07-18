package services;

import helpers.Helper;
import models.ApiMessage;
import models.User;
import models.UserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class UserService {

    public UserService(){

    }

    public ApiMessage registerUser(HashMap<Object, Object> user_info, String db_url, RestTemplate rest_template){

        String email = (String)user_info.get("email");
        String password = (String)user_info.get("password");
        String firstname = (String)user_info.get("firstname");
        String lastname = (String)user_info.get("lastname");
        String account_type = (String)user_info.get("account_type");

        //create a new user
        User new_user = UserFactory.getUser(email, password, firstname, lastname, account_type);

        //set the username
        new_user.setUserName();

        //save the user info in the db

        return Helper.sendDataToDatabase(new_user.getUserInfo(), db_url, rest_template);
    }
}
