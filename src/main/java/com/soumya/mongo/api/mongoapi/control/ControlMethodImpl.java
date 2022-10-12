package com.soumya.mongo.api.mongoapi.control;

import com.soumya.mongo.api.mongoapi.exception.MissingDataException;
import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import com.soumya.mongo.api.mongoapi.service.DataTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

@Component
public class ControlMethodImpl implements Methods{
    private static final Logger LOGGER = Logger.getLogger(ControlMethodImpl.class.getName());

    @Autowired
    DataTransactionService dataTransactionService;
    /** Get All Data From A Particular Collection.
     * @param insert {@link Insert type Object}.
     * @return Collection Data.
     */
    @Override
    public Object insertData(Insert insert) {
        try {
            if (Objects.nonNull(insert.getDocument()) && Objects.nonNull(insert.getDataSource()) && Objects.nonNull(insert.getDatabase()) && Objects.nonNull(insert.getCollection())) {
                return dataTransactionService.insertData(insert);
            } else {
                if (Objects.isNull(insert.getCollection()) || Objects.isNull(insert.getDocument())) {
                    MissingDataException missingDataException = new MissingDataException();
                    missingDataException.setMessage("Collection and Document Field cannot be null for Insert to MongoDB to work");
                    return missingDataException;
                }
                return dataTransactionService.insertData(insert.getCollection(), insert.getDocument());
            }
        } catch (Exception exception){
            return exception.getLocalizedMessage();
    }
    }



    /**
     * Get Data By Search Filters.
     * @param fields
     * @param collection
     * @return
     */
    @Override
    public Object getDataBy(Map<String, String> fields, String collection) {
        return null;
    }
}
