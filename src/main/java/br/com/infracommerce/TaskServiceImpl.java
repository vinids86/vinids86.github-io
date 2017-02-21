package br.com.infracommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by vinicius on 20/02/17.
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public void moveTaskPosition() throws UnsupportedEncodingException {

        String url = "https://vinids86.kanboard.net/jsonrpc.php";
        String requestJson = "{\"jsonrpc\": \"2.0\", \"method\": \"moveTaskPosition\", \"id\": 1, \"params\":{\"project_id\": 1,\"task_id\": 1,\"column_id\": 1,\"position\": 1}}";
        String user = "jsonrpc";
        String apiToken = "2bd46f9e54f8e4d0bc0a0a11b3c2bc10bfadeec93c8c80c2efca879445ba";


        HttpHeaders headers = new HttpHeaders();
        String plainCreds = user + ":" + apiToken;
        byte[] plainCredsBytes = plainCreds.getBytes();
        String base64Creds = Base64.getEncoder().encodeToString(plainCredsBytes);
        headers.add("Authorization", "Basic " + base64Creds);

        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        RestTemplate restTemplate = new RestTemplate();
        String answer = restTemplate.postForObject(url, entity, String.class);

        System.out.println(answer);
    }
}
