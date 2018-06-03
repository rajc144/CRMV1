package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
public class Opportunity {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "opportunityid")
    private Integer opportunityid;

    private Integer companyid;

    private Integer customerid;

    private String title;

    private Integer confidence;

    //projected sale date
    private Timestamp saledate;

    private String tags;

    private Double minrev;

    private Double maxrev;

    private Integer addressid;

    private Integer salespersonid;

    private String projecttype;

    private Integer source;

    private String status;


}
