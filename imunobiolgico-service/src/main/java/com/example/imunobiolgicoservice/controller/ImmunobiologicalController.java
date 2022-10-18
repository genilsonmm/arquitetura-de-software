package com.example.imunobiolgicoservice.controller;

import com.example.imunobiolgicoservice.dto.ResponseDto;
import com.example.imunobiolgicoservice.entity.Immunobiological;
import com.example.imunobiolgicoservice.repository.ImmunobiologicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("immunobiological")
public class ImmunobiologicalController {

    @Autowired
    private ImmunobiologicalRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping
    public List<Immunobiological> getAll(){
        return repository.findAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity getByCode(@PathVariable long code){
        var result = repository.findById(code);

        if(result.isPresent()){
            var response = ResponseDto.builder()
                    .result(result.get())
                    .environment("Port: " + environment.getProperty("local.server.port"))
                    .build();

            return new ResponseEntity(response, HttpStatus.OK);
        }

        return ResponseEntity.noContent().build();
    }
}
