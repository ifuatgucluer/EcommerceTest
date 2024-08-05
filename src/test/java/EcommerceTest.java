
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EcommerceTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // ChromeDriver'ın yolu
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testEcommerceSite() {
        // E-ticaret sitesine git
        driver.get("https://www.example.com");

        // Arama kutusunu bul ve arama terimini gir
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("Laptop");
        searchBox.submit();

        // İlk ürünü bul ve sepete ekle
        WebElement firstProduct = driver.findElement(By.cssSelector(".product-item:first-child"));
        firstProduct.click();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart"));
        addToCartButton.click();

        // Sepeti kontrol et
        WebElement cartButton = driver.findElement(By.id("cart"));
        cartButton.click();

        WebElement cartItem = driver.findElement(By.cssSelector(".cart-item"));
        assertTrue(cartItem.isDisplayed());
    }

    @AfterEach
    public void tearDown() {
        // Tarayıcıyı kapat
        if (driver != null) {
            driver.quit();
        }
    }
}
