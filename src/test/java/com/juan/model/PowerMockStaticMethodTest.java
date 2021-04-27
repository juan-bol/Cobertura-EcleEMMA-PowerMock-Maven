package com.juan.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.agent.PowerMockAgent;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

@PowerMockIgnore({"org.apache.log4j.*"})
//@RunWith(PowerMockRunner.class)
@PrepareForTest({ClassWithStaticMethod2.class, ClassWithStaticMethod.class})
public class PowerMockStaticMethodTest
{	
	@Rule
	public PowerMockRule rule = new PowerMockRule();
	
	static {
	     PowerMockAgent.initializeIfNeeded();
	}
	
	 @Test
    public void testClassWithStaticMethod_printMessage_staticMethod() {
 
        String expectation = "Expectation"; //2
 
        PowerMockito.mockStatic(ClassWithStaticMethod.class); //3
        PowerMockito.when(ClassWithStaticMethod.printMessage(Mockito.anyString())).thenReturn(expectation); //4
         
        String actual = ClassWithStaticMethod.printMessage("asdasda"); //5
        Assert.assertEquals(expectation, actual); //6
    }
	
    @Test
    public void testClassWithStaticMethod_printMessage_staticMethod2() {
 
        String expectation = "Expectation"; //2
 
        PowerMockito.mockStatic(ClassWithStaticMethod2.class); //3
        PowerMockito.when(ClassWithStaticMethod2.printMessage(Mockito.anyString())).thenReturn(expectation); //4
        
        ClassWithFinalMethods clase = new ClassWithFinalMethods();
        String valor = clase.printMessage("asfasfa");
 
        Assert.assertEquals(expectation, valor); //6
    }
    
}