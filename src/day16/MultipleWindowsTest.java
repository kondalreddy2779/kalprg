package day16;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest {
	
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
			//String x=driver.getCurrentUrl();
			Sleeper.sleepTightInSeconds(8);
			switchToFun("//*[@id='navGroupData']/div/div[4]/div/ul/li[2]/a");
			Sleeper.sleepTightInSeconds(8);
			switchToFun("//*[@id='cntnt']/p/a");

		}
		
		public void switchToFun(String x)
		{
			Set<String>windowsid=driver.getWindowHandles();
			System.out.println("the id of the windows is:"+windowsid);
			System.out.println(windowsid.size());
			Iterator<String>it=windowsid.iterator();
			while(it.hasNext())
			{
				driver.switchTo().window(it.next());
				try
				{
				driver.findElement(By.xpath(x)).click();
				break;
			    }
				catch(Exception e)
				{
					
				}
			}
		}
	}
