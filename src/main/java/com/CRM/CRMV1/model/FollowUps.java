package com.CRM.CRMV1.model;


import java.sql.Timestamp;
import lombok.Data;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;


@Entity
@Data
@Table(name="followups")
public class FollowUps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer followups_id;

    private Integer followups_status_code_id;

    private Integer opportunity_id;

    private String followups_desc;

    private Timestamp when_to_followup;

    private Integer assigned_to;

    private Integer address_to_followup_on;

    private Integer remind_assigned_user;

    private Integer followup_type_id;

    private Integer company_id;

    private String followups_status_code_name;

    @Transient
    private FollowUpsStatusCodes followUpsStatusCodes;

}
