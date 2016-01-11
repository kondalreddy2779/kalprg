package keywordDrivenTesting;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertiesTest1 {
	FirefoxDriver driver;

	@BeforeMethod
	public void setUp() throws IOException
	{
		driver=new FirefoxDriver();
		Actions action=new Actions(driver);
		driver.get("https://www.amazon.in");
		Sleeper.sleepTightInSeconds(5);
		WebElement account=driver.findElement(By.id("nav-link-yourAccount"));
		action.moveToElement(account).build().perform();
		driver.findElement(By.xpath("//*[@id='nav-flyout-ya-newCust']/a")).click();
	}
	
    @Test
    public void registrationTest() throws IOException
    {
    	FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\amazon.properties");
    	Properties pr=new Properties();
    	pr.load(f);
    	driver.findElement(By.id(pr.getProperty("Yourname"))).sendKeys("xxxx");
    	driver.findElement(By.id(pr.getProperty("Email"))).sendKeys("raji_537@yahoo.com");
    	driver.findElement(By.id(pr.getProperty("Emailagain"))).sendKeys("raji_537@yahoo.com");
    	driver.findElement(By.id(pr.getProperty("Password"))).sendKeys("1223345567");
    	driver.findElement(By.id(pr.getProperty("Passwordagain"))).sendKeys("1223345567");
    	driver.findElement(By.id(pr.getProperty("signin"))).click();
    }
}
