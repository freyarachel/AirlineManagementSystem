package com.ams.daoimpl;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.ams.dao.ReservationDao;
import com.ams.entity.Flight;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;
import com.ams.util.HibernateUtil;

public class ReservationDaoImpl implements ReservationDao{
	
	
	//Reservation
	@Override
	public Reservation createReservation(Reservation reservation) {
		
		try(Session session=HibernateUtil.getSession()){
								
			session.beginTransaction();	      
			
	        //one to one

	        Payment payment=new Payment();	        
	        payment.setPaymentId(payment.getPaymentId());	
	        
	        reservation.setReservationId(payment.getPaymentId());   
			session.saveOrUpdate(payment);

			reservation.setPayment(payment);
			session.saveOrUpdate(reservation);
			
			
			
			//one to many
			
			// Create Flight objects
			Flight f1 = new Flight();
			f1.setFlightId(f1.getFlightId()); 

			
			// Create Reservation objects
			Reservation rs1 = new Reservation();
			rs1.setReservationDateTime(reservation.getReservationDateTime());
			rs1.setSeatNumber(reservation.getSeatNumber());
			rs1.setStatus(reservation.getStatus());
			rs1.setFlight(f1);
			
            Reservation rs2 = new Reservation();
			rs2.setReservationDateTime(LocalDateTime.of(2024, 3, 25, 8, 0));
			rs2.setSeatNumber(145);
			rs2.setStatus("Not Reserved");
			rs2.setFlight(f1);

			
			// Create lists of Reservation for each FLight
			List<Reservation> reservationsofFlight = new ArrayList<Reservation>();
			reservationsofFlight.add(rs1);
			reservationsofFlight.add(rs2);

			// Set the maintenance lists for each Aircraft
			f1.setReservations(reservationsofFlight);


            session.save(f1);
						
						
			
			session.getTransaction().commit();
			return reservation;
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
	
 public Reservation getReservationById(String reservationId) {
		
	Reservation reservation=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			reservation =session.get(Reservation.class, reservationId);
			System.out.println("Reservation details:");
    	    System.out.println("Reservation ID: " + reservation.getReservationId());
    	    System.out.println("Date and Time : " + reservation.getReservationDateTime());
    	    System.out.println("Seat Number : " + reservation.getSeatNumber());
    	    System.out.println("Status: " + reservation.getStatus());
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
		return reservation;
		
	}
	
	
   public void updateReservation(Reservation reservation) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(reservation);
			
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
public List<Reservation> getAllReservations() {
		
		List<Reservation> reservations=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			reservations =session.createQuery("FROM Reservation").list();
			
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
		return reservations;
		
	}
   
   
   public void deleteReservation(String reservationId) {
	   Reservation reservation=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			reservation=session.get(Reservation.class,reservationId);
			
			session.delete(reservation);
			
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

