package it.polito.ai.web.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import it.polito.ai.model.Auto;
import it.polito.ai.validation.PasswordMatches;

@PasswordMatches
public class UserDto {
	
    @NotNull
    @Size(min = 1)
	private String nickName;

    private String password;

    @NotNull
    @Size(min = 1)
    private String matchingPassword;

    @NotNull
    @Size(min = 1)
    @Email
    private String email;
    
	private String gender;
	private Integer years;
	private String instructionLevel;
	private String ocupation;
	private Auto auto;
	private String carSharing;
	private String bike;
	private String publicTransport;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public String getInstructionLevel() {
		return instructionLevel;
	}

	public void setInstructionLevel(String instructionLevel) {
		this.instructionLevel = instructionLevel;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public Auto getAuto() {
		return auto;
	}

	public void setAuto(Auto auto) {
		this.auto = auto;
	}

	public String getCarSharing() {
		return carSharing;
	}

	public void setCarSharing(String carSharing) {
		this.carSharing = carSharing;
	}

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}

	public String getPublicTransport() {
		return publicTransport;
	}

	public void setPublicTransport(String publicTransport) {
		this.publicTransport = publicTransport;
	}

	@Override
	public String toString() {
		return "UserDto [nickName=" + nickName + ", password=" + password + ", matchingPassword=" + matchingPassword
				+ ", email=" + email + ", gender=" + gender + ", years=" + years + ", instructionLevel="
				+ instructionLevel + ", ocupation=" + ocupation + ", auto=" + auto + ", carSharing=" + carSharing
				+ ", bike=" + bike + ", publicTransport=" + publicTransport + "]";
	}
    
}
