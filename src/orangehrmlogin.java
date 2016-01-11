import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;


public class orangehrmlogin {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://opensource.demo.orangehrm.com/index.php/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin");
        driver.findElement(By.id("btnLogin")).click();
	}

}
