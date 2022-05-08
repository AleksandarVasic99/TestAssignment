package task1.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUsername() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		return el;
	}

	public void setUsername(String value) {
		WebElement usernameEl = this.getUsername();
		usernameEl.clear();
		usernameEl.sendKeys(value);
	}

	public WebElement getPassword() {
		WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		return el;
	}

	public void setPassword(String value) {
		WebElement usernameEl = this.getPassword();
		usernameEl.clear();
		usernameEl.sendKeys(value);
	}

	public void clickSignInButton() {
		driver.findElement(By.id("login-button")).click();
		;
	}

	public void signIn(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickSignInButton();
	}

}