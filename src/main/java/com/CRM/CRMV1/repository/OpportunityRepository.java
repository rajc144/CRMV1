package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Opportunity;
import org.springframework.data.repository.CrudRepository;

public interface OpportunityRepository extends CrudRepository<Opportunity, Integer> {


    Iterable<Opportunity> findAllByCompanyid(Integer companyid);

    Iterable<Opportunity> findAllByCustomerid(Integer customerid);

    Iterable<Opportunity> findAllBySalespersonid(Integer salespersonid);



}
