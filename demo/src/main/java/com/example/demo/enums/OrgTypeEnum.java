package com.example.demo.enums;

public enum OrgTypeEnum {
	COMPANY(0), DIVISION(1), DEPARTMENT(2), MEMBER(3);

	private int authCode;

	OrgTypeEnum(int authCode) {
		this.authCode = authCode;
	}

	public int getCode() {
		return this.authCode;
	}
}
