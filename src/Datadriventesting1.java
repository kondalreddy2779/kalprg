import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Datadriventesting1 
{
	FirefoxDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("https://care.ideacellular.com/wps/portal/account/express-paybill");
	}
	@Test
	public void linktest() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\excelfiles\\Ajaxdataxl.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheet("Sheet1");
	Iterator<Row> row=ws.iterator();
	row.next();
	while(row.hasNext())
	{
		Row r=row.next();
		String phno=r.getCell(0).getStringCellValue();
		driver.findElement(By.name("mobileNumber")).clear();
		driver.findElement(By.name("mobileNumber")).sendKeys(phno);
		driver.findElement(By.name("amountPaid")).click();
		WebElement ajax=driver.findElement(By.xpath("//*[@id='errorHolder']/label"));
		String actajax=null;
		if(ajax.getText().isEmpty())
		{
			actajax="no ajax";
		}
		else
		{
			actajax=ajax.getText();
		}
		r.createCell(2).setCellValue(actajax);
		String expajax=r.getCell(1).getStringCellValue();
		if(actajax.equals(expajax))
		{
			r.createCell(3).setCellValue("passed");
		}
		else
		{
			r.createCell(3).setCellValue("failed");
		}
		}
	FileOutputStream f1=new FileOutputStream("C:\\Users\\qedge\\Desktop\\AjaxdataxResult.xlsx");
	wb.write(f1);
	f1.close();
	}

}
