package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class StepDef extends BaseClass {

	@BeforeStep("@Sanity")
	void beforeStep() {
		System.out.println("Before Step: Executing step in the scenario.");

	}

	@Before()
	public void suetp() throws IOException {

		readconfig = new ReadConfig();

		String br = readconfig.getBrowser();
		log = LogManager.getLogger("StepDef");

		switch (br.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			driver = WebDriverManager.chromedriver().capabilities(options).create();
			log.info("**********Launching Chrome Browser**********");
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			driver.manage().window().maximize();
			log.info("**********Launching Edge Browser**********");
			break;
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			driver.manage().window().maximize();
			log.info("**********Launching Firefox Browser**********");
			break;

		default:
			driver = null;
			log.fatal("**********Wrong browser name provided**********");
			break;

		}

	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		loginPage = new LoginPage(driver);
		addNewCustomerPage = new AddNewCustomerPage(driver);
		searchCustomerPage = new SearchCustomerPage(driver);
		log.info("**********Launching Chrome Browser2**********");

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {

		driver.get(url);
		log.info("**********Opening URL**********");

	}

	@When("User enters Email {string} and Password {string}")
	public void user_enters_email_and_password(String email, String password) throws InterruptedException {

		loginPage.enterEmail(email);
		loginPage.enterPassword(password);
		log.info("**********Providing login details**********");

	}

	@When("click on Login")
	public void click_on_login() {
		loginPage.clickLoginButton();
		log.info("**********Clicked on login button**********");

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		String expectedTitle = "Dashboard / nopCommerce administration";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
			System.out.println("Page title is as expected: " + actualTitle);
			log.warn("**********validated**********");
		} else {
			Assert.assertTrue(false);
			System.out
					.println("Page title is not as expected. Expected: " + expectedTitle + ", but got: " + actualTitle);
			log.fatal("**********Page title is not as expected**********");
		}
	}

	@When("User clicks on logout button")
	public void user_clicks_on_logout_button() {
		loginPage.clickonlogout();
	}

//	@Then("close browser")
//	public void close_browser() {
//		driver.close();
//	}

	// --------
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		String expectedTitle = "Dashboard / nopCommerce administration";
		String actualTitle = driver.getTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() {
		addNewCustomerPage.clickOnCustomersMenu();

	}

	@When("User clicks on Customers menu item")
	public void user_clicks_on_customers_menu_item() {
		addNewCustomerPage.clickOnCustomersMenuItem();

	}

	@Then("User can view customers page")
	public void user_can_view_customers_page() {
		String expectedTitle = "Add a new customer / nopCommerce administration";
		String actualTitle = addNewCustomerPage.getPageTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@When("User clicks on Add new button")
	public void user_clicks_on_add_new_button() {
		addNewCustomerPage.clickOnAddnew();

	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		String expectedTitle = "Add a new customer / nopCommerce administration";
		String actualTitle = addNewCustomerPage.getPageTitle();
		if (actualTitle.equals(expectedTitle)) {
			Assert.assertTrue(true);
			System.out.println("Add new customer page is displayed successfully.");
		} else {
			Assert.assertTrue(false);
			System.out.println("Add new customer page is not displayed.");
		}
	}

	@When("User enters customer information")
	public void user_enters_customer_information() {
		addNewCustomerPage.enterEmail(generateemailid());
		addNewCustomerPage.enterPassword("test123");
		addNewCustomerPage.enterFirstName("John");
		addNewCustomerPage.enterLastName("Doe");
		addNewCustomerPage.enterGender("Male");
//		addNewCustomerPage.enterDob("01/01/1990");
		addNewCustomerPage.enterCompanyName("Test Company");
		addNewCustomerPage.enterManagerOfVendor("Vendor 1");

	}

	@When("User clicks on save button")
	public void user_clicks_on_save_button() {
		addNewCustomerPage.clickOnSave();

	}

	@Then("User can view customer information {string}")
	public void user_can_view_customer_information(String string) {
		String bodytag = driver.findElement(By.tagName("body")).getText();
		if (bodytag.contains("customer has been added successfully")) {
			Assert.assertTrue(true);
			System.out.println("Customer information is displayed successfully.");
		} else {

			System.out.println("Customer information is not displayed.");
		}

	}

	// --------
	@When("User enters email")
	public void user_enters_email() {
		searchCustomerPage.enterEmailAdd("victoria_victoria@nopCommerce.com");
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		searchCustomerPage.clickOnSearchButton();

	}

	@Then("User should found email in the search table")
	public void user_should_found_email_in_the_search_table() {
		String expectedemail = "victoria_victoria@nopCommerce.com";
		Assert.assertTrue(driver.getPageSource().contains(expectedemail));

	}

	// -----
	@When("Enter customer name")
	public void enter_customer_name() {
		searchCustomerPage.enterFirstName("Victoria");
	}

	@When("User enters last name")
	public void user_enters_last_name() {
		searchCustomerPage.enterLastName("Terces");

	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
		String expectedName = "Victoria Terces";
		Assert.assertTrue(driver.getPageSource().contains(expectedName));
		System.out.println("Customer name found in the search table: " + expectedName);
	}

	// @After
	public void teardown(Scenario sc) {
		System.out.println("Tear Down method executed..");
		if (sc.isFailed() == true) {
			// Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\HP\\JavaFullStck\\CucumberFramework\\Screenshot\\failedScreenshot.png";
			TakesScreenshot scrShot = ((TakesScreenshot) driver);

			// Call getScreenshotAs method to create image file
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			// Move image file to new destination
			File DestFile = new File(fileWithPath);

			// Copy file at destination

			try {
				FileUtils.copyFile(SrcFile, DestFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		driver.quit();
	}

//	@After
//	public void teardwn(Scenario sc) {
//		System.out.println("Tear Down method executed..");
//		if (sc.isFailed() == true) {
//			// Convert web driver object to TakeScreenshot
//
//			String fileWithPath = "C:\\Users\\HP\\JavaFullStck\\CucumberFramework\\Screenshot\\failedScreenshot.png";
//			TakesScreenshot scrShot = ((TakesScreenshot) driver);
//
//			// Call getScreenshotAs method to create image file
//			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
//
//			// Move image file to new destination
//			File DestFile = new File(fileWithPath);
//
//			// Copy file at destination
//
//			try {
//				FileUtils.copyFile(SrcFile, DestFile);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//
//		driver.quit();
//	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {

		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// attach image file report(data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
}
