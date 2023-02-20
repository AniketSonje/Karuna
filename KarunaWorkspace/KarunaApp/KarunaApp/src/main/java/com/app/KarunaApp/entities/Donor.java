package com.app.KarunaApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="donor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donor extends BaseEntity {
	
	@Column(name="Donor_Name",length=100)
	private String name;
	
	@Column(length=50,unique=true)
	private String email;
	
	@Column(length=500)
	private String address;
	
	@Column(length=50,nullable = false) 
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Column(length=13)
	private Long mobile;
	
	@Column(name="Donation_Count")
	private Long donationCount;
	
	@Column(name="status")
	private boolean status;

}
