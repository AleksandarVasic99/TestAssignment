package task1.pages;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBarPage {

	private WebDriver driver;

	public NavBarPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void numberOfProductsInCart(String expectedNumber) {
		String ActualNumberOfProducts = driver.findElement(By.xpath("//*[@class=\"shopping_cart_badge\"]")).getText();
		String ExpectedNumberOfProducts = expectedNumber;
		assertEquals(ExpectedNumberOfProducts, ActualNumberOfProducts);
	}

	public void clickOnCart() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class=\"shopping_cart_link\"]")));
		el.click();
	}

}
