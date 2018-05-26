package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.FollowUpsStatusCodes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FollowUpsStatusCodesRepository extends CrudRepository<FollowUpsStatusCodes, Integer> {


    @Query(value="SELECT f FROM FollowUpsStatusCodes f WHERE f.followups_status_code_id=:code")
    FollowUpsStatusCodes findByStatusCode(Integer code);

}
