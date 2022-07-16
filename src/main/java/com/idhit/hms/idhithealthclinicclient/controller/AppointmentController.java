package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Appointment;
import com.idhit.hms.idhithealthclinicclient.model.AppointmentPayload;
import com.idhit.hms.idhithealthclinicclient.model.AppointmentResponsePayload;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/idhita")
public class AppointmentController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/appointments/register")
    public String createAppointmentForm(ModelMap modelMap){
        AppointmentPayload appointmentPayload = new AppointmentPayload();
        modelMap.addAttribute("appointment", appointmentPayload);
        return "create-appointment";
    }

    @PostMapping("/appointments/save")
    public String createAppointment(AppointmentPayload appointmentPayload,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "create-appointment";
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<Appointment> response = restTemplate.postForEntity(baseUrl + "/appointments", appointmentPayload, Appointment.class, httpHeaders);
        Appointment result = response.getBody();
        if (result.getDoctorName().equals("None")) {
            return "doctor-not-found";
        } else {
            return "redirect:/idhita/appointments/" + result.getId();
        }
    }

    @GetMapping("appointments/{id}")
    public String getSingleAppointment(@PathVariable Long id,
                                       ModelMap modelMap){
        Appointment appointment = restTemplate.getForEntity(baseUrl+"/appointments/"+id,Appointment.class).getBody();
        String date = new SimpleDateFormat("dd-MM-yyyy").format(appointment.getAppointmentDateTime());
        modelMap.addAttribute("date", date);
        modelMap.addAttribute("appointment", appointment);
        System.out.println(appointment.toString());
        return "single-appointment";
    }

    @GetMapping("/appointments")
    public String getAllAppointments(ModelMap modelMap){
        List<Appointment> appointments = restTemplate.getForEntity(baseUrl+"/appointments",ArrayList.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        appointments = mapper.convertValue(appointments, new TypeReference<List<Appointment>>() {});//to explicitly
                                                                                                    //inform jackson
                                                                                                    //that this is an
                                                                                                    //list of appointment object
        appointments = appointments.stream().
                filter((a) -> !(a.getDoctorName()== null)). //filtered the null doctors
                filter((a) -> !(a.getDoctorName().          //filtered the doctor that have the name "None"
                        equals("None"))).collect(Collectors.toList()); //collected the final appointments that have doctors listed in it

        ArrayList<String> dates = new ArrayList<>();
        ArrayList<String> links = new ArrayList<>();

        for (Appointment a : appointments) {
            if(a.getAppointmentDateTime() != null) {
                dates.add(new SimpleDateFormat("dd-MM-yyyy").format(a.getAppointmentDateTime()));
            }else{
                dates.add("");
            }
            links.add("/idhita/appointments/" + a.getId());
        }

        modelMap.addAttribute("appointments", appointments);
        modelMap.addAttribute("dates", dates);
        modelMap.addAttribute("links", links);
        return "all-appointments";
    }

}
