package it.polito.ai.model;

import java.util.GregorianCalendar;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Message 
{
	@Id
	private ObjectId id;
	
	private String nickName;
	private String message;
	private GregorianCalendar timestamp;
	
	
	
	
	public Message() 
	{
	}

	public Message(String nickName, String message, GregorianCalendar timestamp) 
	{
		this.nickName = nickName;
		this.message = message;
		this.timestamp = timestamp;
	}
	
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public GregorianCalendar getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(GregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}
	
	
	

}
