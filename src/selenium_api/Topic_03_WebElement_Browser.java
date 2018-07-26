package selenium_api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_WebElement_Browser {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void TC_01_IsDisplayed() throws Exception {
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement ageRadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
		WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));

		Assert.assertTrue(isControlDisplayed(emailTextbox));
		Assert.assertTrue(isControlDisplayed(ageRadioButton));
		Assert.assertTrue(isControlDisplayed(educationTextArea));

		if (isControlDisplayed(emailTextbox) && isControlDisplayed(educationTextArea)) {
			emailTextbox.sendKeys("Automation Testing");
			educationTextArea.sendKeys("Automation Testing");
		}
		Thread.sleep(5000);
	}

	public boolean isControlDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public void TC_02_IsEnable() throws Exception {
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement ageURadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
		WebElement passwordText = driver.findElement(By.xpath("//input[@id='password']"));
		WebElement educationTextArea = driver.findElement(By.xpath("//textarea[@id='edu']"));
		WebElement job1selectextbox = driver.findElement(By.xpath("//select[@id='job1']"));
		WebElement developmentradioButton = driver.findElement(By.xpath("//input[@id='development']"));
		WebElement slider1line = driver.findElement(By.xpath("//input[@id='slider-1']"));
		WebElement buttonEnabledButton = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		WebElement ageRadioDisable = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		WebElement biographyTextare = driver.findElement(By.xpath("//textarea [@id='bio']"));
		WebElement job2selecttextbox = driver.findElement(By.xpath("//textarea [@id='bio']"));
		WebElement interestCheckdisableRadio = driver.findElement(By.xpath("//input[@id='check-disbaled']"));
		WebElement slider2line = driver.findElement(By.xpath("//input[@id='slider-2']"));
		WebElement buttonDisableddButton = driver.findElement(By.xpath("//button[@id='button-disabled']"));

		isControlEnabled(emailTextbox);
		isControlEnabled(ageURadioButton);
		isControlEnabled(passwordText);
		isControlEnabled(educationTextArea);
		isControlEnabled(job1selectextbox);
		isControlEnabled(developmentradioButton);
		isControlEnabled(slider1line);
		isControlEnabled(buttonEnabledButton);
		isControlEnabled(ageRadioDisable);
		isControlEnabled(biographyTextare);
		isControlEnabled(job2selecttextbox);
		isControlEnabled(interestCheckdisableRadio);
		isControlEnabled(slider2line);
		isControlEnabled(buttonDisableddButton);

		Thread.sleep(5000);
	}

	public void isControlEnabled(WebElement element) {
		if (element.isEnabled()) {
			System.out.println("Element is enabled");
		} else {
			System.out.println("Element is disabled");
		}

	}

	@Test
	public void TC_03_IsEnable() throws Exception {

		WebElement ageURadioButton = driver.findElement(By.xpath("//input[@id='under_18']"));
		ageURadioButton.click();
		WebElement developmentradioButton = driver.findElement(By.xpath("//input[@id='development']"));
		developmentradioButton.click();
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
