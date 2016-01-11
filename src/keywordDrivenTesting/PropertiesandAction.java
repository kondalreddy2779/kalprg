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

public class PropertiesandAction {
	FirefoxDriver driver;
	static Properties pr;
	
	@BeforeMethod
		public void setUp() throws IOException
		{   
		    FileInputStream f1=new FileInputStream("D:\\kalpana\\SeleniumExamples\\amazon.properties");
    	     pr=new Properties();
    	    pr.load(f1);
			driver=new FirefoxDriver();
			Actions action=new Actions(driver);
			driver.get("https://www.amazon.in");
			Sleeper.sleepTightInSeconds(5);
			WebElement account=driver.findElement(By.id("nav-link-yourAccount"));
			action.moveToElement(account).build().perform();
			driver.findElement(By.xpath("//*[@id='nav-flyout-ya-newCust']/a")).click();
			Sleeper.sleepTightInSeconds(5);
		}
		
	   public void FirstName() throws IOException
	   {    setUp();
		   driver.findElement(By.id(pr.getProperty("Yourname"))).sendKeys("aaaaaa");
	   }
	   public void Email()
	   {
		   driver.findElement(By.id(pr.getProperty("Email"))).sendKeys("raji_537@yahoo.com");
	   }
	   public void EmailAgain()
	   {
		   driver.findElement(By.id(pr.getProperty("Emailagain"))).sendKeys("raji_537@yahoo.com");
	   }
	   public void Password()
	   {
		   driver.findElement(By.id(pr.getProperty("Password"))).sendKeys("123abcd");
	   }
	   public void PasswordAgain()
	   {
		   driver.findElement(By.id(pr.getProperty("Passwordagain"))).sendKeys("123abcd");
	   }
	   public void Account()
	   {
		   driver.findElement(By.id(pr.getProperty("signin"))).click();
	   }
	}


