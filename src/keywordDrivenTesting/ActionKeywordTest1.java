package keywordDrivenTesting;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;



public class ActionKeywordTest1 {
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
		Sleeper.sleepTightInSeconds(5);
	}
	
   public void FirstName() throws IOException
   {  setUp();
	   driver.findElement(By.id("ap_customer_name")).sendKeys("aaaaaa");
   }
   public void Email()
   {
	   driver.findElement(By.id("ap_email")).sendKeys("raji_537@yahoo.com");
   }
   public void EmailAgain()
   {
	   driver.findElement(By.id("ap_email_check")).sendKeys("raji_537@yahoo.com");
   }
   public void Password()
   {
	   driver.findElement(By.id("ap_password")).sendKeys("123abcd");
   }
   public void PasswordAgain()
   {
	   driver.findElement(By.id("ap_password_check")).sendKeys("123abcd");
   }
   public void Account()
   {
	   driver.findElement(By.id("continue")).click();
   }
}
