package com.CRM.CRMV1.controller;

import com.CRM.CRMV1.UserInfoRepository;
import com.CRM.CRMV1.model.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
@RequestMapping(value="/get")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;



    @RequestMapping(value="/foo")
    public String accountGet(@RequestParam("uname") String username)
    {
        //logger.info("get account called");
        return username;
    }

    @GetMapping (path="/all")
    public @ResponseBody Iterable<Users> getAllUsers(){

        return userInfoRepository.findAll();

    }



}
