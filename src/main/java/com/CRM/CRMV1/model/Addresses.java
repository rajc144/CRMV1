package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="addresses")
public class Addresses {

        @Id
        @GeneratedValue(strategy =GenerationType.IDENTITY)
        @Column(name = "address_id")
        private Integer addressId;

        @Column(name = "profile_id")
        private Integer profileId;

        private String address1;

        private String address2;

        private String city;

        private String state;

        private String zipcode;

        private String country;

        private String primary_phone;

        private String secondary_phone;

        private String email;

}
