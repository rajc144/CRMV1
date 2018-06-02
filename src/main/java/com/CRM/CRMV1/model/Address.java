package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="address")
public class Address {

        @Id
        @GeneratedValue(strategy =GenerationType.IDENTITY)
        @Column(name = "addressid")
        private Integer addressid;

        private Integer profileid;

        private String address1;

        private String address2;

        private String city;

        private String state;

        private String zipcode;

        private String country;


        private String primaryphone;


        private String secondaryphone;

        private String email;

}
