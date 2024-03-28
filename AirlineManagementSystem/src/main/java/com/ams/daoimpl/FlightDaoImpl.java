package com.ams.daoimpl;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.dao.FlightDao;
import com.ams.entity.Aircraft;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Airport;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;
import com.ams.entity.Reservation;
import com.ams.util.HibernateUtil;

public class FlightDaoImpl implements FlightDao{

	
	//Flight
	@Override
	public Flight createFlight(Flight flight) {
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			/*
			// Create Aircraft objects
			Aircraft a1 = new Aircraft();
			a1.setAircraftId(a1.getAircraftId()); 

			
		    // Create Flight objects
			Flight f1 = new Flight();
			f1.setFlightNumber(flight.getFlightNumber());
			f1.setDepartureDateTime(flight.getDepartureDateTime());
			f1.setArrivalDateTime(flight.getArrivalDateTime());
			f1.setAvailableSeats(flight.getAvailableSeats());
			f1.setPrice(flight.getPrice());
			f1.setCity(flight.getCity());
			f1.setCountry(flight.getCountry());
			f1.setAircraft(a1);
			
			Flight f2 = new Flight();
			f2.setFlightNumber("FK1034");
			f2.setDepartureDateTime(LocalDateTime.of(2024, 3, 26, 21, 30));
			f2.setArrivalDateTime(LocalDateTime.of(2024, 3, 27, 8, 30));
			f2.setAvailableSeats(200);
			f2.setPrice(80000);
			f2.setCity("Jordan");
			f2.setCountry("Israel");
			f2.setAircraft(a1);
			
			// Create lists of Airport for each Aircraft
			List<Flight> flightsOfAircraft = new ArrayList<Flight>();
			flightsOfAircraft.add(f1);
			flightsOfAircraft.add(f2);

			// Set the maintenance lists for each Aircraft
			a1.setFlights(flightsOfAircraft);

            session.save(a1);
						
		          
            */
           
				
			session.save(flight);
			session.getTransaction().commit();
			return flight;

			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			return null;
			
	}
	
  public Flight getFlightById(String flightId) {
		
	  Flight flight=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			flight =session.get(Flight.class, flightId);
			 System.out.println("Flight details:");
     	    System.out.println("Flight" + flight.getFlightId());
     	    System.out.println("Flight Number: " + flight.getFlightNumber());
     	    System.out.println("Departure: " +flight.getDepartureDateTime());
     	    System.out.println("Arrival: " + flight.getArrivalDateTime());
     	    System.out.println("Avaialble Seats" + flight.getAvailableSeats());
     	    System.out.println("Price" +flight.getPrice());
     	    System.out.println("City: " + flight.getCity());
     	    System.out.println("Country: " + flight.getCountry());
     	    System.out.println("-----------------------------------");

			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return flight;
		
	}
	
	
   public void updateFlight(Flight flight) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(flight);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
   
   @SuppressWarnings("unchecked")
public List<Flight> getAllFlights() {
		
		List<Flight> flights=new ArrayList<>();
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			
			 TypedQuery<Flight> q = session.createQuery("SELECT DISTINCT a FROM Flight a LEFT JOIN FETCH a.reservations", Flight.class);

			 flights = q.getResultList();
		        
		        
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		return flights;
		
	}
   
   
   public void deleteFlight(String flightId) {
		Flight flight=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			flight=session.get(Flight.class,flightId);
			
			session.delete(flight);
			
			session.getTransaction().commit();
			}
			catch(HibernateException e)
			{
				System.out.println(e);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	}
	

}

