package com.example.demo.patient.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    String relationship,name,telecom,adress,gender,organisation,period;
}
