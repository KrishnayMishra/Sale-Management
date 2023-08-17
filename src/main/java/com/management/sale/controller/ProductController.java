package com.management.sale.controller;
//Adding product and getting all the products
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.management.sale.entity.PriceChange;
import com.management.sale.entity.Product;
import com.management.sale.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	//Adding a new Product
	@PostMapping
	@RequestMapping("/addproducts")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.ok(addedProduct);
    }
	
	//Getting all products and dynamically giving values for starting pageNumber
	@GetMapping("/allproducts")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber) {
        Page<Product> products = productService.getAllProducts(pageNumber);
        return ResponseEntity.ok(products);
    }
	
}
