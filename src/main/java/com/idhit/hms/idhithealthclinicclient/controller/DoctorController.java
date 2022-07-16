package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Appointment;
import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.model.DoctorPayload;
import com.idhit.hms.idhithealthclinicclient.model.Schedule;
import com.idhit.hms.idhithealthclinicclient.security.UserDetailsImpl;
import com.idhit.hms.idhithealthclinicclient.util.HMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/idhita")
public class DoctorController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HMSUtil util;

    //@Autowired
    //DoctorRepo repo;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/doctors/register")
    public String createDoctorForm(ModelMap modelMap){
        DoctorPayload doctorPayload = new DoctorPayload();
        modelMap.addAttribute("doctor", doctorPayload);
        return "create-doctor";
    }

    @GetMapping("/doctors/{id}/home")
    public String doctorDashboard(@PathVariable Long id, ModelMap map){
        UserDetails ob = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(util.checkUserId(id, ob)){

        }else{
            return "forbidden";
        }
        Doctor doctor = restTemplate.getForEntity(baseUrl + "/doctors/" + id, Doctor.class).getBody();
        map.addAttribute("doctorName", doctor.getName());
        return "doctor-home";
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
        UserDetails ob = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(util.checkUserId(id, ob)){
            modelMap.addAttribute("doctor", doctor);
            modelMap.addAttribute("link", "/idhita/doctors/" + id + "/schedule");
            return "single-doctor";
        }else {
            return "forbidden";
        }
    }

    @GetMapping("/doctors/{id}/appointments/{apptId}")
    public String getSingleAppointment(@PathVariable Long id,
                                       @PathVariable Long apptId,
                                       ModelMap modelMap){

        UserDetails ob = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(util.checkUserId(id, ob)){

        }else {

            return "forbidden";
        }

        Appointment appointment = restTemplate.getForEntity(baseUrl+"/appointments/"+apptId,Appointment.class).getBody();
        String date;
        if(appointment.getAppointmentDateTime() != null) {
            date = new SimpleDateFormat("dd-MM-yyyy").format(appointment.getAppointmentDateTime());
        }else{
            date = "";
        }
        modelMap.addAttribute("date", date);
        modelMap.addAttribute("appointment", appointment);
        if(appointment.getStatus().equals("Prescribed")){
            modelMap.addAttribute("buttonName", "Prescribed");
            modelMap.addAttribute("link", "/idhita/doctors/" + id + "/appointments/" + apptId + "/prescriptions/" + appointment.getPrescriptionId());
        }else{
            modelMap.addAttribute("buttonName", "Prescribe");
            modelMap.addAttribute("link", "/idhita/doctors/" + id + "/appointments/" + apptId + "/prescriptions/register");

        }
        System.out.println(appointment.toString());
        return "single-appointment";
    }

    @GetMapping("/doctors")
    public String getAllDoctors(ModelMap map){
        List<Doctor> doctors = restTemplate.getForObject(baseUrl + "/doctors", List.class);
        ObjectMapper mapper = new ObjectMapper();
        doctors = mapper.convertValue(doctors, new TypeReference<List<Doctor>>() {
        });
        List<String> departments = new ArrayList<>();
        List<String> links = new ArrayList<>();
        for (Doctor doc : doctors) {
            departments.add(doc.getDept().getDeptName());
            links.add("/idhita/doctors/" + doc.getDoctorId());
        }
        map.addAttribute("doctors", doctors);
        map.addAttribute("departments", departments);
        map.addAttribute("links", links);
        return "all-doctors";
    }

    @GetMapping("/doctors/{id}/schedule")
    public String getDoctorSchedule(@PathVariable Long id, ModelMap map){

        UserDetails ob = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(util.checkUserId(id, ob)){

        }else{
            return "forbidden";
        }

        List<Schedule> schedules = restTemplate.getForObject(baseUrl + "/doctors/" + id + "/schedule", List.class);
        ObjectMapper mapper = new ObjectMapper();
        schedules = mapper.convertValue(schedules, new TypeReference<List<Schedule>>() {
        });

        ArrayList<String> links = new ArrayList<>();
        for (Schedule s : schedules) {
            if(s != null){
                links.add("/idhita/doctors/" + id + "/appointments/" + s.getApptId());
            }else{
                links.add("");
            }
        }

        map.addAttribute("links", links);
        map.addAttribute("schedule", schedules);
        map.addAttribute("doctorName", schedules.get(0).getDocName());
        return "doctor-schedule";

    }

}
