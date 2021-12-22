package TestVtiger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Selenium;
import vtiger.vtigerhomepage;
import vtiger.vtigerloginpage;
import vtiger.vtigerorganizationpage;

public class testvtigerorganization extends Selenium {

	vtigerloginpage getvtigerloginpage = null;
	vtigerhomepage getvtigerhomepage = null;
	vtigerorganizationpage getvtigerorganizationpage = null;

	@BeforeTest(description = "pre requisite for organization")
	public void prerequisite() {
		WebDriver driver = setUp("Chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		getvtigerhomepage = new vtigerhomepage(driver);
		getvtigerloginpage = new vtigerloginpage(driver);
		getvtigerorganizationpage = new vtigerorganizationpage(driver);

		getvtigerloginpage.loginInVtiger("admin", "Test@123");
		getvtigerhomepage.navigatetooranizationspage();
	}

	@Test(priority = 0, description = "create new organization")
	public void testcreateorg() {
		getvtigerorganizationpage.createneworg(properties.getProperty("orgName"), properties.getProperty("orgPhone"));
	}

	@Test(priority = 1, description = "edit new organization")
	public void testeditorg() {
		getvtigerorganizationpage.editorg(properties.getProperty("orgWebsite"), properties.getProperty("orgCity"));
	}

	@Test(priority = 2, description = "delete new organization")
	public void testdeleteorg() {
		getvtigerorganizationpage.deleteorg();
	}
}
