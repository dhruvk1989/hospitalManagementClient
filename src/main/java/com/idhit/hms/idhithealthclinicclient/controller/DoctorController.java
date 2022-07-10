package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Appointment;
import com.idhit.hms.idhithealthclinicclient.entity.Department;
import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.model.AppointmentPayload;
import com.idhit.hms.idhithealthclinicclient.model.DoctorPayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
public class DoctorController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/doctors/register")
    public String createDoctorForm(ModelMap modelMap){
        DoctorPayload doctorPayload = new DoctorPayload();
        modelMap.addAttribute("doctor", doctorPayload);
        return "create-doctor";
    }

    @PostMapping("/doctors/save")
    public String createDoctor(DoctorPayload doctorPayload,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create-doctor";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            ResponseEntity<Doctor> response = restTemplate.postForEntity(baseUrl + "/doctors", doctorPayload, Doctor.class, httpHeaders);
            Doctor result = response.getBody();
            return "redirect:/idhita/doctors/" + result.getDoctorId();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "dept-not-found";
        }
    }

    @GetMapping("/doctors/{id}")
    public String getOneDoctor(@PathVariable Long id,
                               ModelMap modelMap){
        Doctor doctor = restTemplate.getForEntity(baseUrl + "/doctors/" + id, Doctor.class).getBody();
        modelMap.addAttribute("doctor", doctor);
        return "single-doctor";
    }

    @GetMapping("/doctors")
    public String getAllDoctors(ModelMap map){
        List<Doctor> doctors = restTemplate.getForObject(baseUrl + "/doctors", List.class);
        ObjectMapper mapper = new ObjectMapper();
        doctors = mapper.convertValue(doctors, new TypeReference<List<Doctor>>() {
        });
        List<String> departments = new ArrayList<>();
        for (Doctor doc : doctors) {
            departments.add(doc.getDept().getDeptName());
        }
        map.addAttribute("doctors", doctors);
        map.addAttribute("departments", departments);
        return "all-doctors";
    }

}
