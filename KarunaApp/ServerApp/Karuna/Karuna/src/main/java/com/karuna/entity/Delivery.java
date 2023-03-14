package com.karuna.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="delivery")
public class Delivery extends BaseEntity 
{

	@OneToMany(mappedBy = "deliveryId")
	private List<Item> itemId=new ArrayList<Item>();
	
	@Column(name="delivery_date_time")
	private LocalDateTime deliveryDateTime;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Staff staffId;
	
	
	@ManyToMany
	@JoinTable(
			  name = "delivery_donor_handling", 
			  joinColumns = @JoinColumn(name = "donor_id"), 
			  inverseJoinColumns = @JoinColumn(name = "delivery_id"))
	@JsonManagedReference
	private List<Donor> donors=new ArrayList<Donor>();
	
	@ManyToMany
	@JoinTable(
			  name = "delivery_receiver_handling", 
			  joinColumns = @JoinColumn(name = "receiver_id"), 
			  inverseJoinColumns = @JoinColumn(name = "delivery_id"))
	@JsonManagedReference
	private List<Receiver> receivers=new ArrayList<Receiver>();
	
	
	private Boolean status=false;
	
	
	
	
}
