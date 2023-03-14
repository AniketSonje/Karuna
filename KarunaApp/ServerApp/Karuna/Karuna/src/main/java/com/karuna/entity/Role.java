package com.karuna.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Role {
	
	ADMIN,DELIVERY_PARTNER,CUSTOMER_EXECUTIVE;

}
