package com.ams.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.stat.Statistics;

import com.ams.dao.PassengerDao;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;
import com.ams.util.HibernateUtil;


public class PassengerDaoImpl implements PassengerDao{

	@Override
	public Passenger createPassenger(Passenger passenger) 
	{
		try(Session session=HibernateUtil.getSession()){
		        	        
		session.beginTransaction();
		
		//Many to Many- reservation
		//Create a passenger
		Passenger p1=new Passenger();
		p1.setFirstName(passenger.getFirstName());
		p1.setLastName(passenger.getLastName());
		p1.setGender(passenger.getGender());
		p1.setEmail(passenger.getEmail());
		p1.setAddress(passenger.getAddress());
		
		//Create an passenger 2
		Passenger p2=new Passenger();
		p2.setFirstName("Shravya");
		p2.setLastName("Bejugam");
		p2.setGender("Female");
		p2.setEmail("shravya12@gmail.com");
		p2.setAddress("Delhi");
		
		//Create an passenger 3
		Passenger p3=new Passenger();
		p3.setFirstName("Asha");
		p3.setLastName("Kommu");
		p3.setGender("Female");
		p3.setEmail("asha2@gmail.com");
		p3.setAddress("Mumbai");
		
		//Create reservation 1
		Reservation res1= new Reservation();
		res1.setReservationId("RS_001");
		
		//Create reservation 2
		Reservation res2= new Reservation();
		res2.setReservationId("RS_002");

		
		List<Passenger> passengerOfReservation1=new ArrayList<>();
		passengerOfReservation1.add(p1);
		passengerOfReservation1.add(p2);
		passengerOfReservation1.add(p3);

		List<Passenger> passengerOfReservation2= new ArrayList<>();
		passengerOfReservation2.add(p1);
		passengerOfReservation2.add(p2);
		
		// Set passengers for reservations
        res1.setPassengers(passengerOfReservation1);
        res2.setPassengers(passengerOfReservation2);

		session.save(res1);
		session.save(res2);	
		
		
			
	     
		//session.save(passenger);
		session.getTransaction().commit();
		return passenger;
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

public Passenger getPassengerById(String passengerId) {
		
	Passenger passenger=null;
	
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			passenger =session.get(Passenger.class, passengerId);
			
			System.out.println("Passenger details:");
    	    System.out.println("Passenger ID : " + passenger.getPassengerId());
    	    System.out.println("First Name : " + passenger.getFirstName());
    	    System.out.println("Last Name : " +passenger.getLastName());
    	    System.out.println("Gender: " + passenger.getGender());
    	    System.out.println("Email : " + passenger.getEmail());

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
		return passenger;
		
	}
	
	
   public void updatePassenger(Passenger passenger) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(passenger);
			
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
public List<Passenger> getAllPassengers() {
		
		List<Passenger> passengers=new ArrayList<>();
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
					    
		    TypedQuery<Passenger> p = session.createQuery("SELECT DISTINCT a FROM Flight a LEFT JOIN FETCH a.reservations", Passenger.class);
		    passengers = p.getResultList();
		    
		    TypedQuery<Passenger> p1 = session.createQuery("SELECT DISTINCT a FROM Flight a LEFT JOIN FETCH a.flights", Passenger.class);
		    passengers = p1.getResultList();
		    
		    
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
		return passengers;
		
	}
   
   
   public void deletePassenger(String passengerId) {
	   Passenger passenger=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			passenger=session.get(Passenger.class,passengerId);
			
			session.delete(passenger);
			
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
	