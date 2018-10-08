package com.areyes1.jgc.mockito.e;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.Matchers.containsString;
@RunWith(PowerMockRunner.class)
@PrepareForTest({FinalClass.class})
public class FinalClassTest {
    @Test
    public void getValue() throws Exception {
        FinalClass fc = new FinalClass("foobar");
        
        FinalClass fcMock = PowerMockito.mock(FinalClass.class);
        PowerMockito.when(fcMock.getValue()).thenReturn("foobarTwo");

        assertEquals(fc.getValue(),"foobar");
        assertThat(fcMock.getValue(),containsString("foobarTwo"));

        Mockito.verify(fcMock).getValue();
    }
}
