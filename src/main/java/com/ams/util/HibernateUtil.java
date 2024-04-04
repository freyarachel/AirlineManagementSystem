package com.ams.util;


import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.ams.entity.Aircraft;
import com.ams.entity.AircraftMaintenance;
import com.ams.entity.AirlineEmployee;
import com.ams.entity.Airport;
import com.ams.entity.Flight;
import com.ams.entity.Passenger;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;


public class HibernateUtil {
	
	
private final static SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory()
	{
				
		try {
			return new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Passenger.class)
					.addAnnotatedClass(Airport.class)
					.addAnnotatedClass(Payment.class)
					.addAnnotatedClass(Reservation.class)
					.addAnnotatedClass(Aircraft.class)
					.addAnnotatedClass(AircraftMaintenance.class)
					.addAnnotatedClass(Flight.class)
					.addAnnotatedClass(AirlineEmployee.class)
					.buildSessionFactory();
			
		}catch (Throwable e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {
		
		return sessionFactory;
	}

	public static Session getSession(){
	  return getSessionFactory().openSession(); //session opened
	}			
			
		

	
}

/*
 
			Configuration cfg = new Configuration(); 
			cfg.configure("hibernate.cfg.xml");
			SessionFactory factory =cfg.buildSessionFactory(); 
			

			Passenger passenger= new Passenger();
			passenger.setPassengerId("P113");	
			passenger.setFirstName("Benny");
			passenger.setLastName("Jack");
			passenger.setGender("M");
			passenger.setEmail("benny@gmail.com");
			passenger.setAddress("Kolkata");
			
			System.out.println(factory); 
			System.out.println(factory.isClosed());
			Session session =factory.openSession(); 
			
			session.beginTransaction();
			
			session.save(passenger);
			
			session.getTransaction().commit();
			session.close();
		
		}

}





public class HibernateUtil 
{
	
}

*/