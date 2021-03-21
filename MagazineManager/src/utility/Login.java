package utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {
  
	@Test
	public static void loginToSite(WebDriver driver)
	{
		//Site - https://tsqb.magazinemanager.com
		
		String Email = "vishwasiyer@yahoo.com";
		String Password = "Second@123";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://tsqb.magazinemanager.com");
		driver.manage().window().maximize();
		
		WebElement Emailfield = driver.findElement(By.xpath(".//*[@name='txtLoginId']"));
		WebElement Passwordfield = driver.findElement(By.xpath(".//*[@name='txtPassword']"));
		
		Emailfield.click();
		Emailfield.sendKeys(Email);
		
		try {
			Thread.sleep(3000);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		Passwordfield.click();
		Passwordfield.sendKeys(Password);
		
		driver.findElement(By.xpath(".//*[@name='btnLogin']")).click();
			
	}
}
