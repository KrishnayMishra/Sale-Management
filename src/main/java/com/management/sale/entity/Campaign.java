package com.management.sale.entity;
//Created all parameters for the entity and generated getters setters and constructors.
import java.sql.Timestamp;
import java.util.*;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // annotation helps in producing auto-incrementing primary keys.
    private Long id;
    private String title;
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp startDate;
    
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp endDate;
    
    //Created a collection of campaignDiscounts
    @ElementCollection
    @CollectionTable(name = "campaign_discounts", joinColumns = @JoinColumn(name = "campaign_id"))
    private List<CampaignDiscount> campaignDiscounts;
    
    public void addCampaignDiscount(String productId, Double discount) {
        campaignDiscounts.add(new CampaignDiscount(productId, discount));
    }
    
    public Campaign()
    {
    	
    }

	public Campaign(Long id, String title, Timestamp startDate, Timestamp endDate, List<CampaignDiscount> campaignDiscounts) {

		this.id = id;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.campaignDiscounts = campaignDiscounts;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public List<CampaignDiscount> getCampaignDiscounts() {
		return campaignDiscounts;
	}

	public void setCampaignDiscounts(List<CampaignDiscount> campaignDiscounts) {
		this.campaignDiscounts = campaignDiscounts;
	}
    
}
