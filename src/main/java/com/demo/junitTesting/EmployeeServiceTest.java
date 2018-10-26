package com.demo.junitTesting;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.Mockito.any;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.dao.EmployeeDao;
import com.demo.entity.BussinessException;
import com.demo.entity.Employee;
import com.demo.entity.EmployeeNotFoundException;
import com.demo.service.EmployeeService;

public class EmployeeServiceTest {
	
	
	//mock object
	@Mock
    private EmployeeDao daoMock;

	
	private List<Employee> employees;
	
	// injecting mock object into employee service
    @InjectMocks
    private EmployeeService service1;
	
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        employees=getTestData();
    }

    @Ignore
    @Test
	public void testGetEmployees() throws SQLException {
    	System.out.println(daoMock.getEmployees());
    		when(daoMock.getEmployees()).thenReturn(employees);
    	System.out.println(daoMock.getEmployees());
    		 assertThat(service1.getEmployees(), hasSize(2));
    }
    
    
    
    //@Ignore
    @Test(expected=BussinessException.class)
	public void testGetEmployeesException() throws Exception {
    		when(daoMock.getEmployees()).thenThrow(SQLException.class);
    		service1.getEmployees();
   	  }
    
    
    @Ignore
     @Test
	public void testSave() {
    		when(daoMock.saveEmployee(any(Employee.class)))
    					.thenReturn(true);
    		//assertTrue(service1.insertEmployee(new Employee()));
    		assertThat(service1.insertEmployee(new Employee()),is(true));
	}

    @Ignore
    @Test
 	public void testGetEmployeeById() {
    			Employee e1=new Employee();
    			e1.setId(4534);
     		when(daoMock.getEmployeeById(any(Integer.class)))
     			.thenReturn(Optional.of(e1));
    			
    			Employee d=service1.getEmployeeById(1001);
     		System.out.println(d.getId());
     		assertThat(d, is(notNullValue())); 	
     		}
    
    
    @Ignore
    @Test
 	public void testGetEmployeeByIdAnswer() {
     		when(daoMock.getEmployeeById(any(Integer.class)))
     			.thenAnswer(
     					 invocation->{
     						 Object[] arguments = invocation.getArguments();
     		                if (arguments != null && arguments.length > 0 && arguments[0] != null){
     		                		int id=(Integer)arguments[0];
     		                		if(id>0)
     		                			return Optional.of(new Employee());
     		                	}
     		                	return Optional.empty();
     					 });
     		assertThat(service1.getEmployeeById(0), is(notNullValue())); 
     		}
    
    
    
    @Ignore
    @Test(expected = EmployeeNotFoundException.class)
    public void testGetEmployeeByIdException() {
    	when(daoMock.getEmployeeById(any(Integer.class)))
    				.thenReturn(Optional.empty());
    			//	.thenReturn(Optional.of(new Employee()));
     	service1.getEmployeeById(34);  
    }
    
    
    @Ignore
    @Test
    public void testFindTopOneEmployee() throws SQLException {
		when(daoMock.getEmployees()).thenReturn(getTestData());
			Employee e=service1.findTopOneEmployee();
			System.out.println(e.getName());
			//assertNotNull(e);
			//assertEquals(e.getName(), "ramesh");
	}

    
    private List<Employee> getTestData(){
    	Employee e1=new Employee();
		e1.setId(1001);
		e1.setName("rakesh");
		e1.setAge(23);
		Employee e2=new Employee();
		e2.setId(1002);
		e2.setName("rohit");
		e2.setAge(254);
		List <Employee> employees=new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		return employees;
	}
    
}
