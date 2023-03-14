package com.karuna.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.karuna.entity.BaseEntity;
import com.karuna.entity.Type;

public class RequestDto extends BaseEntity{
	
    private String description;
    
    @Enumerated(EnumType.STRING)
	private Type type;


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	


	public RequestDto(Long id, String description) {
		super(id);
		this.description = description;

	}


	public RequestDto() {
		super();
	}


	@Override
	public String toString() {
		return "RequestDto [description=" + description +"]";
	}
	
	
	

}
