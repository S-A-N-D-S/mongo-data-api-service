package com.soumya.mongo.api.mongoapi.requestentity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Insert extends MongoDataAPIRequestEntity{
    private Map<String,Object> document;
}
