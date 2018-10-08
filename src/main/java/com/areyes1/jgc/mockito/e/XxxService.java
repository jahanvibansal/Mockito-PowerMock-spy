package com.areyes1.jgc.mockito.e;

public class XxxService {
	
	private static int threshold = 1000000;
	public int sum() {
		int i=0;
		while(i < threshold) {
			i=i+1;
		}
		return i;
	}
	
	private boolean isPositiveNumber(int i) {
		if(i > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void foreach(int count) {
		for(int i=0; i<count; i++) {
			isPositiveNumber(i);
		}
	}
	
	public boolean isAllowBuy(int i) {
		if(XxxUtil.isSafe(i)) {
			// ....
		}
		return false;
	}
	
	/*
	 * 4.mock partial method
	 */
	public boolean handle(int i) {
		if(isNeedHandle(i)) {
			// ... logic handle
			return true;
		}
		return false;
	}
	private boolean isNeedHandle(int i) {
		return true;
	}
	
	
	/*
	 * 5.mock construction
	 */
	public XxxUtil getUtil() {
		XxxUtil util = new XxxUtil();
		return util;
	}

}