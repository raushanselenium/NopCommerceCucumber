package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.mortbay.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class VerifyTitleSteps extends Base {

	@Before
	public void setUp() {
		log = LogManager.getLogger("Cucumber Framework Development Program");
		WebDriverManager.chromedriver().setup();
		log.debug("*****INITIAL SETUP*****");

	}

	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {

		log.debug("*****LAUNCHING BROWSER*****");
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
	}

	@When("User opens url {string}")
	public void opensUrl(String url) {
		log.debug("*****OPENING URL*****");
		driver.get(url);
		driver.manage().window().maximize();

	}

	@When("user enters email as {string} and password as {string}")
	public void enterLoginCredentials(String username, String password) {
		log.debug("*****ENTERING LOGIN CREDENTIALS*****");
		lp.setUserName(username);
		lp.setPassword(password);
	}

	@When("User clicks on login")
	public void clickLogin() {
		log.debug("*****CLICKING LOGIN*****");
		lp.clickLoginBtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("****CLICKING LOGIN BUTTON FAILED ******");
			e.printStackTrace();
		}

	}

	@Then("Page title after login is {string}")
	public void verifyTitleAfterLogin(String expTitle) {
		if (driver.getPageSource().contains("Login was unsuccessful")) {
			log.error("*****LOGIN FAILED->TITLE NOT VERIFIED*****");
			driver.close();
			Assert.assertTrue(false);
		} else {
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expTitle, actualTitle);
			log.debug("*****TITLE VERIFIED SUCCESSFULY AFTER LOGIN*****");
		}
	}

	@When("User click on log out link")
	public void clickLogout() {
		log.debug("*****CLICKING LOGOUT*****");
		lp.clickLogout();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("Page title after logout is {string}")
	public void verifyTitleAfterLogout(String title) {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(title, actualTitle);
		log.debug("*****TITLE VERIFIED SUCCESSFULY AFTER LOGOUT*****");
	}

	@Then("Close browser")
	public void closeBrowser() {
		log.debug("*****CLOSING BROWSER*****");
		driver.quit();
	}

	// Add Customer steps

	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		acp = new AddCustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
		log.debug("*****USER VIEWED DASHBOARD*****");
	}

	@When("User clicks on Customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		log.debug("*****CLICKING CUSTOMERS MENU*****");
		acp.clickOnCustomersMenu();
		Thread.sleep(2000);
	}

	@When("User clicks on customers menu item")
	public void user_clicks_on_customers_menu_item() throws InterruptedException {
		log.debug("*****CLICKKING CUSTOMERS MENU ITEM*****");
		acp.clickOnCustomersMenuItem();
		Thread.sleep(2000);
	}

	@When("User clicks on Add new button")
	public void user_clicks_on_add_new_button() throws InterruptedException {
		log.debug("*****CLICKING ADD NEW BUTTON TO ADD CUSTOMER*****");
		acp.clickOnAddNew();
		Thread.sleep(2000);
	}

	@Then("User can see Add a new Customer page")
	public void user_can_see_add_a_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle());
		log.debug("*****ADD CUSTOMER PAGE OPENED*****");
	}

	@When("User enters customer info")
	public void user_enters_customer_info() {
		log.debug("*****ENTERING INFO TO ADD NEW CUSTOMER*****");
		String email = Base.randomString() + "@gmail.com";
		acp.setEmail(email);
		acp.setPassword("abc123");
		acp.setFirstName("Raushan");
		acp.setLastName("Kumar");
		acp.setGender("Male");
		acp.setDOB("12/28/1991");
		acp.setCompanyName("Busy QA");
		acp.isTaxExempt(true);
		// acp.setNewsLetter("Your store name");
		acp.setAdminComment("Commenting.....");
	}

	@When("User clicks on Save button")
	public void user_clicks_on_save_button() throws InterruptedException {
		log.debug("*****CLICKING SAVE*****");
		acp.clickSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
		log.debug("*****NEW CUSTOMER ADDED SUCCESSFULLY*****");
	}

// Search Customer steps

	@When("User enters Customer email")
	public void user_enters_customer_email() {
		log.debug("*****CUSTOMER EMAIL ENTERED FOR SEARCH OPERATION*****");
		scp = new SearchCustomerPage(driver);
		scp.setEmail("UZOod@gmail.com");

	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() throws InterruptedException {
		log.debug("*****CLICKING SEARCH*****");
		scp.search();
		Thread.sleep(2000);

	}

	@Then("User should find email results in the Search table")
	public void user_should_find_email_results_in_the_search_table() {
		Assert.assertTrue(scp.verifySearchResults("UZOod@gmail.com"));
		log.debug("*****CUSTOMER FOUND IN SEARCH RESULTS*****");
	}

	@After
	public void afterHook() {
		log.info("*****AFTER HOOK*****");
	}

}
