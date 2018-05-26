package com.CRM.CRMV1.model;


import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer profile_id;

    private String fname;

    private String lname;

    private Integer enabled;

    private DateTime join_date;

    private String username;

    private String password;

    private Integer usertypes_id;

    private Integer role_id;
}
