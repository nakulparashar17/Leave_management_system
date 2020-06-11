package com.jkt.training.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.jkt.training.entity.Employees;
import com.jkt.training.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class EmployeesController {

  	@Autowired
	private EmployeeService empser;

  	@GetMapping("/employees")
	public List<Employees> getAllEmployees()
	{
		return empser.getAllEmployees();
	}
	
	@GetMapping("/employees/{id}")
	public Optional<Employees> getEmpbyId(@PathVariable int id)
	{
		return empser.getEmployee(id);
	}
	
	@GetMapping("/employees/{id}/managers")
	public List<Employees> getManagerByEmpId(@PathVariable int id)
	{
		return empser.getManagerByEmpId(id);
	}
	
	@PostMapping(path="/employees",consumes = "application/json")
	public String addEmp(@RequestBody Employees employee)
	{
		Employees isExist=empser.findEmployeeByEmail(employee.getEmail());
		if(isExist!=null) {
			return "already added by this email";
		}
		else {
			empser.addEmp(employee);
			return "New Employee Added";
		}
	}
	
//	@PostMapping(path="/employees/{eid}/manager",consumes = "application/json")
//	public String addMan(@RequestBody Employees employee ,@PathVariable int eid)
//	{
//		employee.setManager(new Employees(0,"","","",0,eid));
//		empser.addMan(employee);
//		//System.out.println(employee.toString());
//		return "New Employee Added";
//	}
	
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
