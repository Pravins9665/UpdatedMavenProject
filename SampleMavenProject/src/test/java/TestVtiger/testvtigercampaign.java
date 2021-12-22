package TestVtiger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Selenium;
import vtiger.vtigercampaignpage;
import vtiger.vtigerhomepage;
import vtiger.vtigerloginpage;

public class testvtigercampaign extends Selenium {

	vtigerloginpage getvtigerloginpage = null;
	vtigerhomepage getvtigerhomepage = null;
	vtigercampaignpage getvtigercampaignpage = null;

	@BeforeTest(description = "pre requisite to perform operations in leads")
	public void Testprerequisite() {
		WebDriver driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		getvtigerhomepage = new vtigerhomepage(driver);
		getvtigerloginpage = new vtigerloginpage(driver);
		getvtigercampaignpage = new vtigercampaignpage(driver);

		getvtigerloginpage.loginInVtiger("admin", "Test@123");
		getvtigerhomepage.navigatetocampaignpage();
	}

	@Test(priority = 0, description = "create new campaign")
	public void testcreatecampaign() {
		getvtigercampaignpage.createcampaign(properties.getProperty("campaignName"), "june", "2022", "2");

	}

	@Test(priority = 1, description = "edit new campaign")
	public void testeditcampaign() {
		getvtigercampaignpage.editcampaign();
	}

	@Test(priority = 2, description = "delete new campaign")
	public void testdeletecampaign() {
		getvtigercampaignpage.deletecampaign();
	}

}
