package com.demo.junitTesting;

import static org.junit.Assert.*;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

public class EmployeeSpy {

	
    @InjectMocks
    private EmployeeService service1;
	
    @Spy
    private EmployeeDaoImpl daoSpy=new EmployeeDaoImpl();
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerify() {
    		Employee e1=new Employee();
		e1.setId(1001);
		e1.setName("ramesh");
		e1.setAge(23);
         assertEquals(service1.insertEmployee(e1), true);
         //verify that the save method has been invoked
			verify(daoSpy).saveEmployee(any(Employee.class));
        }
  	
}
