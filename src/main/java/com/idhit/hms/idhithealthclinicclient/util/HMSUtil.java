package com.idhit.hms.idhithealthclinicclient.util;

import com.idhit.hms.idhithealthclinicclient.entity.Doctor;
import org.hibernate.annotations.SortComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;

@Component
public class HMSUtil {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${server.base.url}")
    private String baseUrl;

    public boolean checkUserId(Long id, UserDetails ob){

        Doctor doctor = restTemplate.getForEntity(baseUrl + "/doctors/" + id, Doctor.class).getBody();

        if(ob.getUsername().equals(doctor.getUserName())
                ||
                ob.getAuthorities().stream().collect(Collectors.toList()).get(0).getAuthority().equals("ROLE_ADMIN")){
            return true;
        }else {
            return false;
        }

    }

    public String checkRoleBasedHome(UserDetails ob, Long docId){
        String role = ob.getAuthorities().stream().collect(Collectors.toList()).get(0).getAuthority();

        if(role.equals("ROLE_ADMIN")){
            return "/idhita/home";
        }else if(role.equals("ROLE_DOCTOR")){
            return "/idhita/" + docId + "/home";
        }else if(role.equals("ROLE_RECEP")){
            return "/idhita/recep_home";
        }else if(role.equals("ROLE_PHARMA")) {
            return "/idhita/pharma_home";
        }

        return "/idhita/home";
    }

}
