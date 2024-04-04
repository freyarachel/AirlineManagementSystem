package com.ams;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.ams.dao.FlightDao;
import com.ams.daoimpl.FlightDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Airport;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;
import com.ams.entity.Reservation;
import com.google.protobuf.TextFormat.ParseException;

public class FlightOperations {

    //Flight
	
	static Scanner sc = new Scanner(System.in);

    
    
    static FlightDao flightDao = new FlightDaoImpl();
    
        private static Flight flightInputs() throws ParseException {
            sc.nextLine();

            System.out.println("Enter Flight ID:");
            String flightId = sc.nextLine();

            System.out.println("Enter Flight Number:");
            String flightNumber = sc.nextLine();

            System.out.println("Enter Departure Date and Time in yyyy-MM-dd HH:mm:ss:");
            String departureDateTimeInput=sc.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime departureDateTime= LocalDateTime.parse(departureDateTimeInput, formatter);
            
                            
            System.out.println("Enter Arrival DateTime in the format yyyy-MM-dd HH:mm:ss :");
            String arrivalDateTimeInput=sc.nextLine();
            LocalDateTime arrivalDateTime = LocalDateTime.parse(arrivalDateTimeInput, formatter);
            
            System.out.println("Enter Available Seats:");
            int availableSeats = sc.nextInt();

            System.out.println("Enter Price:");
            double price = sc.nextDouble();
            
            System.out.println("Enter City:");
            String city = sc.nextLine();
            sc.nextLine();

            
            System.out.println("Enter Country:");
            String country = sc.nextLine();

            
            
            //Aircraft aircraft= new Aircraft();

            List<Passenger> passengers = new ArrayList<>();
            List<Reservation> reservations = new ArrayList<>();
            
            List<AirlineEmployee> airlineEmployees =new ArrayList<>();


            return new Flight(flightId, flightNumber, departureDateTime, arrivalDateTime, availableSeats, price,city,country, passengers,reservations,airlineEmployees);
        }
        
        
        
        public static void flightDetails() throws ParseException {
            
            System.out.println("1.Insert Flight Details");
    		System.out.println("2.Get Flight details based on id");
    		System.out.println("3.Update Flight Details");
    		System.out.println("4.Get all Flight details");
    		System.out.println("5.Delete Flight Details");
    		System.out.println("5.Join Reservation and  Flight Details");


            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                	Flight flight = flightInputs();
                	Flight savedFlight = flightDao.createFlight(flight);
                   System.out.println("Flight "+savedFlight+" added successfully:");
               
                    break;
                    
                case 2:
              	   
                    System.out.println("Enter Flight ID:");
                    String flightId = sc.next();
                    
                    Flight flightById = flightDao.getFlightById(flightId); 
                    if (flightById != null) {
                        System.out.println("Flight details: " + flightById);
                    } else {
                        System.out.println("Flight not found.");
                    }
                	 	
                	break;
                	
                case 3:
                	
                	System.out.println("Enter Flight ID to update:");
                    String updateFlightId = sc.next(); // Read Route ID from user
                	
                    Flight flightToUpdate = flightDao.getFlightById(updateFlightId); // Get Route by ID
                    if (flightToUpdate != null) {
                    	flightToUpdate.setPrice(15000);
                    	flightDao.updateFlight(flightToUpdate); // Update the Route
                        System.out.println("Flight updated successfully.");
                    } else {
                        System.out.println("Flight not found.");
                    }
                	
                	break;
                	
                	
                case 4:   	
                	
                	List<Flight> flights = flightDao.getAllFlights();
                	for (Flight a : flights) {
                	    System.out.println("Flight details:");
                	    System.out.println("Flight: " + a.getFlightId());
                	    System.out.println("Flight Number: " + a.getFlightNumber());
                	    System.out.println("Departure: " + a.getDepartureDateTime());
                	    System.out.println("Arrival: " + a.getArrivalDateTime());
                	    System.out.println("Avaialble Seats: " + a.getAvailableSeats());
                	    System.out.println("Price: " + a.getPrice());
                	    System.out.println("City: " + a.getCity());
                	    System.out.println("Country: " + a.getCountry());
                	    System.out.println("-----------------------------------");

                	}
                	
                	break;
                	
                case 5:
                	          	
                	System.out.println("Enter Flight ID to delete:");
                    String deleteFlightId = sc.next(); // Read Route ID from user
                    flightDao.deleteFlight(deleteFlightId); // Delete Route by ID
                    System.out.println("Flight deleted successfully.");
                	
                	break;
                	
                case 6:
                	
                	System.out.println("Joining Flight and Reservations:");
                	List<Flight> joinRes= flightDao.getAllFlights();
                	System.out.println("Flight - Reservations(time of flight)");

                	for (Flight a : joinRes) {
    					System.out.println(a.getFlightNumber()+ ", " +
    			                   a.getReservations().stream()
    			                                  .map(ap -> String.valueOf(ap.getReservationDateTime()))
    			                                  .collect(Collectors.joining(", ")));	    
    				}
                	
                	break;
                
                	
                	
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            
            
            
        }

}
