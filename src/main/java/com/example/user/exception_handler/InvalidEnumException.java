package com.example.user.exception_handler;

public class InvalidEnumException extends Exception {
	
	private String enumValue;
    private String enumName;
	
	public InvalidEnumException(String msg) {
		super(msg);
		System.out.println("invalid");
	}

	public InvalidEnumException(String enumValue, String enumName) {
		  this.enumValue = enumValue;
	        this.enumName = enumName;
	}

	public String getEnumName() {
		return enumName;
	}

	public void setEnumName(String enumName) {
		this.enumName = enumName;
	}

	public String getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}
	
	
}
