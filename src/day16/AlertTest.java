package day16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class AlertTest {
FirefoxDriver driver;
@BeforeMethod
public void setUp()
{
	driver=new FirefoxDriver();
	driver.get("http://google.com");
	Sleeper.sleepTightInSeconds(5);
}
@Test
public void alertTesting()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("alert('hi friends');");
	Sleeper.sleepTightInSeconds(5);
	Alert myalert=driver.switchTo().alert();
	myalert.accept();
			
}
}
