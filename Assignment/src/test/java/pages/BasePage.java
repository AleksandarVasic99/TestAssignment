package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	private WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public boolean presentsOfTitle(String title) {
		boolean isPresent = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.titleIs(title));
		return isPresent;
	}

	public boolean checkUrl(String url) {
		return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlToBe(url));
	}

}
