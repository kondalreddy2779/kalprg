package practiceDataDrivenTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportGeneration {
@Test
public void reportTest() throws IOException
{
	ExtentReports reports=new ExtentReports("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\reports\\index.html",true);
	ExtentTest test=reports.startTest("GoogleandGmailTesting");
	FirefoxDriver driver=new FirefoxDriver();
	test.log(LogStatus.INFO,"Launched firefox" );
	driver.get("http://google.com");
	test.log(LogStatus.INFO, "open Google");
	driver.findElement(By.linkText("Gmail")).click();
	test.log(LogStatus.INFO, "clicked on Gmail");
	File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(srcfile, new File("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\scheernshots\\gmail.png"));
	test.addScreenCapture("D:\\kalpana\\SeleniumExamples\\src\\com\\qedge\\scheernshots\\gmail.png");
	reports.endTest(test);
	reports.flush();
	
}
}
