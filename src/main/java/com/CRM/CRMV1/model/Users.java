package com.CRM.CRMV1.model;


import lombok.Data;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "profileid")
    private Integer profileid;

    private String role;

    private String fname;

    private String lname;

    private Integer enabled;

    private Timestamp joindate;

    private String username;

    private String password;

    private String usertype;

    private String businessname;

    private Integer companyid;

    private Integer customerid;

    private Integer vendorid;

    private String owner;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp created;

    @UpdateTimestamp
    @Column(name = "modified")
    private Timestamp modified;



}
