package com.example.tienda_online.model;

public class Product {
    String productName, description, availableUnits, price;
    public Product(){}

    public Product(String productName, String description, String availableUnits, String price){
        this.productName = productName;
        this.description = description;
        this.availableUnits = availableUnits;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(String availableUnits) {
        this.availableUnits = availableUnits;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
