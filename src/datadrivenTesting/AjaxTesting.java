package datadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxTesting {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("https://care.ideacellular.com/wps/portal/account/express-paybill");
		Sleeper.sleepTightInSeconds(6);
			
	}
	@Test
	public void ajaxTest()throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\excelfiles\\ajax.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row>row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			driver.findElement(By.name("mobileNumber")).clear();
			driver.findElement(By.name("mobileNumber")).sendKeys(r.getCell(0).getStringCellValue());
			driver.findElement(By.name("amountPaid")).click();
			String x=driver.findElement(By.xpath("//*[@id='errorHolder']/label")).getText();
			String actajax=null;
			if(x.equals(r.getCell(1).getStringCellValue()))
			  {
				r.createCell(2).setCellValue(x);
			  }
			else
			{
				r.createCell(2).setCellValue("No ajax");
			}
		 String expajax=r.getCell(1).getStringCellValue();
		 actajax=r.getCell(2).getStringCellValue();
		 if(actajax.equals(expajax))
		 {
			 r.createCell(3).setCellValue("Passed");
		 }
		 else
		 {
			 r.createCell(3).setCellValue("Failed"); 
		 }
		}
		FileOutputStream f1=new FileOutputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\resultsexcel\\ajax.xlsx");
	    wb.write(f1);
	    f1.close();
	}
}
