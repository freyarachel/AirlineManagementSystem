package com.ams;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.ams.dao.PaymentDao;
import com.ams.daoimpl.PaymentDaoImpl;
import com.ams.entity.Aircraft;
import com.ams.entity.Flight;
import com.ams.entity.Payment;
import com.ams.entity.Reservation;

public class PaymentOperations {
	
	//Payment
	
	static Scanner sc = new Scanner(System.in);

    static PaymentDao paymentDao = new PaymentDaoImpl();
    
    private static Payment paymentInputs() {
        sc.nextLine();
        
        System.out.println("Enter Payment ID: ");
        String paymentId = sc.nextLine();
        
        System.out.println("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();
                  
        System.out.println("Enter Payment DateTime in the format yyyy-MM-dd HH:mm:ss :");
        String paymentDateTimeInput=sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime paymentDateTime = LocalDateTime.parse(paymentDateTimeInput, formatter);
        
        System.out.println("Enter Payment Method:");
        String paymentMethod = sc.nextLine();

        System.out.println("Enter Status:");
        String status = sc.nextLine();
        
        Reservation reservation= new Reservation();
        
       
		return new Payment(paymentId,amount, paymentDateTime, paymentMethod, status,reservation);

    }


	public static void paymentDetails() {
        
        System.out.println("1.Insert Payment Details");
		System.out.println("2.Get Payment details based on id");
		System.out.println("3.Update Payment Details");
		System.out.println("4.Get all Payment details");
		System.out.println("5.Delete Payment Details");
		System.out.println("6. Payment ORDERBY  Details");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
            	Payment  payment = paymentInputs();
            	Payment savedPayment = paymentDao.createPayment( payment);
               System.out.println("Payment "+savedPayment+" added successfully:");
           
                break;
                
            case 2:
            	
                
             	//Route routeById=routeDao.getRouteById(route.getRouteId());
                
                System.out.println("Enter Payment ID:");
                String paymentId = sc.next(); // Read Route ID from user
                
                Payment paymentById = paymentDao.getPaymentById(paymentId); // Get Route by ID
                if (paymentById != null) {
                    System.out.println("Payment details: " + paymentById);
                } else {
                    System.out.println("Payment not found.");
                }
            	
            	
            	
            	break;
            	
            case 3:
            	
            	System.out.println("Enter Payment ID to update:");
                String updatePaymentId = sc.next(); // Read Route ID from user
                
            	//route.setCity("Delhi");
            	//routeDao.updateRoute(route);
            	
            	
                Payment paymentToUpdate = paymentDao.getPaymentById(updatePaymentId); // Get Route by ID
                if (paymentToUpdate != null) {
                	
                    // Update the Route properties
                	
                	
                	//System.out.println("Enter Payment ID to update:");
                    //String updatePaymentId = sc.next(); 
                    
                	
                	paymentToUpdate.setAmount(3500);
                	paymentToUpdate.setStatus("Failed");
                	paymentToUpdate.setPaymentMethod("UPI");
                	
                	
                	
                	paymentDao.updatePayment(paymentToUpdate); // Update the Route
                    System.out.println("Payment updated successfully.");
                } else {
                    System.out.println("Payment not found.");
                }
            	
            	break;
            	
            	
            case 4:
            	
            	//List<Route> routes=routeDao.getAllRoutes();
            	//routes.forEach(r -> System.out.println(r.getRouteId()));
            	
            	List<Payment> payments = paymentDao.getAllPayments();
                
            	for (Payment a : payments) {
            	    System.out.println("Payment details:");
            	    System.out.println("Payment" + a.getPaymentId());
            	    System.out.println("Date and Time: " + a.getPaymentDateTime());
            	    System.out.println("Amount: " + a.getAmount());
            	    System.out.println("Payment Method" + a.getPaymentMethod());
            	    System.out.println("Status" + a.getStatus());
            	    System.out.println("-----------------------------------");

            	}
            	
            	
            	break;
            	
            case 5:
            	
            	//routeDao.deleteRoute(route.getRouteId());
            	
            	System.out.println("Enter Payment ID to delete:");
                String deletePaymentId = sc.next(); // Read Route ID from user
                paymentDao.deletePayment(deletePaymentId); // Delete Route by ID
                System.out.println("Payment deleted successfully.");
            	
            	break;
            	
            	
            	
            case 6:
            	System.out.println("Payment ORDER BY:");
            	List<Payment> orderPayment= paymentDao.getAllPayments();
        		System.out.println("Payment | Amount  ");

            	for (Payment a : orderPayment) {
					System.out.println(a.getPaymentId()+" - "+ a.getAmount());    
				}
            	
            	break;    
            	
            	
            default:
                System.out.println("Invalid choice.");
                break;
        }
        }
        
    }
	
	


