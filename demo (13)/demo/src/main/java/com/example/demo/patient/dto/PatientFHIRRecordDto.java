package com.example.demo.patient.dto;

import jakarta.persistence.Table;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PatientFHIRRecordDto {
    long identifier;
    boolean active,multipleBirthBoolean;
    int multipleBirthInteger;
    List<String> name,telecom,generalPractitioner,adress;
    String gender,maritalStatus,photo,managingOrganisation;
    List<Contact> contacts;

    List<Communication> communications;
    List<Link> links;


}
