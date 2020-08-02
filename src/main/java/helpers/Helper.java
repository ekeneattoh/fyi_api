package helpers;

import java.util.HashMap;

import models.ApiStringMessage;
import org.springframework.web.client.RestTemplate;

public class Helper {

    private Helper(){

    }

    public static String getUtilityServiceProdEndpoint(){

        return "";
    }

    public static String getUtilityServiceDevEndpoint(){
        return "http://127.0.0.1:5000";
    }

    public static ApiStringMessage queryUtilityService(HashMap<String, Object> data, String service_url, RestTemplate rest_template){

        return rest_template.postForObject(service_url, data, ApiStringMessage.class);
    }


}
