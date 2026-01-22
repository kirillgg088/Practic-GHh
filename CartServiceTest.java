package com.wildberries.unittests;

import com.wildberries.demoapp.model.Cart;
import com.wildberries.demoapp.model.Product;
import com.wildberries.demoapp.service.CartService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {
    
    @Test
    void testCalculateDiscount_WhenCartTotalOver5000_ShouldReturnDiscount() {
        // Arrange (Подготовка)
        Cart cart = new Cart();
        cart.addProduct(new Product("Ноутбук", 4500));
        cart.addProduct(new Product("Мышь", 800));
        CartService service = new CartService();
        
        // Act (Действие)
        double discount = service.calculateDiscount(cart);
        
        // Assert (Проверка)
        assertEquals(5300 * CartService.DISCOUNT_RATE, discount, 0.01);
        // Ожидаем скидку 10% от 5300 = 530
    }
    
    @Test
    void testCalculateDiscount_WhenCartTotalUnder5000_ShouldReturnZero() {
        Cart cart = new Cart();
        cart.addProduct(new Product("Футболка", 1500));
        CartService service = new CartService();
        
        double discount = service.calculateDiscount(cart);
        
        assertEquals(0, discount, 0.01);
    }
}
