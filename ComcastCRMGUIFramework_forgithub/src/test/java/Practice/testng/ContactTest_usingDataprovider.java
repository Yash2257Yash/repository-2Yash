package Practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactTest_usingDataprovider 
{
	
	@Test(dataProvider = "getData")
		public  void  CreateContactTest(String Firstname,String LastName)
		{
			System.out.println(" Firstname:+ "+Firstname +"  LastName: "+LastName);
		}
	@DataProvider
	public Object[][] getData()
	{
		Object[][]objArr=new Object[3][2];
		objArr[0][0]="Deepak";
		objArr[0][1]="HR";
		objArr[1][0]="Sam";
		objArr[1][1]="HD";
		objArr[2][0]="Jhon";
		objArr[2][1]="stev";

		return objArr;
	}
	
	
	
	
	
//		@Test(dependsOnMethods = "CreateContactTest")
//		public  void  modifyContactTest()
//		{
//			System.out.println("modifyContactTest  HDFC into ICICI  ");
//		}
//
//		@Test(dependsOnMethods = "modifyContactTest")
//		public  void  deleteContactTest()
//		{
//			System.out.println("deleteContactTest  ICICI   ");
//		}
//	

}
