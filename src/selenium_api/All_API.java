package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class All_API {

	WebDriver driver;

	@Test
	public void TC_01() {
		// WEB BROWSER(refresh/navigate/maximize/back/forward/...)
		// Mở 1 page url lên(*)
		driver.get("http://");

		// Trả về url của page hiện tại(*)
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://");

		// Trả về source code của page hiện tại
		String source_Page = driver.getPageSource();
		Assert.assertTrue(source_Page.contains("Insurance Project"));

		// Trả về title của Page hiện tại(*)
		String title = driver.getTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");

		// Trả về page id(GUID) của page hiện tại-> Windows(*)
		String parent_ID = driver.getWindowHandle();

		// Trả về page id của tất cả các page-> Windows(*)
		driver.getWindowHandles();

		// Đóng browser-> chỉ đóng tab hiện tại(1 tab = đóng browser)
		driver.close();

		// Đóng browser-> nhiều tab = đóng browser(*)
		driver.quit();

		// Tương tác vs duy nhất 1 element
		// Nếu ko tìm thấy element-> Failed-> Ném ra ngoại lệ No Such element
		WebElement emailTextbox = driver.findElement(By.id("email"));
		emailTextbox.click();

		// Tương tác vs 1 list emlements(*)
		// Nếu ko tìm thấy element-> Failed-> Trả về 1 list element empty
		List<WebElement> elements = driver.findElements(By.id("email"));
		elements.get(0).click();

		// Wait cho page hiện tại được render thành công(DOM:html/css/java)(*)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Auto GUI(Graphic User Interface)-> Check Responsive
		// Auto Functional UI

		// F11: Full Screen browser
		driver.manage().window().fullscreen();

		// 0-0: Điểm trên cùng bên trái
		// 1920* 1080->1K
		// Check vị trí của browser nằm trong độ phân giải của OS là bao nhiêu
		driver.manage().window().getPosition();

		// Chiều rộng và chiều cao của browser
		driver.manage().window().getSize();

		// Open browser-> Full browser lên(ko phải full creen)(*)
		driver.manage().window().maximize();

		// Muốn back lại page cũ
		driver.navigate().back();

		// Back->Tới page cũ
		driver.navigate().forward();

		// F5 lại page/reload page
		driver.navigate().refresh();

		// Luôn chờ page render/ load thành công trong khoảng timeout của selenium
		driver.get("http://");

		// Ko chờ load thành công trong khoảng timeout của selenium
		driver.navigate().to("http://");

		// Alert(*)
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("");
		String abc = alert.getText();

		// Frame/iframe(*)
		driver.switchTo().frame("");
		driver.switchTo().defaultContent();

		// WEB ELEMENT(textbox/text area/dropdown/...)
		// 01: Mỗi phần find element thì chỉ tương tác/action được 1 lần (*)
		driver.findElement(By.xpath("//input[@id='email']")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");

		// 02: Khai báo 1 biến emlent-> có thể action nhiều lần (*)
		WebElement email_Textbox = driver.findElement(By.xpath("//input[@id='email']"));

		// Trả về empty data cho các element (textbox/text area/ dropdown)(*)
		email_Textbox.clear();

		// Nhập text/value vào các element(textbox/text area/dropdown)(*)
		email_Textbox.sendKeys("");

		// Trả lại giá trị nằm trong attribute của element(*)
		// <input id="password" type="password" name="user_pass" placeholder="Textbox is
		// disabled" disabled="disabled"/>
		WebElement passwordTextbox = driver.findElement(By.xpath("//input[@id='password']"));
		String passwordTexbox = passwordTextbox.getAttribute("placeholder");
		Assert.assertEquals(passwordTexbox, "Textbox is disabled");

		// Auto GUI(Graphic User Interface)
		String backgroundColor = emailTextbox.getCssValue("background-color");
		// #5fcf80
		String color = email_Textbox.getCssValue("color");

		// Trả về vị trí của element trong màn hình
		Point locator = email_Textbox.getLocation();

		// Trả về kích thước của element (Rộng + cao)
		Dimension size = email_Textbox.getSize();

		// Trả lại text của element đó (*)
		// .//*[@id='advice-required-entry-email']
		String textElement = email_Textbox.getText();
		// This is a required field.

		// Kiểm tra xem 1 element có hiển thị hay ko-> all elements (*)
		Assert.assertTrue(email_Textbox.isDisplayed());

		// Kiểm tra xem 1 element có hiển thị hay ko-> element có khả năng enabled/
		// disable (textbox/ text area/ drowndown/ radio/ checkbox)
		Assert.assertTrue(!email_Textbox.isEnabled());
		Assert.assertFalse(email_Textbox.isEnabled());

		// Kiểm tra xem 1 element đã được chọn hay ko-> radio/ checkbox (Dropdown có
		// riêng 1 API) (*)
		Assert.assertTrue(email_Textbox.isSelected());

		// Click vào element (button/ radio/ checkbox/ link/ dropdown/ image...) (*)
		email_Textbox.click();

		// Gửi sự kiên ENTER cho element mà nó cần thao tác
		// Form: Login/ Register / Search
		email_Textbox.submit();
	}

}
