package com.example.vacinaservice.dto;

import lombok.Data;

@Data
public class ResultDto<T> {

    public T result;
    public String environment;
}
