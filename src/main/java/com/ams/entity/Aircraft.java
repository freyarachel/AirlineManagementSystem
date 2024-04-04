package com.ams.entity;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class Aircraft{ 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_gen")
    @GenericGenerator(
        name = "aircraft_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AR_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	@Column(name="AircraftId", length = 20)
	private String aircraftId;


	@Column(name = "AircraftType",length = 30)
	private String aircraftType;

	@Column(name = "Manufacturer",length = 30)
	private String manufacturer;

	@Column(name="Model", length = 20)
	private String model;

	@Column(name="TotalSeats", length = 150)
	private int totalSeats;
	
	
	
	
	//One to Many Aircraft to Airport  
	@OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Airport> airports;

		
	//One to Many - Aircraft to AircraftMaintenance -d
	@OneToMany(mappedBy = "aircraft", cascade=CascadeType.ALL, orphanRemoval = true)
	private List<AircraftMaintenance> aircraftMaintenances=new ArrayList<>();
	
	
	
	
   
	public String getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(String aircraftId) {
		this.aircraftId = aircraftId;
	}

	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	

	public List<AircraftMaintenance> getAircraftMaintenances() {
		return aircraftMaintenances;
	}

	public void setAircraftMaintenances(List<AircraftMaintenance> aircraftMaintenances) {
		this.aircraftMaintenances = aircraftMaintenances;
	}


	public List<Airport> getAirports() {
		return airports;
	}

	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}

	public Aircraft(String aircraftId, String aircraftType, String manufacturer, String model, int totalSeats, List<AircraftMaintenance> aircraftMaintenances, List<Airport> airports) {
		super();
		this.aircraftId = aircraftId;
		this.aircraftType = aircraftType;
		this.manufacturer = manufacturer;
		this.model = model;
		this.totalSeats = totalSeats;
		this.aircraftMaintenances = aircraftMaintenances;
		this.airports = airports;
	}

	public Aircraft() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Aircraft [aircraftId=" + aircraftId + ", aircraftType=" + aircraftType + ", manufacturer="
				+ manufacturer + ", model=" + model + ", totalSeats=" + totalSeats 
				+ ", aircraftMaintenances=" + aircraftMaintenances + ", airports=" + airports + "]";
	}

		
    
    
    //Getters and Setters

	
	
}	
	
