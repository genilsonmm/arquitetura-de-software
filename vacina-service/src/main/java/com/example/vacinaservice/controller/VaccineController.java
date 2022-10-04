package com.example.vacinaservice.controller;

import com.example.vacinaservice.dto.ImmunobiologicalDto;
import com.example.vacinaservice.dto.RegistryDto;
import com.example.vacinaservice.dto.ResultDto;
import com.example.vacinaservice.entity.VaccineRegistry;
import com.example.vacinaservice.repository.VaccineRepository;
import com.example.vacinaservice.request.ImmunobiologicalRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
    private Environment environment;

    @Autowired
    private VaccineRepository repository;

    @Autowired
    private ImmunobiologicalRequest immunobiologicalRequest;

    @PostMapping
    public ResponseEntity post(
            @RequestBody RegistryDto registryDto){

        var immunobiologicalDto =
                immunobiologicalRequest.getByCode(registryDto.getVaccineCode());

        String port = environment.getProperty("local.server.port");


        VaccineRegistry vaccineRegistry =
                toEntity(registryDto, immunobiologicalDto.result);

        repository.save(vaccineRegistry);

        ResultDto<RegistryDto> vaccineResult = new ResultDto<>();
        vaccineResult.result = registryDto;
        vaccineResult.environment = "Vaccine: " + port +
                " - Immunobiological: " + immunobiologicalDto.environment;

        return new ResponseEntity(vaccineResult, HttpStatus.CREATED);
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
