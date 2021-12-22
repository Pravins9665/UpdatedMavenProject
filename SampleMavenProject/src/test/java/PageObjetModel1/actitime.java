package PageObjetModel1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class actitime {

	WebDriver driver;
	
	By usernamefield = By.xpath("//input[@id='username']");
	By Passwordfield = By.xpath("//input[@name='pwd']");
	By Loginbutton = By.xpath("//a[@id='loginButton']");
	By Logout = By.xpath("//a[@id='logoutLink']");
	
	actitime(WebDriver driver){
		this.driver = driver;
	}
	
	public void setusername(String username) {
		driver.findElement(usernamefield).sendKeys(username);
	}
	public void setpassword(String password) {
		driver.findElement(Passwordfield).sendKeys(password);
	}
	public void clickonlogin() {
		driver.findElement(Loginbutton).click();
	}
	public void clickonlogout() {
		driver.findElement(Logout).click();
	}
}
