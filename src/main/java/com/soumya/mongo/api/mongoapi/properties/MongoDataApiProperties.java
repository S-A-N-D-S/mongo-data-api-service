package com.soumya.mongo.api.mongoapi.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "sm.spring.data.api")
@Data
@Component
public class MongoDataApiProperties {
//    @Autowired
//    private RestApiContext context;
    private String apiKey;
    private String dataSource;
    private String database;
    private String mongoDbUrl;
    private Integer maxConnectionPoolSize;
    private Integer maxConnectionRoutes;
    private Integer timeout;
    private Integer requestTimeout;
    private Integer socketTimeout;
    private Boolean proxy;
    private String proxyHost;
    private Integer proxyPort;
    private String proxyUsername;
    private String proxyPassword;
}
