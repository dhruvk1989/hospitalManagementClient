package com.idhit.hms.idhithealthclinicclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {


    private Long doctorId;

    private String name;

    private String age;


    private Department dept;

    @JsonIgnore
    private List<Prescription> prescriptionList;


    @JsonIgnore
    private List<Appointment> appointments;

}
