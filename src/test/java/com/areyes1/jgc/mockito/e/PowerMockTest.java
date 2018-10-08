package com.areyes1.jgc.mockito.e;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Demo1.class)
public class PowerMockTest {
	
	@Test
	public void testStaticMethod() {
	PowerMockito.mockStatic(Demo1.class);
		when(Demo1.getProperty()).thenReturn("a");
		assertEquals("a", TestService.getProperty());
	}

	@Test
	public void testStaticMethod2() {
	PowerMockito.mockStatic(Demo1.class);
		when(Demo1.getProperty()).thenReturn("a");
		assertEquals("a", TestService.getPropertyDemo2());
	}
}
