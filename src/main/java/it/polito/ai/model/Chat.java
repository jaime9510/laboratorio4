package it.polito.ai.model;

import java.io.File;

public class Chat 
{
	private Greeting greeting;
	private File immagine;
	
	
	
	public Chat(Greeting greeting, File immagine) {
		super();
		this.greeting = greeting;
		this.immagine = immagine;
	}
	public Greeting getGreeting() {
		return greeting;
	}
	public void setGreeting(Greeting greeting) {
		this.greeting = greeting;
	}
	public String getImmagine() {
		return immagine.getPath();
	}
	public void setImmagine(File immagine) {
		this.immagine = immagine;
	}
	@Override
	public String toString() {
		return greeting.toString();
	}
	
	
	
	

}
