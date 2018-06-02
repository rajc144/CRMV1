package com.CRM.CRMV1.enums;

import java.io.Serializable;

public enum UserRoles implements Serializable {

    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_INTERNAL_USER("ROLE_INTERNAL_USER"),
    ROLE_VENDOR("ROLE_VENDOR"),
    ROLE_CLIENT("ROLE_CLIENT");


    private String uRole;

    UserRoles(String role){
        this.uRole = role;

    }

    @Override
    public String toString() {
        return uRole;
    }

    public String getUserRole()
    {
        return this.uRole;
    }

}
