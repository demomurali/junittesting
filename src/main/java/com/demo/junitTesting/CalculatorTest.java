package com.demo.junitTesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest  {

	private Calculator calculator;
	
	public CalculatorTest(){
		calculator=new Calculator();
	}
	
	@BeforeClass
	public static void initClass(){
	System.out.println("inside the before class");
	}
	
	@Before
	public void initMethod(){
		System.out.println("inside the before");
		calculator.setSomeValue(4);
	}
	
	
	@Test
	public void testAdd() {
		assertNotNull(calculator);
		int result=calculator.add(4, 5);
		assertEquals(14, result);
	}

	
	@Test
	public void testSub() {
		int result=calculator.sub(12, 5);
		assertEquals(4, result);
	}


	@Test(expected = NumberFormatException.class)
	public void testSubException() {
		int result=calculator.sub(0, 5);
	}
	
	
	@Test
	public void testSub1() {
		int result=calculator.sub(12, 5);
		assertEquals(4, result);
	}
	

	@After
	public void preDestroyMethod(){
		System.out.println("inside the after");

	}

	@AfterClass
	public static void preDestroyClass(){
		System.out.println("inside the after class");
	}
	
}
