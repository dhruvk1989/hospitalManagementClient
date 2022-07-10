package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Appointment;
import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.entity.Prescription;
import com.idhit.hms.idhithealthclinicclient.model.PrescriptionRequestPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/idhita")
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

    @GetMapping("/doctors/{docId}/appointments/{apptId}/prescriptions/register")
    public String prescriptionForm(@PathVariable Long docId,
                                   @PathVariable Long apptId,
                                   ModelMap map){
        PrescriptionRequestPayload prescription = new PrescriptionRequestPayload();
        map.addAttribute("prescription", prescription);
        return "prescription-form";
    }

    @PostMapping("/doctors/{docId}/appointments/{apptId}/prescriptions/save")
    public String createPrescripton(@PathVariable Long docId,
                                    @PathVariable Long apptId,
                                    PrescriptionRequestPayload prescriptionRequestPayload,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "prescription-form";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        Prescription prescription = restTemplate.postForEntity(baseUrl + "/doctors/" + docId + "/appointments/" + apptId + "/prescriptions", prescriptionRequestPayload, Prescription.class, httpHeaders).getBody();
        return "redirect:/idhita/doctors/" + docId + "/appointments/" + apptId + "/prescriptions/" + prescription.getPrescriptionId();
    }

    @GetMapping("/doctors/{docId}/appointments/{apptId}/prescriptions/{presId}")
    public String getSinglePrescription(@PathVariable Long docId,
                                            @PathVariable Long apptId,
                                            @PathVariable Long presId,
                                            ModelMap map){
        Prescription prescriptions = restTemplate.getForObject(baseUrl + "/doctors/" + docId + "/appointments/" + apptId + "/prescriptions/" + presId,
                Prescription.class);
        //String medicines = String.join(",", prescriptions.getMedicines());
        Appointment appointment = prescriptions.getAppointment();
        map.addAttribute("medicines", prescriptions.getMedicines());
        map.addAttribute("patientName", appointment.getPatientName());
        map.addAttribute("doctor", appointment.getDoctorName());
        map.addAttribute("remarks", prescriptions.getDoctorRemarks());
        return "single-prescription";
    }

}
