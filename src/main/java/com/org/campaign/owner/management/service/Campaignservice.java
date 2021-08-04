package com.org.campaign.owner.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.campaign.owner.management.model.Campaignmodel;
import com.org.campaign.owner.management.repository.Campaignrepository;


@Service
public class Campaignservice {
	
	@Autowired
	Campaignrepository campaignrepository;
	
	public List<String> getdetails(){
		List<String> ls = new ArrayList();
		ls.add("campaign_Owner : ABC");
		ls.add("campaign_contact : 12345");
		ls.add("campaign_channel : TV");
		return ls;
	}
	
	private int campaignOwnerIdCount = 1;
	private  List<Campaignmodel> campaignDetails = new ArrayList();
	public Campaignmodel addcampaignmodel (Campaignmodel campaign){
		campaign.setCampaignOwnerId(campaignOwnerIdCount);
		campaignDetails.add(campaign);
		campaignOwnerIdCount++;
		return campaign;
		
	}
	
	public List<Campaignmodel> getOwnerDetails(){
		return campaignDetails;
	}
	
	public Optional<Campaignmodel> getOwnerDetails(int CampaignOwnerId){
		/*return campaignDetails
				.stream()
				.filter(c->c.getCampaignOwnerId() == CampaignOwnerId)
				.findFirst()
				.get();*/
		return campaignrepository.findById(CampaignOwnerId);
		
	}
	
	public Optional<Campaignmodel> updateOwnerDetails(int CampaignOwnerId , Campaignmodel campaign){
		/*campaignDetails*/
		/*.stream()*/
		/*.forEach(c -> {
			if(c.getCampaignOwnerId()==CampaignOwnerId){
				c.setCampaignContact(campaign.getCampaignContact());
				c.setCampaignChannels(campaign.getCampaignChannels());
				c.setCampaignState(campaign.getCampaignState());
			}
		});*/
	
				Optional<Campaignmodel> model =  campaignrepository.findById(CampaignOwnerId);
				if(model.isPresent()){
				
				model.get().setCampaignChannels(campaign.getCampaignChannels());
				model.get().setCampaignContact(campaign.getCampaignContact());
				model.get().setCampaignState(campaign.getCampaignState());
			    campaignrepository.save(model.get());
			    return model;
			    
				}
				return Optional.empty();
				
		/*return campaignDetails
				.stream()
				.filter(c -> c.getCampaignOwnerId()==CampaignOwnerId)
				.findFirst()
				.get();*/
	}

}
