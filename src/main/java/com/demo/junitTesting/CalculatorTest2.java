package com.demo.junitTesting;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest2 {

	private Calculator calculator=new Calculator();
	
	@Test
	public void test() {
		assertEquals(6, calculator.mul(2, 3));
	}

}
