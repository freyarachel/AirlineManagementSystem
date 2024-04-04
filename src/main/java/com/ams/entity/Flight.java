package com.ams.entity;


import java.time.LocalDateTime;
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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Flight{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_gen")
    @GenericGenerator(
        name = "flight_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "F_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="FlightId", length = 20)
	private String flightId;


	@Column(name = "FlightNumber",length = 30)
	private String flightNumber;
	
	@Column(name ="DepartureDateTime",length = 20)
    private LocalDateTime departureDateTime;
	
	@Column(name ="ArrivalDateTime",length = 20)
    private LocalDateTime arrivalDateTime;


	@Column(name="AvailableSeats", length = 10)
	private int availableSeats;

	@Column(name="Price", length = 20)
	private double price;
	
	
	@Column(name="City", length = 10)
	private String city;

	@Column(name="Country", length = 20)
	private String country;
	
	
		
		
	//One to Many - Flight to Reservation -
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
    
    /*
	//Many to One - Flight to Aircraft -d
	@ManyToOne(cascade=CascadeType.ALL)
	private Aircraft aircraft;
   */
	
	
	//Many to Many - Flight to Passenger(R) 
	@ManyToMany( cascade = CascadeType.ALL)
	 private List<Passenger> passengers = new ArrayList<>();   

    
    //Many to Many - Flight to AirlineEmployee -d
  	@ManyToMany( cascade = CascadeType.ALL)
    private List<AirlineEmployee> airlineEmployees=new ArrayList<>();

  	

	public String getFlightId() {
		return flightId;
	}


	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}


	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}


	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}


	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}


	public int getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
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





	public List<Passenger> getPassengers() {
		return passengers;
	}


	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}


	public List<Reservation> getReservations() {
		return reservations;
	}


	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}


	public List<AirlineEmployee> getAirlineEmployees() {
		return airlineEmployees;
	}


	public void setAirlineEmployees(List<AirlineEmployee> airlineEmployees) {
		this.airlineEmployees = airlineEmployees;
	}


	public Flight(String flightId, String flightNumber, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
			int availableSeats, double price, String city, String country,
			List<Passenger> passengers, List<Reservation> reservations, List<AirlineEmployee> airlineEmployees) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.availableSeats = availableSeats;
		this.price = price;
		this.city = city;
		this.country = country;
		this.passengers = passengers;
		this.reservations = reservations;
		this.airlineEmployees = airlineEmployees;
	}


	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", flightNumber=" + flightNumber + ", departureDateTime="
				+ departureDateTime + ", arrivalDateTime=" + arrivalDateTime + ", availableSeats=" + availableSeats
				+ ", price=" + price + ", city=" + city + ", country=" + country 
				+ ", passengers=" + passengers + ", reservations=" + reservations + ", airlineEmployees="
				+ airlineEmployees + "]";
	}


	
	

	

}
