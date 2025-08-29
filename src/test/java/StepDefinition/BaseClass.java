package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utilities.*;

public class BaseClass {

	public static WebDriver driver;
	public LoginPage loginPage;
	public AddNewCustomerPage addNewCustomerPage;
	public SearchCustomerPage searchCustomerPage;
	public static Logger log;
	public ReadConfig readconfig;

	public String generateemailid() {
		return (RandomStringUtils.randomAlphabetic(5) + "@gmail.com");
	}
}
