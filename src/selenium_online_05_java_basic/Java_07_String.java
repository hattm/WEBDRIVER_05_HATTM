package selenium_online_05_java_basic;

public class Java_07_String {

	public static void main(String[] args) {
		
		String testing = "Automation Testing Online Advance 05";
		String automation = "Automation Testing Online ";
		
		//=============Length===============
		int length = automation.length();
		System.out.println("Do dai cua chuoi = " + length);
		
		
		String chuoi = "Automation Testing";
		char kytu = chuoi.charAt(5);
		System.out.println("Ky tu = "+ kytu);
		
		String test= automation.concat("Tutorial");
		System.out.println("Noi chuoi = "+ test);
		
		
		
		// Automation Test Online
		// Automation Testing Tutorial
		// so sanh chuổi tuyệt đối
		boolean compareValue = testing.equals(automation);
		System.out.println("So sanh chuoi tuyệt đối = " + compareValue);
		
		compareValue = automation.equals(automation);
		System.out.println("So sanh chuoi tuyệt đối = " + compareValue);
		
		// so sánh chuổi tuyệt đối
		compareValue = testing.contains("Test Online");
		System.out.println("So sanh chuoi tương đối = " + compareValue);
		
		
		// testing = Automation Testing Online
		int index_01 = testing.indexOf("Online");
		/*int index_02 = testing.indexOf("Advance");
		System.out.println("Vị trí chuôi = "+ index_01);
		System.out.println("Vị trí chuôi = "+ index_02);*/
		
		
		String subStringStart = testing.substring(index_01);
		System.out.println("Chuoi con = "+ subStringStart);
		
		String suStringToEnd = testing.substring(11,18);
		System.out.println("Chuoi con = "+ suStringToEnd);
		
		suStringToEnd = testing.substring(19,25);
		System.out.println("Chuoi con = "+ suStringToEnd);
		
		
		// Viewing 36 of 12591 results ham tach chuoi
		String text = " Viewing 36 of 12591 results ";
		text = text.trim();
		String[] subString = text.split(" ");
		for(int i = 0; i< subString.length; i++) {
			System.out.println("Vi tri thu " + i + " : " + subString[i]);
		}
		System.out.println(extractNumberFromString(text,1));
		System.out.println(extractNumberFromString(text,3));
		
		String price = "$500.00";
		String url = "http://live.guru99.com/index.php/mobile.html";
		price = price.replace("$", "");
		price = price.replace(".00", "");
		url = url.replace("http:", "");
		url = url.replace("https:", "");
		url = url.replace("//", "");
		url = url.replace("$", "");
		url = url.replace("!", "");
		url = url.replace("/", "");
		System.out.println(price);
		System.out.println(url);
		
		
		String upper = testing.toUpperCase();
		System.out.println("In hoa = " + upper);
		
		String lower = testing.toLowerCase();
		System.out.println("In thuong = " + lower);
		
		 String trimString  = " "
				
				+ "    "
				+ "    "
				+ "    Viewing 36 of 12591 results ham tach chuoi     "
				+ "     "
				+ "     ";
		System.out.println(trimString);
		trimString = trimString.trim();
		System.out.println(trimString);
		
		String giaTien = "$500.00";
		giaTien = giaTien.replace("$", "");
		giaTien = giaTien.replace(".00", "");
		int tien = Integer.parseInt(giaTien);
		System.out.println("String = " + giaTien);
		System.out.println("Integer = " + tien);
		
		double tienDouble = Double.parseDouble(giaTien);
		System.out.println("Double = " + tienDouble);
		
		
		float tienFloat  = Float.parseFloat(giaTien);
		System.out.println("Float = " + tienFloat);

		
	}
	
	public static int extractNumberFromString(String text, int number) {
		String[] subString = text.split(" ");
		int result = Integer.parseInt(subString[number]);
		return result;
	}
		

}
