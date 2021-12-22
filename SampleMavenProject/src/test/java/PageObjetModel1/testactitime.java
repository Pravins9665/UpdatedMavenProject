package PageObjetModel1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.Selenium;

public class testactitime extends Selenium {

	@Test
	public void testloginlogout() {
		WebDriver driver = setUp("chrome", "https://demo.actitime.com/login.do");
		actitime act = new actitime(driver);
		
		act.setusername("admin");
		act.setpassword("manager");
		act.clickonlogin();
		act.clickonlogout();
		
		
	}
}
