package com.example.demo.patient;

import com.example.demo.patient.dto.Communication;
import com.example.demo.patient.dto.Contact;
import com.example.demo.patient.dto.Link;
import com.example.demo.patient.enums.Gender;
import com.example.demo.patient.enums.MaritalStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue
    long id;
    String firstName,lastName,address,profilePicture,phoneNumber;
    Date dateOfBirth;
    MaritalStatus maritalStatus;
    Gender gender;
    boolean isPatientPartOfMultipleBirth;
    int multipleBirthNumber;


 /*   List<String> Links,generalPractitioners;
    List<Communication> languages;
    List<Contact> contacts;
    List<Link> links;*/
}
