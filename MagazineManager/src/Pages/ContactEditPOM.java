package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactEditPOM {
	
	WebElement companyname, firstname, lastname, email, primaryphone, savebtn;
	
	String CompanyName, FirstName, LastName, Email, PrimaryPhone;
	
	By CompanyNamefield = By.xpath(".//*[@name='CompanyName']");
	By FirstNamefield = By.xpath(".//*[@name='FirstName']");
	By LastNamefield = By.xpath(".//*[@name='LastName']");
	By EmailAddressfield = By.xpath(".//*[@name='Email']");
	By PrimaryPhonefield = By.xpath(".//*[@name='Phone']");
	By savebutton = By.xpath(".//*[@id='btnSave']");
	
	public void setCompanyDetails(WebDriver driver, String CompanyName, String FirstName, String LastName)
	{
		this.CompanyName = CompanyName;
		this.FirstName = FirstName;
		this.LastName = LastName;
		
		companyname = driver.findElement(CompanyNamefield);
		companyname.click();
		companyname.sendKeys(CompanyName);
		
		firstname = driver.findElement(FirstNamefield);
		firstname.click();
		firstname.sendKeys(FirstName);
		
		lastname = driver.findElement(LastNamefield);
		lastname.click();
		lastname.sendKeys(LastName);
		
	}
	
	public void setAddressDetails(WebDriver driver, String Email, String PrimaryPhone)
	{
		
		this.Email = Email;
		this.PrimaryPhone = PrimaryPhone;
		
		email = driver.findElement(EmailAddressfield);
		email.click();
		email.sendKeys(Email);
		
		primaryphone = driver.findElement(PrimaryPhonefield);
		primaryphone.click();
		primaryphone.sendKeys(PrimaryPhone);
		
	}
	
	public void createContact(WebDriver driver, String CompanyName, String FirstName, String LastName, String Email, String PrimaryPhone)
	{
		this.CompanyName = CompanyName;
		this.FirstName = FirstName;
		this.LastName = LastName;
		this.Email = Email;
		this.PrimaryPhone = PrimaryPhone;
		
		this.setCompanyDetails(driver, CompanyName, FirstName, LastName);
//		try { Thread.sleep(3000);
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
		this.setAddressDetails(driver, Email, PrimaryPhone);
		
		savebtn = driver.findElement(savebutton);
		savebtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
