package keywordDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class AmazonAction {
	
	ActionKeywordTest1 object=new ActionKeywordTest1();
	@Test
	    public void registrationTest() throws IOException
	    {
	    	FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\Keywords\\amazonAction.xlsx");
	    	XSSFWorkbook wb=new XSSFWorkbook(f);
	    	XSSFSheet ws=wb.getSheet("Sheet1");
	    	Iterator<Row>row=ws.iterator();
	    	row.next();
	    	while(row.hasNext())
	    	{
	    		Row r=row.next();
	    		String x=r.getCell(3).getStringCellValue();
	    		if(x.equals("FirstName"))
	    		{
	    			object.FirstName();
	    		}
	    		else if(x.equals("Email"))
	    		{
	    			object.Email();
	    		}
	    		else if(x.equals("EmailAgain"))
	    		{
	    			object.EmailAgain();
	    		}
	    		else if(x.equals("Password"))
	    		{
	    			object.Password();
	    		}
	    		else if(x.equals("PasswordAgain"))
	    		{
	    			object.PasswordAgain();
	    		}
	    		else if(x.equals("Account"))
	    		{
	    			object.Account();
	    		}
	    	}
	    }
}
