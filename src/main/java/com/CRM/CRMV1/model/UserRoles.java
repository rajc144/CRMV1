package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="userroles")
public class UserRoles {

     @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer role_id;

    private String role_name;

    private String role_desc;
}
