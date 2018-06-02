package com.CRM.CRMV1.repository;

import com.CRM.CRMV1.model.FollowUps;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FollowUpsRepository extends CrudRepository<FollowUps, Integer> {


    //@Query(value='select a, b from FollowUps fu INNER JOIN FollowupsStatusCodes fc on fu.followups_status_code_id = fc.followups_status_code_id')

   // @Query(value="SELECT f FROM FollowUps f WHERE f.company_id=:company_id")
   // FollowUps findTop(Integer company_id);

}