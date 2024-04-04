package com.ams;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ams.dao.AircraftDao;
import com.ams.daoimpl.AircraftDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.entity.Airport;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;

public class AircraftOperations {

	//Aircraft
		
	static Scanner sc = new Scanner(System.in);

    static AircraftDao aircraftDao = new AircraftDaoImpl();
    
    private static Aircraft aircraftInputs() {
        sc.nextLine();
        
        System.out.println("Enter Aircraft ID: ");
        String aircraftId = sc.nextLine();
        
        
        System.out.println("Enter Aircraft Name:");
        String aircraftName = sc.nextLine();
        
        System.out.println("Enter Manufacturer:");
        String manufacturer = sc.nextLine();

        System.out.println("Enter Model:");
        String model = sc.nextLine();
        
        System.out.println("Enter Total seats:");
        int totalSeats = sc.nextInt();
        

        List<AircraftMaintenance> aircraftMaintenances = new ArrayList<AircraftMaintenance>();
    	
        List<Airport> airports = new ArrayList<Airport>();
        


        return new Aircraft(aircraftId, aircraftName, manufacturer, model,totalSeats,aircraftMaintenances,airports);

    }


	public static void aircraftDetails() {
        
        System.out.println("1.Insert Aircraft Details");
		System.out.println("2.Get Aircraft details based on id");
		System.out.println("3.Update Aircraft Details");
		System.out.println("4.Get all Aircraft details");
		System.out.println("5.Delete Aircraft Details");
		System.out.println("6.Join Aircraft and Aiprort Details");
		System.out.println("7.Join  Aircraft Maintenances Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Aircraft aircraft = aircraftInputs();
            	Aircraft savedAircraft = aircraftDao.createAircraft(aircraft);
               System.out.println("Aircraft "+savedAircraft+" added successfully:");
           
                break;
                
                
            case 2:
          	   
                System.out.println("Enter Aircraft ID:");
                String aircraftId = sc.next();
                
                Aircraft aircraftById = aircraftDao.getAircraftById(aircraftId); 
                if (aircraftById != null) {
                    System.out.println("Aircraft details: " + aircraftById);
                } else {
                    System.out.println("Aircraft not found.");
                }
                    
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Aircraft ID to update:");
                String updateAircraftId = sc.next(); // Read Route ID from user
            	
                Aircraft aircraftToUpdate = aircraftDao.getAircraftById(updateAircraftId); // Get Route by ID
                if (aircraftToUpdate != null) {
                	
                	aircraftToUpdate.setManufacturer("Boeing");//Boeing,airbus,Beechcraft
                	aircraftToUpdate.setModel("Regional");//business,commercial
                	aircraftDao.updateAircraft(aircraftToUpdate); // Update the Route
                    System.out.println("Aircraft updated successfully.");
                } else {
                    System.out.println("Aircraft not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<Aircraft> aircrafts = aircraftDao.getAllAircrafts();
            	for (Aircraft a : aircrafts) {
            	    System.out.println("Aircraft details:");
            	    System.out.println("Aircraft ID: " + a.getAircraftId());
            	    System.out.println("Type: " + a.getAircraftType());
            	    System.out.println("Manufacturer: " + a.getManufacturer());
            	    System.out.println("Model: " + a.getModel());
            	    System.out.println("Total Seats : " + a.getTotalSeats());
            	    System.out.println("-----------------------------------");

            	}
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter Aircraft ID to delete:");
                String deleteAircraftId = sc.next(); // Read Route ID from user
                aircraftDao.deleteAircraft(deleteAircraftId); // Delete Route by ID
                System.out.println("Aircraft deleted successfully.");
            	
            	break;
            	
            	
            case 6:
            	
            	System.out.println("Joining Aircraft and Airport:");
            	List<Aircraft> joinAirport= aircraftDao.getAllAircrafts();
            	for (Aircraft a : joinAirport) {
					System.out.println(a.getAircraftId() + ", " +
			                   a.getAirports().stream()
			                                  .map(ap -> String.valueOf(ap.getAirportId()))
			                                  .collect(Collectors.joining(", ")));	    
				}
            	
            	break;
            	
             case 7:
            	
            	System.out.println("Joining Aircraft and Aircraft Maintenances:");
            	List<Aircraft> joinMaintenances = aircraftDao.getAllAircrafts();
            	System.out.println("Aircraft  |   Aircraft Maintenances");
            	for (Aircraft a : joinMaintenances) {
					System.out.println(a.getAircraftId() + ", " +
			                   a.getAircraftMaintenances().stream()
			                                  .map(ap -> String.valueOf(ap.getAircraftMaintenanceId()))
			                                  .collect(Collectors.joining(", ")));	    
				}
            	
            	break;
            	
            
            
            	
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }
}
