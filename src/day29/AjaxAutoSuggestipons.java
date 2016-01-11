package day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.Test;

public class AjaxAutoSuggestipons {
	@Test
	public void ajaxTest()
	{
		FirefoxDriver driver= new FirefoxDriver();
		driver.get("http://google.com");
		driver.findElement(By.xpath("//*[@id='sb_ifc0']")).sendKeys("selenium");
		Sleeper.sleepTightInSeconds(5);
		//xpath of the complete block of ajaxautosuggestions
		WebElement block=driver.findElement(By.xpath("//*[@id='sbtc']/div[2]/div[2]/div[1]"));
		List<WebElement> ajax=block.findElements(By.xpath("//*[starts-with(@id,'sbse']/div[2]"));
		System.out.println(ajax.size());
		for(int i=0;i<ajax.size();i++)
		{
			System.out.println(ajax.get(i).getText());
		}
		
	}

}
