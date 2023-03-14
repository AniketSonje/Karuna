package com.karuna.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment extends BaseEntity 
{
    
	@Column(name="payment_date_time")
	private LocalDateTime paymentDateTime;
	private String description;
	private Boolean status;
	public LocalDateTime getPaymentDateTime() {
		return paymentDateTime;
	}
	public void setPaymentDateTime(LocalDateTime paymentDateTime) {
		this.paymentDateTime = paymentDateTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Payment(Long id, LocalDateTime paymentDateTime, String description, Boolean status) {
		super(id);
		this.paymentDateTime = paymentDateTime;
		this.description = description;
		this.status = status;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [paymentDateTime=" + paymentDateTime + ", description=" + description + ", status=" + status
				+ "]";
	}
	
	
	
	
	
}
