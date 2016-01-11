package datadrivenTesting;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class KeywordTest {
	FirefoxDriver driver;
	static Properties pr;
	public void setUp() throws IOException
	{
		FileInputStream f1=new FileInputStream("D:\\kalpana\\SeleniumExamples\\orange.properties");
		pr=new Properties();
		pr.load(f1);
	}
	
	public void launchBrowser()
	{
		 driver=new FirefoxDriver();
	}
	public void enterUrl()
	{
		driver.get("http://opensource.demo.orangehrm.com");
		Sleeper.sleepTightInSeconds(5);
		
	}
	public void enterUsername() throws IOException
	{  
		setUp();
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys("Admin");
		
	}
	public void enterPassword()
	{
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys("admin");
	}
	public void clickLogin()
	{
		driver.findElement(By.id(pr.getProperty("login"))).click();
	}
	
	
        /*public static void main(String[] args)
          {
               KeywordTest key1=new KeywordTest();
                key1.launchBrowser();
                key1.enterUrl();
                key1.enterUsername1();
                key1.enterPassword1();
                key1.clickLogin1();


           }*/
}
