package selenium_online_05_java_basic;

public class Java_07_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String automation = " Automation Test Online ";
		
		/*=============Length===============*/
		int length = automation.length();
		System.out.println("Do dai cua chuoi = " + length);
		
		
		String chuoi = "Automation Testing";
		char kytu = chuoi.charAt(5);
		System.out.println("Ky tu = "+ kytu);
		
		String testing = automation.concat("Tutorial");
		System.out.println("Noi chuoi = "+ testing);
		
		
		
		//Automation Test Online
		// Automation Testing Tutorial
		boolean compareValue = automation.equals(automation);
		System.out.println("So sanh chuoi = "+ compareValue);
		
		compareValue = automation.equals(automation);
		System.out.println("So sanh chuoi = "+ compareValue);
	}

}
