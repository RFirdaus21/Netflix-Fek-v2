package API;

import Model.LoginRequest;
import Model.LoginResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Administrator
 */
public class LoginApiHandler {
    public String login(String username, String password){
        try {
            LoginRequest loginRequest = new LoginRequest();
            loginRequest.setUsername(username);
            loginRequest.setPassword(password);
            
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(loginRequest);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:3000/login"))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(jsonPayload))
                .build();

            HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

            int statusCode = response.statusCode();

            if(statusCode == 404){
                return "";
            }
            
            String responseBody = response.body();
            LoginResponse user = objectMapper.readValue(responseBody, LoginResponse.class);
            
            return user.getRole();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e);
            return "";
        }
    }
}
