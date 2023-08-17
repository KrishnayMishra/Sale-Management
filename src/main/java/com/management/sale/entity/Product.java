package com.management.sale.entity;
//Created all parameters for the entity and generated getters setters and constructors.
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

@Entity
public class Product {
	
	@Id
	private String id;
	private String title;
	private String description;
    private double mrp;
    private double currentPrice;
    private double discount;
    private int inventory;
    
	public Product(String id, String title, String description, double mrp,  double discount,
			int inventory) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.mrp = mrp;
		this.discount = discount;
		this.inventory = inventory;

	}
	public Product() {
		
		// TODO Auto-generated constructor stub
	}
	public Product(Product product) {
	    this.id = product.getId();
	    this.title = product.getTitle();
	    this.description = product.getDescription();
	    this.mrp = product.getMrp();
	    this.currentPrice = product.getCurrentPrice();
	    this.discount = product.getDiscount();
	    this.inventory = product.getInventory();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
}

