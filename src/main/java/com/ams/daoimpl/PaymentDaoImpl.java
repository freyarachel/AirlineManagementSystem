package com.ams.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ams.dao.PaymentDao;
import com.ams.entity.Aircraft;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;
import com.ams.util.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao{


        //Payment
		@Override
		public Payment createPayment(Payment payment) {
			
			try(Session session=HibernateUtil.getSession()){
				
				session.beginTransaction();
				        
		        
				session.save(payment);
				session.getTransaction().commit();
				return payment;
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



public Payment getPaymentById(String paymentId) {
		
	Payment payment=null;
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			payment =session.get(Payment.class, paymentId);
			  System.out.println("Payment details: ");
      	    System.out.println("Payment: " +payment.getPaymentId());
      	    System.out.println("Date and Time: " + payment.getPaymentDateTime());
      	    System.out.println("Arrival: " + payment.getAmount());
      	    System.out.println("Avaialble Seats: " + payment.getPaymentMethod());
      	    System.out.println("Price: " + payment.getStatus());
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
		return payment;
		
	}
	
	
   public void updatePayment(Payment payment) {
		
		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			session.saveOrUpdate(payment);
			
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
      
   public List<Payment> getAllPayments() {
	   
	   List<Payment> payments= new ArrayList<>();
	    try (Session session = HibernateUtil.getSession()) {
	        session.beginTransaction();

	        TypedQuery<Payment> p = session.createQuery("SELECT a FROM Payment a ORDER BY a.amount", Payment.class);

	        payments = p.getResultList();

	        session.getTransaction().commit();
	    } catch (HibernateException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return payments;
	}

   
   public void deletePayment(String paymentId) {
	   Payment payment=null;

		try(Session session=HibernateUtil.getSession()){
			
			session.beginTransaction();
			
			payment=session.get(Payment.class,paymentId);
			
			session.delete(payment);
			
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
   public List<Payment> getPaymentsWithReservations() {
       List<Payment> payments = null;
       try (Session session = HibernateUtil.getSession()) {
           session.beginTransaction();

           String hql = "SELECT p FROM Payment p JOIN p.reservation r";
           payments = session.createQuery(hql).list();

           session.getTransaction().commit();
       } catch (HibernateException e) {
           e.printStackTrace();
       }
       return payments;
   }

	
}
