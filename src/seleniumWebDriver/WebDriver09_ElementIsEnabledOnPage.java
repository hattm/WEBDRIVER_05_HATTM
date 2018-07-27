package seleniumWebDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriver09_ElementIsEnabledOnPage {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test01_TextboxIsDisabled() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		String element = "//input[@id='password']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Textbox is enabled");

		} else {
			System.out.println("Textbox is disabled");
		}
	}

	@Test
	public void Test02_TextAreaIsDisabled() throws Exception {
		String element = "//textarea[@id='bio']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Text Area is enabled");
		} else {
			System.out.println("Text Area is disable");
		}
	}

	@Test
	public void Test03_CheckboxIsDisabled() throws Exception {
		String element = "//[@id='check-disable']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Checkbox is enabled");
		} else {
			System.out.println("Checkbox is disable");
		}
	}

	@Test
	public void Test04_ButtonIsDisabled() throws Exception {
		String element = "//*[button-disabled]";
		if (isElementEnabled(driver, element)) {
			System.out.println("Button is enabled");

		} else {
			System.out.println("Button is disable");
		}
	}

	@Test
	public void Test05_SliderIsDisabled() throws Exception {
		String element = "//*[id='slider-2']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Slider is enable");
		} else {
			System.out.println("Slider is disable");
		}
	}

	@Test
	public void Test06_RadioButtonIsDisabled() throws Exception {
		String element = "//input[@id='radio-disable']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Radio is enabled");
		} else {
			System.out.println("Radio is disable");
		}
	}

	@Test
	public void Test07_DropdownListIsDisabled() throws Exception {
		String element = "//*[id='job2']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Dropdown is enable");
		} else {
			System.out.println("Dropdown is disable");
		}
	}

	private boolean isElementEnabled(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
