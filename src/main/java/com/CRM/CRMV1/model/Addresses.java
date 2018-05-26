package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="addresses")
public class Addresses {

        @Id
        @GeneratedValue(strategy =GenerationType.AUTO)
        private Integer address_id;

        private Integer profile_id;

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
