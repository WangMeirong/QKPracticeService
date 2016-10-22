package com.qk.practice.util;

import java.util.Date;

public class DateUtil {
	
	/**
	 * Get current mill seconds.
	 * @return
	 */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
    
    /**
     * Convert to Date from mill seconds.
     * @param millSeconds
     * @return
     */
    public static Date convertDate(long millSeconds) {
    	return new Date(millSeconds);
    }
    
    
    
    public static void main(String[] args) {
		System.out.print(convertDate(1476284429000l));
	}
}
