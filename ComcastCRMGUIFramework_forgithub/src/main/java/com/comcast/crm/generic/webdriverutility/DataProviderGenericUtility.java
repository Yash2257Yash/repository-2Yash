package com.comcast.crm.generic.webdriverutility;

import org.testng.annotations.DataProvider;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderGenericUtility {
	
	@DataProvider(name="Mobiledatafromamazon")
	public Object[][] getdatafromdataProvider() throws Throwable
	{
		ExcelUtility elib=new ExcelUtility();
		int rowcount=elib.getRowCount("Products");
		System.out.println(rowcount);
		Object[][] objArr=new Object[rowcount][2];
		for(int i=0;i<rowcount;i++)
		{
		
		objArr[i][0]=elib.getDataFromExcel("Products", i+1, 0);
		//System.out.println(objArr[i][0]);

		objArr[i][1]=elib.getDataFromExcel("Products", i+1, 1);
		//System.out.println(objArr[i][1]);

}
		return objArr;
		}
}
