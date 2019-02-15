package com.challenge.eletronicpayroll.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.challenge.eletronicpayroll.models.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
