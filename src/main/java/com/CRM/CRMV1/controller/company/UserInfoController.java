package com.CRM.CRMV1.controller.company;

import com.CRM.CRMV1.model.UserRoles;
import com.CRM.CRMV1.repository.UserInfoRepository;
import com.CRM.CRMV1.model.Users;
import com.CRM.CRMV1.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@EnableAutoConfiguration
@RequestMapping(value="/user")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Autowired
    UserRolesRepository userRolesRepository;

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

    @GetMapping (path="/{username}")
    public @ResponseBody Users getUserByUserName(@PathVariable String username){

        Users u =userInfoRepository.findUsersByUsername(username);
        return u;

    }


    @GetMapping (path="/role/{id}")
    public @ResponseBody
    Optional<UserRoles> getUserRoleByUserName(@PathVariable Integer id){

        Optional<UserRoles> u = userRolesRepository.findById(id);
        return u;

    }


}
