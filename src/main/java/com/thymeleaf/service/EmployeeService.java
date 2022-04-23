package com.thymeleaf.service;

import com.thymeleaf.entity.Employee;
import java.util.*;;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByEmail(String email);
	public Employee getEmployeeById(Long empId);
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	public void deleteEmployee(Long empId);
}
