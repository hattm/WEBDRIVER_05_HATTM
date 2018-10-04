package selenium_online_05_java_basic;

public class Java_03_Operator {

	public static void main(String[] args) {
		int time = 10;
		boolean value = false;
		String name = "Dao Minh Dam";
		System.out.println("Time = " + time);
		System.out.println("Name = " + name);
		System.out.println("Value = " + value);
		
		int a, b = 10, c = 5;
		a = b + c;
		System.out.println("Cong = "+ a);
		
		a = b - c;
		System.out.println("Tru = " + a);
		
		a = b * c;
		System.out.println("Nhan = " + a);
		
		a = b / c;
		System.out.println("Chia lay nguye = " + a);
		// 2
		a = b % c;
		System.out.println("Chia lay du" + a);
		//0
		
		b++;
		System.out.println("Tang len 1 = " + b);
		//11
		c--;
		System.out.println("Giam xuong 1 = " + c);
		//4
		
		int ten = 10;
		int twenty = 20;
		int thirty = 30;
		
		System.out.println("Lon hon = "+ (ten > twenty));
		System.out.println("Lon hon or bang = " + (thirty >= twenty));;
		System.out.println("Nho hon = "+ (thirty <= twenty));
		System.out.println("Nho hon or bang = " + (thirty <= twenty));
		System.out.println("Bang bang = " + (thirty == twenty + ten));
		System.out.println("Khan bang = " + (thirty != twenty + ten));
		
		boolean value_01 = true;
		boolean value_02 = false;
		System.out.println("Ca hai deu dung = " + (value_01&& value_02));
		System.out.println("Mot trong 2 dung = " + (value_01 || value_02));
		System.out.println("Phu ding = "+ (!value_01));
		
		
		int first = 10;
		int second = 20;
		int third = 30;
		boolean  bValue;
		int iValue;
		
		bValue = (third == first + second) ? true: false;
		System.out.println("Gia tri = " + bValue);
		
		iValue = (third == second + first) ? 50: 100;
		System.out.println("Ket qua = " + iValue);
		
		iValue = (!(third == second + first)) ? 50:100;
		System.out.println("Phu dinh cua ket qua = " + iValue);
	}

}
