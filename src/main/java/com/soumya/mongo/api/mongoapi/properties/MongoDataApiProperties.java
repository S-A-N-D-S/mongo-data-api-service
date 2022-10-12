package com.soumya.mongo.api.mongoapi.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sm.spring.data.api")
@Data
@Component
public class MongoDataApiProperties {
    @Autowired
    private RestApiContext context;
    private String apiKey;
    private String dataSource;
    private String database;
    private String mongoDbUrl;
}
