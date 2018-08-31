package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
		// Explicit wait
		wait = new WebDriverWait(driver, 10);
		// Implicit wait/ Global wait findElement/ findElements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

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

		List<WebElement> flipBannerImages = driver
				.findElements(By.xpath("//div[@class='flipBanner']//img[@class='front icon']"));
		int flipBannerImageNumber = flipBannerImages.size();
		Assert.assertEquals(flipBannerImageNumber, 8);
		int i = 0;

		// For - Each
		for (WebElement image : flipBannerImages) {
			Assert.assertTrue(image.isDisplayed());
			i++;
			System.out.println("Image [" + i + "] Displayed!");

		}

		// For
		for (int x = 0; x < flipBannerImageNumber; x++) {
			Assert.assertTrue(flipBannerImages.get(x).isDisplayed());
			System.out.println("Image [" + x + "] Displayed!");

		}

	}
	
	public void TC_02_Windows() {
		driver.get("http://daominhdam.890m.com/");

		/* CASE 01- 2 window / 2 tabs: switch via GUID */
		// Get GUID of current page (parent page)
		String parentGUID = driver.getWindowHandle();
		System.out.println("parentGUID= "+ parentGUID);
		System.out.println("Title before = " + driver.getTitle());

		// Click to new window
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		// Swith to New tab or new window
		//switchToChildwindowByGUID(parentGUID);
		switchToWindowByTitile("Google");
		
		
		// Verify witch sucess
		String googleTitle = driver.getTitle();
		System.out.println("Title after = "+ googleTitle);
		Assert.assertEquals(googleTitle, "Google");

		closeAllWithoutParentWindows(parentGUID);
		
		// Verify switch to parent success
		Assert.assertEquals(driver.getTitle(), "SELENIUM WEBDRIVER FORM DEMO");
		/* CASE O2- >= 2 window / 2tabs : witch via page title */

	}

	@Test
	public void TC_03_HdfcBankWindows() {
	driver.get("http://www.hdfcbank.com/");
	
	String parentGUID = driver.getWindowHandle();
	System.out.println("Parent ID = "+ parentGUID);
	
	// Kiểm tra và close quảng cáo nếu có xuất hiện
	overrideGlobalWait(15);
	List<WebElement> notificationIfrmage = driver
			.findElements(By.xpath("//iframe[@id='vizury-notification-template']"));
	System.out.println("Number element = " + notificationIfrmage.size());

	if (notificationIfrmage.size() > 0) {
		driver.switchTo().frame(notificationIfrmage.get(0));
		WebElement closeIcon = driver.findElement(By.xpath("//div[@id='div-close']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", closeIcon);
		driver.switchTo().defaultContent();

	}
	
	// Click Agri link and switch to Agri link window 
	driver.findElement(By.xpath("//a[text()='Agri']")).click();
	switchToWindowByTitile("HDFC Bank Kisan Dhan Vikas e-Kendra");
		
	
	// Click Account Details and switch to Account Details tab
	driver.findElement(By.xpath("//p[text()='Account Details']")).click();
	switchToWindowByTitile("Welcome to HDFC Bank NetBanking");
	
	// Switch to footer frame
	WebElement footerFrame = driver.findElement(By.xpath("//frame[@name='footer']"));
	driver.switchTo().frame(footerFrame);
	
	// Click Privacy Policy and switch to Privacy Policy tab
	driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
	switchToWindowByTitile("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
	
	// Click CSR link
	driver.findElement(By.xpath("//a[text()='CSR']")).click();
	
	closeAllWithoutParentWindows(parentGUID);
	Assert.assertEquals(driver.getTitle(), "HDFC Bank: Personal Banking Services");
	
	
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}


	public void switchToChildwindowByGUID(String parentID) {
		// Get all current windows/ tabs
		Set<String> allWindows = driver.getWindowHandles();

		// Duyệt qua tất cả các windows/ tabs
		for (String runWindow : allWindows) {
			
			// Nếu window/ tab ID nào mà khác vs parent ID thì switch qua
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}

		}

	}
	
	public void switchToWindowByTitile(String expectedTitle) {
		// Get all current windows/ tabs
		Set<String> allWindows = driver.getWindowHandles();
	
		// Lăp từng window/ tab
		for(String runWindows:allWindows) {
			System.out.println("WindowID= "+ runWindows);
			// Switch vào từng window trước
			driver.switchTo().window(runWindows);
			
			// Get ra title của window/ tab mà mình đã switch quá
			String actualTitle = driver.getTitle();
			
			// Kiểm tra nếu title mình đã get mà bằng vs expected title mà mình đã truyền vào
			if(actualTitle.equals(expectedTitle)) {
				// Thoart khỏi vòng lặp
				break;
			}
		}
	}
	
	public boolean closeAllWithoutParentWindows(String parentGUID) {
		// Get all current windows/ tabs
		Set<String> allWindows = driver.getWindowHandles();
		
		// Duyệt qua từng window/ tab
		for(String runWindows:allWindows) {
			System.out.println("WindowID= "+ runWindows);
			
			// Nếu windows/ tabs guid khác vs parent id
			if(!runWindows.equals(parentGUID)) {
				// Switch qua windows/ tab đó
				driver.switchTo().window(runWindows);
				
				// Close window/ tab đó
				driver.close();
			}
			
		}
		
		// Switch về parent windows
		driver.switchTo().window(parentGUID);
		
		// Kiểm tra xem có còn đúng 1 window hay ko
		if(driver.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	
	
	public void overrideGlobalWait(long timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
}
