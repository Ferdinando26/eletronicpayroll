package com.challenge.eletronicpayroll.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.challenge.eletronicpayroll.models.Employee;

import com.challenge.eletronicpayroll.services.EmployeeService;

@RestController
@RequestMapping(value = "employees")
public class EmployeeController {
	
	//private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public ResponseEntity<?> find(@PathVariable Integer id){
		
		Employee obj = employeeService.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	public ResponseEntity<Void> insert(@Valid @RequestBody Employee obj){
		
		obj = employeeService.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}
