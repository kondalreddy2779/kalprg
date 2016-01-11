import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class slidebar 
{
	FirefoxDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://www.cleartrip.com/flights");
	}
	@Test
	
		public void slidetest()
		{
		Sleeper.sleepTightInSeconds(75);
			Actions action=new Actions(driver);
			WebElement slider=driver.findElement(By.xpath("//*[@id='ResultContainer_1_1']/section[2]/section/aside[1]/div[1]/form/div/div[2]/div/div/div[1]"));
			int x=slider.getLocation().x;
			int y=slider.getLocation().y;
			System.out.println(x+"--"+y);
			action.dragAndDropBy(slider, x, 50).build().perform();
		
	}

}
