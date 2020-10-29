package com.juanjo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtilities {

	public static String getStrCurrentDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return now.format(formatter);
	}
}
