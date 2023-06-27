package com.example.demo.patient;

import com.example.demo.patient.dtoMapper.FHIRDtoMapper;
import com.example.demo.patient.service.FHIRService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public FHIRDtoMapper mapper(){return  new FHIRDtoMapper();}
}
