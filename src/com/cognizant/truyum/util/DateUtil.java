package com.cognizant.truyum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static Date convertToDate(String dateOfLaunch) throws ParseException {
		Date d = sdf.parse(dateOfLaunch);
		return d;

	}

	public static String converToString(Date date) {
		return sdf.format(date);

	}

}
