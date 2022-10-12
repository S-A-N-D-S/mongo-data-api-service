package com.soumya.mongo.api.mongoapi.properties;

import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestApiContext {
    private Map<String, String> headers = new HashMap<>();
    private Response response;
    private Map<String, JSONObject> requestBody = new HashMap<>();
    private HttpRequest.Builder builder = new HttpRequest.Builder();
    private Map<String, String> pathParams = new HashMap<>();
    private Map<String, String> params = new HashMap<>();
    private String mandatoryFields;

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public HttpRequest.Builder getBuilder() {
        return builder;
    }

    public void setBuilder(HttpRequest.Builder builder) {
        this.builder = builder;
    }

    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public String getMandatoryFields() {
        return mandatoryFields;
    }

    public Map<String, JSONObject> getRequestBody() {
        return requestBody;
    }

    public void setMandatoryFields(String mandatoryFields, String mandatoryValues) {
        List<String> key = Arrays.asList(mandatoryFields.split("\\s*,\\s*"));
        List<String> val = Arrays.asList(mandatoryValues.split("\\s*,\\s*"));
        int count = key.size();
        int i = 0;
        while (count >= i + 1) {
            getParams().put(key.get(i), val.get(i));
            System.out.println(getParams());
            i++;
        }
        this.mandatoryFields = mandatoryFields;
    }

}
