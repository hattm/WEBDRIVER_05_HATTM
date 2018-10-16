package selenium_online_05_java_basic;

public class Java_Exercise {
	public static void main(String[] args) {
		String testing2 = "Automation Testing Tutorials Online";
		String testing = "Automation 01 Testing 345 Tutorials Online 1234565";

		char kyTu = 'a';
		int count = 0;
		testing = testing.replace("A", "a");
		// duyệt từ đầu đến cuối chuỗi
		for (int i = 0; i < testing.length(); i++) {
			// Nếu ký tự tại vị trí thứ i bằng 'a' thì tăng count lên 1
			if (testing.charAt(i) == kyTu) {
				count++;
				
			}
		}

		System.out.println ("ký tự a  = " + count);

		boolean compareValue = testing.contains("Testing");
		System.out.println("So sanh chuoi tương đối = " + compareValue);

		boolean StringStart = testing.startsWith("Automation");
		System.out.println("Chuoi bat dau bang Automation = " + StringStart);

		boolean StringEnd = testing.endsWith("Online");
		System.out.println("Chuoi ket thuc bang Online = " + StringEnd);

		// Truyền vào chuỗi con và chỉ số bắt đầu
		int index3 = testing2.indexOf("Tutorials");
		System.out.println("Vi tri tu Tutorials = " + index3);

		String replaceString = testing.replace("Online", "Ofline");// thay thế tất cả chuỗi "is" to "was"
		System.out.println(replaceString);

		int digitCount = 0;
		for (int i = 0; i < testing.length(); i++) {
			if (Character.isDigit(testing.charAt(i)))
				digitCount++;
		}

		System.out.println("So chu so: " + digitCount);

	}

}
