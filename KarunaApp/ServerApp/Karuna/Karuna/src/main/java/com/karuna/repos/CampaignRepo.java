package com.karuna.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karuna.dto.AddCampaignDto;
import com.karuna.entity.Campaign;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {

	List<Campaign> findAllByStatus(Boolean status);

	Campaign save(AddCampaignDto campaignDto);

}
