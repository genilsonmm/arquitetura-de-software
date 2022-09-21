package com.example.imunobiologicoservice.controller;

import com.example.imunobiologicoservice.dto.ResponseDto;
import com.example.imunobiologicoservice.entity.Immunobiological;
import com.example.imunobiologicoservice.repository.ImmunobiologicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("immunobiological")
public class ImmunobiologicalController {

    @Autowired
    private ImmunobiologicalRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping
    public List<Immunobiological> get(){

        return repository.findAll();
    }

    @GetMapping("{code}")
    public ResponseEntity getByCode(@PathVariable Long code){
        var immunobiological =
                repository.findById(code);

        if(immunobiological.isPresent()){

            String port = environment.getProperty("local.server.port");

            var response = ResponseDto.builder()
                    .result(immunobiological.get())
                    .environment(port)
                    .build();

            return new ResponseEntity(response, HttpStatus.OK);
        }

        return new ResponseEntity("Código inválido",
                HttpStatus.BAD_REQUEST);
    }
}
