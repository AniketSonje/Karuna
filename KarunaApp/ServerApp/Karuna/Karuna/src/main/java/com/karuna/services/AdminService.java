package com.karuna.services;

import java.util.List;

import com.karuna.dto.AddCampaignDto;
import com.karuna.dto.LoginDto;
import com.karuna.dto.RegisterStaffDto;
import com.karuna.entity.Campaign;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;

public interface AdminService {
	
	 Staff login(LoginDto loginDto);
	    
	    List<Request> viewRequests();
    	    
	    Campaign addCampaign(AddCampaignDto campaignDto);
	    
	    String deleteCampaign(Long campaignId);
	    
	    String removeDonor(Long donorId);
	    
	    String removeReceiver(Long receiverId);
	    
	    Campaign updateCampaign(AddCampaignDto newCampaign);
	   
	    Staff addStaff(RegisterStaffDto newStaff);
	    
	    Staff updateStaff(RegisterStaffDto updatedStaff);
	    
	    String deleteStaff(Long staffId);
	    
	    String viewLocationOfDonor(Long donorId);
		 
		 String viewLocationOfReceiver(Long receiverid);
		 
		 Boolean checkPaymentStatus(Long paymentId);
	    
	    String logout(Long staffId);
	    
	    List<Staff> viewStaffs();
	    

}
