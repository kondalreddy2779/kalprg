import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Droganddrop 
{
FirefoxDriver driver;
@BeforeTest
public void setup()
{
	driver=new FirefoxDriver();
	driver.get("https://jqueryui.com/droppable/");
}
@Test
public void mousehovertest()
{
	Actions action=new Actions(driver);
	driver.switchTo().frame(0);
	WebElement drag=driver.findElement(By.id("draggable"));
	WebElement drop=driver.findElement(By.id("droppable"));
	action.dragAndDrop(drag, drop).build().perform();
}

}
