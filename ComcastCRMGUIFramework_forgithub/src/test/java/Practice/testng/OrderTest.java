package Practice.testng;

import org.testng.annotations.Test;

public class OrderTest {

	
	@Test
		public  void  CreateOrderTest()
		{
			System.out.println("CreateOrderTest");
		}
		@Test(dependsOnMethods = "CreateOrderTest")
		public  void  BillingOrderTest()
		{
			System.out.println("BillingOrderTest");
		}
		//For invocation count 
		@Test(invocationCount = 5)
		public  void  CreateOrderTest_______1()
		{
			System.out.println("CreateOrderTest_______1");
		}
		@Test(dependsOnMethods = "CreateOrderTest_______1")
		public  void  BillingOrderTest___________1()
		{
			System.out.println("BillingOrderTest___________1");
		}
		

}
