package com.example.vacinaservice.request;

import com.example.vacinaservice.dto.ImmunobiologicalDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "immunobiological", url = "http://localhost:8080")
public interface ImmunobiologicalRequest {

    @GetMapping("/immunobiological/{code}")
    ImmunobiologicalDto getByCode(
            @PathVariable long code);
}
