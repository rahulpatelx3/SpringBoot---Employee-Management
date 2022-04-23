package com.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.thymeleaf.entity.Employee;
import com.thymeleaf.service.EmployeeServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping({"employees","/list","/"})
	public ModelAndView getAllEmployee() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("emp-list");
		modelAndView.addObject("emp", this.employeeService.getAllEmployee());
		return modelAndView;
	}
	
	@GetMapping("/addEmp")
	public ModelAndView addEmployee() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("add-emp");
		Employee newEmp=new Employee();
		modelAndView.addObject("emp", newEmp);
		return modelAndView;
	}
	
	@PostMapping("/addEmp")
	public String addEmployeePost(@ModelAttribute("emp") Employee employee) {
		Employee emp=this.employeeService.getEmployeeByEmail(employee.getEmail());
		if(emp!=null) {
			return "redirect:/addEmp?error";
		}
		this.employeeService.addEmployee(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/editEmp")
	public ModelAndView editEmployee(@RequestParam Long empId) {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("edit-emp");
		Employee newEmp=this.employeeService.getEmployeeById(empId);
		modelAndView.addObject("emp", newEmp);
		return modelAndView;
	}
	
	@PostMapping("/editEmp")
	public String editEmployeePost(@ModelAttribute("emp") Employee employee) {
		this.employeeService.updateEmployee(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/deleteEmp")
	public String deleteEmployee(@RequestParam Long empId) {
		this.employeeService.deleteEmployee(empId);
		return "redirect:/list";
	}
	
}
