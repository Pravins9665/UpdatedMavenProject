package TestVtiger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Selenium;
import vtiger.vtigercontactspage;
import vtiger.vtigerhomepage;
import vtiger.vtigerloginpage;

public class testvtigercontacts extends Selenium {

	vtigerhomepage getvtigerhomepage = null;
	vtigercontactspage getvtigercontactspage = null;
	vtigerloginpage getvtigerloginpage = null;

	@BeforeTest(description = "pre requisite to perform operations in leads")
	public void Testprerequisite() {
		WebDriver driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		getvtigerhomepage = new vtigerhomepage(driver);
		getvtigercontactspage = new vtigercontactspage(driver);
		getvtigerloginpage = new vtigerloginpage(driver);

		getvtigerloginpage.loginInVtiger("admin", "Test@123");
		getvtigerhomepage.navigatetocontactspage();
	}

	@Test(priority = 0, description = "create new contact")
	public void testcreatecontact() {
		getvtigercontactspage.createcontacts(properties.getProperty("contactFirstName"),
				properties.getProperty("contactLastName"), properties.getProperty("ContactOfficePhone"));

	}

	@Test(priority = 1, description = "edit new contact")
	public void testeditcontact() {
		getvtigercontactspage.editcontacts(properties.getProperty("contactTitle"));

	}

	@Test(priority = 2, description = "delete new contact")
	public void testdeletecontact() {
		getvtigercontactspage.deletecontact();
	}
}
