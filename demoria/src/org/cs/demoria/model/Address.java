package org.cs.demoria.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Embeddable
public class Address {

	@NotNull
	@Pattern(regexp = ".+", message = "Street name must not be empty!")
	private String streetName;
	
	@NotNull
	@Pattern(regexp = ".+", message = "Street number must not be empty!")
	private String streetNum;
	
	@NotNull
	@Pattern(regexp = ".+", message = "City must not be empty!")
	private String city;
	
	@NotNull
	@Pattern(regexp = ".+", message = "Zip code must not be empty!")
	private String zipCode;
	
	private String state;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
