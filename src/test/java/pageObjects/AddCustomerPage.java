package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	public WebDriver driver;
	
	public AddCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	By lnkCustomers_menu=By.xpath("//a[@href='#']//child::p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']/p[contains(text(),'Customers')]");
	By btnAddnew=By.xpath("//a[@href='/Admin/Customer/Create']");
	By txtEmail=By.id("Email");
	By txtPassword=By.id("Password");
	By txtFristName=By.id("FirstName");
	By txtLastName=By.id("LastName");
	By rdMaleGender=By.id("Gender_Male");
	By rdFemaleGender=By.id("Gender_Female");
	By txtDob=By.cssSelector("#DateOfBirth.k-input");
	By txtCompanyName=By.id("Company");
	By chkbxisTaxExempt=By.id("IsTaxExempt");
	By txtNewsLetter=By.xpath("//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']//parent::div");
	By lstitemYourStoreName=By.xpath("//span[contains(text(),'Your store name')]");
	By lstitemTestStore2=By.xpath("//span[contains(text(),'Test store 2')]");
	By txtcustomerRoles=By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']//parent::div");
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	By lstitemForumModerators=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By txtMgrVendor=By.id("VendorId");
	By lstitemVendor1=By.cssSelector("#VendorId>option:nth-child(2)");
	By lstitemVendor2=By.cssSelector("#VendorId>option:nth-child(3)");
	By chkbxActive=By.id("Active");
	By txtAdminComment=By.cssSelector("textarea[name='AdminComment']");
	By btnSave=By.cssSelector("button[name='save']");
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickOnCustomersMenu()
	{
		driver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem()
	{
		driver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddNew()
	{
		driver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email)
	{
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txtPassword).sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		driver.findElement(txtFristName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		driver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("male"))
		{
			driver.findElement(rdMaleGender).click();
		}
		else
		{
			driver.findElement(rdFemaleGender).click();
		}
	}
	
	public void setDOB(String dob)
	{
		driver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyName(String cname)
	{
		driver.findElement(txtCompanyName).sendKeys(cname);
	}
	
	public void isTaxExempt(boolean b)
	{
		if(b)
			driver.findElement(chkbxisTaxExempt).click();
	}
	
	public void setNewsLetter(String news)
	{
		Select newsLetterDD=new Select(driver.findElement(txtNewsLetter));
		newsLetterDD.selectByVisibleText(news);
	}
	
	public void setAdminComment(String comment)
	{
		driver.findElement(txtAdminComment).sendKeys(comment);
	}
	
	public void clickSave()
	{
		driver.findElement(btnSave).click();
	}

}
