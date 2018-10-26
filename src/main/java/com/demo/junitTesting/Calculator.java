package com.demo.junitTesting;

public class Calculator {

	private int someValue;
	
	public int add(int a, int b){
		someValue++;
		return a+b+someValue;
	}
	
	public int sub(int a, int b){
		if(a==0)
			throw new NumberFormatException("zero is not allowed");
		someValue--;
		return a-b-someValue;
	}
	

	public int mul(int a, int b){
		return a*b;
	}
	
	public int getSomeValue() {
		return someValue;
	}

	public void setSomeValue(int someValue) {
		this.someValue = someValue;
	}

}
