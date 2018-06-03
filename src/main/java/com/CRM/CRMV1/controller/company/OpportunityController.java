package com.CRM.CRMV1.controller.company;

import com.CRM.CRMV1.model.Address;
import com.CRM.CRMV1.model.Opportunity;
import com.CRM.CRMV1.repository.CompanyRepository;
import com.CRM.CRMV1.repository.OpportunityRepository;
import com.CRM.CRMV1.repository.UserInfoRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
@RequestMapping(value="/company/opp")
public class OpportunityController {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    OpportunityRepository opportunityRepository;


    @RequestMapping(value="/add", method = RequestMethod.POST)
    public Opportunity addNewAddress(@RequestBody Opportunity opportunity)
    {

        return opportunityRepository.save(opportunity);
    }

    @RequestMapping(value="/get/all/company/{companyid}", method = RequestMethod.GET)
    public Iterable<Opportunity> getALlOppsByCompanyId(@PathVariable Integer companyid)
    {

        return opportunityRepository.findAllByCompanyid(companyid);
    }

    @RequestMapping(value="/get/all/customer/{customerid}", method = RequestMethod.GET)
    public Iterable<Opportunity> getALlOppsByClientId(@PathVariable Integer customerid)
    {

        return opportunityRepository.findAllByCustomerid(customerid);
    }

    @RequestMapping(value="/get/all/sales/{salespersonid}", method = RequestMethod.GET)
    public Iterable<Opportunity> getALlOppsBySalesPersonId(@PathVariable Integer salespersonid)
    {

        return opportunityRepository.findAllBySalespersonid(salespersonid);
    }

}
