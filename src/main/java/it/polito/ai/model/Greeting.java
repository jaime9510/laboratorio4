package it.polito.ai.model;

public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

	@Override
	public String toString() {
		return content;
	}
    
    

}
