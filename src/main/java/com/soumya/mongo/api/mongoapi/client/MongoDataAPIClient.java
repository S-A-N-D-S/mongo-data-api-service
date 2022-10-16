package com.soumya.mongo.api.mongoapi.client;

import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import org.springframework.http.ResponseEntity;

public interface MongoDataAPIClient {
    /**
     * get all data using property configured data.
     * @param collection name of collection.
     * @return The result of Mongo DB API.
     */
    Object getAll(String collection);

    /**
     * get all data from configurable data endpoint.
     * @param collection name of collection.
     * @param apiKey apiKey of mongo data api.
     * @return The result of Mongo DB API.
     */
    Object getAll(String collection , String apiKey);

    /**
     * Insert Data To MongoDB.
     * @param mongoDbUrl url.
     * @param apiKey apiKey to access the resource.
     * @param insert payload to send.
     * @return ResponseEntity response from insert request.
     */
    ResponseEntity<String> insertData(String mongoDbUrl, String apiKey, Insert insert);
}
