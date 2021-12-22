package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigerorganizationpage extends Selenium {

	WebDriver driver;

	public vtigerorganizationpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, vtigerorganizationpage.class);
	}

	@FindBy(id = "Accounts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addneworganization;

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationname;

	@FindBy(xpath = "//input[@name='website']")
	private WebElement organizationwebsite;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement organizationphone;

	@FindBy(xpath = "//input[@name='bill_city']")
	private WebElement billingcity;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement orgsavebutton;

	@FindBy(xpath = "//h4[contains(text(),'Organizations')]")
	private WebElement orgHeaderLink;

	@FindBy(xpath = "//tr[td[span[span[contains(text(),'123456')]]]]/td[1]//span[@class='more dropdown action']")
	private WebElement kebabmenuorg;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[2]/a[1]")
	private WebElement selecteditoption;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[3]/a[1]")
	private WebElement selectdeleteoption;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmdelete;

	public void createneworg(String orgname, String phone) {
		clickOnElement(addneworganization);
		typeInput(organizationname, orgname);
		typeInput(organizationphone, phone);
		clickOnElement(orgsavebutton);
		clickOnElement(orgHeaderLink);
	}

	public void editorg(String website, String city) {
		clickOnElement(kebabmenuorg);
		clickOnElement(selecteditoption);
		typeInput(organizationwebsite, website);
		typeInput(billingcity, city);
		clickOnElement(orgsavebutton);
	}

	public void deleteorg() {
		clickOnElement(kebabmenuorg);
		clickOnElement(selectdeleteoption);
		clickOnElement(confirmdelete);
	}
}
