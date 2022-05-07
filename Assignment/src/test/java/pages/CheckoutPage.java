package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getFirstName() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));
		return el;
	}

	public void setFirstName(String value) {
		WebElement El = this.getFirstName();
		El.clear();
		El.sendKeys(value);
	}

	public WebElement getLastName() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("last-name")));
		return el;
	}

	public void setLastName(String value) {
		WebElement El = this.getLastName();
		El.clear();
		El.sendKeys(value);
	}

	public WebElement getZipCode() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("postal-code")));
		return el;
	}

	public void setZipCode(String value) {
		WebElement El = this.getZipCode();
		El.clear();
		El.sendKeys(value);
	}

	public void clickContinueButton() {
		driver.findElement(By.id("continue")).click();
	}

	public void populateCheckoutFields(String firstname, String lastname, String zipcode) {
		this.setFirstName(firstname);
		this.setLastName(lastname);
		this.setZipCode(zipcode);
		this.clickContinueButton();
	}

	public void clickFinishButton() {
		driver.findElement(By.id("finish")).click();
	}

	public void getModalDialog() {
		WebElement Message = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		String ActualMessage = Message.getText();
		System.out.println(ActualMessage);
		Assert.assertEquals("THANK YOU FOR YOUR ORDER", ActualMessage);
	}

}
