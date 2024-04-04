package com.ams.dao;

import java.util.List;


import com.ams.entity.Airport;

public interface AirportDao {
	
	
	
	//Airport
	Airport createAirport(Airport airport);
	Airport getAirportById(String airportId);
    void updateAirport(Airport airport);
    List<Airport> getAllAirports();
    void deleteAirport(String airportId);





}