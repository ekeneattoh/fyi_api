package helpers;

import java.util.HashMap;
import org.springframework.web.client.RestTemplate;

//Singleton class
public class Helper {

    private static final Helper instance = new Helper();

    private Helper(){

    }

    public static Helper getInstance(){

        return instance;
    }

    public static String sendDataToDatabase(HashMap<String, String> data, String database_rest_url, RestTemplate rest_template){

        String response = rest_template.getForObject(database_rest_url, String.class);

        return response;
    }
}
