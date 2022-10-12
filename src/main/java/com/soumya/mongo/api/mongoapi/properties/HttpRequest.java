package com.soumya.mongo.api.mongoapi.properties;

import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class HttpRequest {
    private static final Logger LOGGER = LogManager.getLogger(HttpRequest.class);
    private String endpoint;
    private Map<String, String> pathParams;
    private Map<String, String> headers;
    private Map<String, String> params;
    private Object requestBody;
    private boolean isProxy;

    public HttpRequest(HttpRequest.Builder builder) {
        this.endpoint = builder.endpoint;
        this.headers = builder.headers;
        this.pathParams = builder.pathParams;
        this.params = builder.params;
        this.requestBody = builder.requestBody;
        this.isProxy = builder.isProxy;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    Map<String, String> getPathParams() {
        return this.pathParams;
    }

    Map<String, String> getParams() {
        return this.params;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    Object getRequestBody() {
        return this.requestBody;
    }

    boolean isProxy() {
        return this.isProxy;
    }

    public static class Builder {
        private Map<String, String> params;
        private String endpoint;
        private Map<String, String> pathParams;
        private Map<String, String> headers;
        private Object requestBody;
        private boolean isProxy = false;

        public Builder() {
        }

        public HttpRequest.Builder withEndpoint(String endpoint) {
            HttpRequest.LOGGER.debug("Building http request with endpoint: " + endpoint);
            this.endpoint = endpoint;
            return this;
        }

        public HttpRequest.Builder withPathParams(Map<String, String> pathParams) {
            HttpRequest.LOGGER.debug("Building http request with path params.");
            this.pathParams = pathParams;
            return this;
        }

        public HttpRequest.Builder withParams(Map<String, String> params) {
            HttpRequest.LOGGER.debug("Building http request with query/form params.");
            this.params = params;
            return this;
        }

        public HttpRequest.Builder withHeaders(Map<String, String> headers) {
            HttpRequest.LOGGER.debug("Building http request with headers.");
            this.headers = headers;
            return this;
        }

        public HttpRequest.Builder withRequestBody(Object requestBody) {
            HttpRequest.LOGGER.debug("Building http request with body.");
            this.requestBody = requestBody;
            return this;
        }

        public HttpRequest.Builder withProxy(boolean isProxy) {
            HttpRequest.LOGGER.debug("Building http request with proxy");
            this.isProxy = isProxy;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }
    }
}
