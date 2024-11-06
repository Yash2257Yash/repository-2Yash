package Practice.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.Baseutility.BaseTestforRealProject;

@Listeners(com.comcast.crm.listenerUtility.TaskListenerImplementationclassOfTask.class)

public class InvoiceTest extends BaseTestforRealProject {

	// @Test(retryAnalyzer=com.comcast.crm.listenerUtility.RetryAnalyserImple.class)
	@Test
	public void CreateInvoiceTest() {
		System.out.println("hi");
		System.out.println("step1");
		System.out.println("step2");
		System.out.println("step3");

		System.out.println("step4");
		System.out.println("step5");

	}

}
