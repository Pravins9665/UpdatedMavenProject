package sikuli;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import Utility.Selenium;

public class TestUploadfile extends Selenium {

	static WebDriver driver;

	@Test
	public void testURL() {
		driver = setUp("Chrome", "http://demo.automationtesting.in/Register.html");
	}
	
	@Test
	public void testupload() throws Exception {
		WebElement upload = driver.findElement(By.xpath("//input[@id='imagesrc']"));
		/*
		 * While Uploading a file, after finding element to choose file to upload direct
		 * click may not work. So we have to use Actions class to perform click
		 * operation.
		 */

		// 1. Using Actions class(it will work for all browsers)
		Actions act = new Actions(driver);
		act.click(upload).perform();
		// or
		// 2. Using javacsriptExecutor (it may not work at all time)
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("arguments[0].click();", upload);

		String pngfilepath = "G:\\SETUP\\workspace\\WEB3.0\\resourcefiles\\";
		String uploadfilepath = "G:\\SETUP\\workspace\\WEB3.0\\datafiles\\";

		Screen s = new Screen();

		Pattern inputtextbox = new Pattern(pngfilepath + "inputbox.PNG");
		Pattern openbutton = new Pattern(pngfilepath + "openbutton.PNG");
		Thread.sleep(2000);

		s.wait(inputtextbox, 10);
		s.type(inputtextbox, uploadfilepath + "macbook.PNG");
		s.click(openbutton);
	}
}
