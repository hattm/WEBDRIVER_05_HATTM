package selenium_online_05_testng;

import org.testng.annotations.Test;

public class TestNG_02_GroupTestCases {
	
  @Test(groups= "customer" )
  public void TC_01_NewCustomer() {
	  System.out.println("Testcase 01");
  }
  
  @Test(groups= "payment")
  public void TC_02_EditCustomer() {
	  System.out.println("Testcase 02");
	  
  }
  
  @Test(groups= "manager",enabled = false)
  public void TC_03_DeleteCustomer() {
	  System.out.println("Testcase 03");
  }
  
  @Test(groups= "payment")
  public void TC_04_ManageCustomer() {
	  System.out.println("Testcase 04");
  }
  
  @Test(groups= "customer")
  public void TC_05_TransferCustomer() {
	  System.out.println("Testcase 05");
  }
  
}
