package Practice.testng;

import java.util.Date;

import org.testng.annotations.Test;

public class TimeStamp {
	@Test
	public void Time()
	{
		String Time=new Date().toString().replace(" ","_").replace(":", "_");
		System.out.println(Time);
	}

}
