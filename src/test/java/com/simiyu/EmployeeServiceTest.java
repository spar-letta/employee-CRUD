/**
 * 
 */
package com.simiyu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.simiyu.model.Employee;
import com.simiyu.model.Rank;
import com.simiyu.repository.EmployeeRepository;
import com.simiyu.service.EmployeeService;
import com.simiyu.service.impl.EmployeeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
/**
 * @author enock
 *
 */
@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@Mock
	private EmployeeRepository emloyeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Test
	public void testFindAllEmployees(){
		
		List<Employee> emp_list = new ArrayList<>();
		emp_list.add(new Employee("Enock simiyu", 708761565, 30474150,Rank.DEPUTY));
		emp_list.add(new Employee("Caren Mutoro", 708361565, 32174150, Rank.PPINCIPAL));
		emp_list.add(new Employee("Palmer Tess", 708261565, 37474150, Rank.SNRTEACHER));
		
		given(emloyeeRepository.findAll()).willReturn(emp_list);
		List<Employee> expected = employeeService.findAll();
		
		assertEquals(expected, emp_list);
		assertEquals(expected.size(), 3);
	}
	
	@Test
	public void findUserById() {
		final long id = 1L;
		final Employee emp = new Employee(1L,"Enock simiyu", 708761565, 30474150, Rank.PPINCIPAL);
		given(emloyeeRepository.findById(id)).willReturn(Optional.of(emp));
		final Optional<Employee> expected = employeeService.findById(id);
		assertThat(expected).isNotNull();
	}
	
	@Test
	public void testSaveEMployee() {
		final Employee new_emp = new Employee("Enock simiyu", 708761565, 30474150, Rank.SNRTEACHER);
		given(emloyeeRepository.save(new_emp)).willAnswer(i -> i.getArgument(0));
		Employee savedEmp = employeeService.save(new_emp);
		assertThat(savedEmp).isNotNull();
		verify(emloyeeRepository).save(any(Employee.class));
	}
	
	@Test
	public void testUpdateEmployee() {
		final long id = 1L;
		final Employee new_emp = new Employee(1L, "Enock simiyu", 708761565, 30474150, Rank.SNRTEACHER);
		given(emloyeeRepository.save(new_emp)).willReturn(new_emp);
		final Employee expected = employeeService.update(new_emp,id);
		assertThat(expected).isNotNull();
		verify(emloyeeRepository).save(any(Employee.class));
	}
	
	@Test
	public void testDeleteEmployeeById() {
		final long id = 1L;
		employeeService.delete(id);
		
		verify(emloyeeRepository, times(1)).deleteById(id);
	}
}
