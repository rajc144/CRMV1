package com.CRM.CRMV1.controller.company;

import com.CRM.CRMV1.model.Address;
import com.CRM.CRMV1.repository.AddressRepository;
import com.CRM.CRMV1.repository.UserInfoRepository;
import com.CRM.CRMV1.model.Users;
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
    AddressRepository addressRepository;

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
    public @ResponseBody
    java.util.Optional<Users> getUserProfileByUserName(@PathVariable String username){

        java.util.Optional<Users> u = userInfoRepository.findUsersByUsername(username);
        return u;
    }


    /**
     * given user id returns their role from the userroles table.
     * @param userid
     * @return

    @GetMapping (path="/role/{userid}")
    public @ResponseBody Optional<UserRoles> getUserRoleByUserId(@PathVariable Integer userid){

        return null;

    }
     */


    /**
     * add new address for a user. requires profile id.
     *
     * @param address
     * @return
     */
    @RequestMapping(value="/add/address", method = RequestMethod.POST)
    public Address addNewAddress(@RequestBody Address address)
    {
        return addressRepository.save(address);
    }

    /**
     * get list of all addresses for give profile id.
     * @param /get/addresses/{profileid}
     * @return
     */

    @RequestMapping(value="/get/addresses/{profileid}", method = RequestMethod.GET)
    public @ResponseBody Optional<Address> addNewUser(@PathVariable Integer profileid)
    {
        return addressRepository.findAddressByProfileid(profileid);
    }


}
