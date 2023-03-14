package com.karuna.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karuna.dto.LoginDto;
import com.karuna.entity.Donor;
import com.karuna.entity.Receiver;
import com.karuna.entity.Request;
import com.karuna.entity.Staff;
import com.karuna.exception.ResourceNotFoundException;
import com.karuna.repos.DonorRepo;
import com.karuna.repos.PaymentRepo;
import com.karuna.repos.ReceiverRepo;
import com.karuna.repos.RequestRepo;
import com.karuna.repos.StaffRepo;


@Service
@Transactional
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService {
	
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

	    @Override
		public Staff login(LoginDto loginDto) {
			Staff staff= staffRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())
					.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
			staff.setStatus(true);
			return mapper.map(staff, Staff.class);
		}

	@Override
	public List<Request> viewRequests() {
		Boolean status=false;
		return reqRepo.findAllByStatus(status);

	}

	@Override
	public String viewLocationOfDonor(Long donorId) {
		return donorRepo.findById(donorId).orElseThrow().getAddress();
		
	}

	@Override
	public String viewLocationOfReceiver(Long receiverId) {
		return receiverRepo.findById(receiverId).orElseThrow().getAddress();
	  
	}

	@Override
	public Boolean checkPaymentStatus(Long paymentId) {
		return paymentRepo.findById(paymentId).orElseThrow().getStatus();
	}

	@Override
	public String logout(Long staffId) {
		staffRepo.findById(staffId).orElseThrow().setStatus(false);
		return "Successfully Logged Out !!!";
		
	}

	@Override
	public Boolean handleRequest(Long reqId) {
		reqRepo.findById(reqId).orElseThrow().setStatus(true);
		return true;
	}
	
	

}
