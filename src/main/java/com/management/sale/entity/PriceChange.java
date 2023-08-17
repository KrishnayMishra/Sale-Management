package com.management.sale.entity;
//Created this entity to store the change in prices of product over date.
import java.sql.Timestamp;

import jakarta.persistence.*;

@Entity
public class PriceChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TIMESTAMP")
    private Timestamp date;
    
    private String product_id;
    private double price;
    
    
    public PriceChange( Timestamp date, String product_id, double price) {
	
		this.date = date;
		this.product_id = product_id;
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
    public PriceChange() {
    	
    }
    public PriceChange(double price) {
        this.price = price;
       
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

    
}
