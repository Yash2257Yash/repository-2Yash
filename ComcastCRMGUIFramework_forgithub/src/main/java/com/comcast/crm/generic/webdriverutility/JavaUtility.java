package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	SimpleDateFormat sdf;

	// dont write main method in utility
	// for random number
	public int getRandomNumber() {
		Random random = new Random();

		int randomnum = random.nextInt(10000);
		return randomnum;
	}

	// for system date
	public String getSystemDateYYYYDDMM() {
		Date dateobj = new Date();
		sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateobj);
		return date;
	}

	public String getRequiredDateYYYYDDMM(int days) {
				Calendar cal = sdf.getCalendar();
//System.out.println(cal.getTime());
		cal.add(Calendar.DAY_OF_MONTH, days);
		//System.out.println(cal.getTime());

		String reqDate = sdf.format(cal.getTime());
		//System.out.println(cal.getTime());
		//System.out.println(reqDate);

		
		return reqDate;

	}

}
