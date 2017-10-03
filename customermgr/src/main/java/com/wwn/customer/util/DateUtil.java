package com.wwn.customer.util;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateUtil {

	public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String dateToString(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(PATTERN);
		return sdf.format(date);
	}
}
