package com.CRM.CRMV1.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="company")
public class Company {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    private Integer companyid;

    private Integer profileid;

}

