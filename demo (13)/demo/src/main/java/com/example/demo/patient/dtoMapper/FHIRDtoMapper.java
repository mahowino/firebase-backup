package com.example.demo.patient.dtoMapper;


import com.example.demo.patient.Patient;
import com.example.demo.patient.dto.PatientFHIRRecordDto;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
public class FHIRDtoMapper implements Function<Patient, PatientFHIRRecordDto> {
    String organisationName="Tambua Health";
    @Override
    public PatientFHIRRecordDto apply(Patient patient) {
        return PatientFHIRRecordDto
                .builder()
                .name(
                        List.of
                                (
                                        patient.getFirstName(),
                                        patient.getLastName()
                                )
                )
                .adress(
                        List.of(
                                patient.getAddress()
                        )
                )
                .communications(
                        List.of(

                        )
                )
                .active(true)
                .contacts(
                       List.of(

                       )
                )
                .gender(
                        patient
                                .getGender()
                                .toString()
                )
                .photo(
                        patient
                                .getProfilePicture()
                )
                .generalPractitioner(
                        List.of(

                        )
                )
                .identifier(
                        patient
                                .getId()
                )
                .managingOrganisation(
                        organisationName
                )
                .maritalStatus(
                        patient.
                                getMaritalStatus()
                                .toString()
                )
                .multipleBirthBoolean(
                        patient
                                .isPatientPartOfMultipleBirth()
                )
                .multipleBirthInteger(
                        patient
                                .getMultipleBirthNumber()
                )
                .telecom(
                        List.of(
                                patient.getPhoneNumber()
                        ))

                .build();
    }
}
