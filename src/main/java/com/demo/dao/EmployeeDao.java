package com.demo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.demo.entity.Employee;

public interface EmployeeDao {
	public List<Employee> getEmployees() throws SQLException;
	public boolean saveEmployee(Employee e);
	public Optional getEmployeeById(int id);
	public Employee findTopOneEmployee();
}
