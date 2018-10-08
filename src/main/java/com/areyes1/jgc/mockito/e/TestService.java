package com.areyes1.jgc.mockito.e;

// TODO: Auto-generated Javadoc
/**
 * The Class TestService.
 */
public class TestService {

	public int getUniqueId() {
		return 43;
	}
	
	public int testing(int num) {
		someMethod("");
		return num;
	}
	
	public void someMethod(String someMethod) {
		System.out.println(someMethod);
	}
	
	public int someMethod1(String someMethod) {
		return Integer.parseInt(someMethod);
	}
	public static String getProperty() {
		String s=Demo1.getProperty();
		return s;
	}
	
	public static String getPropertyDemo2() {
		String s=Demo2.getProperty();
		return s;
	}
}
