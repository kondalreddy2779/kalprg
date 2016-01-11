package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PaytmRegistration {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://paytm.com");
		Sleeper.sleepTightInSeconds(4);
			
	}
	@Test
	public void registrationTest() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\excelfiles\\fbregistration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		//Iterator<Row>row=ws.iterator();
		//row.next();
		Sleeper.sleepTightInSeconds(4);
		driver.findElement(By.xpath("//*[@id='user-detail']/div/div/div[5]/span/a[1]")).click();
	    List<WebElement> frames=driver.findElements(By.tagName("iframe"));
	    System.out.println(frames.size());
	    for(int i=0;i<frames.size();i++)
	    {
		    driver.switchTo().frame(i);
		    try
		    {
	    	driver.findElement(By.xpath("//*[@id='login-header-wrapper']/ul/li[2]")).click();
	    	
	    	Sleeper.sleepTightInSeconds(4);
	    	Iterator<Row>row=ws.iterator();
	    	row.next();
	    	while(row.hasNext())
			{
				Row r=row.next();
				
				driver.findElement(By.xpath("//*[@id='input_2']")).sendKeys(r.getCell(0).getStringCellValue());
				//sendKeys(r.getCell(0).getStringCellValue());
				driver.findElement(By.xpath("//*[@id='input_3']")).sendKeys(r.getCell(1).getStringCellValue());
				driver.findElement(By.xpath("//*[@id='input_4']")).sendKeys(r.getCell(2).getStringCellValue());
				
				driver.findElement(By.xpath("//*[@id='signupForm']/div/md-content/button[2]")).click();
				Sleeper.sleepTightInSeconds(4);
	         }
	    	
	    	break;
		    }
		    catch(Exception e)
		    {
		    	driver.switchTo().defaultContent();
		    }
		}
	       
		
	}
}
