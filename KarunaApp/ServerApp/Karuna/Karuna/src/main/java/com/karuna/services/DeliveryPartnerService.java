package com.karuna.services;

import java.util.List;

import com.karuna.dto.LoginDto;
import com.karuna.entity.Donor;
import com.karuna.entity.Receiver;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;

public interface DeliveryPartnerService {
	
	Staff login(LoginDto loginDto);
	
	List<Request> viewRequests();
	 
	 String viewLocationOfDonor(Long donorId);
	 
	 String viewLocationOfReceiver(Long receiverId);
	 
	 Boolean checkPaymentStatus(Long paymentId);
	 
	 String logout(Long staffId);
	 
	 Boolean handleRequest(Long reqId);
	 

}
