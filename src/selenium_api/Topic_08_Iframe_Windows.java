package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Topic_08_Iframe_Windows {
	WebDriverWait wait;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Test
	public void TC_01_Iframe_Frame() {
		driver.get("http://www.hdfcbank.com/");

		/*--- Issuse 01- Handle check 1 element isDisplayed 
		 * Nếu sử dụng WebElment : Failed -> Throw Such element exception */

		// Step 02: Check close pop up displayed(exist click close icon)
		List<WebElement> notificationIfrmage = driver
				.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
		System.out.println("Number element = " + notificationIfrmage.size());

		if (notificationIfrmage.size() > 0) {
			driver.switchTo().frame(notificationIfrmage.get(0));
			WebElement closeIcon = driver.findElement(By.xpath("//div[@id='div-close']"));

			// Javascript click to element
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", closeIcon);
			System.out.println("Print close popup");

			/* Issuse 03: Switch between 2 iframe (Switch to default content)----- */
			// Switch to Top Window
			driver.switchTo().defaultContent();

		}
		/* Issuse 02: Handle dynamic iframe (id: random when page reload....) */
		// Step 03: Verify đoạn text được hiển thị: What are you looking for?
		WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		driver.switchTo().frame(lookingForIframe);

		// Check text displayed
		String lookingForText = driver.findElement(By.xpath("//span[@id='messageText']")).getText();
		Assert.assertEquals(lookingForText, "What are you looking for?");

		// Switch to default content
		driver.switchTo().defaultContent();

		// Step 04- Switch to banner iframe
		WebElement bannerIframe = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
		driver.switchTo().frame(bannerIframe);

		// Verify banner image
		By bannerImagesXpath = By.xpath("//div[@id='productcontainer']//img");
		List<WebElement> bannerImages = driver.findElements(bannerImagesXpath);
		int bannerImageNumber = bannerImages.size();

		// Check image =6
		Assert.assertEquals(bannerImageNumber, 6);
		

		// Check all image are presence
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(bannerImagesXpath));
		// Assert.assertTrue(image.isDisplayed());
		
		// Switch to default content
		driver.switchTo().defaultContent();
		
		// Step 05: Verify flipper banner được hiển thị và có 8 items
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='flipBanner']")).isDisplayed(), true);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='flipBanner']")).isDisplayed());
		
		List<WebElement>flipBannerImages = driver.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']"));
		int flipBannerImageNumber = flipBannerImages.size();
		Assert.assertEquals(flipBannerImageNumber,8);
		int i = 0;
		
		// For - Each 
		for(WebElement image: flipBannerImages) {
			Assert.assertTrue(image.isDisplayed());
			 i++;
			System.out.println("Image [" + i + "] Displayed!");
			
		}
		
		// For
		for(int x= 0; x < flipBannerImageNumber; x++) {
			Assert.assertTrue(flipBannerImages.get(x).isDisplayed());
			System.out.println("Image [" + x + "] Displayed!");
			
		}
			
		}
		


	public void TC_02() {

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
