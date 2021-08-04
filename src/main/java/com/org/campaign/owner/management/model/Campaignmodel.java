package com.org.campaign.owner.management.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Campaign_Owner_Mnagement")
public class Campaignmodel {

	@Id
	private int campaignOwnerId;
	private String campaignOwnerName;
	private String campaignContact;
	private String campaignChannels;
	private String campaignState;
	
	public int getCampaignOwnerId() {
		return campaignOwnerId;
	}
	public void setCampaignOwnerId(int campaignOwnerId) {
		this.campaignOwnerId = campaignOwnerId;
	}
	public String getCampaignOwnerName() {
		return campaignOwnerName;
	}
	public void setCampaignOwnerName(String campaignOwnerName) {
		this.campaignOwnerName = campaignOwnerName;
	}
	public String getCampaignContact() {
		return campaignContact;
	}
	public void setCampaignContact(String campaignContact) {
		this.campaignContact = campaignContact;
	}
	public String getCampaignChannels() {
		return campaignChannels;
	}
	public void setCampaignChannels(String campaignChannels) {
		this.campaignChannels = campaignChannels;
	}
	public String getCampaignState() {
		return campaignState;
	}
	public void setCampaignState(String campaignState) {
		this.campaignState = campaignState;
	}
	
}
