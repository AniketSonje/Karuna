package com.karuna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karuna.dto.AddCampaignDto;
import com.karuna.dto.LoginDto;
import com.karuna.services.CustomerExecutiveService;

@RestController
@CrossOrigin
@RequestMapping("/customer_executive")
public class CustomerExecutiveController {
	

	@Autowired
	private CustomerExecutiveService custService;
	
	 @PostMapping("/login")
	 public ResponseEntity<?> validateDonor(@RequestBody LoginDto loginDto){
	       	return ResponseEntity.ok(custService.login(loginDto));
	       }

	@GetMapping("/request")
	public ResponseEntity<?> viewRequest(){
			 Boolean status=true;
			return ResponseEntity.ok(custService.viewRequests(status));
		}
	@GetMapping("/handle_request/{reqId}")
	public ResponseEntity<?> acceptRequest(@PathVariable Long reqId){
		return ResponseEntity.ok(custService.handleRequest(reqId));
	}
	
	@GetMapping("/logout/{staffId}")
	public ResponseEntity<?> logout(@PathVariable Long staffId){
		return ResponseEntity.ok(custService.logout(staffId));
	}
	
	@PostMapping("/campaign")
	public ResponseEntity<?> addCampaign(@RequestBody AddCampaignDto campaign){
		return ResponseEntity.ok(custService.addCampaign(campaign));
	}
	
	@PutMapping("/update_campaign")
	public ResponseEntity<?> updateCampaign(@RequestBody AddCampaignDto campaign){
		return ResponseEntity.ok(custService.updateCampaign(campaign));
	}
	
	@DeleteMapping("/{campaignId}")
	public ResponseEntity<?> removeCampaign(@PathVariable Long campaignId){
		return ResponseEntity.ok(custService.deleteCampaign(campaignId));
	}
	
	@DeleteMapping("/{donorId}")
	public ResponseEntity<?> deleteDonor(@PathVariable Long donorId){
		return ResponseEntity.ok(custService.removeDonor(donorId));
	}

	@DeleteMapping("/{receiverId}")
	public ResponseEntity<?> deleteReceiver(@PathVariable Long receiverId){
		return ResponseEntity.ok(custService.removeDonor(receiverId));
	}
	
		
}
