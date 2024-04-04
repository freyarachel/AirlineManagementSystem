package com.ams.entity;


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

public class Passenger{ 
	
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_gen")
    @GenericGenerator(
        name = "passenger_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "P"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	
	@Column(name="PassengerId", length = 20)
	private String passengerId;

	@Column(name = "FirstName",length = 30)
	private String firstName;

	@Column(name = "LastName",length = 30)
	private String lastName;

	@Column(name="Gender", length = 10)
	private String gender;

	@Column(name="Email", length = 50)
	private String email;
	
	@Column(name="Address", length = 50)
	private String address;
	
	
	//Many to Many Passenger to Reservation -
	@ManyToMany(mappedBy="passengers",cascade = CascadeType.ALL)
	private List<Reservation> reservations;
	
	
	//Many to Many Passenger to Flight 
    @ManyToMany(mappedBy="passengers",cascade = CascadeType.ALL)
	private List<Flight> flights;
    
    


	public String getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public List<Reservation> getReservation() {
		return reservations;
	}



	public void setReservation(List<Reservation> reservation) {
		this.reservations = reservation;
	}



	public List<Flight> getFlight() {
		return flights;
	}



	public void setFlight(List<Flight> flight) {
		this.flights = flight;
	}



	public Passenger(String passengerId, String firstName, String lastName, String gender, String email, String address,
			List<Reservation> reservation, List<Flight> flight) {
		super();
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.reservations = reservation;
		this.flights = flight;
	}



	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", email=" + email + ", address=" + address + ", reservation=" + reservations
				+ ", flight=" + flights + "]";
	}



	

	
		
	

}
