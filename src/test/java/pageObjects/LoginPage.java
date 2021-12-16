package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "Email") 
	WebElement emailField; 
	
	@FindBy(id = "Password")
	WebElement passwordField;
	
	@FindBy(css = "div.buttons>button")
	WebElement loginBtn;
	
	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void  setUserName(String email) {
		emailField.clear();
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	

}
