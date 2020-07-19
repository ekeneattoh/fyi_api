package controllers;

import helpers.Helper;
import models.ApiStringMessage;
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
    private RestTemplate template;

    @Autowired
    public UserController(UserService user_service, RestTemplate template) {

        //constructor based dependency injection

        this.user_service = user_service;
        this.template = template;
    }


    @GetMapping("/")
    public String homePage() {

        return "Random FYIs";
    }

    @PostMapping("/account")
    public ApiStringMessage register(@RequestBody HashMap<Object, Object> payload) {

        String UTILITY_URL = Helper.getUtilityServiceDevEndpoint();

        String encryption_url = UTILITY_URL +"/encrypt";

        final String collection_name = "users";
        String user_email = (String) payload.get("email");

        String db_prod_url = UTILITY_URL +
                "/" + collection_name + "/" + user_email + "/add";

        return user_service.registerUser(payload, db_prod_url, encryption_url , template);
    }
}
