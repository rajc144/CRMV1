package com.crm.enums;

import java.io.Serializable;

public enum UserTypes implements Serializable {

	CONTRACTOR("CONTRACTOR"), CUSTOMER("CUSTOMER"), SUBCONTRACTOR("SUBCONTRACTOR");

	private String userType;

	UserTypes(String uType) {
		this.userType = uType;
	}

	@Override
	public String toString() {
		return userType;
	}

	public String getUserType() {
		return this.userType;
	}
}
