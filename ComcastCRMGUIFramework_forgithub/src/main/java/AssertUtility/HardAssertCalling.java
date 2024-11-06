package AssertUtility;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HardAssertCalling {
	
	
	
	public void  hardAssertforboolean(String expvalue,String actvalue)
	{
		 boolean value=expvalue.contains(actvalue);
		Assert.assertTrue(value);
	}
	

}
