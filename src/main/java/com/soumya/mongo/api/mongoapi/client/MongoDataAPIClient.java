package com.soumya.mongo.api.mongoapi.client;

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
}
