package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Company;
import com.CRM.CRMV1.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @Query(value="SELECT fname, lname, profileid from users where companyid= :companyid and role in('ROLE_ADMIN', 'ROLE_INTERNAL_USER')" ,nativeQuery=true)
    List<Object[]> findAllCompanyUsersByCompanyid(@Param("companyid")Integer companyid);
}
