package com.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.demo.dao.EmployeeDao;
import com.demo.dao.EmployeeDaoImpl;
import com.demo.entity.BussinessException;
import com.demo.entity.Employee;
import com.demo.entity.EmployeeNotFoundException;

public class EmployeeService {

	private EmployeeDao employeeDao=new EmployeeDaoImpl();

	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	
	public List<Employee> getEmployees() throws Exception{
		
		List <Employee>employees=null;
		//try{
		
		//System.out.println(employeeDao);
		
		employees= employeeDao.getEmployees();// Sqlexception
		employees.stream().forEach(
				employee->System.out.println(employee.getName()));
		
		
		/*}catch(SQLException e){
			System.out.println("inside the employee serviceeeeeeee exception");
			throw new BussinessException(e.getMessage());
		}*/
		return employees;
	}
	
	//employeeDao dummy ---> employeeDao.getEmployee---> list of employees
	public boolean insertEmployee(Employee e){
		return employeeDao.saveEmployee(e);
	}
	
	
	public Employee findTopOneEmployee() throws SQLException{
			List<Employee> employees=employeeDao.getEmployees();
			employees.stream().sorted(
										(Employee e1,Employee e2)->e1.compareTo(e2)
									);
			if(employees.size()>0)
			return employees.get(employees.size()-1);
			else
			return null;
	}
	
	
	public Employee getEmployeeById(int id){
		
		Optional options=employeeDao.getEmployeeById(id);
		System.out.println(options);
		// mock object for dao
		// option object which contains employee object
		// option with empty content
		if(options.isPresent()){
			return (Employee) options.get();
		}else{
			throw new EmployeeNotFoundException("no employee found for this "+id);
		}
		}
}
