package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilityforcliniq {
public String getDataFromPropertiesFile(String key) throws Throwable
{
	FileInputStream fis=new FileInputStream("./configAppData/Createorgcommondatafrocliniq.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data=pobj.getProperty(key);
	return data;
	



}
}
