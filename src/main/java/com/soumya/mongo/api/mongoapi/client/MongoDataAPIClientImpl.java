package com.soumya.mongo.api.mongoapi.client;

import com.soumya.mongo.api.mongoapi.properties.MongoDataApiProperties;
import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MongoDataAPIClientImpl implements MongoDataAPIClient {
    @Autowired
    MongoDataApiProperties mongoDataApiProperties;


    @Override
    public Object getAll(String collection) {
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(mongoDataApiProperties.getApiKey());
//        mongoDataApiProperties.getContext().getHeaders().clear();
//        mongoDataApiProperties.getContext().getHeaders().put("Content-Type", "application/json");
//        mongoDataApiProperties.getContext().getHeaders().put("api-key", mongoDataApiProperties.getApiKey());
        return mongoDataApiProperties.getApiKey();
    }

    @Override
    public Object getAll(String collection, String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
//        System.out.println(mongoDataApiProperties.getApiKey());
//        mongoDataApiProperties.getContext().getHeaders().clear();
//        mongoDataApiProperties.getContext().getHeaders().put("Content-Type", "application/json");
//        mongoDataApiProperties.getContext().getHeaders().put("api-key", apiKey);
        return mongoDataApiProperties.getApiKey();
    }

    /**
     * Insert Data To MongoDB.
     *
     * @param mongoDbUrl url.
     * @param apiKey     apiKey to access the resource.
     * @param insert     payload to send.
     * @return ResponseEntity response from insert request.
     */
    @Override
    public ResponseEntity<String> insertData(String mongoDbUrl, String apiKey, Insert insert) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set("api-key", apiKey);
        HttpEntity<Insert> requestInsertHttpEntity = new HttpEntity<>(insert, httpHeaders);
        ResponseEntity<Object> result = restTemplate.exchange(mongoDbUrl, HttpMethod.POST,requestInsertHttpEntity,Object.class);
//        ResponseEntity<String> result = restTemplate.postForEntity(mongoDbUrl, requestInsertHttpEntity, String.class);
        return ResponseEntity.ok(result.getBody().toString());
    }

    private ClientHttpRequestFactory getClientHttpRequest() {
        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(mongoDataApiProperties.getTimeout())
                .setConnectionRequestTimeout(mongoDataApiProperties.getRequestTimeout())
                .setSocketTimeout(mongoDataApiProperties.getSocketTimeout())
                .build();
        CloseableHttpClient closeableHttpClient = HttpClientBuilder
                .create()
                .setDefaultRequestConfig(config)
                .build();
        return new HttpComponentsClientHttpRequestFactory(closeableHttpClient);
    }
}