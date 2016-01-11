package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseHover {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver= new FirefoxDriver();
		driver.get("http://flipkart.com");
	}
	@Test
	public void mouseHoverTest()
	{
		Actions action= new Actions(driver);
		WebElement event= driver.findElement(By.xpath("//*[@id='fk-mainhead-id']/div[2]/div/div/ul/li[1]/a/span"));
		action.moveToElement(event).build().perform();
		Sleeper.sleepTightInSeconds(3);
	    event.findElement(By.linkText("Motorola"));
	}
}
