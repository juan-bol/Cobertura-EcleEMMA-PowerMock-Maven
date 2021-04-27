package com.juan.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
 
@RunWith(PowerMockRunner.class)
@PrepareForTest(ClassWithFinalMethods.class)
public class PowerMockFinalMethodTest
{
    @Test
    public void testClassWithFinalMethods_printMessage_finalMethod() throws Exception {
 
        String message = "Hello PowerMockito"; //1
 
        ClassWithFinalMethods mockObject = PowerMockito.mock(ClassWithFinalMethods.class); //2
        PowerMockito.whenNew(ClassWithFinalMethods.class).withNoArguments().thenReturn(mockObject); //3
 
        ClassWithFinalMethods object = new ClassWithFinalMethods(); //4
        PowerMockito.verifyNew(ClassWithFinalMethods.class).withNoArguments(); //5
 
        PowerMockito.when(object.printMessage(message)).thenReturn(message); //6
        String helloPowerMockito = object.printMessage(message); //7
        Mockito.verify(object).printMessage(message); //8
        Assert.assertEquals(message, helloPowerMockito); //9
    }
}