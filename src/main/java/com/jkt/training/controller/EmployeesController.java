package com.jkt.training.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jkt.training.entity.Employees;
import com.jkt.training.service.EmployeeService;
@RestController
public class EmployeesController {

  	@Autowired
	private EmployeeService empser;
	@GetMapping("/employees")
	public List<Employees> getAllEmployees()
	{
		return empser.getAllEmployees();
	}
	@GetMapping("/employee/{id}")
	public Optional<Employees> getEmpbyId(@PathVariable int id)
	{
		return empser.getEmployee(id);
	}
	
	@PostMapping(path="/employees",consumes = "application/json")
	public String addEmp(@RequestBody Employees employee)
	{
		empser.addEmp(employee);
		//System.out.println(employee.toString());
		return "New Employee Added";
	}
	
	@PutMapping(path="/employees/{id}",consumes="application/json")
	public String updateEmp(@RequestBody Employees emp, @PathVariable int id)
	{
		empser.updateEmp(emp, id);
		return "Employee Updated";
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		empser.deleteEmp(id);
		return "Employee deleted";
	}
}
