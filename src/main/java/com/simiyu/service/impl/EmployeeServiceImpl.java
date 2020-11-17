/**
 * 
 */
package com.simiyu.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.simiyu.exception.ResourceNotFoundException;
import com.simiyu.model.Employee;
import com.simiyu.repository.EmployeeRepository;
import com.simiyu.service.EmployeeService;

/**
 * @author enock
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		if(employees == null) {
			return null;
		}else {
			return employees;
		}
		
	}

	@Override
	public Optional<Employee> findById(long id) {
		Optional<Employee> emp = employeeRepository.findById(id);
		if(emp.isEmpty()) {
			return null;
		}else {
			return emp;
		}
		
	}

	@Override
	public Employee save(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee update(Employee emp, long id) {
		Employee up_emp = employeeRepository.getOne(id);
		if(up_emp != null) {
			//update
			up_emp.setId(id);
			up_emp.setName(emp.getName());
			up_emp.setId_no(emp.getId_no());
			up_emp.setPhone(emp.getPhone());
			//up_emp.setRank(emp.getRank());
			return employeeRepository.save(up_emp);
		}else {
			// save new record
			return employeeRepository.save(emp);
		}
		
	}

	@Override
	public void delete(long id) { 
		employeeRepository.deleteById(id);

	}

	@Override
	public void deleteAll() {
		employeeRepository.findAll();		
	}

	
	


}
