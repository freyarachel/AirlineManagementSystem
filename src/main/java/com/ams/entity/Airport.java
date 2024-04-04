package com.ams.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Airport{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_gen")
    @GenericGenerator(
        name = "airport_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AP_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="AirportId", length = 20)
	private String airportId;


	@Column(name = "AirportName",length = 30)
	private String airportName;

	@Column(name="City", length = 10)
	private String city;

	@Column(name="Country", length = 20)
	private String country;
	
	
	
	
	//Many To One - Airport to Aircraft-
	@ManyToOne(cascade = CascadeType.ALL)
	private Aircraft aircraft;




	public String getAirportId() {
		return airportId;
	}




	public void setAirportId(String airportId) {
		this.airportId = airportId;
	}




	public String getAirportName() {
		return airportName;
	}




	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public String getCountry() {
		return country;
	}




	public void setCountry(String country) {
		this.country = country;
	}




	




	public Aircraft getAircraft() {
		return aircraft;
	}




	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}




	public Airport(String airportId, String airportName, String city, String country,
			Aircraft aircraft) {
		super();
		this.airportId = airportId;
		this.airportName = airportName;
		this.city = city;
		this.country = country;
		this.aircraft = aircraft;
	}




	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Airport [airportId=" + airportId + ", airportName=" + airportName + ", city=" + city + ", country="
				+ country  + ", aircraft=" + aircraft + "]";
	}


	
	
	
    //Getters and Setters

		

		

	
	
	
	

}