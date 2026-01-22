package com.wildberries.webtests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchAndCartTest extends BaseTest {
    
    @Test
    void testSearchProductAndAddToCart() {
        // 1. Поиск товара
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("футболка мужская черная хлопок" + Keys.ENTER);
        
        // 2. Выбор первого товара из результатов
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(".product-card__link:first-child")
            )
        );
        firstProduct.click();
        
        // 3. Добавление в корзину
        WebElement addToCartBtn = wait.until(
            ExpectedConditions.elementToBeClickable(
                By.cssSelector(".btn-main")
            )
        );
        addToCartBtn.click();
        
        // 4. Проверка, что товар добавлен
        WebElement cartCounter = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".navbar-pc__notify")
            )
        );
        assertTrue(cartCounter.getText().contains("1"));
    }
}
