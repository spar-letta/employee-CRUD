/**
 * 
 */
package com.simiyu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.simiyu.model.Employee;

/**
 * @author enock
 *
 */
public interface EmployeeService {

	// find all employees
		List<Employee> findAll();
		//find employee by id;
		Optional<Employee> findById(long id);
		//save employee
		Employee save(Employee employee);
		//update employee
		Employee update(Employee emp, long id);
		//delete employee by id
		void delete(long id);
		//delete all employees
		void deleteAll();
		
    	
}
