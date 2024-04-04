package com.ams.dao;

import java.util.List;

import com.ams.entity.AirlineEmployee;
import com.ams.entity.Airport;

public interface AirlineEmployeeDao {
	
	//AirlineEmployee
    AirlineEmployee createAirlineEmployee(AirlineEmployee airlineEmployee);
    
    AirlineEmployee getAirlineEmployeeById(String airlineEmployeeId);
    void updateAirlineEmployee(AirlineEmployee airlineEmployee);
    List<AirlineEmployee> getAllAirlineEmployees();
    void deleteAirlineEmployee(String airlineEmployeeId);

}