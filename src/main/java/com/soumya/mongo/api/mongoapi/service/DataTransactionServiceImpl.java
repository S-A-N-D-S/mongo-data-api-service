package com.soumya.mongo.api.mongoapi.service;

import com.soumya.mongo.api.mongoapi.client.MongoDataAPIClient;
import com.soumya.mongo.api.mongoapi.control.ControlMethodImpl;
import com.soumya.mongo.api.mongoapi.control.Methods;
import com.soumya.mongo.api.mongoapi.properties.MongoDataApiProperties;
import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class DataTransactionServiceImpl implements DataTransactionService {
    private static final Logger LOGGER = Logger.getLogger(DataTransactionService.class.getName());

    private Boolean accessFlag = false;

    @Autowired
    MongoDataAPIClient mongoDataAPIClient;

    @Autowired
    MongoDataApiProperties mongoDataApiProperties;
    /**
     * Get All Data For Provided Collection Name.
     * @param collectionName Collection Name
     * @return List Of Data for given Collection.
     */
    @Override
    @Async
    public List<Object> insertData(String collectionName, Map<String,Object> dataToInsert) {
        List<Object> data = new ArrayList<>();
        isAccesible();
        if(accessFlag.equals(true)){
           //call the function that needs to be called.
            // at the end set @accessFlag = false
            Insert insert = insertMapping(dataToInsert,collectionName);
            mongoDataAPIClient.insertData(mongoDataApiProperties.getMongoDbUrl(),
                    mongoDataApiProperties.getApiKey(),
                    insert);
            accessFlag = false;
        }
        return data;
    }

    @Async
    private void isAccesible() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        int i = 0;
        Boolean flag = false;
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement.getClassName());
            i++;
            if (stackTraceElement.getClassName().equals(DataTransactionServiceImpl.class.getName())) {
                flag = true;
                continue;
            }
            if ((stackTraceElement.getClassName().equals(Methods.class.getName()) || stackTraceElement.getClassName().equals(ControlMethodImpl.class.getName()) && flag)) {
                LOGGER.info("Data Logged for previous class detection was successful which is " + stackTraceElement.getClassName());
                accessFlag = true;
                flag = false;
            } else {
                flag = false;
            }
        }
    }

    /**
     * @param insert
     * @return
     */
    @Override
    @Async
    public List<Object> insertData(Insert insert) {
        List<Object> data = new ArrayList<>();
        isAccesible();
        if(accessFlag.equals(true)){
            //call the function that needs to be called.
            // at the end set @accessFlag = false
            data.add(mongoDataAPIClient.insertData(mongoDataApiProperties.getMongoDbUrl(),
                    mongoDataApiProperties.getApiKey(),
                    insert));
            accessFlag = false;
        }
        return data;
    }
    @Async
    private Insert insertMapping(Map<String,Object> dataToInsert , String collectionName) {
        Insert insert = new Insert();
        insert.setDocument(dataToInsert);
        insert.setDatabase(mongoDataApiProperties.getDatabase());
        insert.setDataSource(mongoDataApiProperties.getDataSource());
        insert.setCollection(collectionName);
        return insert;
    }
}

