package com.example.vacinaservice.dto;

import lombok.Data;

@Data
public class RegistryDto {

    private String cpf;
    private int vaccineCode;
    private int dose;
    private String name;
}
