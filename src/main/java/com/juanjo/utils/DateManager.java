package com.juanjo.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateManager {
	
	public static String getCurrentDateTime(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		return LocalDateTime.now().format(formatter);
	}
	
}
