package stepDefinitions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;

public class DateDemo {

	WebDriver driver;
	LoginPage lp;
	AddCustomerPage acp;
	String url="https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		lp=new LoginPage(driver);
		driver.get(url);
		lp.setUserName("admin@yourstore.com");
		lp.setPassword("admin");
		lp.clickLoginBtn();
		acp=new AddCustomerPage(driver);
		acp.clickOnCustomersMenu();
		acp.clickOnCustomersMenuItem();
		acp.clickOnAddNew();
	}
	
	public void selectDate(LocalDate d)
	{
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	    String formattedDate = d.format(myFormatObj);
	    String dateSplit[]=formattedDate.split("/");
	    String month=dateSplit[0];
	    String dateSplit1[]=dateSplit[1].split("/");
	    String day=dateSplit1[0];
	    String year=dateSplit1[1];
	    System.out.println(month+" "+day+" "+year);
		driver.findElement(By.cssSelector(".k-select[role='button']")).click();
		
	}
	public static void main(String[] args) {
		DateDemo dd=new DateDemo();
		//dd.setUp();
		dd.selectDate(null);
				
	}


}
