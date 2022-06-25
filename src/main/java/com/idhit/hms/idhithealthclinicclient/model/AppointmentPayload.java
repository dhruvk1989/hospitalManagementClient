package com.idhit.hms.idhithealthclinicclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AppointmentPayload {

    private String name;
    private Integer age;
    private String gender;
    private String symptoms;

}
