package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigerleadspage extends Selenium {

	WebDriver driver;

	public vtigerleadspage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Leads_listView_basicAction_LBL_ADD_RECORD")
	private WebElement addLead;

	@FindBy(xpath = "//span[text()='None']")
	private WebElement salotaionForLead;

	@FindBy(xpath = "//div[@id='select2-drop']/ul/li[2]")
	private WebElement selectSalotationTypeForLead;

	@FindBy(id = "Leads_editView_fieldName_firstname")
	private WebElement firstNameInputFieldForLead;

	@FindBy(id = "Leads_editView_fieldName_lastname")
	private WebElement lastNameInputFieldForLead;

	@FindBy(id = "Leads_editView_fieldName_phone")
	private WebElement contactNumberOfLead;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveButtonForLead;

	@FindBy(xpath = "//h4[contains(text(),'Leads')]")
	private WebElement leadHeaderLink;

	@FindBy(xpath = "//a[contains(text(),'Elon')]")
	private WebElement newlyCreatedLeadName;

	@FindBy(xpath = "//tr[td[span[span[contains(text(),'9999900000')]]]]/td[1]//span[@class='more dropdown action']")
	private WebElement kebabmenuleads;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[2]/a[1]")
	private WebElement selecteditoption;

	@FindBy(name = "company")
	private WebElement companyinput;

	@FindBy(xpath = "//span[contains(text(),'Testing')]")
	private WebElement editedcompanyinput;

	@FindBy(xpath = "//body/div[@id='page']/ul[3]/li[3]/a[1]")
	private WebElement selectdeleteoption;

	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement confirmdelete;

	public void createnewleads(String fname, String lname, String number) {

		clickOnElement(addLead);
		clickOnElement(salotaionForLead);
		clickOnElement(selectSalotationTypeForLead);
		typeInput(firstNameInputFieldForLead, fname);
		typeInput(lastNameInputFieldForLead, lname);
		typeInput(contactNumberOfLead, number);
		clickOnElement(saveButtonForLead);
		clickOnElement(leadHeaderLink);
	}

	public boolean validateleadscreation() {
		return isElementExist(newlyCreatedLeadName);
	}

	public void editleads(String companyname) {
		clickOnElement(kebabmenuleads);
		clickOnElement(selecteditoption);
		typeInput(companyinput, companyname);
		clickOnElement(saveButtonForLead);
	}

	public boolean validateleadsedit() {
		return isElementExist(editedcompanyinput);
	}

	public void deleteleads() {
		clickOnElement(kebabmenuleads);
		clickOnElement(selectdeleteoption);
		clickOnElement(confirmdelete);

	}

	public boolean validatedeleteleads() {
		return isElementExist(newlyCreatedLeadName);
	}
}
