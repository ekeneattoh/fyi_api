package helpers;

import java.util.HashMap;

import models.ApiMessage;
import org.springframework.web.client.RestTemplate;

public class Helper {

    private Helper(){

    }

    public static String getUtilityServiceProdEndpoint(){

        return "https://securityserviceapi.herokuapp.com";
    }

    public static String getUtilityServiceDevEndpoint(){
        return "http://127.0.0.1:5000";
    }

    public static ApiMessage sendDataToDatabase(HashMap<String, String> data, String database_rest_url, RestTemplate rest_template){

        return rest_template.postForObject(database_rest_url, data, ApiMessage.class);
    }

    public static RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

}
