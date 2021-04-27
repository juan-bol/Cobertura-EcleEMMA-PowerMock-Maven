package com.juan.model;

public class ClassWithFinalMethods {
	public final String printMessage(String message) {
        return ClassWithStaticMethod2.printMessage(message);
    }
}
