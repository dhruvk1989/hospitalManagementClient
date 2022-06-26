package com.idhit.hms.idhithealthclinicclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoctorPayload {
    private String name;
    private String age;
    private String dept;
}
