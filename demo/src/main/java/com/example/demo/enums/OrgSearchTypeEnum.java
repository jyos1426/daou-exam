package com.example.demo.enums;

public enum OrgSearchTypeEnum {
	DEPARTMENT("dept"), MEMBER("member");

	private String authCode;

	OrgSearchTypeEnum(String authCode) {
		this.authCode = authCode;
	}

	public String getCode() {
		return this.authCode;
	}
}
