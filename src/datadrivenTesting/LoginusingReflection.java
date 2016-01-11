package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class LoginusingReflection {
	KeywordLogin key=new KeywordLogin();
	Method[]methods=key.getClass().getMethods();
	@Test
	public void loginTest() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
	 FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\Keywords\\keywords.xlsx");
	 XSSFWorkbook wb=new XSSFWorkbook(f);
	 XSSFSheet ws=wb.getSheet("Sheet1");
	
	 Iterator<Row>row=ws.iterator();
	 row.next();
	 while(row.hasNext())
	 {
		 Row r=row.next();
		 String action=r.getCell(3).getStringCellValue();
		 createAction(action);
	 }
	 
	}	
	public void createAction(String action) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		for(int i=0;i<methods.length;i++)
		{
			if(action.equals(methods[i].getName()))
			{
				methods[i].invoke(key);
				break;
			}
		}
	}
}
	 
