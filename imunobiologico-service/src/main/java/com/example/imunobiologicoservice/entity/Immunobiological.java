package com.example.imunobiologicoservice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "immunobiological")
public class Immunobiological {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    @Column(nullable = false, length = 100)
    private String display;

    @Column(nullable = false, length = 300)
    private String definition;
}
