package com.org.campaign.owner.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.org.campaign.owner.management.model.Campaignmodel;

@Repository
public interface Campaignrepository extends MongoRepository<Campaignmodel, Integer> {

}
