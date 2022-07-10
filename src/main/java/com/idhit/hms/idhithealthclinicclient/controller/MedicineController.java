package com.idhit.hms.idhithealthclinicclient.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.idhit.hms.idhithealthclinicclient.entity.Medicine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

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
        map.addAttribute("medicines", medicines);
        return "medicines";
    }

}
