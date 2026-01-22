package com.wildberries.demoapp.model;

public class Product {
    private String name;
    private double price;
    
    // Конструктор, геттеры, сеттеры
}

public class Cart {
    private List<Product> items = new ArrayList<>();
    
    public void addProduct(Product product) { items.add(product); }
    public double getTotalPrice() { 
        return items.stream().mapToDouble(Product::getPrice).sum(); 
    }
}
