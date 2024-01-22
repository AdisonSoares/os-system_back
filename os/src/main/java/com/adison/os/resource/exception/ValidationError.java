package com.adison.os.resource.exception;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ValidationError extends StandardError{
    private List<FieldMessage> errors = new ArrayList<>();
    public ValidationError() {

    }
    public ValidationError(Long timestamp, Integer status, String error) {
        super(timestamp, status, error);
    }

    public void addError(String fieldName, String message){
        this.errors.add(new FieldMessage(fieldName,message));
    }
}
