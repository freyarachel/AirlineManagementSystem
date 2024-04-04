package com.ams.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity

public class AircraftMaintenance{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_gen")
    @GenericGenerator(
        name = "aircraft_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "AM_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="AircraftMaintenanceId", length = 20)
	private String aircraftMaintenanceId;
	
	@Column(name ="AircraftMaintenanceDateTime",length = 20)
    private LocalDateTime aircraftMaintenanceDateTime;


	@Column(name="Description", length = 50)
	private String description;

	@Column(name="Cost", length = 20)
	private double cost;
    
    //Many to One AircraftMaintenance to Aircraft(R)-
  	@ManyToOne(cascade=CascadeType.ALL)
  	private Aircraft aircraft;
  	
  	

	public String getAircraftMaintenanceId() {
		return aircraftMaintenanceId;
	}

	public void setAircraftMaintenanceId(String aircraftMaintenanceId) {
		this.aircraftMaintenanceId = aircraftMaintenanceId;
	}

	public LocalDateTime getAircraftMaintenanceDateTime() {
		return aircraftMaintenanceDateTime;
	}

	public void setAircraftMaintenanceDateTime(LocalDateTime aircraftMaintenanceDateTime) {
		this.aircraftMaintenanceDateTime = aircraftMaintenanceDateTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public AircraftMaintenance(String aircraftMaintenanceId, LocalDateTime aircraftMaintenanceDateTime,
			String description, double cost, Aircraft aircraft) {
		super();
		this.aircraftMaintenanceId = aircraftMaintenanceId;
		this.aircraftMaintenanceDateTime = aircraftMaintenanceDateTime;
		this.description = description;
		this.cost = cost;
		this.aircraft = aircraft;
	}

	public AircraftMaintenance() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AircraftMaintenance [aircraftMaintenanceId=" + aircraftMaintenanceId + ", aircraftMaintenanceDateTime="
				+ aircraftMaintenanceDateTime + ", description=" + description + ", cost=" + cost + ", aircraft="
				+ aircraft + "]";
	}
  	
  	
  	
  	//Getters and Setters

	
  	

	  	


}