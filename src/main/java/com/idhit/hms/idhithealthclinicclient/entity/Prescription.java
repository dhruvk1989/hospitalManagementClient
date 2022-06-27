package com.idhit.hms.idhithealthclinicclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Prescription {

    private Long prescriptionId;

    @JsonIgnore
    private Doctor doctor;


    private Appointment appointment;


    private String medicines;
    
}
