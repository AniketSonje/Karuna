package com.karuna.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Type {
	
	DELIVERY,ITEM,UNKNOWN;
	
	  @JsonCreator
	    public static Type fromValue(String value) {
	        try {
	            return Type.valueOf(value.toUpperCase());
	        } catch (IllegalArgumentException e) {
	            return UNKNOWN;
	        }
	    }

}
