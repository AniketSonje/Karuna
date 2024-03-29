package com.karuna.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.karuna.dto.LoginDto;
import com.karuna.dto.RegisterReceiverDto;
import com.karuna.dto.RequestDto;
import com.karuna.entity.Donor;
import com.karuna.entity.Item;
import com.karuna.entity.Receiver;
import com.karuna.entity.Request;
import com.karuna.exception.ResourceNotFoundException;
import com.karuna.repos.DonorRepo;
import com.karuna.repos.ItemRepo;
import com.karuna.repos.ReceiverRepo;
import com.karuna.repos.RequestRepo;

@Service
@Transactional
public class ReceiverServiceImpl implements ReceiverService {

	@Autowired
	private ReceiverRepo receiverRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private RequestRepo reqRepo;
	
	@Autowired
	private DonorRepo donorRepo;
	
	
	
	public ReceiverServiceImpl() {
		super();
	}

	@Override
	public Receiver registerReceiver(RegisterReceiverDto newReceiver) {
		Receiver receiver=mapper.map(newReceiver, Receiver.class);
		return receiverRepo.save(receiver);
	}

	@Override
	public Receiver login(LoginDto loginDto) {
		Receiver receiver=receiverRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
		receiver.setStatus(true);
		return mapper.map(receiver, Receiver.class);
	}

	@Override
	public Item receive(Long itemId,Long receiverId) {
		Item item=itemRepo.findById(itemId).orElseThrow();
			item.setStatus(true);
			item.setAcceptedDateTime(LocalDateTime.now());
			item.setReceiver(receiverRepo.findById(receiverId).orElseThrow());
			return item;
		}
	
		
	

	@Override
	public String logout(Long receiverId) {
		receiverRepo.findById(receiverId).orElseThrow().setStatus(false);
		return "Logged Out !!!";
	}

	@Override
	public String deleteAccount(Long receiverId) {
		receiverRepo.deleteById(receiverId);
		return "Receiver Deleted!!!";
	}

	@Override
	public Receiver updateReceiver(RegisterReceiverDto updatedReceiver) {
		Receiver receiver=mapper.map(updatedReceiver, Receiver.class);
		if(receiverRepo.existsById(updatedReceiver.getId())) {
			return receiverRepo.save(receiver);
		}
		return null;
	}

	
		
		@Override
		public List<Item> viewItems() {
		    return itemRepo.findAllByStatusIsNullOrStatusFalse();
		}
	

//	@Override
//	public List<Item> viewHistory(Long receiverId) {
//		
//			return itemRepo.findAllByReceiverId(receiverRepo.findById(receiverId).orElseThrow());
//	}
		
		@Override
		public List<Item> viewHistory(Long receiverId) {
		    Receiver receiver = receiverRepo.findById(receiverId)
		        .orElseThrow(() -> new ResourceNotFoundException("Receiver not found"));
		    List<Long> receiverIds = Collections.singletonList(receiverId);
		    return itemRepo.findAllByReceiverIdIn(receiverIds);
		}

	@Override
	public List<Donor> viewDonors() {
		return donorRepo.findAll();
	}

	@Override
	public Request createRequest(RequestDto requestDto) {
		Request request=mapper.map(requestDto, Request.class);
		
	
		return reqRepo.save(request);
	}

}
