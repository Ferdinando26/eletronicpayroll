package com.challenge.eletronicpayroll.services;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.challenge.eletronicpayroll.models.Employee;
import com.challenge.eletronicpayroll.repositories.EmployeeRepository;
import com.challenge.eletronicpayroll.services.exceptions.ObjectNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// This method is used in "Employee Update ()" method.
//	public void DataUpdate(Employee newObj, Employee obj) {      
//		newObj.setName(obj.getName());
//		newObj.setProject(obj.getProject());
//		newObj.setPis(obj.getPis());
//		
//	}

	public Employee find(Long id) {

		Optional<Employee> obj = employeeRepository.findById(id);

		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));

	}

	public Employee insert(Employee obj) {

		obj.setId(null);

		return employeeRepository.save(obj);

	}

	public List<Employee> findAll() {

		return employeeRepository.findAll();
	}

	public void delete(Long id) {

		find(id);
		try {
			employeeRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("The Employee couldn't be deleted from database");
		}
	}

	public Employee update(Employee obj) {
		Employee newObj = find(obj.getId());

		newObj.setName(obj.getName());
		newObj.setPis(obj.getPis());
		newObj.setProject(obj.getProject());
		System.out.println("The update wasn't successfully done");

		return employeeRepository.save(newObj);
	}

}
