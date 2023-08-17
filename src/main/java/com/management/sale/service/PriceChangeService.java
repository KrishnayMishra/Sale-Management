package com.management.sale.service;
//Created logic for saving data in Dao and fetching change in prices of products by date.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.sale.dao.PriceChangeDao;
import com.management.sale.entity.PriceChange;
import com.management.sale.entity.Product;

@Service
public class PriceChangeService {
	
	@Autowired
	PriceChangeDao priceChangeDao;
	
    public PriceChange addPriceChange(PriceChange priceChange) {
        return priceChangeDao.save(priceChange);
     }
    
    public List<PriceChange> getProductHistory(String productId)
    {
    	return priceChangeDao.findAllPricesSortedByDate(productId);
    }

}
