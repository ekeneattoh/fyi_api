package controllers;

import helpers.Helper;
import models.ApiStringMessage;
import models.BasicUser;
import models.FYIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import services.UserService;

import javax.validation.Valid;


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
    public FYIResponse register(@Valid @RequestBody BasicUser incoming_user) {

        String UTILITY_URL = Helper.getUtilityServiceDevEndpoint();

        String encryption_url = UTILITY_URL +"/encrypt";

        final String user_info_collection_name = "user_info";
        final String user_fyi_collection_name = "fyis";

        String user_email = (String) ( incoming_user.getUserInfo().get("email") );
        String account_type = (String) incoming_user.getUserInfo().get("account_type");

        String db_user_info_prod_url = UTILITY_URL +
                "/" + user_info_collection_name + "/" + user_email + "/add";

        String db_user_fyi_prod_url = UTILITY_URL +
                "/" + user_fyi_collection_name + "/" + user_email + "/add";

        return user_service.registerUser(account_type, incoming_user, db_user_info_prod_url,
                db_user_fyi_prod_url, encryption_url , template);
    }
}
