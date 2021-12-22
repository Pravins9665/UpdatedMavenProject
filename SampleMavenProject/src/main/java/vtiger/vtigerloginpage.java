package vtiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class vtigerloginpage extends Selenium {

	WebDriver driver;

	public vtigerloginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, vtigerloginpage.class);
	}

	@FindBy(id = "username")
	private WebElement usernameInput;

	@FindBy(css = "#password")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement loginButton;

	public void loginInVtiger(String username, String pwd) {
		typeInput(usernameInput, username);
		typeInput(password, pwd);
		clickOnElement(loginButton);
	}

}
