package com.CRM.CRMV1.controller.company;

import com.CRM.CRMV1.enums.UserTypes;
import com.CRM.CRMV1.model.Addresses;
import com.CRM.CRMV1.model.UserRoles;
import com.CRM.CRMV1.repository.AddressesRepository;
import com.CRM.CRMV1.repository.UserInfoRepository;
import com.CRM.CRMV1.model.Users;
import com.CRM.CRMV1.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@EnableAutoConfiguration
@RequestMapping(value="/company/user")
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    AddressesRepository addressesRepository;

    @RequestMapping(value="/foo")
    public String accountGet(@RequestParam("uname") String username)
    {
        //logger.info("get account called");
        return username;
    }

    /**
     * getAllUsers returns list of users in the database
     * @return
     */
    //todo: remove from prod.
    @GetMapping (path="/all")
    public @ResponseBody Iterable<Users> getAllUsers(){

        return userInfoRepository.findAll();

    }

    /**
     * given username returns user profile info.  this has user type in it that can be used to determine which site to send the user to.
     * e.g. usertype == contractor then send to contractor.
     * @param username
     * @return
     */
    @GetMapping (path="/{username}")
    public @ResponseBody Users getUserProfileByUserName(@PathVariable String username){

        Users u = userInfoRepository.findUsersByUsername(username);
        return u;
    }


    /**
     * given user id returns their role from the userroles table.
     * @param userid
     * @return
     */
    @GetMapping (path="/role/{userid}")
    public @ResponseBody
    Optional<UserRoles> getUserRoleByUserId(@PathVariable Integer userid){

        Optional<UserRoles> u = userRolesRepository.findById(userid);
        return u;
    }

    /**
     *adds new user type.
     * must specify user type so we can update the look up tables
     * @param user
     * @return
     */
    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/add/user", method = RequestMethod.POST)
    public Users addNewUser(@RequestBody Users user)
    {
        Users u = userInfoRepository.save(user);

        if(user.getUsertype().equals(UserTypes.CONTRACTOR))
        {
            //update the contractor to profile id table for look up
        }
        else if(user.getUsertype().equals(UserTypes.CUSTOMER)) {

        }
        else if(user.getUsertype().equals(UserTypes.VENDOR)) {

        }

        return u;
    }

    @RequestMapping(value="/add/address", method = RequestMethod.POST)
    public Addresses addNewUser(@RequestBody Addresses address)
    {
        return addressesRepository.save(address);
    }


}
