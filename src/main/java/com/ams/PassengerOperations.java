package com.ams;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ams.dao.PassengerDao;
import com.ams.daoimpl.PassengerDaoImpl;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;

public class PassengerOperations {

	
	//Passenger

    static Scanner sc = new Scanner(System.in);

    static PassengerDao passengerDao = new PassengerDaoImpl();
    
    private static Passenger passengerInputs() {
        sc.nextLine();
        
        System.out.println("Enter Passenger ID:");
        String passengerId = sc.nextLine();

        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();

        System.out.println("Enter Address:");
        String address = sc.nextLine();
                

        List<Reservation> reservation = new ArrayList<Reservation>();
        
        List<Flight> flight = new ArrayList<Flight>();
        


        return new Passenger(passengerId, firstName, lastName, gender, email, address,reservation,flight);


    }


    public static void passengerDetails() {
        
        System.out.println("1.Insert Passenger Details");
		System.out.println("2.Get Passenger details");
		System.out.println("3.Update Passenger Details");
		System.out.println("4.Get all Passengers Details");
		System.out.println("5.Delete Passenger Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                Passenger passenger = passengerInputs();
                Passenger savedPassenger = passengerDao.createPassenger(passenger);
               System.out.println("Passenger "+savedPassenger+" added successfully:");
           
                break;
                
            case 2:
         	   
                System.out.println("Enter Passenger ID:");
                String passengerId = sc.next();
                
                Passenger passengerById = passengerDao.getPassengerById(passengerId); 
                if (passengerById != null) {
                    System.out.println("Passenger details: " + passengerById);
                } else {
                    System.out.println("Passenger not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Passenger ID to update:");
                String updatePassengerId = sc.next(); // Read Route ID from user
            	
                Passenger passengerToUpdate = passengerDao.getPassengerById(updatePassengerId); // Get Route by ID
                if (passengerToUpdate != null) {
                	passengerToUpdate.setFirstName("Regina");
                	passengerToUpdate.setEmail("regina@gmail.com");

                	passengerDao.updatePassenger(passengerToUpdate); // Update the Route
                    System.out.println("Passenger updated successfully.");
                } else {
                    System.out.println("Passenger not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Passenger> passengers = passengerDao.getAllPassengers();
            	for (Passenger a : passengers) {
            	    System.out.println("Passenger details:");
            	    System.out.println("Passenger ID : " + a.getPassengerId());
            	    System.out.println("First Name : " + a.getFirstName());
            	    System.out.println("Last Name : " + a.getLastName());
            	    System.out.println("Gender: " + a.getGender());
            	    System.out.println("Email : " + a.getEmail());

            	    System.out.println("-----------------------------------");

            	}

            	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Passenger ID to delete:");
                String deletePassengerId = sc.next(); // Read Route ID from user
                passengerDao.deletePassenger(deletePassengerId); // Delete Route by ID
                System.out.println("Passenger deleted successfully.");
            	
            	break;
            	
                        
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;

        }
    }
}
