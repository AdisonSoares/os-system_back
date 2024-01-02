package com.adison.os.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class StandardError implements Serializable {
    private Long timestamp;
    private Integer status;
    private String error;
}
