package com.CRM.CRMV1.controller.company;


import com.CRM.CRMV1.enums.UserTypes;
import com.CRM.CRMV1.model.Company;
import com.CRM.CRMV1.model.Users;
import com.CRM.CRMV1.repository.CompanyRepository;
import com.CRM.CRMV1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Optional;


/**
 *
 * This class allows CRUD functions for interacting with the Users table.
 *
 *
 */

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/customer")
public class UsersController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private CompanyRepository companyRepository;

    /**
     * Creates new user in the users table.
     * must specify user type and user role.
     *
     * @param user
     * @return
     */
    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Users addNewClient(@RequestBody Users user)
    {
        Calendar calendar = Calendar.getInstance();

        //set current time stamp for join date when adding a new user

        user.setJoindate(new java.sql.Timestamp(calendar.getTime().getTime()));

        //ensure we set role as client and customer as their type
        //todo: use the enums
        user.setRole("ROLE_CLIENT");
        user.setUsertype("CUSTOMER");
        user.setOwner(""); //they cannot be owner as they are client of someone

        Users u = userInfoRepository.save(user);

        return u;
    }


    /**
     * Retrieve user profile by user profile id
     * @param profileid
     * @return
     */
    @RequestMapping (value = "/get/{profileid}", method = RequestMethod.GET)
    public Optional<Users> getUserByProfileId(@PathVariable Integer profileid)
    {
        return userInfoRepository.findById(profileid);
    }

    /**
     * get user by username
     * @param username
     * @return
     */
    @RequestMapping(value="/get/{username}")
    public Optional<Users> getUserByUserName(@PathVariable String username)
    {
        return userInfoRepository.findUsersByUsername(username);
    }
}
