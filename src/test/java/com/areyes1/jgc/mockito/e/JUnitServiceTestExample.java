package com.areyes1.jgc.mockito.e;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * The Class JUnitServiceTestExample.
 */
@RunWith(MockitoJUnitRunner.class)
public class JUnitServiceTestExample {

/*@Mock  TestService test ;*/
	@Test
	public void testSimpleInt() {
		TestService test = Mockito.mock(TestService.class);
		when(test.getUniqueId()).thenReturn(43);
		int i=test.someMethod1("41");
		assertEquals(0, i);
		assertEquals(test.getUniqueId(), 43);
	}

	/**
	 * Test more than one return value.
	 */
	// Demonstrates the return of multiple values
	@Test
	public void testMoreThanOneReturnValue() {
		Iterator i = mock(Iterator.class);
		when(i.next()).thenReturn("Mockito").thenReturn("is neat!!");
		assertFalse(i.hasNext());
		String result = i.next() + " " + i.next();
		assertEquals("Mockito is neat!!", result);
		
	}

	/**
	 * Test return value dependent on method parameter.
	 */
	@Test
	public void testReturnValueDependentOnMethodParameter() {
		Comparable c = mock(Comparable.class);
		when(c.compareTo("Mockito")).thenReturn(1);
		when(c.compareTo("Eclipse")).thenReturn(2);
		// assert
		assertEquals(1, c.compareTo("Mockito"));
		assertEquals(2, c.compareTo("Eclipse"));
	}

	/**
	 * Test return value in dependent on method parameter.
	 */
	@Test
	public void testReturnValueInDependentOnMethodParameter() {
		Comparable c = mock(Comparable.class);
		when(c.compareTo(anyInt())).thenReturn(-1);
		assertEquals(-1, c.compareTo(9));
	}

	@Test
	public void testVerify() {
		// create and configure mock
		TestService test = Mockito.mock(TestService.class);
		when(test.getUniqueId()).thenReturn(43);

		// call method testing on the mock with parameter 12
		test.testing(12);
		test.getUniqueId();
		test.getUniqueId();
		test.someMethod("Hello World");
		test.someMethod("called at least once");
		test.someMethod("called at least twice");
		test.someMethod("called five times");
		test.someMethod("called at most 3 times");

		// now check if method testing was called with the parameter 12
		verify(test).testing(Matchers.eq(12));
		/*verify(test).testing(num)*/

		// was the method called twice?
		verify(test, atLeastOnce()).getUniqueId();

		// other alternatives for verifiying the number of method calls for a
		// method
		verify(test, never()).someMethod("never called");
		verify(test, atLeastOnce()).someMethod("called at least once");
		
		//	Will all fail because we didn't met the conditions.
		verify(test, atLeast(1)).someMethod("called at least twice");	 
		verify(test, times(1)).someMethod("called five times");
		verify(test, atMost(3)).someMethod("called at most 3 times");
	}
	
	@Test(expected= MockitoException.class)
	public void testFinalClass() {
		//Cannot mock final class
		Mockito.mock(FinalClass.class);
	}
}
