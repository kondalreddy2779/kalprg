import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excelwrite {

	public static void main(String[] args) throws IOException {
	FileInputStream f=new FileInputStream("C:\\Users\\qedge\\Desktop\\sudheer.xlsx");
	XSSFWorkbook wb=new XSSFWorkbook(f);
	XSSFSheet ws=wb.getSheet("sheet1");
	Row r=null;
	Cell c=null;
	//modify an existing cell
	r=ws.getRow(0);
	c=r.getCell(1);
	c.setCellValue("uday");
	//create cell in existing row
	r=ws.getRow(1);
    c=r.createCell(2);
	c.setCellValue("xxxxxx");
	//create row and cell  in that row
	r=ws.createRow(3);
	c=r.createCell(0);
	c.setCellValue("zzzzzz");
	/*save the file*/
	FileOutputStream f1=new FileOutputStream("C:\\Users\\qedge\\Desktop\\sudheer.xlsx");
	wb.write(f1);
	f1.close();
	
}

}
