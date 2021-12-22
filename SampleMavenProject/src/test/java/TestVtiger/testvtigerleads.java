package TestVtiger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Selenium;
import vtiger.vtigerhomepage;
import vtiger.vtigerleadspage;
import vtiger.vtigerloginpage;

public class testvtigerleads extends Selenium {

	vtigerhomepage getvtigerhomepage = null;
	vtigerleadspage getvtigerleadspage = null;
	vtigerloginpage getvtigerloginpage = null;

	@BeforeTest(description = "pre requisite to perform operations in leads")
	public void Testprerequisite() {
		
		WebDriver driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		getvtigerhomepage = new vtigerhomepage(driver);
		getvtigerleadspage = new vtigerleadspage(driver);
		getvtigerloginpage = new vtigerloginpage(driver);

		getvtigerloginpage.loginInVtiger("admin", "Test@123");
		getvtigerhomepage.navigatetoleadspage();
	}

	@Test(priority = 0, description = "create new leads")
	public void Testcreateleads() {
		getvtigerleadspage.createnewleads(properties.getProperty("leadFirstName"),
				properties.getProperty("leadLastName"), properties.getProperty("leadContactNumber"));
		Assert.assertTrue(getvtigerleadspage.validateleadscreation());

	}

	@Test(priority = 1, description = "edit new leads")
	public void Testeditleads() {
		getvtigerleadspage.editleads(properties.getProperty("leadCompanyName"));
		Assert.assertTrue(getvtigerleadspage.validateleadsedit());

	}

	@Test(priority = 2, description = "delete new leads")
	public void Testdeleteleads() {
		getvtigerleadspage.deleteleads();
		Assert.assertFalse(getvtigerleadspage.validatedeleteleads());
	}
}
