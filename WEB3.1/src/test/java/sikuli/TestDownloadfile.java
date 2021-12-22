package sikuli;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utility.Selenium;

public class TestDownloadfile {

	static WebDriver driver;

	@Test(priority = 1)
	public void testURL() {
		driver = Selenium.setUp("Chrome", "http://demo.automationtesting.in/FileDownload.html");
	}

	@Test(priority = 1, description = "download word file...")
	public void testdownloadwordfile() {
		WebElement inputtext = driver.findElement(By.xpath("//textarea[@id='textbox']"));
		inputtext.sendKeys("Hello, Welcome to Selenium World!");

		WebElement createword = driver.findElement(By.xpath("(//button[text()='Generate File'])[1]"));
		if (createword.isEnabled()) {
			createword.click();
		}
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
	}

	@Test(priority = 2, description = "download pdf file...")
	public void testdownoadpdffile() {

		driver.findElement(By.id("pdfbox")).sendKeys("Hello, Welcome to Selenium World!");
		driver.findElement(By.id("createPdf")).click();
		driver.findElement(By.id("pdf-link-to-download")).click();
	}

	@Test(priority = 2, description = "validate the files are downloaded are not...")
	public void testvalidate() throws Exception {
		Thread.sleep(5000);
		String path1 = "C:\\Users\\admin\\Downloads\\info.txt";
		String path2 = "C:\\Users\\admin\\Downloads\\info.pdf";
		
		File file1 = new File(path1);
		File file2 = new File(path2);

		if (file1.exists() && (file2.exists())) {
			System.out.println("file are downloaded...");
		} else
			System.out.println("files are not downloaded...");
	}

}
