package com.soumya.mongo.api.mongoapi.requestentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Update extends MongoDataAPIRequestEntity{
    Map<String,Object> filter;
    FieldUpdateMap update;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class FieldUpdateMap {
        @JsonProperty("$currentDate")
        Map<String,String> currentDate;
        @JsonProperty("$inc")
        Map<String,String> inc;
        @JsonProperty("$min")
        Map<String,String> min;
        @JsonProperty("$max")
        Map<String,String> max;
        @JsonProperty("$mul")
        Map<String,String> mul;
        @JsonProperty("$rename")
        Map<String,String> rename;
        @JsonProperty("$set")
        Map<String,String> set;
        @JsonProperty("$setOnInsert")
        Map<String,String> setOnInsert;
        @JsonProperty("$unset")
        Map<String,String> unset;
    }
}
