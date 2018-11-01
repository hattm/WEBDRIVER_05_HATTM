package selenium_demo;

public class Tip_01_StringFormatResParameter {
	public static void main(String[]args) {
		String locator_00 = "//a[text()='New Customer']";
		String locator_01 = "//a[text()='%s']";
		String locator_02 = "//a[text()='%s']//button[text()='%s']";
		String locator_03 = "//a[text()='%s']//button[text()='%s']//a[text()='%s']";
		String locator_04 = "//a[text()='%s']//button[text()='%s']//a[text()='%s']//button[text()='%s']";
		
		clickToElement(locator_00);
		clickToElement(locator_01, "New Customer");
		clickToElement(locator_02, "New Customer", "Save");
		clickToElement(locator_03, "New Customer","Save", "Cancle");
		clickToElement(locator_04, "New Customer", "Save", "Cancle", "Delete");
		
	}

	private static void clickToElement(String locator) {
		System.out.println(locator);
	}
	// Rest Parameter (Trick Java Language)
	private static void clickToElement(String locator, String...value) {
		locator = String.format(locator, (Object[]) value);
		System.out.println(locator);
	}

}
