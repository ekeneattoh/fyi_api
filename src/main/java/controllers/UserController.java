package controllers;

import helpers.Helper;
import models.ApiStringMessage;
import models.BasicUser;
import models.FYIErrorResponse;
import models.FYIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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

    private final String UTILITY_URL;
    private final String user_info_collection_name;
    private final String user_fyi_collection_name;

    @Autowired
    public UserController(UserService user_service, RestTemplate template) {

        //constructor based dependency injection

        this.user_service = user_service;
        this.template = template;

        UTILITY_URL = Helper.getUtilityServiceDevEndpoint();
        user_info_collection_name = "user_info";
        user_fyi_collection_name = "fyis";
    }


    @GetMapping("/")
    public String homePage() {

        return "Random FYIs";
    }

    @PostMapping("/account")
    public FYIResponse register(@Valid @RequestBody BasicUser incoming_user, BindingResult bindingResult) {

        String encryption_url = UTILITY_URL +"/encrypt";

        String user_email = (String) ( incoming_user.getUserInfo().get("email") );
        String account_type = (String) incoming_user.getUserInfo().get("account_type");

        String db_user_info_prod_url = UTILITY_URL +
                "/" + user_info_collection_name + "/" + user_email + "/add";

        String db_user_fyi_prod_url = UTILITY_URL +
                "/" + user_fyi_collection_name + "/" + user_email + "/add";

        if(bindingResult.hasErrors()){
            return new FYIErrorResponse(bindingResult.toString());
        }

        return user_service.registerUser(account_type, incoming_user, db_user_info_prod_url,
                db_user_fyi_prod_url, encryption_url , template);
    }
}
