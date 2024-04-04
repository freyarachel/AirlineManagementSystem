package com.ams.dao;

import java.util.List;


import com.ams.entity.Payment;
import com.ams.entity.Reservation;

public interface PaymentDao {
	
	//Payment
    Payment createPayment(Payment payment); 
    Payment getPaymentById(String paymentId);
    void updatePayment(Payment payment);
    List<Payment> getAllPayments();
    void deletePayment(String paymentId);
    List<Payment> getPaymentsWithReservations();

}
