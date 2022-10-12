package com.soumya.mongo.api.mongoapi.control;

import com.soumya.mongo.api.mongoapi.requestentity.Insert;

import java.util.Map;

public interface Methods {
    Object insertData(Insert insert);
    Object getDataBy(Map<String,String> fields, String collection);
}
