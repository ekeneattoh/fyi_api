package services;

import helpers.Helper;
import models.ApiStringMessage;
import models.User;
import models.UserFactory;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

public class UserService {

    public UserService(){

    }

    public ApiStringMessage registerUser(HashMap<Object, Object> incoming_user_data, String db_url, String encryption_url, RestTemplate rest_template){

        String email = (String)incoming_user_data.get("email");
        String password = (String)incoming_user_data.get("password");
        String firstname = (String)incoming_user_data.get("firstname");
        String lastname = (String)incoming_user_data.get("lastname");
        String account_type = (String)incoming_user_data.get("account_type");

        //create a new user
        User new_user = UserFactory.getUser(email, password, firstname, lastname, account_type);

        //set the username
        new_user.setUserName();

        //encrypt the user supplied password
        HashMap<String, String > plain_password_data = new HashMap<String, String>();
        plain_password_data.put("plain_data", (String)incoming_user_data.get("password"));

        String encrypted_password = (String) ( Helper.queryUtilityService(plain_password_data,encryption_url,rest_template ) ).getData();

        //set the encrypted password for the user
        new_user.setPassword(encrypted_password);

        //save the user info in the db
        return Helper.queryUtilityService(new_user.getUserInfo(), db_url, rest_template);
    }
}
