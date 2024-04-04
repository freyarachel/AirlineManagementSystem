package com.ams.daoimpl;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ams.dao.AircraftDao;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.entity.Airport;
import com.ams.entity.Flight;
import com.ams.entity.Payment;
import com.ams.util.HibernateUtil;

public class AircraftDaoImpl implements AircraftDao{

//Aircraft
		@Override
		public Aircraft createAircraft(Aircraft aircraft) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
		        
				session.save(aircraft);
				session.getTransaction().commit();
				return aircraft;
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
		
	
		public Aircraft getAircraftById(String aircraftId) {
			
			Aircraft aircraft=null;
			
			Session session=HibernateUtil.getSession();
				
				session.beginTransaction();
				
				aircraft =session.get(Aircraft.class, aircraftId);
				
				System.out.println("Aircraft details:");
        	    System.out.println("Aircraft ID: " + aircraft.getAircraftId());
        	    System.out.println("Type: " + aircraft.getAircraftType());
        	    System.out.println("Manufacturer: " + aircraft.getManufacturer());
        	    System.out.println("Model: " + aircraft.getModel());
        	    System.out.println("Total Seats : " + aircraft.getTotalSeats());
				
				session.getTransaction().commit();
				
			return aircraft;
			
		}
		
		
		
		
	   public void updateAircraft(Aircraft aircraft) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				
				
				session.saveOrUpdate(aircraft);
				
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
	   
	   public List<Aircraft> getAllAircrafts() {
		   
		    List<Aircraft> aircrafts = new ArrayList<>();
		    try (Session session = HibernateUtil.getSession()) {
		        session.beginTransaction();

		        TypedQuery<Aircraft> q = session.createQuery("SELECT DISTINCT a FROM Aircraft a LEFT JOIN FETCH a.airports", Aircraft.class);
		        TypedQuery<Aircraft> q1 = session.createQuery("SELECT DISTINCT a FROM Aircraft a LEFT JOIN FETCH a.aircraftMaintenances", Aircraft.class);

		        aircrafts = q.getResultList();
		        aircrafts = q1.getResultList();

		        session.getTransaction().commit();
		    } catch (HibernateException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return aircrafts;
		}

	   
	   public void deleteAircraft(String aircraftId) {
		   Aircraft aircraft=null;

			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				
				aircraft=session.get(Aircraft.class,aircraftId);
				
				session.delete(aircraft);
				
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
