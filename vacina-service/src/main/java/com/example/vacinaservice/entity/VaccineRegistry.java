package com.example.vacinaservice.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "vaccine_registry")
@Data
public class VaccineRegistry {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vaccine_code", length = 3, nullable = false)
    private long vaccineCode;

    @Column(length = 200, nullable = false)
    private String display;

    @Column(length = 2, nullable = false)
    private int dose;

    @Column(length = 14, nullable = false)
    private String cpf;

    @Column(length = 200, nullable = false)
    private String name;
}
