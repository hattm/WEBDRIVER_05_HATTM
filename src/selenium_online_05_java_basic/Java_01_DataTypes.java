package selenium_online_05_java_basic;

public class Java_01_DataTypes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Step 01- Declaring variable (Khai bao bien)
				// Step 02- Naming variables (Dat ten)
				// Step 03- Initialzation of variables (Gan gia tri cho bien)

				/* ========Boolean========= */
				boolean testResult;
				testResult = true;
				System.out.println("Ket qua dung = " + testResult);
				testResult = false;
				System.out.println("ket qua sai= " + testResult);
				System.out.println("=====================");

				/* ========Int========= */
				int cart;
				cart = 2;
				System.out.println("so luong gio hang = " + cart);
				cart = cart + 10;
				System.out.println("so luong gio hang = " + cart);
				System.out.println("===================");
				
				/* ========Double========= */
				double ketqua;
				ketqua = 8.60;
				System.out.println("ket qua = " + ketqua);
				System.out.println("====================");
				
				/* ========String========= */
				String name, address, city;
				name = "Tran Thi Mong Ha";
				address = "123 Address";
				city = "Ho Chi Minh";
				System.out.println(name);
				System.out.println(address);
				System.out.println(city);
	}

}
