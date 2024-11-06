package Practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	
	
	@Test
		public  void  CreateContactTest()
		{
			System.out.println("execute CreateContact of HDFC");
		}
		@Test(dependsOnMethods = "CreateContactTest")
		public  void  modifyContactTest()
		{
			System.out.println("modifyContactTest  HDFC into ICICI  ");
		}

		@Test(dependsOnMethods = "modifyContactTest")
		public  void  deleteContactTest()
		{
			System.out.println("deleteContactTest  ICICI   ");
		}
	

}
