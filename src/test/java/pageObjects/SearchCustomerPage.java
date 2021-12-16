package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	WebDriver driver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		waithelper=new WaitHelper(driver);
	}
	
	By txtEmail=By.cssSelector("#SearchEmail[name='SearchEmail']");
	By txtFirstName=By.cssSelector("#SearchFirstName[name='SearchFirstName']");
	By txtLastName=By.cssSelector("#SearchLastName[name='SearchLastName']");
	By btnSearch=By.cssSelector("#search-customers[class='btn btn-primary btn-search']");
	By webTable=By.cssSelector("#customers-grid:nth-of-type(1)");
	By webTableRows=By.cssSelector("div.dataTables_scrollBody tbody tr");
	By webTableCols=By.cssSelector("div.dataTables_scrollBody tbody td");
	
	public void setEmail(String email)
	{
		waithelper.waitForElement(driver.findElement(txtEmail), 30);
		driver.findElement(txtEmail).clear();;
		driver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		waithelper.waitForElement(driver.findElement(txtFirstName), 30);
		driver.findElement(txtFirstName).clear();;
		driver.findElement(txtFirstName).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		waithelper.waitForElement(driver.findElement(txtLastName), 30);
		driver.findElement(txtLastName).clear();;
		driver.findElement(txtLastName).sendKeys(lname);
	}
	
	public void search()
	{
		driver.findElement(btnSearch).click();
	}
	
	public int getNoOfRows()
	{
		List<WebElement> rows=driver.findElements(webTableRows);
		return (rows.size());
	}
	
	public int getNoOfColumns()
	{
		List<WebElement> cols=driver.findElements(webTableCols);
		return (cols.size());
	}
	
	public boolean verifySearchResults(String email)
	{
		WebElement customerTable=driver.findElement(webTable);
		boolean flag=false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailId=customerTable.findElement(By.cssSelector("div.dataTables_scrollBody tbody tr:nth-of-type("+i+") td:nth-of-type(2)")).getText();
			if(emailId.equalsIgnoreCase(email))
			{
				flag=true;
				break;
			}
		}
		return flag;
		
	}
	

}
