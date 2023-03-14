package com.karuna.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karuna.dto.AddCampaignDto;
import com.karuna.dto.LoginDto;
import com.karuna.dto.RegisterStaffDto;
import com.karuna.entity.Campaign;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;
import com.karuna.exception.ResourceNotFoundException;
import com.karuna.repos.CampaignRepo;
import com.karuna.repos.DonorRepo;
import com.karuna.repos.PaymentRepo;
import com.karuna.repos.ReceiverRepo;
import com.karuna.repos.RequestRepo;
import com.karuna.repos.StaffRepo;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	
	  @Autowired
	    private RequestRepo reqRepo;

	    @Autowired
	    private StaffRepo staffRepo;
	    
	    
	    @Autowired
	    private DonorRepo donorRepo;
	    
	    @Autowired
	    private ReceiverRepo receiverRepo;
	    
	    @Autowired
		private ModelMapper mapper;
	    
	    @Autowired
	    private PaymentRepo paymentRepo;
	    
	    @Autowired
	    private CampaignRepo campaignRepo;

	@Override
	public Staff login(LoginDto loginDto) {
		Staff staff= staffRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		staff.setStatus(true);
		return mapper.map(staff, Staff.class);
	}

	
	@Override
	public String logout(Long staffId) {
		staffRepo.findById(staffId).orElseThrow().setStatus(false);
		return "Successfully Logged Out !!!";
		
	}

	@Override
	public List<Staff> viewStaffs() {
		
		return staffRepo.findAll();
	}


	@Override
	public List<Request> viewRequests() {
		Boolean status=false;
		return reqRepo.findAllByStatus(status);
	}


	@Override
	public Campaign addCampaign(AddCampaignDto campaignDto) {
		return campaignRepo.save(campaignDto);
	}

	
	@Override
	public String deleteCampaign(Long campaignId) {
		campaignRepo.deleteById(campaignId);
		return "Campaign Deleted !!!!";
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
	public Campaign updateCampaign(AddCampaignDto updatedCampaign) {
		 Campaign campaign=mapper.map(updatedCampaign,Campaign.class);     
			if(campaignRepo.existsById(updatedCampaign.getId())) {
	    	   return campaignRepo.save(campaign);
	       }
			return null;
	}


	@Override
	public Staff addStaff(RegisterStaffDto newStaff) {
		Staff staff=mapper.map(newStaff, Staff.class);
		
		return staffRepo.save(staff);
	}


	@Override
	public Staff updateStaff(RegisterStaffDto updatedStaff) {
		 Staff staff=mapper.map(updatedStaff,Staff.class);     
			if(staffRepo.existsById(updatedStaff.getId())) {
	    	   return staffRepo.save(staff);
	       }
			return null;
		
	}


	@Override
	public String deleteStaff(Long staffId) {
	
		staffRepo.deleteById(staffId);
		return "Staff Deleted";
	}


	@Override
	public String viewLocationOfDonor(Long donorId) {
		return donorRepo.findById(donorId).orElseThrow().getAddress();
		
	}


	@Override
	public String viewLocationOfReceiver(Long receiverid) {
		return receiverRepo.findById(receiverid).orElseThrow().getAddress();
		
	}


	@Override
	public Boolean checkPaymentStatus(Long paymentId) {
		
		return paymentRepo.findById(paymentId).orElseThrow().getStatus();
	}

	

}
