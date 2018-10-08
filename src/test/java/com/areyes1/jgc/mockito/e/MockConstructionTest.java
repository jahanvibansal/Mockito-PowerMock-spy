package com.areyes1.jgc.mockito.e;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxService.class) 
public class MockConstructionTest {

	@Test
	public void mockConstruction() throws Exception {
		XxxService service = new XxxService();
		XxxUtil util = new XxxUtil();
		String name = "hello";
		util.setName(name);
		PowerMockito.whenNew(XxxUtil.class).withNoArguments().thenReturn(util);
		XxxUtil res = service.getUtil();
		assertEquals(name, res.getName());
	
}
}
