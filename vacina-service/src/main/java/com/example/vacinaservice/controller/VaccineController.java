package com.example.vacinaservice.controller;

import com.example.vacinaservice.dto.ImmunobiologicalDto;
import com.example.vacinaservice.dto.RegistryDto;
import com.example.vacinaservice.entity.VaccineRegistry;
import com.example.vacinaservice.repository.VaccineRepository;
import com.example.vacinaservice.request.ImmunobiologicalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("vaccine-registry")
public class VaccineController {

    @Autowired
    private VaccineRepository repository;

    @Autowired
    private ImmunobiologicalRequest immunobiologicalRequest;

    @PostMapping
    public ResponseEntity post(
            @RequestBody RegistryDto registryDto){

        ImmunobiologicalDto immunobiologicalDto =
                immunobiologicalRequest.getByCode(registryDto.getVaccineCode());

        VaccineRegistry vaccineRegistry =
                toEntity(registryDto, immunobiologicalDto);

        return new ResponseEntity(repository.save(vaccineRegistry),
                HttpStatus.CREATED);
    }

    private VaccineRegistry toEntity(RegistryDto registryDto, ImmunobiologicalDto immunobiologicalDto) {
        VaccineRegistry vaccineRegistry = new VaccineRegistry();
        vaccineRegistry.setVaccineCode(immunobiologicalDto.getCode());
        vaccineRegistry.setCpf(registryDto.getCpf());
        vaccineRegistry.setDose(registryDto.getDose());
        vaccineRegistry.setName(registryDto.getName());
        vaccineRegistry.setDisplay(immunobiologicalDto.getDisplay());
        return vaccineRegistry;
    }
}
