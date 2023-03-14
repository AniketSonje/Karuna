package com.karuna.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karuna.dto.AddCampaignDto;
import com.karuna.dto.LoginDto;
import com.karuna.entity.Campaign;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;
import com.karuna.exception.ResourceNotFoundException;
import com.karuna.repos.CampaignRepo;
import com.karuna.repos.DonorRepo;
import com.karuna.repos.ReceiverRepo;
import com.karuna.repos.RequestRepo;
import com.karuna.repos.StaffRepo;

@Service
@Transactional
public class CustomerExecutiveServiceImpl implements CustomerExecutiveService {
	
	    @Autowired
	    private RequestRepo reqRepo;

	    @Autowired
	    private StaffRepo staffRepo;
	    
	    @Autowired
	    private CampaignRepo campaignRepo;
	    
	    @Autowired
	    private DonorRepo donorRepo;
	    
	    @Autowired
	    private ReceiverRepo receiverRepo;
	    
	    @Autowired
		private ModelMapper mapper;

	    @Override
		public Staff login(LoginDto loginDto) {
			Staff staff= staffRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
					.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
			staff.setStatus(true);
			return mapper.map(staff, Staff.class);
		}

	@Override
	public List<Request> viewRequests(Boolean status) {
		
		return reqRepo.findAllByStatus(status);
		
	}

	@Override
	public Campaign addCampaign(AddCampaignDto newCampaign) {
		 Campaign campaign=mapper.map(newCampaign, Campaign.class);
		 campaign.setStatus(true);
		return campaignRepo.save(campaign);
		
	}

	@Override
	public Campaign updateCampaign(AddCampaignDto updatedCampaign) {
	      Campaign campaign=mapper.map(updatedCampaign, Campaign.class);
	      if(campaignRepo.existsById(updatedCampaign.getId())) {
	    	  campaign.setStatus(true);
	    	  return campaignRepo.save(campaign);
	      }
	      return null;
	}

	@Override
	public String deleteCampaign(Long campaignId) {
		campaignRepo.deleteById(campaignId);
		return "Campaign Deleted !!!";
	
		
	}

	@Override
	public String removeDonor(Long donorId) {
		donorRepo.deleteById(donorId);
		return "Donor Deleted!!!";
		
		
	}

	@Override
	public String removeReceiver(Long receiverId) {
		receiverRepo.deleteById(receiverId);
		return "Receiver Deleted!!!";
		
	}

	@Override
	public String logout(Long staffId) {
		staffRepo.findById(staffId).orElseThrow().setStatus(false);
		
	  return "Successfully Logged Out!!!";
		
	}
	

	@Override
	public Boolean handleRequest(Long requestId) {
		reqRepo.findById(requestId).orElseThrow().setStatus(true);
		return true;
	}
	

}
