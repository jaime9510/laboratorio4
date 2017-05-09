package it.polito.ai.model;

public class Auto {
	
	private Integer registrationYear;
	private String typeFuel;
	
	public Auto() {
	}
	
	public Auto(Integer registrationYear, String typeFuel) {
		super();
		this.registrationYear = registrationYear;
		this.typeFuel = typeFuel;
	}

	public Integer getRegistrationYear() {
		return registrationYear;
	}
	public void setRegistrationYear(Integer registrationYear) {
		this.registrationYear = registrationYear;
	}
	public String getTypeFuel() {
		return typeFuel;
	}
	public void setTypeFuel(String typeFuel) {
		this.typeFuel = typeFuel;
	}
	
	

}
