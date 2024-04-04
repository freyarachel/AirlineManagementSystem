package com.ams;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.ams.dao.AirportDao;
import com.ams.daoimpl.AirportDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.Airport;
import com.ams.entity.Passenger;

public class AirportOperations {

	//Airport
	
	static Scanner sc = new Scanner(System.in);

    static AirportDao airportDao = new AirportDaoImpl();
    
    private static Airport airportInputs() {
        sc.nextLine();
        
        System.out.println("Enter Airport ID: ");
        String airportId = sc.nextLine();
        
        
        System.out.println("Enter Airport Name:");
        String airportName = sc.nextLine();
        
        System.out.println("Enter City:");
        String city = sc.nextLine();

        System.out.println("Enter Country:");
        String country = sc.nextLine();

        
        Aircraft aircraft = new Aircraft();

        return new Airport(airportId, airportName, city, country, aircraft);

    }


	public static void airportDetails() {
        
        System.out.println("1.Insert Airport Details");
		System.out.println("2.Get Airport details based on id");
		System.out.println("3.Update Airport Details");
		System.out.println("4.Get all Airport details");
		System.out.println("5.Delete Airport Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Airport airport = airportInputs();
            	Airport savedAirport = airportDao.createAirport(airport);
               System.out.println("Airport "+savedAirport+" added successfully:");
           
                break;
                
            case 2:
          	   
                System.out.println("Enter Airport ID:");
                String airportId = sc.next();
                
                Airport airportById = airportDao.getAirportById(airportId); 
                if (airportById != null) {
                    System.out.println("Airport details: " + airportById);
                } else {
                    System.out.println("Airport not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Airport ID to update:");
                String updateAirportId = sc.next(); // Read Route ID from user
            	
                Airport airportToUpdate = airportDao.getAirportById(updateAirportId); // Get Route by ID
                if (airportToUpdate != null) {
                	airportToUpdate.setCity("London");
                	airportToUpdate.setCountry("United Kingdom");
                	airportDao.updateAirport(airportToUpdate); // Update the Route
                    System.out.println("Airport updated successfully.");
                } else {
                    System.out.println("Airport not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Airport> airports = airportDao.getAllAirports();
            	
            	for (Airport a : airports) {
            	    System.out.println("Airport details:");
            	    System.out.println("Airport ID: " + a.getAirportId());
            	    System.out.println("Airport Name: " + a.getAirportName());
            	    System.out.println("City: " + a.getCity());
            	    System.out.println("Country: " + a.getCountry());
            	    System.out.println("-----------------------------------");
            	    
            	    

            	}

            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Airport ID to delete:");
                String deleteAirportId = sc.next(); // Read Route ID from user
                airportDao.deleteAirport(deleteAirportId); // Delete Route by ID
                System.out.println("Airport deleted successfully.");
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }
}
