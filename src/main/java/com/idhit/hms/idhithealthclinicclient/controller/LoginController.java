package com.idhit.hms.idhithealthclinicclient.controller;

import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import com.idhit.hms.idhithealthclinicclient.entity.User;
import com.idhit.hms.idhithealthclinicclient.repo.UserRepo;
import com.idhit.hms.idhithealthclinicclient.util.HMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LoginController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HMSUtil hmsUtil;

    @Value("${server.base.url}")
    private String baseUrl;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    @PostMapping("/process_register")
    public String processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepo.save(user);

        return "register_success";
    }

    @GetMapping("/idhita/redirect")
    public String redirect(ModelMap modelMap){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        List<? extends GrantedAuthority> authorities = userDetails.getAuthorities().stream().collect(Collectors.toList());

        if(authorities.get(0).getAuthority().equals("ROLE_ADMIN")){
            return "redirect:/idhita/home";
        } else if(authorities.get(0).getAuthority().equals("ROLE_RECEP")){
            return "redirect:/idhita/recep_home";
        }else if(authorities.get(0).getAuthority().equals("ROLE_PHARMA")){
            return "redirect:/idhita/pharma_home";
        }else if(authorities.get(0).getAuthority().equals("ROLE_DOCTOR")){
            String username = userDetails.getUsername();
            try {
                Doctor doctor = restTemplate.getForEntity(baseUrl + "/doctors/emailSearch?email=" + username, Doctor.class).getBody();
                return "redirect:/idhita/doctors/" + doctor.getDoctorId();
            }catch(Exception e){
                modelMap.put("error", e.getMessage());
                return "error-page";
            }
        }else{
            modelMap.put("error", "Unknown Role " + authorities.get(0).getAuthority());
            return "error-page";
        }

    }

}
