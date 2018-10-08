package com.areyes1.jgc.mockito.e;

import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxService.class)  
public class MockPartialMethodTest {
	
	private XxxService service = new XxxService();
	
	@Test 
	public void mockPartialPrivateMethod() throws Exception {
		service = PowerMockito.spy(service);
		PowerMockito.when(service, "isNeedHandle", anyInt()).thenReturn(false); // mock private method
		
		//action
		boolean res = service.handle(2);
		
		//assert
		Mockito.verify(service).handle(anyInt());
		assertFalse(res); 
		PowerMockito.verifyPrivate(service, times(1)).invoke("isNeedHandle", anyInt());
	}

	@Test
	public void test1() {
	
		List list = new LinkedList();
		List spy = PowerMockito.spy(list);
		//Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
	//	PowerMockito.when(spy.get(0)).thenReturn("foo");
		
		//You have to use doReturn() for stubbing
		PowerMockito.doReturn("foo").when(spy).get(0);
		
	}
}