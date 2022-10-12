package com.soumya.mongo.api.mongoapi.exception;

import lombok.Data;
import lombok.Setter;

@Data
public class MissingDataException extends Exception{
    private String message;
}
