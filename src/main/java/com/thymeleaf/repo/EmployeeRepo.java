package com.thymeleaf.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thymeleaf.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	public Employee findByEmail(String email);
}
