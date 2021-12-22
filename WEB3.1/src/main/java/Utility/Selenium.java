package Utility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium {

	public static WebDriver driver;

	// WebDriver Setup & open browser
	public static WebDriver setUp(String browsername, String URL) {

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		return driver;

	}

	// To get URL
	public static void getURL() {
		String url = driver.getCurrentUrl();
		System.out.println("URL of current page is: " + url);
	}

	// To get Title of current Web Page
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title of current page is: " + title);
	}

	// Mouse hover operation
	public static void mousehover(String hoverOP, WebElement element, WebElement element1, Integer x, Integer y) {
		Actions act = new Actions(driver);
		if (hoverOP.equalsIgnoreCase("targetonly")) {
			act.moveToElement(element).perform();
		} else if (hoverOP.equalsIgnoreCase("childtarget")) {
			act.moveToElement(element).moveToElement(element1).click().perform();
		} else if (hoverOP.equalsIgnoreCase("targetwithcordinates")) {
			act.moveToElement(element, x, y).perform();
		} else
			act.moveByOffset(x, y).perform();
	}

	// Normal DropDown operation
	public static void dropdown(String dd, WebElement element, Integer num, String text, String value) {
		Select slt = new Select(element);
		if (dd.equalsIgnoreCase("index")) {
			slt.selectByIndex(num);
		} else if (dd.equalsIgnoreCase("text")) {
			slt.selectByVisibleText(text);
		} else if (dd.equalsIgnoreCase("value")) {
			slt.selectByValue(value);
		}
	}

	// Dropdown without select class behaving as normal webelement with single
	// option selection
	public static void dropdown1(List<WebElement> options, String value) {
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(value)) {
				option.click();
				break;
			}
		}
	}

	// Dropdown without select class behaving as normal webelement with multiple
	// choices
	public static void dropdown2(String xpath, String... value) {
		List<WebElement> choicelist = driver.findElements(By.xpath(xpath));
		if (!value[0].equalsIgnoreCase("all")) {
			for (WebElement items : choicelist) {
				String text = items.getText();

				for (String val : value) {
					if (text.equalsIgnoreCase(val)) {
						items.click();
						break;
					}
				}
			}
		} else {
			for (WebElement item : choicelist) {
				item.click();
			}
		}
	}

	// To take ScreenShots
	public static void Getscreenshot(String filepath) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// To select random check box
	public static void Checkbox(List<WebElement> checkboxex, String txt) {

		for (WebElement multiple : checkboxex) {
			String text = multiple.getText();
			if (text.equalsIgnoreCase(txt)) {
				multiple.click();
			}
		}
	}

	// To pick date from calendar
	public static void calendar(String month, String year, String xpathofmonthyear, String xpathnextmonthyear) {
		while (true) {
			String monthyear = driver.findElement(By.xpath(xpathofmonthyear)).getText();
			String arr[] = monthyear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
				break;
			else
				driver.findElement(By.xpath(xpathnextmonthyear)).click();
		}

	}

	// To pick day after month & year
	public static void pickdate(String day, List<WebElement> alldates) {
		for (WebElement element : alldates) {
			String date = element.getText();
			if (date.equals(day)) {
				element.click();
				break;
			}
		}
	}

	// Method to wait for an element till it's not display .
	public void waitForElementDisplayed(WebElement element) {

		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}

	// Method to wait for an element till it's not clickable.

	public void waitForElementToBeClickable(WebElement element) {

		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
	}

	// Close the current browser
	public void cleapUp() {
		driver.close();
	}

}
