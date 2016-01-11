package day16;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SliderAutomation {
	FirefoxDriver driver;
	@BeforeMethod
	public void setUp()
	{
		driver= new FirefoxDriver();
		driver.get("https://jqueryui.com/slider/#slider-vertical");
	}
	@Test
	public void sliderTest()
	{
		driver.switchTo().frame(0);
		Actions action=new Actions(driver);
		WebElement slider=driver.findElement(By.xpath("//*[@id='slider-vertical']/span"));
	   int y=slider.getLocation().y;
	   action.dragAndDropBy(slider, 40,y).build().perform();
	}

}
