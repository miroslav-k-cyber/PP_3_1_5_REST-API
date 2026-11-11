package ru.kata.pp_3_1_5_restapi;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RestApiClient {
    
    private static final String API_URL = "http://94.198.50.185:7081/api/users";
    
    public String getDataFromUrl() {
        RestTemplate restTemplate = new RestTemplate();
        
        // 1. GET-запрос, получаем куки
        ResponseEntity<String> getResponse = restTemplate.getForEntity(API_URL, String.class);
        String cookie = getResponse.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        
        // Создаем заголовки
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(HttpHeaders.COOKIE, cookie);
        
        // POST-запрос - создаем пользователя
        User newUser = new User(3L, "James", "Brown", (byte) 25);
        String cod1 = sendRequest(restTemplate, HttpMethod.POST, newUser, API_URL, httpHeaders);
        System.out.println("POST: " + cod1);
        
        // PUT-запрос, изменяем пользователя
        User updatedUser = new User(3L, "Thomas", "Shelby", (byte) 25);
        String cod2 = sendRequest(restTemplate, HttpMethod.PUT, updatedUser, API_URL, httpHeaders);
        System.out.println("PUT: " + cod2);
        
        // DELETE-запрос, удаляем пользователя по id
        String cod3 = sendRequest(restTemplate, HttpMethod.DELETE, null, API_URL + "/3", httpHeaders);
        System.out.println("DELETE: " + cod3);
        return cod1 + cod2 + cod3;
    }

    
    // Метод делает все нужные запросы - POST, PUT, DELETE.
    private String sendRequest(RestTemplate restTemplate, HttpMethod method, User user, String url, HttpHeaders headers) {
        HttpEntity<User> request = new HttpEntity<>(user, headers);
        
        try {
            ResponseEntity<String> response = restTemplate.exchange(url, method, request, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            System.out.println("!!! ОШИБКА при запросе " + method + " !!!");
            System.out.println("Статус: " + e.getStatusCode());
            System.out.println("Тело ответа: " + e.getResponseBodyAsString());
            return "";
        }
    }
    
}