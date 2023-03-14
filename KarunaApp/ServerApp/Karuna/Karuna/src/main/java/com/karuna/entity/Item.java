package com.karuna.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="item")
public class Item extends BaseEntity 
{
	
   @Column(name="listed_date_time")
   @CreationTimestamp
	private LocalDateTime listedDateTime;
   
	private Long quantity;
	
	@Column(name="status")
	@ColumnDefault("false")
	@Value("${some.key:false}")
	private Boolean status;
	
	private String description;
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="accepted_date_time")
	private LocalDateTime acceptedDateTime;
	
	@ManyToOne
	@JoinColumn(name="donor_id")
	@JsonManagedReference
	private Donor donorId;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@OneToOne
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;
	
	@ManyToOne
	private Delivery deliveryId;

	public LocalDateTime getListedDateTime() {
		return listedDateTime;
	}

	public void setListedDateTime(LocalDateTime listedDateTime) {
		this.listedDateTime=listedDateTime;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDateTime getAcceptedDateTime() {
		return acceptedDateTime;
	}

	public void setAcceptedDateTime(LocalDateTime acceptedDateTime) {
		this.acceptedDateTime = acceptedDateTime;
	}

	public Donor getDonorId() {
		return donorId;
	}

	public void setDonorId(Donor donorId) {
		this.donorId = donorId;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public Delivery getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Delivery deliveryId) {
		this.deliveryId = deliveryId;
	}

	
	public Item() {
		super();
	}

	public Item(Long id, LocalDateTime listedDateTime, Long quantity, Boolean status, String description,
			LocalDateTime acceptedDateTime, Donor donorId, Category category, Receiver receiver, Delivery deliveryId) {
		super(id);
		this.listedDateTime = listedDateTime;
		this.quantity = quantity;
		this.status = status;
		this.description = description;
		this.acceptedDateTime = acceptedDateTime;
		this.donorId = donorId;
		this.category = category;
		this.receiver = receiver;
		this.deliveryId = deliveryId;
	}

	@Override
	public String toString() {
		return "Item [listedDateTime=" + listedDateTime + ", quantity=" + quantity + ", status=" + status
				+ ", description=" + description + ", acceptedDateTime=" + acceptedDateTime + ", donorId=" + donorId
				+ ", category=" + category + ", receiver=" + receiver + ", deliveryId=" + deliveryId + "]";
	}

	

	
	
	
	
}
