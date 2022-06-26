package com.idhit.hms.idhithealthclinicclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/idhit")
public class HomeController {

    @GetMapping("/home")
    public String reachHome(){
        return "home-page";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

}
