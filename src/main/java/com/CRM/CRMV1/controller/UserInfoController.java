package com.CRM.CRMV1.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/get")

public class UserInfoController {
    @RequestMapping(value="/foo")
    public String accountGet(@RequestParam("uname") String username)
    {
        //logger.info("get account called");
        return username;
    }

}
