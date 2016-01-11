package testsuiteExcution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BookTickect extends Constants {
@Test
public void bookTicketTest()
{
	driver.findElement(By.name("passFirst0")).sendKeys("raji");
	driver.findElement(By.name("pass.0.meal")).sendKeys("Hindu");
	driver.findElement(By.name("buyFlights")).click();
}
}
