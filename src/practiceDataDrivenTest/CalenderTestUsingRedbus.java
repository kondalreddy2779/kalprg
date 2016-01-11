package practiceDataDrivenTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalenderTestUsingRedbus {

	FirefoxDriver driver;

	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=new FirefoxDriver();
		driver.get("https://www.redbus.in");
	}
	
    @Test
    public void calTest() throws IOException
    { 
    FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\redbus.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheet("Sheet1");
	Iterator<Row>row=ws.iterator();
	row.next();
	while(row.hasNext())
	{
		Row r=row.next();
    	driver.findElement(By.id("txtSource")).sendKeys(r.getCell(0).getStringCellValue());
    	driver.findElement(By.id("txtDestination")).sendKeys(r.getCell(1).getStringCellValue());
    	driver.findElement(By.xpath("//*[@id='Search']/div[1]/div[2]/ul/li[1]")).click();
    	driver.findElement(By.id("txtOnwardCalendar")).click();
    }
	   
    	//String doj="31/12/2016";
    	//String[] a=doj.split("/");
    	//String year=a[2];
       // int x=Integer.parseInt(a[1]);
        //String[] months={"Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sept","Octr","Novr","Dec"};
       // String month=months[x-1];
        //String day=a[0];
        String monthyear="Dec";
        monthyear=monthyear.concat("2017");
        System.out.println(monthyear);
        String calmonthyear=driver.findElement(By.xpath("//*[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr[1]/td[2]")).getText();
        System.out.println("the cal month and year:" +calmonthyear);
      while(!calmonthyear.equals(monthyear))
        {
    	  
        	driver.findElement(By.xpath("//*[@id='rbcal_txtOnwardCalendar']/table[2]/tbody/tr[1]/td[3]/button")).click();
        	calmonthyear=driver.findElement(By.xpath("//*[@id='rbcal_txtOnwardCalendar']/table[1]/tbody/tr[1]/td[2]")).getText();
        
    	  
        }
    	  
        
    }
    
}
