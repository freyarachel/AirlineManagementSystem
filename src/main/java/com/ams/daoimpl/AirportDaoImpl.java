package com.ams.daoimpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.dao.AirportDao;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.entity.Airport;
import com.ams.util.HibernateUtil;

public class AirportDaoImpl implements AirportDao{


       //Airport
		@Override
		public Airport createAirport(Airport airport) 
		{
			try(Session session=HibernateUtil.getSession()){
				
			session.beginTransaction();
			
			
			// Create Aircraft objects
			Aircraft a1 = new Aircraft();
			a1.setAircraftId(a1.getAircraftId()); 

						
		    // Create AircraftMaintenance objects
			Airport ap1 = new Airport();
			ap1.setAirportName(airport.getAirportName());
			ap1.setCity(airport.getCity());
			ap1.setCountry(airport.getCountry());
			ap1.setAircraft(a1);
			
			Airport ap2 = new Airport();
			ap2.setAirportName("Heathrow Aiport");
			ap2.setCity("London");
			ap2.setCountry("UK");
			ap2.setAircraft(a1);
			
			// Create lists of Airport for each Aircraft
			List<Airport> airportsOAircraft = new ArrayList<Airport>();
			airportsOAircraft.add(ap1);
			airportsOAircraft.add(ap2);

			// Set the maintenance lists for each Aircraft
			a1.setAirports(airportsOAircraft);

            session.save(a1);
			
			
	        
			//session.save(airport);
			session.getTransaction().commit();
			return airport;
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
		
		public Airport getAirportById(String airportId) {
			
			Airport airport=null;
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				airport =session.get(Airport.class, airportId);
				 System.out.println("Airport details:");
         	    System.out.println("Airport ID: " + airport.getAirportId());
         	    System.out.println("Airport Name: " + airport.getAirportName());
         	    System.out.println("City: " + airport.getCity());
         	    System.out.println("Country: " + airport.getCountry());
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
			return airport;
			
		}
		
		
	   public void updateAirport(Airport airport) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				session.saveOrUpdate(airport);
				
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
	public List<Airport> getAllAirports() {
			
			List<Airport> airports=null;
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				airports =session.createQuery("FROM Airport").list();
				
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
			return airports;
			
		}
	   
	   
	   public void deleteAirport(String airportId) {
		   Airport airport=null;

			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				airport=session.get(Airport.class,airportId);
				
				session.delete(airport);
				
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