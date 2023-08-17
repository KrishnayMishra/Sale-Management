package com.management.sale.service;
//Developed logic on adding product, getting products with their prices adjusted with the ongoing campaigns and also storing prices of product
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.management.sale.dao.CampaignDao;
import com.management.sale.dao.PriceChangeDao;
import com.management.sale.dao.ProductDao;
import com.management.sale.entity.Campaign;
import com.management.sale.entity.CampaignDiscount;

import com.management.sale.entity.Product;
import com.management.sale.entity.PriceChange;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CampaignDao campaignDao;
	
	@Autowired
	private PriceChangeDao priceChangeDao;
	
	public Product addProduct(Product product) {
		
	    double mrp=product.getMrp();
	    double discount=product.getDiscount();
	    double currentPrice= mrp-(mrp*discount/100);
	    product.setCurrentPrice(currentPrice);
	  //Getting current Date in "yyyy-MM-dd'T'HH:mm:ss'Z'" format
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String currentDateTime = LocalDateTime.now(ZoneOffset.UTC).format(formatter);
        Timestamp inputDate = Timestamp.valueOf(currentDateTime.replace("T", " ").replace("Z", ""));
        PriceChange initialPriceChange = new PriceChange(inputDate,product.getId(),product.getCurrentPrice());
        priceChangeDao.save(initialPriceChange);  //saving product price data 
        
        return productDao.save(product); //saving product details
    }
	
	 public Page<Product> getAllProducts(int pageNumber) {
		   Pageable pageable = PageRequest.of(pageNumber,10); //Setting the default value of max no of pages as 10 and dynamically fetching value for pageNumber
	        Page<Product> products = productDao.findAll(pageable); //getting all saved products
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
	        String currentDateTime = LocalDateTime.now(ZoneOffset.UTC).format(formatter);
	        Timestamp inputDate = Timestamp.valueOf(currentDateTime.replace("T", " ").replace("Z", ""));
	        List<Campaign> activeCampaigns = campaignDao.findActiveCampaigns(inputDate); //getting all active campaigns
	        
	        //Adjust the price according to the live campaigns of different products
	        for (Product product : products) {
	            double tempPrice = product.getCurrentPrice();
              for (Campaign campaign : activeCampaigns) {          	
	               for (CampaignDiscount campaignDiscount : campaign.getCampaignDiscounts()) {
	                    if (campaignDiscount.getProductId().equals(product.getId())) {
	                        tempPrice = tempPrice - (tempPrice * campaignDiscount.getDiscount() / 100);
	                    }
	                }
	            }
              PriceChange initialPriceChange = new PriceChange(inputDate,product.getId(),tempPrice);
              priceChangeDao.save(initialPriceChange); //Saving product price history after updating it.
              double discount = ((product.getMrp()-tempPrice)*100)/product.getMrp();
              product.setCurrentPrice(tempPrice);
              product.setDiscount(discount);

	        }

	        return products;
	    }
	 
}
