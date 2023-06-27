package com.example.demo.patient.controller;

import com.example.demo.patient.Patient;
import com.example.demo.patient.dto.PatientFHIRRecordDto;
import com.example.demo.patient.service.FHIRService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patient")
@RequiredArgsConstructor
public class FHIRController {


    private final FHIRService service;
    @PostMapping("/add")
    public ResponseEntity<PatientFHIRRecordDto> addPatient(@RequestBody Patient patient){
        return ResponseEntity.ok(service.addDataToFHIRDatabase(patient));
    }

}
