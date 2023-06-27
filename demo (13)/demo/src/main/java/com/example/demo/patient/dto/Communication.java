package com.example.demo.patient.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
 public class Communication {
     String language;
     boolean preferred;
}
