package stepDefinitions;
// This is Base class
//This comment added from Github remote repository
//This comment is from local repository
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;
import utilities.WaitHelper;

public class Base {
	
	public WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public WaitHelper waith;
	public SearchCustomerPage scp;
	public static Logger log;
	
	public  static  String randomString()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
