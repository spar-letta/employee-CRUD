/**
 * 
 */
package com.simiyu.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simiyu.model.Employee;
import com.simiyu.service.EmployeeService;

/**
 * @author enock
 *
 */
@RestController
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(value = "/employees")
	public ResponseEntity<List<Employee>> findAllEmployees(){
		return new ResponseEntity<>(employeeService.findAll(),HttpStatus.OK);
	}
	
	@PostMapping(value = "/employees")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		return new ResponseEntity<>(employeeService.save(employee),HttpStatus.CREATED);
	}
	
	
}
