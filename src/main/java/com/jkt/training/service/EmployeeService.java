package com.jkt.training.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jkt.training.entity.Employees;
import com.jkt.training.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
  	private EmployeeRepository emprepo;
	
  	public List<Employees> getAllEmployees()
	{
		return emprepo.findAll();
	}
	
	public Optional<Employees> getEmployee(int id)
	{
		Optional<Employees> emp = emprepo.findById(id);
		return emp;
		
	}
	public void addEmp(Employees employee)
	{
		emprepo.save(employee);
	}
	
	
//	//mapping
//	public void addMan(Employees employee)
//	{
//		emprepo.save(employee);
//	}

	public void updateEmp(Employees emp,int EmpId)
	{
	
		if(emprepo.existsById(EmpId))
			emprepo.save(emp);
	
	}
	
	public void deleteEmp(int EmpId)
	{
		Employees emp=emprepo.getOne(EmpId);
		emprepo.delete(emp);
	}
}
