package selenium_demo;

public class StringFormat {
	public static void main(String[] args) {
		
		String DynamicName = "//a[text()='%s']";

		ClickToEmelent(DynamicName, "New Customer");
		ClickToEmelent(DynamicName, "Edit Customer");
		ClickToEmelent(DynamicName, "Home Page");

	}

	public static void ClickToEmelent(String locator, String value) {
		locator = String.format(locator, value);
		System.out.println(locator);

	}

}
