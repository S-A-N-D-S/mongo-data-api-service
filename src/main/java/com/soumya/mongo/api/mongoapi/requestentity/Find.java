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
public class Find extends MongoDataAPIRequestEntity{
    Map<String,Object> filter;
    Map<String,Object> projection;
    Map<String,Object> sort;
    Collation collation;

    @AllArgsConstructor
    @Data
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private class Collation {
        String locale;
        Boolean caseLevel;
        String caseFirst;
        Integer strength;
        Boolean numericOrdering;
        String alternate;
        String maxVariable;
        Boolean backwards;
    }
}
