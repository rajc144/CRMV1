package com.CRM.CRMV1.controller.company;


import com.CRM.CRMV1.model.Address;
import com.CRM.CRMV1.model.Company;
import com.CRM.CRMV1.model.Users;
import com.CRM.CRMV1.repository.AddressRepository;
import com.CRM.CRMV1.repository.CompanyRepository;
import com.CRM.CRMV1.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/company")
public class CompanyController {


    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    AddressRepository addressRepository;


    /**
     * use to add new company to the database.
     * it will first generate a random company id
     * use that as company_id in company and users table.
     *
     * @param newCompany
     * @return company id.  if need user info, then call /get/{profileid}
     */

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Company addNewCompany(@RequestBody Users newCompany)
    {
        //set current time stamp for join date when adding a new user
        Calendar calendar = Calendar.getInstance();
        newCompany.setJoindate(new java.sql.Timestamp(calendar.getTime().getTime()));

        Integer rnd = new Random().nextInt(10000000);


        // now add that record to the users table
        newCompany.setCompanyid(rnd);

        //todo: need to set the role
        //newCompany.setRole(UserTypes.getUserType()); //this end point is for contractors only.  so set their type as contractor.  so Front end does not have to do so.

        Users u = userInfoRepository.save(newCompany);

        //then use the company id to save the company table
        Company c = new Company();
        c.setCompanyid(u.getCompanyid());
        c.setProfileid(u.getProfileid());
        c = companyRepository.save(c);

        return c;


    }

    @RequestMapping(value="/login/{username}")
    public Optional<Users> getUserByUserName(@PathVariable String username)
    {
        return userInfoRepository.findUsersByUsername(username);
    }

    /**
     * Creates new user in the users table.
     *
     * @param user
     * @return newly created user.
     */
    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/add/client", method = RequestMethod.POST)
    public Users addNewUser(@RequestBody Users user)
    {

        if(user.getCompanyid().equals(null))
            return null;

        user.setRole("ROLE_CLIENT");
        user.setUsertype("CUSTOMER");

        Users u = userInfoRepository.save(user);

        //update the company table to indicate this user belongs to this company (we can many to many in this way).

        Company c = new Company();
        c.setCompanyid(u.getCompanyid()); //company who is adding this user as their client
        c.setProfileid(u.getProfileid()); //newly created profile by the save aboe.


        return u;
    }


    /**
     * Creates new address for the client .
     *
     * @param address
     * @return newly created address.
     */
    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/add/client/address", method = RequestMethod.POST)
    public Address addNewUser(@RequestBody Address address)
    {
        return addressRepository.save(address);
    }


    /**
     * get list of all addresses for the client .
     *
     * @param profileid
     * @return List of all addresses.
     */
    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/get/client/addresses/{profileid}", method = RequestMethod.GET)
    public Iterable<Address> getAllAddressesByProfileId (@PathVariable Integer profileid)
    {
        return addressRepository.findAllByProfileid(profileid);
    }



    @RequestMapping(value="/get/users/{companyid}", method = RequestMethod.GET)
    public List<Object[]> getAllUserByCompanyId (@PathVariable Integer companyid)
    {
        return companyRepository.findAllCompanyUsersByCompanyid(companyid);
    }


    /**
     * get list of all addresses for the client .
     *
     * @param profileid
     * @return List of all addresses.

    //todo: handle errors (e.g. if user exist)
    @RequestMapping(value="/get/clients/{companyid}", method = RequestMethod.GET)
    public Iterable<Users> getAllAddressesByProfileId (@PathVariable Integer companyid)
    {
        return userInfoRepository.findAllByProfileid(companyid);
    }

  */

}
