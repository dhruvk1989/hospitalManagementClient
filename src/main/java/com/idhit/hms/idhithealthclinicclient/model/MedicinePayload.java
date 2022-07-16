package com.idhit.hms.idhithealthclinicclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicinePayload {

    private Long id;

    String medicineName;

    String companyName;

    String disease;

    int price;

    private String expiryDate;

}
