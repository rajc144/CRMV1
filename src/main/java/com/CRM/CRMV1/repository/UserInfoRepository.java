package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserInfoRepository extends CrudRepository<Users, Integer>  {

    Users findUsersByUsername(String username) throws UsernameNotFoundException;


}
