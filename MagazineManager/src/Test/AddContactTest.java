package Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ContactEditPOM;

public class AddContactTest {
	
	WebDriver driver;
  
	@Test(priority=0)
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		utility.Login.loginToSite(driver);
	}
	
	@Test(priority=1, dependsOnMethods="setup")
	public void addContact()
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ext-element-7']")).click();
		driver.findElement(By.xpath(".//*[text()='Add Contact']")).click();
		
		ContactEditPOM obj = new ContactEditPOM();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement addContactFrame = driver.findElement(By.xpath(".//*[@id='box-1083']"));
		
		driver.switchTo().frame(addContactFrame);
		obj.createContact(driver, "18Mar21 CompanyV01", "srinivasan", "vishwas", "vishwasiyer@yahoo.com", "9940391026");
		
	}
	
	
}
