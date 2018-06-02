package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {



}
