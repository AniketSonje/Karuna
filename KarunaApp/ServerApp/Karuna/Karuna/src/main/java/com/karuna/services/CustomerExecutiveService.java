package com.karuna.services;

import java.util.List;

import com.karuna.dto.AddCampaignDto;
import com.karuna.dto.LoginDto;
import com.karuna.entity.Campaign;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;

public interface CustomerExecutiveService {
	
	    Staff login(LoginDto loginDto);
	    
	    List<Request> viewRequests(Boolean status);
       	    
	    Campaign addCampaign(AddCampaignDto newCampaign);
	    
	    String deleteCampaign(Long campaignId);
	    
	    String removeDonor(Long donorId);
	    
	    String removeReceiver(Long receiverId);
	    
	    String logout(Long staffId);

		Campaign updateCampaign(AddCampaignDto newCampaign);
       
		Boolean handleRequest(Long requestId);
		

}
