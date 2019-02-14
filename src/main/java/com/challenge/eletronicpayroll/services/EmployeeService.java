package com.challenge.eletronicpayroll.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.challenge.eletronicpayroll.models.Employee;
import com.challenge.eletronicpayroll.repositories.EmployeeRepository;
import com.challenge.eletronicpayroll.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeService  {
	
	private EmployeeRepository employeeRepository;
	
	// This method is used in "Employee Update ()" method.
//	public void DataUpdate(Employee newObj, Employee obj) {
//		newObj.setName(obj.getName());
//		newObj.setProject(obj.getProject());
//		newObj.setPis(obj.getPis());
//		
//	}
	
	public Employee find (Integer id) {
		
		Optional<Employee> obj = employeeRepository.findById(id);
		
		return obj.orElseThrow(()-> new ObjectNotFoundException("Object not found"));
		
	}
	
	public Employee insert (Employee obj) {
		
		obj.setId(null);
		
		return employeeRepository.save(obj);
		
	}
	
	public List<Employee> findAll(){
		
		return employeeRepository.findAll();
	}
	
//	public Employee update (Employee obj) {
//		
//		Employee newObj = find(obj.getId());
//		DataUpdate(newObj, newObj);
//		
//	}

}
