package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Selenium;

public class actitime extends Selenium {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernamefield;

	@FindBy(xpath = "//input[@name='pwd']")
	private WebElement password;

	@FindBy(xpath = "//a[@id='loginButton']")
	private WebElement login;

	@FindBy(xpath = "//a[@id='logoutLink']")
	private WebElement logout;

	actitime(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}

	public void actitimeloginTologout(String username, String pwd) {
		typeInput(usernamefield, username);
		typeInput(password, pwd);
		clickOnElement(login);
		clickOnElement(logout);
	}

}
