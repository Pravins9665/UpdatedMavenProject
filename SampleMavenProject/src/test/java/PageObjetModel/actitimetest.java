package PageObjetModel;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Utility.Selenium;

public class actitimetest extends Selenium {

	static WebDriver driver;

	@Test
	public void Testloginandlogout() {
		driver = setUp("Chrome", "https://demo.actitime.com/login.do");
		actitime act = new actitime(driver);
		act.actitimeloginTologout("admin", "manager");
	}

}
