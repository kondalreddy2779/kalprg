package testsuiteExcution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SelectAFlight extends Constants {
@Test
public void selectFlightTest()
{
	driver.findElement(By.name("outFlight")).click();
	driver.findElement(By.name("inFlight")).click();
	driver.findElement(By.name("reserveFlights")).click();
}
}
