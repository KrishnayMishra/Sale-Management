package com.management.sale.controller;
//Getting price history of any product
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.management.sale.entity.PriceChange;
import com.management.sale.entity.Product;
import com.management.sale.service.PriceChangeService;

@RestController
public class PriceChangeController {
	
	@Autowired
	private PriceChangeService priceChangeService;
	
	
	@GetMapping("/{productId}/price-history")
    public ResponseEntity<List<PriceChange>> getProductPriceHistory(@PathVariable String productId) {
        List<PriceChange> priceHistory = priceChangeService.getProductHistory(productId);
        return ResponseEntity.ok(priceHistory);
    }

}
