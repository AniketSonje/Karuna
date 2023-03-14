package com.karuna.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.NoArgsConstructor;

@Entity
@Table(name="staff")
@NoArgsConstructor
public class Staff extends BaseEntity 
{

	private String name;
	
	private String email;
	
	private String address;
	
	private String password;
	
	private Boolean status;
	
	private Long phone;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
//	@OneToMany(mappedBy = "staffId",fetch = FetchType.EAGER)
//	private List<Delivery> deliveryId=new ArrayList<Delivery>();
//	
//	@ManyToMany(mappedBy = "staffs",fetch = FetchType.EAGER)
//	private List<Request> requests=new ArrayList<Request>();
	
	   @OneToMany(fetch = FetchType.EAGER, mappedBy = "staffId")
	    @BatchSize(size = 10) // fetch 10 deliveries at a time
	    private List<Delivery> deliveryId;
	    
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "staffs")
	    @BatchSize(size = 10) // fetch 10 requests at a time
	    @JsonBackReference
	    private List<Request> requests;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Delivery> getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(List<Delivery> deliveryId) {
		this.deliveryId = deliveryId;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public Staff(Long id, String name, String email, String address, String password, Long phone, Role role) {
		super(id);
		this.name = name;
		this.email = email;
		this.address = address;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}

	public Staff() {
		super();
	}

	@Override
	public String toString() {
		return "Staff [name=" + name + ", email=" + email + ", address=" + address + ", password=" + password
				+ ", status=" + status + ", phone=" + phone + ", role=" + role + ", deliveryId=" + deliveryId
				+ ", requests=" + requests + "]";
	}
	
	
	
	
}
