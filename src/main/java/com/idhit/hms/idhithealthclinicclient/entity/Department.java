package com.idhit.hms.idhithealthclinicclient.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Department {

    private Long deptId;
    @JsonIgnore
    private List<Doctor> doctor;

    private String deptName;

}
