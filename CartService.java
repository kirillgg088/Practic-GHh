package com.wildberries.demoapp.service;

import com.wildberries.demoapp.model.Cart;
import com.wildberries.demoapp.model.Product;

public class CartService {
    public static final double DISCOUNT_RATE = 0.1; // 10% скидка
    
    public double calculateDiscount(Cart cart) {
        if (cart.getTotalPrice() > 5000) {
            return cart.getTotalPrice() * DISCOUNT_RATE;
        return 0;
