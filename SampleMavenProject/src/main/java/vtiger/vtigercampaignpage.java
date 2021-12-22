package vtiger;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigercampaignpage extends Selenium {

	WebDriver driver;

	public vtigercampaignpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".addButton")
	private WebElement addcampaign;

	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement campaignname;

	@FindBy(xpath = "//input[@name='closingdate']")
	private WebElement expectedclosingdate;

	@FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
	private WebElement selectmonthyear;

	@FindBy(xpath = "(//th[@class='next'])[1]")
	private WebElement nextmonthyear;

	@FindBy(xpath = "//table[@class=' table-condensed']//tbody//tr/td")
	private List<WebElement> selectdate;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement savecampiagn;

	@FindBy(xpath = "//h4[contains(text(),'Campaigns')]")
	private WebElement campaignsheaderlink;

	@FindBy(xpath = "//a[contains(text(),'Elon')]")
	private WebElement newcreatedcampaignname;

	@FindBy(xpath = "//tr[td[span[span[a[text()='Automation']]]]]/td[1]//span[@class='more dropdown action']")
	private WebElement kebabmenucampaign;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[2]/a[1]")
	private WebElement selecteditoption;

	@FindBy(xpath = "(//tr/td[@class='fieldValue']/div/a)[2]")
	private WebElement campaignstatus;

	@FindBy(xpath = "//ul[@class='select2-results']//li[3]")
	private WebElement campaignstatusactive;

	@FindBy(xpath = "//span[contains(text(),'Active')]")
	private WebElement editedcampaignstatusactive;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[3]/a[1]")
	private WebElement selectdeleteoption;

	@FindBy(xpath = "//button[contains(text(), 'Yes')]")
	private WebElement confirmdelete;

	public void createcampaign(String cname, String month, String year, String day) {
		clickOnElement(addcampaign);
		typeInput(campaignname, cname);
		clickOnElement(expectedclosingdate);
		calendar(month, year, selectmonthyear, nextmonthyear);
		pickdate(day, selectdate);
		clickOnElement(savecampiagn);
		clickOnElement(campaignsheaderlink);
	}

	public boolean validatecampaigncreation() {
		return isElementExist(newcreatedcampaignname);
	}

	public void editcampaign() {
		clickOnElement(kebabmenucampaign);
		clickOnElement(selecteditoption);
		clickOnElement(campaignstatus);
		clickOnElement(campaignstatusactive);
		clickOnElement(savecampiagn);

	}

	public void deletecampaign() {
		clickOnElement(kebabmenucampaign);
		clickOnElement(selectdeleteoption);
		clickOnElement(confirmdelete);

	}

}
