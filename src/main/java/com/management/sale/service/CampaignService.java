package com.management.sale.service;
//Created logic for adding data in campaign dao and listing all the campaigns
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.sale.dao.CampaignDao;
import com.management.sale.entity.Campaign;

@Service
public class CampaignService {
	
	@Autowired 
	private CampaignDao campaignDao;
	
	public Campaign addCampaign(Campaign campaign) {
        return campaignDao.save(campaign);
    }
	
	public List<Campaign> getAllCampaigns() {
        return campaignDao.findAllSortedByStartDate();
        
    }

}
