package com.ams;

import java.util.Scanner;

import com.google.protobuf.TextFormat.ParseException;

public class App 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	Scanner sc=new Scanner(System.in);
    	
    		System.out.println("Press");
    		System.out.println("1.Passenger Details");
    		System.out.println("2.Airport Details");
    		System.out.println("3.Flight Details");
    		System.out.println("4.Reservation Details");
    		System.out.println("5.Payment Details");
    		System.out.println("6.Airline Employee Details");
    		System.out.println("7.Aircraft Details");
    		System.out.println("8.Aircraft Maintenance Details");

    	
        	int choice=sc.nextInt();
        	
    	  switch(choice)
    	  {
    	  
    	  case 1:
    		  PassengerOperations.passengerDetails();
    		  break;    		 
    		  
    		  
    	  case 2:
    		  AirportOperations.airportDetails();

    		  break;
    		  
    	  case 3:
    		  FlightOperations.flightDetails();

    		  break;
    		  
    	  case 4:
    		  ReservationOperations.reservationDetails();

    		  break;
          
    	  case 5:
    		  PaymentOperations.paymentDetails();

    		  break;
    		  
        		  
    	  case 6:
    		  AirlineEmployeeOperations.airlineEmployeeDetails();

    		  break;
    		  
    	  case 7:
    		  AircraftOperations.aircraftDetails();

    		  break;
    		  
    	     		  
    	  case 8:
    		  AircraftMaintenanceOperations.aircraftMaintenanceDetails();

    		  break;
    
    		  
    	  }
    	
    	sc.close();
    }
}
