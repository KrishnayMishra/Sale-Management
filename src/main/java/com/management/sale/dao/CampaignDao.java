package com.management.sale.dao;
//Created repository for storing data and coded queries for finding campaigns sorted by date and for finding active campaign by comparing with the Dates stored in database.
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.management.sale.entity.Campaign;


public interface CampaignDao extends JpaRepository<Campaign, String> {
    // Add custom queries if needed
	
	@Query("SELECT c FROM Campaign c ORDER BY c.startDate")
    List<Campaign> findAllSortedByStartDate(); 
	

	@Query("SELECT c FROM Campaign c WHERE :inputDate BETWEEN c.startDate AND c.endDate")
    List<Campaign> findActiveCampaigns(@Param("inputDate") Timestamp inputDate);
}
