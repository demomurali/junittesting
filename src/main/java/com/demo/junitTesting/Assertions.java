package com.demo.junitTesting;


import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


import static org.hamcrest.core.Every.everyItem;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.demo.entity.Employee; 

public class Assertions {

	@Test
	public void examples(){
	
		/*
		 * 	String a="hi";
		String b="hi";
		
		assertEquals(a,b);
		assertThat(a,is(b));
		assertTrue(a.equals(b));
		assertThat(a, is(equalTo(b)));
		assertEquals(a, b);
		assertThat(a, is(b));
			
		//	assertNotNull(null);
		assertTrue(a.equals(b));
		assertEquals(a, b);
		
		// core matchers
		//assertThat(a, b);
		assertThat(a, is(b));
		assertThat(a, equalTo(b));
		assertThat(a, is(equalTo(b)));
			
		
		assertThat(e1, equalTo(e2));
			
	
		*/
		Employee e1=new Employee();
		e1.setId(1001);
		e1.setName("rakesh");
		e1.setAge(23);
		Employee e2=new Employee();
		e2.setId(1002);
		e2.setName("rohit");
		e2.setAge(254);
		// obj ---> name
		// obj--> name, 'rakesh
		// obj1 equals obj
		// obj1 content obj
		
		//assertThat(e1, instanceOf(Employee.class));
		//assertThat(e1, equalTo(e2));
		// compare two object
		//assertEquals(e1,e2);
		
		//assertThat(e1, instanceOf(Employee.class));
		//assertThat(e1, equalTo(e2));
		//assertEquals(e1,e2);
		
		
		//assertThat(e1, hasProperty("name"));
		//assertThat(e1, hasProperty("name",equalTo("rakesh")));
		assertThat(e1, samePropertyValuesAs(e2));
			
		List <Employee> emptyList=new ArrayList<Employee>();
		List <Employee> employees=new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
	
		// arraywithsize
	
		// assertThat(emptyList, emptyArray());
	//	 assertThat(employees, hasSize(2));
	//	 assertThat(employees, contains(e2));
	//	 assertThat(employees, contains(employees));
	//	 assertThat(employees, containsInAnyOrder(e2,e1));	/**/
	}
	
}
