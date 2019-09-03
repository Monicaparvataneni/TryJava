package com.monica.rest.webservices.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {
private Date timestamp;
private String messsage;
private String description;

public ExceptionResponse(Date timestamp, String messsage, String description) {
	super();
	this.timestamp = timestamp;
	this.messsage = messsage;
	this.description = description;
}
public Date getTimestamp() {
	return timestamp;
}
public void setTimestamp(Date timestamp) {
	this.timestamp = timestamp;
}
public String getMesssage() {
	return messsage;
}
public void setMesssage(String messsage) {
	this.messsage = messsage;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
