package com.demo.campaign_management_ms_controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.campaign_management_ms_exception.ResourceNotFoundException;
import com.demo.campaign_management_ms_model.Campaign;
import com.demo.campaign_management_ms_repo.CampaignRepository;

@RestController
public class CampaignController {
	@Autowired
	private CampaignRepository campaignRepository;

	@GetMapping("/campaign")
	public ResponseEntity<List<Campaign>> listOfCampaign() {
		List<Campaign> campaign= campaignRepository.findAll();
		return ResponseEntity.ok().body(campaign);

	}

	@GetMapping("/campaign/{id}")
	public ResponseEntity<Campaign> getlistofCampaignId(@PathVariable(value = "id") Long cgid)
			throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException("Campaign not found for this id :: " + cgid));
		return ResponseEntity.ok().body(campaign);

	}

	@PostMapping("/campaign")
	public ResponseEntity<Campaign> createCampaign(@RequestBody Campaign campaign) {
		try {
			Campaign _campaign = campaignRepository.save(campaign);
			return new ResponseEntity<>(_campaign, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PutMapping("campaign/{cgid}")
	public ResponseEntity<Campaign> updateCampaign(@RequestBody Campaign campaignDetail, @PathVariable long cgid)
			throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException("campaign not found for this id:: " + cgid));
		campaign.setId(campaignDetail.getId());
		campaign.setName(campaignDetail.getName());
		campaign.setStart_date(campaignDetail.getStart_date());
		campaign.setEnd_date(campaignDetail.getEnd_date());
		campaign.setState(campaignDetail.getState());
		campaign.setChannel(campaignDetail.getChannel());
		campaign.setPrice(campaignDetail.getPrice());
		campaign.setCateogry(campaignDetail.getCateogry());
		Campaign updateCampaign = campaignRepository.save(campaign);
		return ResponseEntity.ok(updateCampaign);

	}

	@DeleteMapping("campaign/{cgid}")
	public ResponseEntity<HttpStatus> deleteDept(@PathVariable long cgid) throws ResourceNotFoundException {
		Campaign campaign = campaignRepository.findById(cgid)
				.orElseThrow(() -> new ResourceNotFoundException("campaign not found for this id:: " + cgid));
		campaignRepository.deleteById(cgid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/campaign")
	public ResponseEntity<HttpStatus> deleteDept() throws ResourceNotFoundException {
		campaignRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}

}
