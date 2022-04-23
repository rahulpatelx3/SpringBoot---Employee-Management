package com.thymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thymeleaf.entity.Employee;
import com.thymeleaf.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		return this.employeeRepo.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return this.employeeRepo.save(employee);
	}

	@Override
	public void deleteEmployee(Long empId) {
		this.employeeRepo.deleteById(empId);
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		return this.employeeRepo.findByEmail(email);
	}

	@Override
	public Employee getEmployeeById(Long empId) {
		return this.employeeRepo.findById(empId).get();
	}

}
