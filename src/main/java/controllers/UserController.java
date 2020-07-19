package controllers;

import helpers.Helper;
import models.ApiStringMessage;
import models.BasicUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import services.UserService;


@RestController
public class UserController {

    private final UserService user_service;
    private final RestTemplate template;

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
    public ApiStringMessage register(@RequestBody BasicUser incoming_user) {

        String UTILITY_URL = Helper.getUtilityServiceDevEndpoint();

        String encryption_url = UTILITY_URL +"/encrypt";

        final String collection_name = "users";
        String user_email = incoming_user.getUserInfo().get("email");
        String account_type = incoming_user.getUserInfo().get("account_type");

        String db_prod_url = UTILITY_URL +
                "/" + collection_name + "/" + user_email + "/add";

        return user_service.registerUser(account_type, incoming_user, db_prod_url, encryption_url , template);
    }
}
