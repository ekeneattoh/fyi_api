package services;

import helpers.Helper;
import models.*;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.HashMap;

public class UserService {

    public UserService(){

    }

    public FYIResponse registerUser(String account_type, User incoming_user, String user_info_db_url, String fyi_db_url,
                                    String encryption_url, RestTemplate rest_template){

        //create a new user
        User new_user = UserFactory.getUser(account_type, incoming_user);

        //set the username
        new_user.setUserName();

        //encrypt the user supplied password
        HashMap<String, Object > plain_password_data = new HashMap<>();
        plain_password_data.put("plain_data", incoming_user.getPassword());

        String encrypted_password = (String) ( Helper.queryUtilityService(plain_password_data,encryption_url,rest_template ) ).getData();

        final String successful_db_response = "Data added!";

        //set the encrypted password for the user
        new_user.setPassword(encrypted_password);

        //save the user info in the db
        ApiStringMessage db_response =  Helper.queryUtilityService(new_user.getUserInfo(), user_info_db_url, rest_template);

        /*
            create FYI collection for the user
            This is a josn document with username and a list of fyi strings
         */
        HashMap<String, Object>fyis = new HashMap<>();
        fyis.put("username", new_user.getUsername());
        fyis.put("fyis", new ArrayList<String>());
        ApiStringMessage fyi_db_response = Helper.queryUtilityService(fyis, fyi_db_url, rest_template);

        /*
            if you get a successful response from adding data to the database
            return the username to the client
            otherwise, return the response of the database service
         */
        if ( db_response.getData().equals(successful_db_response) &&
                fyi_db_response.getData().equals(successful_db_response) ){
           return new FYIResponse(new_user.getUsername());
        }
        else {
            return new FYIErrorResponse(db_response.getData());
        }

    }
}
