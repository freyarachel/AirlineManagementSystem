package com.ams.dao;

import java.util.List;

import com.ams.entity.Flight;
import com.ams.entity.Passenger;

public interface FlightDao {
	
	//Flight 
    Flight createFlight(Flight flight);
    
    Flight getFlightById(String flightId);
    void updateFlight(Flight flight);
    List<Flight> getAllFlights();
    void deleteFlight(String flightId);


}
