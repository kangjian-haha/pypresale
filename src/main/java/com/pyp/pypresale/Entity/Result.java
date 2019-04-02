package com.pyp.pypresale.Entity;

import lombok.Data;

@Data
public class Result<T>{
    private Integer code;
    private String meg;
    private T data;
}
