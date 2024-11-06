package AssertUtility;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SoftAssertCalling {
	
	SoftAssert soft=new SoftAssert();
	
	
	public  void softAssertusingboolean(String actvalue,String expvalue)
	{
		boolean value = actvalue.contains(expvalue);
		
		soft.assertTrue(value);
//		soft.assertAll();
	}
	public  void assertALL()
	{
		soft.assertAll();
		
	}

}
