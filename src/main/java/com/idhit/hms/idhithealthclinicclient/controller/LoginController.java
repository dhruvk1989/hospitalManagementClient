package com.idhit.hms.idhithealthclinicclient.controller;

import com.idhit.hms.idhithealthclinicclient.model.AppointmentPayload;
import com.idhit.hms.idhithealthclinicclient.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/idhita")
public class LoginController {

    @GetMapping("/login")
    public String login(ModelMap modelMap){
        Login login = new Login();
        modelMap.addAttribute("login", login);
        return "login";
    }

}
