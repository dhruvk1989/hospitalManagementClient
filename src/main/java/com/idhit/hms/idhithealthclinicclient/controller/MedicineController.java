package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.entity.Medicine;
import com.idhit.hms.idhithealthclinicclient.model.DoctorPayload;
import com.idhit.hms.idhithealthclinicclient.model.MedicinePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("idhita")
public class MedicineController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/medicines")
    public String getMedicines(ModelMap map){
        List<Medicine> medicines = restTemplate.getForObject(baseUrl + "/medicines", List.class);
        ObjectMapper mapper = new ObjectMapper();
        medicines = mapper.convertValue(medicines, new TypeReference<List<Medicine>>() {});

        ArrayList<String> dates = new ArrayList<>();
        for (Medicine m : medicines) {
            if(m.getExpiryDate() != null) {
                dates.add(new SimpleDateFormat("dd-MM-yyyy").format(m.getExpiryDate()));
            }else{
                dates.add("");
            }
        }

        map.addAttribute("dates", dates);
        map.addAttribute("medicines", medicines);
        return "medicines";
    }

    @GetMapping("/medicines/register")
    public String createMedicine(ModelMap map){
        MedicinePayload medicine = new MedicinePayload();
        map.addAttribute("medicine", medicine);
        return "create-medicine";
    }

    @PostMapping("/medicines/save")
    public String createDoctor(MedicinePayload medicine,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "create-medicine";
        }
        Medicine medicine1 = new Medicine();
        medicine1.setMedicineName(medicine.getMedicineName());
        medicine1.setCompanyName(medicine.getCompanyName());
        medicine1.setDisease(medicine.getDisease());
        medicine1.setPrice(medicine.getPrice());
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(medicine.getExpiryDate());
        medicine1.setExpiryDate(date);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(baseUrl + "/medicines", medicine1, String.class, httpHeaders);
            String result = response.getBody();
            return "redirect:/idhita/medicines/";
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "dept-not-found";
        }
    }

}
