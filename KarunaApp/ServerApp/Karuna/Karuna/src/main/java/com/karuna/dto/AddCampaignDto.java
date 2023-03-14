package com.karuna.dto;

import com.karuna.entity.BaseEntity;

public class AddCampaignDto extends BaseEntity {
	
    private String name;
    
    private String description;

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

	public AddCampaignDto(Long id, String name, String description) {
		super(id);
		this.name = name;
		this.description = description;
	}

	public AddCampaignDto() {
		super();
	}

	@Override
	public String toString() {
		return "AddCampaignDto [name=" + name + ", description=" + description + "]";
	}
    
	
    

}
