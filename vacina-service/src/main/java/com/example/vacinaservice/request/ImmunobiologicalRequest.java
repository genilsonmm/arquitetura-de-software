package com.example.vacinaservice.request;

import com.example.vacinaservice.dto.ImmunobiologicalDto;
import com.example.vacinaservice.dto.ResultDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "immunobiological-service")
public interface ImmunobiologicalRequest {

    @GetMapping("/immunobiological/{code}")
    ResultDto<ImmunobiologicalDto> getByCode(
            @PathVariable long code);
}
