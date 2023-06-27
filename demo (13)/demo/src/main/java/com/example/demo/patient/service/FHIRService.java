package com.example.demo.patient.service;

import com.example.demo.patient.Patient;
import com.example.demo.patient.dto.PatientFHIRRecordDto;
import com.example.demo.patient.dtoMapper.FHIRDtoMapper;
import com.example.demo.patient.exception.DatabaseException;
import com.example.demo.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FHIRService {

    @Autowired
    private final PatientRepository patientRepository;
    private final FHIRDtoMapper fhirDtoMapper;
    public PatientFHIRRecordDto addDataToFHIRDatabase(Patient patient){
        patientRepository.save(patient);
        return patientRepository.findById(patient.getId())
                .map(fhirDtoMapper)
                .orElseThrow(DatabaseException::new);
    }



}
