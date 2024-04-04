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

