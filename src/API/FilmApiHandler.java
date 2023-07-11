/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package API;

import Model.FilmRequestResponse;
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
public class FilmApiHandler {
    public List<FilmRequestResponse> getAll()
    {
        List<FilmRequestResponse> films = new ArrayList<>();
        try {
            
            String uriString = "http://localhost:3000/films";
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
            films = objectMapper.readValue(responseBody, new TypeReference<List<FilmRequestResponse>>() {});
            
            return films;
        } catch (IOException | InterruptedException | URISyntaxException ex) {
            System.out.println(ex);
            return films;
        }  
    }
    
    public FilmRequestResponse getById(int id)
    {
        FilmRequestResponse films = new FilmRequestResponse();
        try {
            
            String uriString = "http://localhost:3000/films/"+id;
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
            films = objectMapper.readValue(responseBody, FilmRequestResponse.class);
            
            return films;
        } catch (IOException | InterruptedException | URISyntaxException ex) {
            System.out.println(ex);
            return films;
        }  
    }
    
    public boolean create(FilmRequestResponse filmRequest){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPayload = objectMapper.writeValueAsString(filmRequest);
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:3000/films"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                .build();

            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            
            return statusCode != 404;
        } catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean delete(int id)
    {
        try {
            String uriString = "http://localhost:3000/films/" + id;
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
