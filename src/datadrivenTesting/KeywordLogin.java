package datadrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class KeywordLogin {
	FirefoxDriver driver;
public void launchBrowser()
{
	 driver=new FirefoxDriver();
}
public void enterUrl()
{
	driver.get("http://opensource.demo.orangehrm.com");
	Sleeper.sleepTightInSeconds(5);
	
}
public void enterUsername()
{
	driver.findElement(By.id("txtUsername")).sendKeys("Admin");
}
public void enterPassword()
{
	driver.findElement(By.id("txtPassword")).sendKeys("admin");
}
public void clickLogin()
{
	driver.findElement(By.id("btnLogin")).click();
}
}
