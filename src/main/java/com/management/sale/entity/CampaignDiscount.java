package com.management.sale.entity;
//Created this to enter value into the campaignDiscounts of Campaign entity
import jakarta.persistence.Embeddable;

@Embeddable // helped in creating a class that can be embedded as a component within Campaign entity class, rather than being treated as a separate entity itself.
public class CampaignDiscount {
    private String productId;
    private double discount;

    public CampaignDiscount() {
    }

    public CampaignDiscount(String productId, double discount) {
        this.productId = productId;
        this.discount = discount;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
