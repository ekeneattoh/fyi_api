package controllers;

import helpers.Helper;
import models.ApiMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import services.UserService;

import java.util.HashMap;

@RestController
public class UserController {

    private UserService user_service;

    @Autowired
    public UserController(UserService user_service){

        this.user_service = user_service; //constructor based dependency injection
    }


    @GetMapping("/")
    public String homePage(){

        return "Random FYIs";
    }

    @PostMapping("/account")
    public ApiMessage register(@RequestBody HashMap<Object, Object> payload){

        String db_prod_url = Helper.getUtilityServiceDevEndpoint();

         final String collection_name = "users";
         String user_email = (String)payload.get("email");

         final RestTemplate template = Helper.getRestTemplate();

         return user_service.registerUser(payload,
                 ( db_prod_url + "/"+collection_name + "/" + user_email + "/add"), template);
    }
}
