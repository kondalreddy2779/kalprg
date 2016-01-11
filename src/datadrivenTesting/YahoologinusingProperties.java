package datadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YahoologinusingProperties {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver=new FirefoxDriver();
		driver.get("http://yahoomail.com");
		Sleeper.sleepTightInSeconds(4);
			
	}
	@Test
	public void loginTest()throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\kalpana\\SeleniumExamples\\orange.properties");
		Properties pr=new Properties();
		pr.load(f);
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys("raji_537");
		driver.findElement(By.id(pr.getProperty("password"))).sendKeys("abc@123");
		driver.findElement(By.id(pr.getProperty("login"))).click();
	}
}
