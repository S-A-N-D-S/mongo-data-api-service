package com.soumya.mongo.api.mongoapi.controller;

import com.soumya.mongo.api.mongoapi.control.Methods;
import com.soumya.mongo.api.mongoapi.requestentity.Insert;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class DataController {
    @Autowired
    Methods methods;

    @PostMapping("/fetchAllFromCollection")
    public ResponseEntity<Object> insertData(@RequestBody @NonNull Insert insert) {
        Object data = methods.insertData(insert);
        return ResponseEntity.ok(data);
    }

    @PostMapping("/fetchAllFromCollection/{}")
    public ResponseEntity<Object> getAllConfigurable(@RequestBody @NonNull Insert insert) {
        Object data = methods.insertData(insert);
        return ResponseEntity.ok(data);
    }

}
