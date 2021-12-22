package Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jse {
	public static WebDriver driver;

	public static void gettitlebyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println("Title of current webpage is: " + title);
	}

	public static void getURLbyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String url = js.executeScript("return document.URL;").toString();
		System.out.println("URL of current webpage is: " + url);
	}

	public static void getdomainbyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String domain = js.executeScript("return document.domain;").toString();
		System.out.println("Domain of current webpage is: " + domain);
	}

	public static void getinnertextbyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innertext = js.executeScript("return documentElement.innertext;").toString();
		System.out.println("URL of current webpage is: " + innertext);
	}

	public static void SendkeysbyJS(WebDriver driver, String locator, String attribute, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (locator.equalsIgnoreCase("id")) {
			js.executeScript("document.getElementById('" + attribute + "').value='" + value + "';");
		} else if (locator.equalsIgnoreCase("name")) {
			js.executeScript("document.getElementByname('" + attribute + "').value='" + value + "';");
		}
	}

	public static void clickelementbyJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void clickelementbyID(WebDriver driver, String id) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(' " + id + " ').click();");
	}

	public static void checkboxbyJS(WebDriver driver, String attribute, Boolean value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('" + attribute + "').checked=" + value + ";");

	}

	public static void generatealertbyJS(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + " ')");
	}

	public static void refreshbowserbyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public static void scrollpage(WebDriver driver, String scrollop, Integer pxl) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (scrollop.equalsIgnoreCase("Down")) {
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		} else if (scrollop.equalsIgnoreCase("Up")) {
			js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		} else if (scrollop.equalsIgnoreCase("Pixel")) {
			js.executeScript("window.scrollBy(0," + pxl + ")");
		}
	}

	public static void scrollToElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public static void drawborder(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public static void ZoompagebyJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}

}
