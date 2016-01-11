package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;




import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExcelRead {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		Sleeper.sleepTightInSeconds(4);
		driver.findElement(By.linkText("REGISTER")).click();
		
	}
	@Test
	public void registrationTest() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\ajax.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row>row=ws.iterator();
		row.next();
		while(row.hasNext())
		{
			Row r=row.next();
			Iterator<Cell>cell=r.iterator();
			while(cell.hasNext())
			{
				Cell c=cell.next();
				System.out.print(c.getStringCellValue());
			}
			System.out.println();
		}
	}
}
