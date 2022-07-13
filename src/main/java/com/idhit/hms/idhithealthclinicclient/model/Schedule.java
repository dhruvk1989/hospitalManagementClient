package com.idhit.hms.idhithealthclinicclient.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    private Long docId;
    private Long apptId;
    private String patientName;
    private String docTime;
    private String docName;
    private String apptDate;
}
