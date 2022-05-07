package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void clickAddToCart(String product) {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[//div[text()=\"" + product + "\"]]//button[text()='Add to cart']")));
		el.click();
	}
	public boolean buttonIsSelected(String product) {
		return new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//div[//div[text()=\"" + product + "\"]]//button[text()='Remove']"))).isSelected();
	}
	public void clickOnProduct(String product) {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"inventory_item_label\"]//div[text()=\"" + product + "\"]")));
		el.click();
	}
	public void clickRemoveFromCart(String product) {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[//div[text()=\"" + product + "\"]]//button[text()='Remove']")));
		el.click();
	}
	
	
}
