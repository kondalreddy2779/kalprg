package keywordDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ActionandPropertiesTest {
	PropertiesandAction object=new PropertiesandAction();
	Method[] methods=object.getClass().getMethods();

	@Test
	    public void registrationTest() throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	    {
	    	FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\Keywords\\amazonAction.xlsx");
	    	XSSFWorkbook wb=new XSSFWorkbook(f);
	    	XSSFSheet ws=wb.getSheet("Sheet1");
	    	Iterator<Row>row=ws.iterator();
	    	//object.setUp();
	    	row.next();
	    	while(row.hasNext())
	    	{
	    		Row r=row.next();
	    		String x=r.getCell(3).getStringCellValue();
	    		excuteAction1(x);
	    	}
	    }
	    	public void excuteAction1(String x) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	    	{
	    		for(int i=0;i<methods.length;i++)
	    		{
	    			if(x.equals(methods[i].getName()))
	    			{
	    				methods[i].invoke(object);
	    				break;
	    			}
	    		}
	    	}
	    }

