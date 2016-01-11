package practiceDataDrivenTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

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

public class AmazonReg {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=new FirefoxDriver();
		Actions actions=new Actions(driver);
		driver.get("https://www.amazon.in");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\qedge\\Desktop\\New folder\\one.png"));

		Sleeper.sleepTightInSeconds(9);
		WebElement accounts=driver.findElement(By.id("nav-link-yourAccount"));
		actions.moveToElement(accounts).build().perform();
		driver.findElement(By.xpath("//*[@id='nav-flyout-ya-newCust']/a")).click();
		File srcFile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("C:\\Users\\qedge\\Desktop\\New folder\\two.png"));

	}
	@Test
	public void registrationTest() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\amazonRegstration.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row>row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			driver.findElement(By.id("ap_customer_name")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.id("ap_email")).sendKeys(r.getCell(1).getStringCellValue());
			driver.findElement(By.id("ap_email_check")).sendKeys(r.getCell(2).getStringCellValue());
			driver.findElement(By.id("ap_password")).sendKeys(r.getCell(3).getStringCellValue());
			driver.findElement(By.id("ap_password_check")).sendKeys(r.getCell(4).getStringCellValue());
			driver.findElement(By.id("continue")).click();
			String x=driver.findElement(By.xpath("//*[@id='hud-dashboard']/div[2]/div/a")).getText();
			System.out.println(x);
			if(x.equals("raji's Amazon"))
			{
				r.createCell(5).setCellValue("Passed");
			}
			else
			{
				r.createCell(5).setCellValue("Failed");
			}
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("C:\\Users\\qedge\\Desktop\\New folder\\three.png"));
	}
		
		FileOutputStream f1=new FileOutputStream("C:\\Users\\qedge\\Desktop\\amazonRegstration.xlsx");
		wb.write(f1);
		f1.close();
}
}
