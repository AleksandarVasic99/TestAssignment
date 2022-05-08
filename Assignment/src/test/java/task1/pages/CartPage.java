package task1.pages;

import static org.junit.Assert.assertTrue;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void pressenceOfProduct(String product) {
		assertTrue(driver.getPageSource().contains(product));
	}

	public boolean isElementDisplayed(String product) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> dynamicElement = driver.findElements(By.xpath("//div[//div[text()=\"" + product + "\"]]"));
		if (dynamicElement.size() != 0) {
			return false;
		} else {
			return true;
		}
	}

	public void clickCheckoutButton() {
		driver.findElement(By.id("checkout")).click();
	}

}