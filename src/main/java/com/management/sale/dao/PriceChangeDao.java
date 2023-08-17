package com.management.sale.dao;
//Created a repository for storing data and coded a query for finding sorted prices of products by date.
import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.management.sale.entity.Campaign;
import com.management.sale.entity.PriceChange;


@Repository
public interface PriceChangeDao extends JpaRepository<PriceChange, Long>{
	
	@Query("SELECT c FROM PriceChange c WHERE c.product_id = :product_id ORDER BY c.date")
	List<PriceChange> findAllPricesSortedByDate(@Param("product_id") String productId);


}
