package com.challenge.eletronicpayroll.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.eletronicpayroll.models.Employee;
import com.challenge.eletronicpayroll.repositories.EmployeeRepository;
import com.challenge.eletronicpayroll.services.EmployeeService;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {

		Employee obj = employeeService.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Employee obj) {

		try {
			obj = employeeService.insert(obj);
		} catch (Exception e) {

			e.printStackTrace();
		}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> findAll() {

		List<Employee> list = null;
		try {
			list = employeeRepository.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		
		employeeService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
	
	public ResponseEntity<Void> update (@Valid @RequestBody Employee obj){
		
		
		return 
	}

}
