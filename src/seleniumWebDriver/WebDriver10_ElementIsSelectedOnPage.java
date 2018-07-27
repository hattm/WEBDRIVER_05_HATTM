package seleniumWebDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class WebDriver10_ElementIsSelectedOnPage {
	WebDriver driver;

	@BeforeClass
	public void SetUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test01_DevelopmentCheckboxIsSelected() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		String element = "//*[@id='development']";
		driver.findElement(By.xpath(element)).click();
		Thread.sleep(2000);
		if (isElementSelected(driver, element)) {
			System.out.println("'Development' checkbox is selected");

		} else {
			System.out.println("'Development' checkbox isn't selected");
		}
	}

	@Test
	public void Test02_DesignCheckboxIsSelected() {
		String element = "//*[@id='design']";
		driver.findElement(By.xpath(element)).click();
		if (isElementSelected(driver, element)){
			System.out.println("'Design' checkbox is selected");

		} else {
			System.out.println("'Design' checkbox is selected");
		}

	}

	@Test
	public void Test03_Under18RadioIsSelected() throws InterruptedException {
		String element = "//*[@id='under_18']";
		driver.findElement(By.xpath(element)).click();
		Thread.sleep(2000);
		if (isElementSelected(driver, element)) {
			System.out.println("'Under 18' radio button is selected");

		} else {
			System.out.println("'Under 18' radio button is selected");
		}

	}

	@Test
	public void Test04_Over18RadioIsSelected() throws InterruptedException {
		String element = "//input[@id='over_18']";
		driver.findElement(By.xpath(element));
		Thread.sleep(5000);
		if (isElementSelected(driver, element)) {
			System.out.println("'Over 18' radio button is selected ");
		} else {
			System.out.println("'Over 18' radio button isn't selected");
		}

	}

	@Test
	public void Test05_JobRoleDropdownIsSelected() {
		String element = "//*[@id='job1']";
		if (isElementSelected(driver, element)) {
			System.out.println("'Job Role 01' dropdown list is selected");

		} else {
			System.out.println("'Job Role 01' dropdown list isn't selected");
		}

	}

	private boolean isElementSelected(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isSelected();

		} catch (NoSuchElementException e) {
			return false;

		}

	}

	@AfterClass
	public void tearDown() {
		 driver.quit();
	}
}
