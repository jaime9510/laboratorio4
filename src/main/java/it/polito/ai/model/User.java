package it.polito.ai.model;

import java.io.File;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.gridfs.GridFS;

@Document
public class User {
	
	@Id
	private ObjectId id;
	
	private String gender;
	private Integer years;
	private String instructionLevel;
	private String ocupation;
	private Auto auto;
	private String carSharing;
	private String bike;
	private String publicTransport;
	private String nickName;
	private String email;
	private String password;
	private String role;
	//private File immagine;
	//private String stringImage;

	// TODO: Field for profile photo

	public User(ObjectId id, String gender, Integer years, String instructionLevel, String ocupation, Auto auto,
			String carSharing, String bike, String publicTransport, String nickName, String email, String password,
			String role/*, File Image, String StringImage*/) {
		super();
		this.id = id;
		this.gender = gender;
		this.years = years;
		this.instructionLevel = instructionLevel;
		this.ocupation = ocupation;
		this.auto = auto;
		this.carSharing = carSharing;
		this.bike = bike;
		this.publicTransport = publicTransport;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		//this.immagine=Image;
		//this.stringImage= StringImage;
	}

	public User() {
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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
	
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public File getImmagine() {
		return immagine;
	}

	public void setImmagine(File immagine) {
		this.immagine = immagine;
	}

	
	
	public String getStringImage() {
		return stringImage;
	}

	public void setStringImage(String stringImage) {
		this.stringImage = stringImage;
	}*/

	@Override
	public String toString() {
		return "User [id=" + id + ", gender=" + gender + ", years=" + years + ", instructionLevel=" + instructionLevel
				+ ", ocupation=" + ocupation + ", auto=" + auto + ", carSharing=" + carSharing + ", bike=" + bike
				+ ", publicTransport=" + publicTransport + ", nickName=" + nickName + ", email=" + email + ", password="
				+ password + ", role=" + role + "]";
	}

	
	
	

}
