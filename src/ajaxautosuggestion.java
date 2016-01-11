

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ajaxautosuggestion 
{
FirefoxDriver driver;
@BeforeTest
public void setup()
{
	driver=new FirefoxDriver();
	driver.get("http://google.com");
}
@Test
public void ajaxtest()
{
	driver.findElement(By.className("gsfi")).sendKeys("selenium");
	Sleeper.sleepTightInSeconds(4);
	WebElement block=driver.findElement(By.xpath(".//*[@id='sbtc']/div[2]/div[2]/div[1]"));
	List<WebElement> ajax=block.findElements(By.tagName("li"));
	for(int i=0;i<ajax.size();i++)
	{
		System.out.println(ajax.get(i).getText());
		
	}
}
}
