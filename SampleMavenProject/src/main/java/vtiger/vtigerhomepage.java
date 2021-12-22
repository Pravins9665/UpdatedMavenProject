package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigerhomepage extends Selenium {

	WebDriver driver;

	public vtigerhomepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='appnavigator']/div")
	private WebElement menubar;

	@FindBy(xpath = "//span[text()=' MARKETING']")
	private WebElement selectmarketing;

	@FindBy(xpath = "((//div[@dir='ltr'])[1]/li/a)[1]")
	private WebElement selectcampaign;

	@FindBy(xpath = "((//div[@dir='ltr'])[1]/li/a)[2]")
	private WebElement selectleads;

	@FindBy(xpath = "((//div[@dir='ltr'])[1]/li/a)[3]")
	private WebElement selectcontacts;

	@FindBy(xpath = "((//div[@dir='ltr'])[1]/li/a)[4]")
	private WebElement selectorganizations;

	public void navigatetoleadspage() {
		clickOnElement(menubar);
		mousehover("childtarget", selectmarketing, selectleads, null, null);
	}

	public void navigatetocampaignpage() {
		clickOnElement(menubar);
		mousehover("childtarget", selectmarketing, selectcampaign, null, null);
	}

	public void navigatetocontactspage() {
		clickOnElement(menubar);
		mousehover("childtarget", selectmarketing, selectcontacts, null, null);
	}

	public void navigatetooranizationspage() {
		clickOnElement(menubar);
		mousehover("childtarget", selectmarketing, selectorganizations, null, null);
	}

}
