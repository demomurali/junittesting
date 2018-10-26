package com.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import com.demo.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees(){
		System.out.println("inside the employee dao implllllll");
		Employee e1=new Employee();
		e1.setId(1001);
		e1.setName("ramesh");
		e1.setAge(23);
		
		Employee e2=new Employee();
		e2.setId(1002);
		e2.setName("suresh");
		e2.setAge(254);
		
		List <Employee> employees=new ArrayList<Employee>();
		employees.add(e1);
		employees.add(e2);
		return employees;
	}
	
	
	public boolean saveEmployee(Employee e){
		return true;
	}




	@Override
	public Optional getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Employee findTopOneEmployee() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
