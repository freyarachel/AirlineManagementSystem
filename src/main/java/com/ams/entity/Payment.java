package com.ams.entity;



import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity

public class Payment{ 
	
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_gen")
    @GenericGenerator(
        name = "payment_gen", 
        strategy = "com.ams.entity.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PY_"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
		@Column(name="PaymentId", length = 20, nullable = false)
    private String paymentId;


	@Column(name="Amount", length = 50)
	private double amount;
	
	@Column(name ="PaymentDateTime",length = 20)
    private LocalDateTime paymentDateTime;

	@Column(name="PaymentMethod", length = 50)
	private String paymentMethod;
	
	@Column(name="Status", length = 50)
	private String status;
	
	//One to One  Payment to Reservation -d	
    @OneToOne(mappedBy="payment", cascade = CascadeType.ALL)
	private Reservation reservation;
    
    

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}

	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Payment(String paymentId, double amount, LocalDateTime paymentDateTime, String paymentMethod, String status,
			Reservation reservation) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDateTime = paymentDateTime;
		this.paymentMethod = paymentMethod;
		this.status = status;
		this.reservation = reservation;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentDateTime=" + paymentDateTime
				+ ", paymentMethod=" + paymentMethod + ", status=" + status + ", reservation=" + reservation + "]";
	}
	
	

	
   

}
