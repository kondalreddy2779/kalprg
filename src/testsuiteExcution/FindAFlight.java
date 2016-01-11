package testsuiteExcution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindAFlight extends Constants {
@Test
public void findaflightTest()
{
	driver.findElement(By.name("tripType")).click();
	driver.findElement(By.name("fromPort")).sendKeys("London");
	driver.findElement(By.name("fromMonth")).sendKeys("January");
	driver.findElement(By.name("fromDay")).sendKeys("15");
	driver.findElement(By.name("toPort")).sendKeys("New York");
	driver.findElement(By.name("toMonth")).sendKeys("February");
	driver.findElement(By.name("toDay")).sendKeys("10");
	driver.findElement(By.name("servClass")).click();
	driver.findElement(By.name("airline")).sendKeys("Unified Airlines");
	driver.findElement(By.name("findFlights")).click();
}
}
