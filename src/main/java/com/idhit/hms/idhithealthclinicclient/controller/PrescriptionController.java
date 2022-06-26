package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Appointment;
import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/idhit")
public class PrescriptionController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/doctors/{docId}/appointments/{apptId}/prescriptions")
    public String getPrescriptionsOfADoctor(@PathVariable Long docId,
                                            @PathVariable Long apptId,
                                            ModelMap map){
        List<Prescription> prescriptions = restTemplate.getForObject(baseUrl + "/doctors/" + docId + "/appointments/" + apptId + "/prescriptions",
                List.class);
        ObjectMapper mapper = new ObjectMapper();
        prescriptions = mapper.convertValue(prescriptions, new TypeReference<List<Prescription>>() {});
        List<Appointment> appointments = new ArrayList<>();
        for (Prescription p : prescriptions) {
            appointments.add(p.getAppointment());
        }
        if(prescriptions.size() == 0){
            return "no-prescriptions";
        }
        map.addAttribute("prescriptions", prescriptions);
        map.addAttribute("appointments", appointments);
        map.addAttribute("doctor", appointments.get(0).getDoctorName());
        return "doctor-prescriptions";
    }

}
