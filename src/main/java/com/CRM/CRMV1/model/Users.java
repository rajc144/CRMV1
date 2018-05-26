package com.CRM.CRMV1.model;


import lombok.Data;
import java.sql.Timestamp;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.time.LocalDateTime;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer profile_id;

    private Integer role_id;

    private String fname;

    private String lname;

    private Integer enabled;

    private Timestamp join_date;

    private String username;

    private String password;

    private Integer usertypes_id;


}
