package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LoginTestusingKeywords {
@Test
public void loginTest() throws IOException
{
 FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\Keywords\\keywords.xlsx");
 XSSFWorkbook wb=new XSSFWorkbook(f);
 XSSFSheet ws=wb.getSheet("Sheet1");
 KeywordLogin key=new KeywordLogin();
 Iterator<Row>row=ws.iterator();
 row.next();
 while(row.hasNext())
 {
	 Row r=row.next();
	 String x=r.getCell(3).getStringCellValue();
	 if(x.equals("launchBrowser"))
	 {
		 key.launchBrowser();
	 }
	 else if(x.equals("enterUrl"))
	 {
		 key.enterUrl();
	 }
	 else if(x.equals("enterUsername"))
	 {
		 key.enterUsername();
	 }
	 else if(x.equals("enterPassword"))
	 {
		 key.enterPassword();
	 }
	 else if(x.equals("clickLogin"))
	 {
		 key.clickLogin();
	 }
 }
}
}
