package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_06_Button_Radio_Checkbox {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	public void TC_01() {
		driver.get("http://live.guru99.com/");
		// Built- in click Selenium: element visible-> action
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='login-form']")).isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/login/");

		// Javacript click: element visible/ invisible -> action(Trick)-> IE
		clickElementByJavascript("//a[@title='Create an Account']");
		Assert.assertTrue(driver.findElement(By.xpath("//form[@id='form-validate']")).isDisplayed());
		Assert.assertEquals(driver.getCurrentUrl(), "http://live.guru99.com/index.php/customer/account/create/");
	}
	@Test
	public void TC_02_Custom_Checkbox() throws Exception {
		driver.get("https://demos.telerik.com/kendo-ui/styling/checkboxes");

		// Case 01 - Label:đang visible - nó có thể click được
		// WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']"));
		// dualZoneCheckbox.click();

		// Khi Assert thì failed: vì mình không checked isSelected cho label
		// Assert.assertTrue(dualZoneCheckbox.isSelected());

		// Case 02 - Input: Invisible không thể click
		// WebElement dualZoneCheckbox_02 = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
		// dualZoneCheckbox_02.click();

		// Khi Assert thì sẽ pass- is Selected(input)
		// Assert.assertTrue(dualZoneCheckbox_02.isSelected());
		// Thread.sleep(5000);

		// Case 03 - Mix label + input - phải khai báo 2 element
		/*
		 * WebElement dualZoneCheckbox = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']")); dualZoneCheckbox.click();
		 * 
		 * WebElement dualZoneCheckbox_02 = driver.findElement(By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input")); Assert.assertTrue(dualZoneCheckbox_02.isSelected());
		 */

		// Case 04 - Chỉ dùng 1 elemet (Vừa click + vừa verify)
		String dualZoneCheckbox = "//label[text()='Dual-zone air conditioning']/preceding-sibling::input";
		// Javacript click: element visible/ invisible/ clickable
		clickElementByJavascript(dualZoneCheckbox);
		Thread.sleep(5000);
		Assert.assertTrue(isElementSelected(dualZoneCheckbox));
		

		// Sau khi checkbox đã được chọn - deselect nó và kiểm tra nó chưa được chọn
		unClickCheckbox(dualZoneCheckbox);
		Assert.assertFalse(isElementSelected(dualZoneCheckbox));
	}


	public void TC_03_Custom_Radionbutton() throws Exception {
		driver.get("http://demos.telerik.com/kendo-ui/styling/radios");
		String petrol147kWRadionbutton = "//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input";
		clickElementByJavascript(petrol147kWRadionbutton);
		Thread.sleep(4000);
		Assert.assertTrue(isElementSelected(petrol147kWRadionbutton));
	}

	@Test
	public void TC_04() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public void clickElementByJavascript(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public boolean isElementSelected(String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public void unClickCheckbox(String locator) {
		// UnChecked
		if (isElementSelected(locator)) {
			// Checked
			clickElementByJavascript(locator);
		}

	}

	public boolean isRadioSelected(WebElement locator) {
		if (!locator.isSelected()) {
			locator.click();
		}
		return true;

	}
}
