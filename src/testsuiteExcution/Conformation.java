package testsuiteExcution;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Conformation extends Constants{
@Test
public void conformationTest()
{
	String expmsg=" Your itinerary has been booked!";
	String actmsg=driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
    System.out.println("the actual messge is:"+actmsg);
	if(expmsg.equals(actmsg))
    {
    	System.out.println("Flight ticket is booked successfully");
    }
    else
    {
    	System.out.println("Flight ticket is not booked successfully");
    }
}
}
