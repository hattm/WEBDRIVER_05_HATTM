package selenium_online_05_java_basic;

public class Java_04_ConditionStatement {

	public static void main(String[] args) {
		/* ========================If=================== */
		boolean value = true;
		if (value = true) {
			System.out.println("Value = " + value);
		}
		System.out.println("====================");
		int diem = 10;
		if (diem == 10) {
			System.out.println("Hoc sinh xuat sac");
		}
		System.out.println("====================");

		/* ===========If Else If====================== */
		String browser = "ie";
		if (browser == "chrome") {
			System.out.println("Khoi tao trinh duyet Chrome");
		} else if (browser == "firefox") {
			System.out.println("Kho tao trinh duyet Firefox");

		} else {
			System.out.println("Khoi tao trinh duyet IE");
		}
		System.out.println("======================");

		/* ===========Switch case====================== */

		String browser_ = "safari";
		switch (browser_) {
		case "chrome":
			System.out.println("Khoi tao trinh duyet Chrome");
			break;
		case "firefox":
			System.out.println("khoi tao trinh duyet firefox");
			break;
		case "ie":
			System.out.println("Khoi tao trinh duyet IE");
			break;
		default:
			System.out.println("Khoi tao trinh duyet Safari");
			break;
		}
		System.out.println("===============");

		String page = "Home Page";
		switch (page) {
		case "New Customer":
			System.out.println("Open New Customer page");
			break;
		case "Edit Customer":
			System.out.println("Open Delete Customer page");
			break;
		case "Delete Customer":
			System.out.println("Open Delete Customer page");
		default:
			System.out.println("Open HOme Page");
			break;
		}
		
		
		
	}

}
