package com.soumya.mongo.api.mongoapi.service;

import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DataTransactionService {
    List<Object> insertData(String collectionName, Map<String,Object> dataToInsert);

    List<Object> insertData(Insert insert);
}
