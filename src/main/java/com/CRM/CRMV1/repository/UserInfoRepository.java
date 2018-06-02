package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<Users, Integer>  {

    Optional<Users> findUsersByUsername(String username) throws UsernameNotFoundException;

    Iterable<Users> findAllByCompanyid(Integer companyid);

    Users save(Users users);

}
