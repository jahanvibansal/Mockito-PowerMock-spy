package com.areyes1.jgc.mockito.e;

import java.io.File;

public class XxxUtil {

	public static boolean isSafe(int i) {
		if(i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private String name = "XxxUtil";
	public String getName() {
    	return name;
    }
	public void setName(String name) {
    	this.name = name;
    }
	
	/*
	 * 1. mock java core library
	 */
	public static void sleep(long time) throws Exception {
		Thread.sleep(time);
	}
	
	/*
	 * 2. mock java core library
	 *  - new instance
	 */
	public static void readFile(String filename) throws Exception {
		File file = new File(filename);
		System.out.println(file.getAbsolutePath());
	}
	
}