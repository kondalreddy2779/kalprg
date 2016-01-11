package testsuiteExcution;

import org.openqa.selenium.By;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class loginTest extends Constants {
@Test
public void loginTest1()
{
	driver=new FirefoxDriver();
	driver.get("http://newtours.demoaut.com");
	driver.findElement(By.name("userName")).sendKeys("tutorial");
	driver.findElement(By.name("password")).sendKeys("tutorial");
	driver.findElement(By.name("login")).click();
}
}
