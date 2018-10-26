package com.demo.entity;


public class Employee implements Comparable<Employee>{

	private int id;
	private String name;
	private int age;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int compareTo(Employee o) {
		Integer i1=this.id;
		Integer i2=o.getId();
		return i1.compareTo(i2);
	}
	
	public boolean equals(Object o){
		System.out.println("inside equals");
		Employee e=(Employee)o;
		return this.id==e.getId();
	}
	
}
