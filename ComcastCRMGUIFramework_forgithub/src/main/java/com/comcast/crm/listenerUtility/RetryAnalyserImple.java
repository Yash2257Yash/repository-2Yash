package com.comcast.crm.listenerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImple implements IRetryAnalyzer {
int count=0;
int limitcount=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<limitcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
