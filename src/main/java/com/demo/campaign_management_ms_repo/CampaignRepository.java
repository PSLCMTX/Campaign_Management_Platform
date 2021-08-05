package com.demo.campaign_management_ms_repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.campaign_management_ms_model.Campaign;
@Repository
public interface CampaignRepository extends MongoRepository<Campaign,Long> {

}
