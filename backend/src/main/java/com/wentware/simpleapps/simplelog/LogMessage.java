package com.wentware.simpleapps.simplelog;


public class LogMessage {

	private long id;
	private String message;

	public LogMessage(long id, String message) {
		this.id = id;
		this.message = message;
	}
	

	public long getId() {
	    return this.id;
	}

	public String getMessage() {
	    return this.message;
	}
}