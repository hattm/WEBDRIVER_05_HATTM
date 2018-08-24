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

public class Topic_09_JavascriptExecutor {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}


	public void TC_01_JavascriptExecutor() {
		
		OpenAnyUrlByJS("http://live.guru99.com/");
		
		String homePageDomain =  (String) executeJSForeWebBrowser("return document.domain;");
		Assert.assertEquals(homePageDomain, "live.guru99.com");
		
		String homePageUrl =  (String) executeJSForeWebBrowser("return document.URL;");
		Assert.assertEquals(homePageUrl, "http://live.guru99.com/");
		
		
		WebElement mobileLink = driver.findElement(By.xpath("//a[text()='Mobile']"));
		highlightElement(mobileLink);
		clickToElementByJS(mobileLink);
		
		WebElement samsungProduct = driver.findElement(By.xpath("//h2[a[@title='Samsung Galaxy']]/following-sibling::div[@class='actions']//button"));
		highlightElement(samsungProduct);
		clickToElementByJS(samsungProduct);
		
		String samsungAddedMsg= (String) executeJSForeWebBrowser("return document.documentElement.innerText;");
		Assert.assertTrue(samsungAddedMsg.contains("Samsung Galaxy was added to your shopping cart."));
		
		WebElement privacyLink= driver.findElement(By.xpath("//a[text()='Privacy Policy']"));
		highlightElement(privacyLink);
		clickToElementByJS(privacyLink);
		
		String privacyPageTitile =  (String) executeJSForeWebBrowser("return document.title;");
		Assert.assertEquals(privacyPageTitile, "Privacy Policy");
		
		scrollToBottonPage();
		
		WebElement wishlistTableContent = driver.findElement(By.xpath("//th[text()='WISHLIST_CNT']/following-sibling::td[text()='The number of items in your Wishlist.']"));
		highlightElement(wishlistTableContent);
		Assert.assertTrue(wishlistTableContent.isDisplayed());
		
		
		OpenAnyUrlByJS("http://demo.guru99.com/v4/");
		String homeDemoPageDomain =  (String) executeJSForeWebBrowser("return document.domain;");
		Assert.assertEquals(homeDemoPageDomain, "demo.guru99.com");
		
	}

	@Test
	public void TC_02_RemoveAttributeInDOM() {
		driver.get(" https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		String firstName = "Automation", lastName = "Testing";
		
		WebElement resultIframe = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(resultIframe);
		
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys(firstName);
		
		
		WebElement lastnameTextbox= driver.findElement(By.xpath("//input[@name='lname']"));
		removeAnyAttributeInDOM(lastnameTextbox, "disabled");
		lastnameTextbox.sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		
		String messsageSucess = driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']")).getText();
		Assert.assertTrue(messsageSucess.contains(firstName)&& messsageSucess.contains(lastName));
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public Object OpenAnyUrlByJS(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.location= ' " + url+ "'");
	}

	public void highlightElement( WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='6px groove red'", element);
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	public Object executeJSForeWebBrowser(String javasript) {
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javasript);
	}
	
	public Object clickToElementByJS( WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].click();", element);
	}
	
	public void  removeAnyAttributeInDOM(WebElement element, String attributeName) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('" + attributeName + "');", element);
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object scrollToBottonPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
	}

}
