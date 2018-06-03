package com.CRM.CRMV1.enums;

import java.io.Serializable;

public enum OpportunityStatus implements Serializable {

    OPEN("OPEN"),
    SOLD("SOLD"),
    LOST("LOST"),
    NOOPPORTUNITY("NOOPPORTUNITY");


    private String oppStatus;

    OpportunityStatus(String role){
        this.oppStatus = oppStatus;

    }

    @Override
    public String toString() {
        return oppStatus;
    }

    public String getUserRole()
    {
        return this.oppStatus;
    }
}
