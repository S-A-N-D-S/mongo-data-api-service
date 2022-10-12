package com.soumya.mongo.api.mongoapi.client;

import com.soumya.mongo.api.mongoapi.properties.MongoDataApiProperties;
import com.soumya.mongo.api.mongoapi.properties.RestApiContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MongoDataAPIClientImpl implements MongoDataAPIClient{
    @Autowired
    MongoDataApiProperties mongoDataApiProperties;

    @Override
    public Object getAll(String collection) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(mongoDataApiProperties.getApiKey());
        mongoDataApiProperties.getContext().getHeaders().clear();
        mongoDataApiProperties.getContext().getHeaders().put("Content-Type","application/json");
        mongoDataApiProperties.getContext().getHeaders().put("api-key", mongoDataApiProperties.getApiKey());
        return mongoDataApiProperties.getApiKey();
    }

    @Override
    public Object getAll(String collection , String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(mongoDataApiProperties.getApiKey());
        mongoDataApiProperties.getContext().getHeaders().clear();
        mongoDataApiProperties.getContext().getHeaders().put("Content-Type","application/json");
        mongoDataApiProperties.getContext().getHeaders().put("api-key", apiKey);
        return mongoDataApiProperties.getApiKey();
    }
}