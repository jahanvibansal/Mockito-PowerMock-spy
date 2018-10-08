package com.areyes1.jgc.mockito.e;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(XxxUtil.class) 
public class MockJavaCoreLibraryTest {

	//mocking the static method
	@Test
	public void mockJavaCoreLibrary() throws Exception {
		PowerMockito.mockStatic(Thread.class);
		XxxUtil.sleep(10000000);
		PowerMockito.verifyStatic(Thread.class,times(1));
		Thread.sleep(anyLong());
	}
	//Mocking the constructor
	@Test
	public void readFile$mockNewFile() throws Exception {
		File file = mock(File.class);
		PowerMockito.whenNew(File.class).withArguments(anyString()).thenReturn(file);
	//	PowerMockito.when(file.getAbsolutePath()).thenReturn("abc");
		XxxUtil.readFile(anyString());
		verify(file, times(1)).getAbsolutePath();
		
	}
}
//Powermock over mockito:
//static
//final class
//private
//constructor