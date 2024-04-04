package com.ams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ams.dao.AirlineEmployeeDao;
import com.ams.daoimpl.AirlineEmployeeDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;

public class AirlineEmployeeOperations {
	
	
	//AirlineEmployee
	
	static Scanner sc = new Scanner(System.in);

    static AirlineEmployeeDao airlineEmployeeDao = new AirlineEmployeeDaoImpl();
    
    private static AirlineEmployee airlineEmployeeInputs() {
        sc.nextLine();
        
        System.out.println("Enter AirlineEmployee  ID: ");
        String airlineEmployeeId = sc.nextLine();
        
        
        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();

        System.out.println("Enter Gender:");
        String gender = sc.nextLine();

        System.out.println("Enter Email:");
        String email = sc.nextLine();
      
        System.out.println("Enter Position:");
        String position = sc.nextLine();
        
        List<Flight> flights  = new ArrayList<Flight>();

        
       
        return new AirlineEmployee(airlineEmployeeId,firstName, lastName, gender, email,position,flights);

    }


	public static void airlineEmployeeDetails() {
        
        System.out.println("1.Insert AirlineEmployee Details");
		System.out.println("2.Get AirlineEmployee details based on id");
		System.out.println("3.Update AirlineEmployee Details");
		System.out.println("4.Get all AirlineEmployee details");
		System.out.println("5.Delete AirlineEmployee Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	AirlineEmployee  airlineEmployee = airlineEmployeeInputs();
            	AirlineEmployee savedAirlineEmployee = airlineEmployeeDao.createAirlineEmployee( airlineEmployee);
               System.out.println("AirlineEmployee "+savedAirlineEmployee+" added successfully:");
           
                break;
                
            case 2:
          	   
                System.out.println("Enter AirlineEmployee ID:");
                String airlineEmployeeId = sc.next();
                
                AirlineEmployee airlineEmployeeById = airlineEmployeeDao.getAirlineEmployeeById(airlineEmployeeId); 
                if (airlineEmployeeById != null) {
                    System.out.println("AirlineEmployee details: " + airlineEmployeeById);
                } else {
                    System.out.println("AirlineEmployee not found.");
                }
            	 	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter AirlineEmployee ID to update:");
                String updateAirlineEmployeeId = sc.next(); // Read Route ID from user
            	
                AirlineEmployee airlineEmployeeToUpdate = airlineEmployeeDao.getAirlineEmployeeById(updateAirlineEmployeeId); // Get Route by ID
                if (airlineEmployeeToUpdate != null) {
                	airlineEmployeeToUpdate.setFirstName("Regina");
                	airlineEmployeeDao.updateAirlineEmployee(airlineEmployeeToUpdate); // Update the Route
                    System.out.println("AirlineEmployee updated successfully.");
                } else {
                    System.out.println("AirlineEmployee not found.");
                }
            	
            	break;
            	
            	
            case 4:   	
            	
            	List<AirlineEmployee> airlineEmployees = airlineEmployeeDao.getAllAirlineEmployees();
            	for (AirlineEmployee a : airlineEmployees) {
            	    System.out.println("AirlineEmployee details:");
            	    System.out.println("AirlineEmployee ID: " + a.getAirlineEmployeeId());
            	    System.out.println("First Name: " + a.getFirstName());
            	    System.out.println("Last Name: " + a.getLastName());
            	    System.out.println("Gender: " + a.getGender());
            	    System.out.println("Email : " + a.getEmail());
            	    System.out.println("Position : " + a.getPosition());

            	    System.out.println("-----------------------------------");

            	}

            	
            	break;
            	
            case 5:
            	          	
            	System.out.println("Enter AirlineEmployee ID to delete:");
                String deleteAirlineEmployeeId = sc.next(); // Read Route ID from user
                airlineEmployeeDao.deleteAirlineEmployee(deleteAirlineEmployeeId); // Delete Route by ID
                System.out.println("AirlineEmployee deleted successfully.");
            	
            	break;
            
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        
    }
	


}
