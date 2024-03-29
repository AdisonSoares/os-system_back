package com.adison.os.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data @NoArgsConstructor @AllArgsConstructor
public class FieldMessage implements Serializable {
    private String fieldName;
    private String message;
}
