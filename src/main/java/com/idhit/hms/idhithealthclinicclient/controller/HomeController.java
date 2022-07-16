package com.idhit.hms.idhithealthclinicclient.controller;

import com.idhit.hms.idhithealthclinicclient.repo.UserRepo;
import com.idhit.hms.idhithealthclinicclient.util.HMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/idhita")
public class HomeController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    HMSUtil hmsUtil;

    @GetMapping("/home")
    public String reachHome(){
        return "home-page";
    }

    @GetMapping("/about")
    public String about(ModelMap modelMap){
        return "about";
    }


    @GetMapping("/recep/home")
    public String recepDashboard() {
        return "recep-home";
    }

    @GetMapping("/hello")
    public String logout(){
        return "hello";
    }

    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }

}
