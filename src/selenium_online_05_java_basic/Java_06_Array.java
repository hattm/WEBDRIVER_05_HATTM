package selenium_online_05_java_basic;

public class Java_06_Array {

	public static void main(String[] args) {
		String[] testingPart = new String[4];
		testingPart[0] = "Automation Testing";
		testingPart[1] = "Manual Testing";
		testingPart[2] = "Perfomance Testing";
		testingPart[3] = "Security Testing";
		
		String[] testing = {"Automation Testing",
							"Manual Testing",
							"Perfomance Testing",
							"Security Testing"};
		
		
		/*========== II - Acess value in Array=========*/
		int iLength = testing.length;
		System.out.println("Do dai cua Array = " + iLength);
		
		String auto = testing[0];
		System.out.println("Gia tri dau tien = " + auto);
		
		String security = testing[iLength - 1];
		System.out.println("Gia tri cuoi cung = " + security);
		System.out.println("-------------------------------");
		
		for(int i = 0; i <= iLength -1; i++) {
			System.out.println("Phan tu thu [" + i + "] trong Array = " + testing[i] );
		}
		System.out.println("--------------------------------");
		
		// For - each
		for(String test : testing) {
			System.out.println("Gia tri = " + test);
		}
		System.out.println("------------------------------");
		
		
		/*============ III - Parse Array to a Method ==============*/
		parse_Array_To_Method(testingPart);
		System.out.println("------------------------");
		
		parse_Array_To_Method(testingPart);
		System.out.println("-------------------------");
		
		/*========== IV- Return Array from a Method============*/
		String[] newArray = return_Array_To_Method();
		for(String array : newArray) {
			System.out.println("In tat ca gia tri trong mang = " + array);
		}
		
	}
	public static void parse_Array_To_Method(String[] array) {
		for(int i = 0; i <= array.length - 1; i++) {
			System.out.println("In tat ca gia tri trong mang = " + array[i]);
		}
	}
	
	public static String[] return_Array_To_Method() {
		String[] aArray = {"Developer", "Tester", "Business Analysist","Product Owner"};
		return aArray;
	}
}
