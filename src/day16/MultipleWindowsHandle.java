package day16;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsHandle {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://bing.com");
		Sleeper.sleepTightInSeconds(5);
	}
	@Test
	public void multipleWindowsTest()
	{
		driver.findElement(By.id("sb_help")).click();
		Sleeper.sleepTightInSeconds(8);
		String title1=driver.getTitle();
		Set<String>windowsid=driver.getWindowHandles();
		Iterator<String>it=windowsid.iterator();
		System.out.println(windowsid.size());
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			String acturl=driver.getTitle();
			if(!title1.equals(acturl))
			{
				driver.findElement(By.xpath("//*[@id='navGroupData']/div/div[3]/div/ul/li[2]/a")).click();
			}
		}
		
	}
}
