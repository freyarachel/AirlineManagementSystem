package com.ams;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.ams.dao.AircraftMaintenanceDao;
import com.ams.daoimpl.AircraftMaintenanceDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.entity.Passenger;

public class AircraftMaintenanceOperations {
	
	
	
	//AircraftMaintenance
	
	static Scanner sc = new Scanner(System.in);

    static AircraftMaintenanceDao aircraftMaintenanceDao = new AircraftMaintenanceDaoImpl();
    
    
    private static AircraftMaintenance aircraftMaintenanceInputs() {
        sc.nextLine();
        
        System.out.println("Enter AircraftMaintenance ID: ");
        String aircraftMaintenanceId = sc.nextLine();       
        
        System.out.println("Enter AircraftMaintenance DateTime in the format yyyy-MM-dd HH:mm:ss :");
        String aircraftMaintenanceDateTimeInput=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime aircraftMaintenanceDateTime = LocalDateTime.parse(aircraftMaintenanceDateTimeInput, formatter);
        
        System.out.println("Enter Description: ");
        String description = sc.nextLine();
        
        System.out.println("Enter cost: ");
        double cost = sc.nextDouble();
        

        Aircraft aircraft=new Aircraft(); 

       
        return new AircraftMaintenance(aircraftMaintenanceId,aircraftMaintenanceDateTime, description, cost, aircraft);

    }


	public static void aircraftMaintenanceDetails() {
        
        System.out.println("1.Insert AircraftMaintenance Details");
		System.out.println("2.Get AircraftMaintenance details based on id");
		System.out.println("3.Update AircraftMaintenance Details");
		System.out.println("4.Get all AircraftMaintenance details");
		System.out.println("5.Delete AircraftMaintenance Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	AircraftMaintenance  aircraftMaintenance = aircraftMaintenanceInputs();
            	AircraftMaintenance savedAircraftMaintenance = aircraftMaintenanceDao.createAircraftMaintenance( aircraftMaintenance);
               System.out.println("AircraftMaintenance "+savedAircraftMaintenance+" added successfully:");
           
                break;
                
                
            case 2:
          	   
                System.out.println("Enter AircraftMaintenance ID:");
                String aircraftMaintenanceId = sc.next();
                
                AircraftMaintenance aircraftMaintenanceById = aircraftMaintenanceDao.getAircraftMaintenanceById(aircraftMaintenanceId); 
                if (aircraftMaintenanceById != null) {
                    System.out.println("AircraftMaintenance details: " + aircraftMaintenanceById);
                } else {
                    System.out.println("AircraftMaintenance not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter AircraftMaintenance ID to update:");
                String updateAircraftMaintenanceId = sc.next(); // Read Route ID from user
            	
                AircraftMaintenance aircraftMaintenanceToUpdate = aircraftMaintenanceDao.getAircraftMaintenanceById(updateAircraftMaintenanceId); // Get Route by ID
                if (aircraftMaintenanceToUpdate != null) {
                	aircraftMaintenanceToUpdate.setDescription("Dents");//dents,corrosion,landing gear,software glitch
                	aircraftMaintenanceToUpdate.setCost(150000);
                	aircraftMaintenanceDao.updateAircraftMaintenance(aircraftMaintenanceToUpdate); // Update the Route
                    System.out.println("AircraftMaintenance updated successfully.");
                } else {
                    System.out.println("AircraftMaintenance not found.");
                }
            	
            	break;
            	
            	
            	
            case 4:   	
            	
            	List<AircraftMaintenance> aircraftMaintenances = aircraftMaintenanceDao.getAllAircraftMaintenances();
            	
            	for (AircraftMaintenance a : aircraftMaintenances) {
            	    System.out.println("AircraftMaintenance details:");
            	    System.out.println("AircraftMaintenance ID: " + a.getAircraftMaintenanceId());
            	    System.out.println("DateTime : " + a.getAircraftMaintenanceDateTime());
            	    System.out.println("Description: " + a.getDescription());
            	    System.out.println("Cost: " + a.getCost());
            	    System.out.println("-----------------------------------");

            	}    	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter AircraftMaintenance ID to delete:");
                String deleteAircraftMaintenanceId = sc.next(); // Read Route ID from user
                aircraftMaintenanceDao.deleteAircraftMaintenance(deleteAircraftMaintenanceId); // Delete Route by ID
                System.out.println("AircraftMaintenance deleted successfully.");
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }


}
