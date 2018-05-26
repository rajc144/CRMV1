package com.CRM.CRMV1.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="followups_status_codes")
public class FollowUpsStatusCodes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer followups_status_code_id;

    private String followups_status_code_name;

    private String followups_status_code_desc;
}
