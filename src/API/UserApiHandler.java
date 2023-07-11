package API;

import Model.UserResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class UserApiHandler {
    public List<UserResponse> getAll()
    {
        List<UserResponse> users = new ArrayList<>();
        try {
            
            String uriString = "http://localhost:3000/users";
            URI  uri = new URI(uriString);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            ObjectMapper objectMapper = new ObjectMapper();
            users = objectMapper.readValue(responseBody, new TypeReference<List<UserResponse>>() {});
            
            return users;
        } catch (IOException | InterruptedException | URISyntaxException ex) {
            System.out.println(ex);
            return users;
        }  
    }
    
    public boolean delete(int id)
    {
        try {
            String uriString = "http://localhost:3000/users/" + id;
            URI  uri = new URI(uriString);
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(uri)
                    .header("Content-Type", "application/json")
                    .DELETE()
                    .build();
            
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();

            return statusCode != 404;
        } catch (IOException | InterruptedException | URISyntaxException ex) {
            System.out.println(ex);
            return false;
        }      
    }
}
