package com.example.imunobiologicoservice.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseDto {

    private Object result;
    private String environment;
}
