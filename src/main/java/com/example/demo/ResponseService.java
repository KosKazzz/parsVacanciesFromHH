package com.example.demo;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResponseService {
    RestTemplate restTemplate = new RestTemplate();
    String resourceUrl = "https://api.hh.ru/vacancies?text=";
    String parameters = "&";

    // TODO @getResponse should receive parameter
    // add header 'User-Agent: api-test-agent'
    public String getResponse(String requestToHH) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("User-Agent", "MyApp/1.0 (my-app-feedback@example.com)");
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);
        //ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl+requestToHH, String.class);
        ResponseEntity<String> response = restTemplate.exchange(resourceUrl + requestToHH, HttpMethod.GET, requestEntity, String.class);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return "ERROR!!! Something going wrong!!!!";
        }
    }
}
