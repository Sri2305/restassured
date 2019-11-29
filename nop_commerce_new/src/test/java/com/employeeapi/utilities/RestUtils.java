package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class RestUtils {
	
	public static String empname() {
		String empname = RandomStringUtils.randomAlphabetic(2);
		return("john"+empname);
						
	}
	public static String empage() {
		String empage = RandomStringUtils.randomNumeric(2);
		return(empage);
						
	}

	public static String empsal() {
		String empsal = RandomStringUtils.randomNumeric(6);
		return(empsal);
						
	}


}
