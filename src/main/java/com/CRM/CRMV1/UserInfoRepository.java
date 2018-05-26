package com.CRM.CRMV1;

import com.CRM.CRMV1.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserInfoRepository extends CrudRepository<Users, Integer> {
}
