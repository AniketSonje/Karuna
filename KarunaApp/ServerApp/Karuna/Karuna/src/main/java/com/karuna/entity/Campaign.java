package com.karuna.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="campaign")
public class Campaign extends BaseEntity
{
    
	@Column(name="campaign_date_time")
	@CreatedDate
	private LocalDateTime campaignDateTime;
	private String name;
	private String description;
	
	@Value("${some.key:true}")
	private Boolean status;
	
	
	public LocalDateTime getCampaignDateTime() {
		return campaignDateTime;
	}
	public void setCampaignDateTime(LocalDateTime campaignDateTime) {
		this.campaignDateTime = campaignDateTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Campaign() {
		super();
	}
	public Campaign(Long id, LocalDateTime campaignDateTime, String name, String description, Boolean status) {
		super(id);
		this.campaignDateTime = campaignDateTime;
		this.name = name;
		this.description = description;
		this.status = status;
	}
	
}
