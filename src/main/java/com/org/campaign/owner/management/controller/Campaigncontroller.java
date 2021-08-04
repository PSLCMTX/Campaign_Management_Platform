package com.org.campaign.owner.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.campaign.owner.management.model.Campaignmodel;
import com.org.campaign.owner.management.repository.Campaignrepository;
import com.org.campaign.owner.management.service.Campaignservice;

@RestController
@RequestMapping(path = "/api/campaign")
public class Campaigncontroller {
	@Autowired
	private Campaignservice campaignservice;
	@Autowired
	private Campaignrepository campaignrepository;
	
	@GetMapping(path = "/get")
	public List<String> getdata(){
		return campaignservice.getdetails();
	}
	
	
	@PostMapping(path = "/create")
	public Campaignmodel addcampaignmodel(@RequestBody Campaignmodel campaign){
		campaignservice.addcampaignmodel(campaign); 
		return campaignrepository.save(campaign);
		//return campaignservice.addcampaignmodel(campaign); 
	}
	
	@GetMapping(path = "/getCampaignOwnerId/{CampaignOwnerId}")
	public Optional<Campaignmodel> getOwnerDetails(@PathVariable("CampaignOwnerId") int CampaignOwnerId){
	return campaignservice.getOwnerDetails(CampaignOwnerId);
	}
	
	@PutMapping(path = "/updateCampaignOwnerDetails/{CampaignOwnerId}")
	public Optional<Campaignmodel> updateOwnerDetails(@PathVariable("CampaignOwnerId") int CampaignOwnerId, @RequestBody Campaignmodel campaign){
	return campaignservice.updateOwnerDetails(CampaignOwnerId, campaign);
	}
	
}