package com.CRM.CRMV1.service;

import com.CRM.CRMV1.model.FollowUps;
import com.CRM.CRMV1.repository.FollowUpsRepository;
import com.CRM.CRMV1.repository.FollowUpsStatusCodesRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FollowUpsService {

    @Autowired
    private FollowUpsRepository followUpsRepository;

    @Autowired
    private FollowUpsStatusCodesRepository followUpsStatusCodesRepository;


    public FollowUps getTop5FollowUps(Integer company_id)
    {
        FollowUps fs = followUpsRepository.findAllByCompany_id(company_id);
        fs.setFollowUpsStatusCodes(followUpsStatusCodesRepository.findByStatusCode(fs.getFollowups_status_code_id()));
        return fs;

    }



}
