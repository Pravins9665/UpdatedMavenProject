package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigercontactspage extends Selenium {

	WebDriver driver;

	public vtigercontactspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(), 'Add Contact')]")
	private WebElement addcontacts;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactlastname;

	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement contactfirstname;

	@FindBy(xpath = "//input[@name='phone']")
	private WebElement contactofficephone;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement contactsavebutton;

	@FindBy(xpath = "//h4[contains(text(),'Contacts')]")
	private WebElement contactHeaderLink;

	@FindBy(xpath = "//tr[td[span[span[contains(text(), '1234567890')]]]]/td[1]//span[@class = 'more dropdown action']")
	private WebElement kebabmenucontacts;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[2]/a[1]")
	private WebElement selecteditoption;

	@FindBy(xpath = "//input[@name = 'title']")
	private WebElement contacttitle;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[3]/a[1]")
	private WebElement selectdeleteoption;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmdelete;

	public void createcontacts(String fname, String lname, String phone) {
		clickOnElement(addcontacts);
		typeInput(contactfirstname, fname);
		typeInput(contactlastname, lname);
		typeInput(contactofficephone, phone);
		clickOnElement(contactsavebutton);
		clickOnElement(contactHeaderLink);
	}

	public void editcontacts(String title) {
		clickOnElement(kebabmenucontacts);
		clickOnElement(selecteditoption);
		typeInput(contacttitle, title);
		clickOnElement(contactsavebutton);
	}

	public void deletecontact() {
		clickOnElement(kebabmenucontacts);
		clickOnElement(selectdeleteoption);
		clickOnElement(confirmdelete);
	}

}
