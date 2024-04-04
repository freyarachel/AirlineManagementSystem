package com.ams.entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.JoinColumn;


@Entity

public class AirlineEmployee{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_gen")
    @GenericGenerator(
        name = "passenger_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AE_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="AirlineEmployeeId", length = 20)
	private String airlineEmployeeId;

	@Column(name = "FirstName",length = 30)
	private String firstName;

	@Column(name = "LastName",length = 30)
	private String lastName;

	@Column(name="Gender", length = 10)
	private String gender;

	@Column(name="Email", length = 50)
	private String email;
		
	@Column(name="Position", length = 50)
	private String position;
	
	

	//Many to Many - AirlineEmployee to Flight 
    @ManyToMany(mappedBy="airlineEmployees",cascade = { CascadeType.ALL})
  	private List<Flight> flights=new ArrayList<>();



	public String getAirlineEmployeeId() {
		return airlineEmployeeId;
	}



	public void setAirlineEmployeeId(String airlineEmployeeId) {
		this.airlineEmployeeId = airlineEmployeeId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}





	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public List<Flight> getFlight() {
		return flights;
	}



	public void setFlight(List<Flight> flights) {
		this.flights = flights;
	}



	public AirlineEmployee(String airlineEmployeeId, String firstName, String lastName, String gender, String email, String position, List<Flight> flights) {
		super();
		this.airlineEmployeeId = airlineEmployeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.position = position;
		this.flights = flights;
	}



	public AirlineEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "AirlineEmployee [airlineEmployeeId=" + airlineEmployeeId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", email=" + email  + ", position="
				+ position + ", flight=" + flights + "]";
	}




	
	

}