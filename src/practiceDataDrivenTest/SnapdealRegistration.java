package practiceDataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SnapdealRegistration {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=new FirefoxDriver();
		Actions actions=new Actions(driver);
		driver.get("http://www.snapdeal.com");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\qedge\\Desktop\\New folder\\one.png"));

		Sleeper.sleepTightInSeconds(4);
		WebElement accounts=driver.findElement(By.xpath("//*[@id='accountHeader']/div[1]/span"));
		actions.moveToElement(accounts).build().perform();
		driver.findElement(By.className("newUserRegister")).click();
		Sleeper.sleepTightInSeconds(5);
		File srcFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("C:\\Users\\qedge\\Desktop\\New folder\\two.png"));

	
	}
	@Test
	public void registrationTest() throws IOException
	{   List<WebElement>myframes=driver.findElements(By.tagName("iframe"));
	System.out.println(myframes.size());
		/*for(int i=0;i<myframes.size();i++)
		{
			
		    driver.switchTo().frame(i);
		     
		
		}*/
		FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\snapdealReg.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row>row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			
			for(int i=0;i<myframes.size();i++)
			{
			    driver.switchTo().frame(i);
			   
			    driver.findElement(By.xpath("//*[@id='login-register-modal']/div[2]/div[2]/div[1]/div/span")).click();
			    File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File("C:\\Users\\qedge\\Desktop\\New folder\\three.png"));

			    //Sleeper.sleepTightInSeconds(5);
			    
				try
				{
	            driver.findElement(By.xpath("//*[@id='j_number']")).sendKeys(r.getCell(0).getStringCellValue());
			    driver.findElement(By.id("j_username_new")).sendKeys(r.getCell(1).getStringCellValue());
			    driver.findElement(By.id("j_password")).sendKeys(r.getCell(2).getStringCellValue());
			    driver.findElement(By.id("j_confpassword")).sendKeys(r.getCell(3).getStringCellValue());
	            driver.findElement(By.id("j_pincode")).sendKeys(r.getCell(4).getStringCellValue());
			    driver.findElement(By.id("signup_submit")).click();
			    Sleeper.sleepTightInSeconds(5);
			    String verifytext=driver.findElement(By.className("resend-otp-link")).getText();
			    if(verifytext.equals("Resend Code?"))
			    {
			    	r.createCell(5).setCellValue("Passed");
			    }
			    else
			    {
			    	r.createCell(5).setCellValue("Failed");
			    }
			   
				}
			    
			    catch(Exception e)
			    {
			    	driver.switchTo().defaultContent();
			    }
			   
			}
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:\\Users\\qedge\\Desktop\\New folder\\four.png"));

		}
		FileOutputStream f1=new FileOutputStream("C:\\Users\\qedge\\Desktop\\snapdealReg.xlsx");
		wb.write(f1);
		f1.close();
	}
}

