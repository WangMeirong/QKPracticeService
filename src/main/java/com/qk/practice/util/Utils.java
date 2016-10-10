package com.qk.practice.util;

import java.util.List;

public class Utils {
	
	public static boolean isEmpty(List list) {
		return (null == list || list.isEmpty());
	}
	
	public static boolean isEmpty(String s) {
		return (null == s || s.length() == 0);
	}

}
