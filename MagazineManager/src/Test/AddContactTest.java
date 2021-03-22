package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import utility.ExcelFileRead;

public class AddContactTest {
	
	WebDriver driver;
	
	static String filepath = "C:\\Personal\\Contact_Details.xlsx";
	static String filename = "Contact_Details.xlsx";
	static String companyName = "";
	static String firstName = "";
	static String lastName = "";
	static String email = "";

	@Test(priority=0)
	public void setup()
	{	
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		utility.Login.loginToSite(driver);
	}
	
	@Test(priority=1, dependsOnMethods="setup")
	public void addContact() throws IOException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ext-element-7']")).click();
		driver.findElement(By.xpath(".//*[text()='Add Contact']")).click();
		
		ContactEditPOM obj = new ContactEditPOM();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement addContactFrame = driver.findElement(By.xpath(".//*[@id='box-1083']"));
		driver.switchTo().frame(addContactFrame);
		
		File file = new File(filepath);
		FileInputStream inputstream = new FileInputStream(file);
		System.out.println(filename.substring(filename.indexOf(".")));;
		if(filename.substring(filename.indexOf(".")).equalsIgnoreCase(".xlsx"))
		{
			Workbook workbook = new XSSFWorkbook(inputstream);
			Sheet sheet = workbook.getSheet("Sheet1");
			int row_count = sheet.getLastRowNum()-sheet.getFirstRowNum();
			for(int i=1; i<row_count; i++)
			{
				Row row = sheet.getRow(i);
				int cell_count = row.getLastCellNum();
				for(int j=0; j<=cell_count; j++)
				{
					companyName = sheet.getRow(i).getCell(0).getStringCellValue();
					firstName = sheet.getRow(i).getCell(1).getStringCellValue();
					lastName = sheet.getRow(i).getCell(2).getStringCellValue();
					email = sheet.getRow(i).getCell(3).getStringCellValue();
				}
			}
		}
		
		obj.createContact(driver, companyName, firstName, lastName, email, "9940391026");
		
	}
	
	
}
