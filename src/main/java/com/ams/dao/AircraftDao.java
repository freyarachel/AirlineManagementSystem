package com.ams.dao;

import java.util.List;

import com.ams.entity.Aircraft;
import com.ams.entity.Airport;


public interface AircraftDao {
	
	//Aircraft
    Aircraft createAircraft(Aircraft aircraft);

    Aircraft getAircraftById(String aircraftId);
    void updateAircraft(Aircraft aircraft);
    List<Aircraft> getAllAircrafts();
    void deleteAircraft(String aircraftId);

   
}
