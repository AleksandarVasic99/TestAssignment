package tests;

import java.time.Duration;
import java.util.Scanner;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import task1.pages.BasePage;
import task1.pages.CartPage;
import task1.pages.CheckoutPage;
import task1.pages.LoginPage;
import task1.pages.NavBarPage;
import task1.pages.ProductsPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Task1 {
	private WebDriver driver;

	private LoginPage loginPage;
	private ProductsPage productsPage;
	private BasePage basePage;
	private NavBarPage navBarPage;
	private CartPage cartPage;
	private CheckoutPage checkoutPage;

	final String product1 = "Sauce Labs Backpack";
	final String product2 = "Sauce Labs Bike Light";
	final String product3 = "Sauce Labs Bolt T-Shirt";
	final String product4 = "Sauce Labs Fleece Jacket";
	final String product5 = "Sauce Labs Onesie";
	final String product6 = "Test.allTheThings() T-Shirt (Red)";

	final String firstname = "Marko";
	final String lastname = "Markovic";
	final String zipcode = "22000";

	@BeforeAll
	@Parameters
	public void initalize() {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println("Input name of the browser:");
			String browser = in.next();
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
				driver = new EdgeDriver();
			}
//			    else if (browser.equalsIgnoreCase("opera")) {
//			    	System.setProperty("webdriver.opera.driver", "operadriver.exe");
//			    	 ChromeOptions options = new ChromeOptions();
//			    	 options.setBinary(new File("C:\\Users\\vasic\\AppData\\Local\\Programs\\Opera"));
//			    	 driver = new OperaDriver(;)
//			}

		}

		// Initialization of all pages
		loginPage = new LoginPage(driver);
		productsPage = new ProductsPage(driver);
		basePage = new BasePage(driver);
		navBarPage = new NavBarPage(driver);
		cartPage = new CartPage(driver);
		checkoutPage = new CheckoutPage(driver);

		// Browser configuration
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

		driver.navigate().to("https://www.saucedemo.com/");
	}

	@Test
	@Order(1)
	public void login() {
		loginPage.signIn("standard_user", "secret_sauce");
		basePage.checkUrl("https://www.saucedemo.com/inventory.html");
	}

	@Test
	@Order(2)
	public void addProduct1() {
		productsPage.clickAddToCart(product1);
		productsPage.buttonIsSelected(product1);
		navBarPage.numberOfProductsInCart("1");
	}

	@Test
	@Order(3)
	public void addProduct2() {
		productsPage.clickOnProduct(product5);
		productsPage.clickAddToCart(product5);
		productsPage.buttonIsSelected(product5);
		navBarPage.numberOfProductsInCart("2");
	}

	@Test
	@Order(4)
	public void verificationOfProductsSelected() {
		navBarPage.clickOnCart();
		productsPage.buttonIsSelected(product1);
		productsPage.buttonIsSelected(product5);
		cartPage.pressenceOfProduct(product1);
		cartPage.pressenceOfProduct(product5);
	}

	@Test
	@Order(5)
	public void removingFirstProductFromCart() throws InterruptedException {
		productsPage.clickRemoveFromCart(product1);
		cartPage.isElementDisplayed(product1);
		cartPage.pressenceOfProduct(product5);
	}

	@Test
	@Order(6)
	public void checkoutProcess() {
		cartPage.clickCheckoutButton();
		checkoutPage.populateCheckoutFields(firstname, lastname, zipcode);
		checkoutPage.clickFinishButton();
		checkoutPage.getModalDialog();

	}

	@AfterAll
	public void quitDriver() {

		driver.quit();
	}
}
