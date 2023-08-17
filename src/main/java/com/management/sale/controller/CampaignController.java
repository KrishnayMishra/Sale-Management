package com.management.sale.controller;
//Adding the new campaigns and retrieving all the campaigns
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.management.sale.entity.Campaign;
import com.management.sale.service.CampaignService;

@RestController
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;
	
	//Adding new Campaign
	@PostMapping
	@RequestMapping("/addcampaigns")
    public ResponseEntity<Campaign> addCampaign(@RequestBody Campaign campaign) {
        Campaign addedCampaign = campaignService.addCampaign(campaign);
        return ResponseEntity.ok(addedCampaign);
    }
	
	//Getting all campaigns
	@GetMapping("/allcampaigns")
    public ResponseEntity<List<Campaign>> getAllCampaigns() {
        List<Campaign> campaigns = campaignService.getAllCampaigns();
        return ResponseEntity.ok(campaigns);
    }

}
