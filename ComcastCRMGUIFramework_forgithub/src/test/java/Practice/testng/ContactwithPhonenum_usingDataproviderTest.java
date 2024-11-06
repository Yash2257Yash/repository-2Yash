package Practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactwithPhonenum_usingDataproviderTest 
{
	
	@Test(dataProvider = "getData1")
		public  void  CreateContactTest(String Firstname,String LastName,long phno)
		{
			System.out.println(" Firstname: "+Firstname +"  LastName: "+LastName+" phno: "+phno);
		}
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] objArr=new Object[3][3];
		objArr[0][0]="Deepak";
		objArr[0][1]="HR";
		objArr[0][2]=9731008015l;
		
		objArr[1][0]="Sam";
		objArr[1][1]="HD";
		objArr[1][2]=7019541313l;
		
		objArr[2][0]="Jhon";
		objArr[2][1]="stev";
		objArr[2][2]=8095462585l;
		
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
