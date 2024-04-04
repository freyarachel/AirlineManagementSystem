package com.ams.dao;

import java.util.List;

import com.ams.entity.Passenger;
import com.ams.entity.Payment;

public interface PassengerDao {
	
	
	//Passenger
    Passenger createPassenger(Passenger passenger);   
    Passenger getPassengerById(String passengerId);
    void updatePassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    void deletePassenger(String passengerId);
    

    

}
