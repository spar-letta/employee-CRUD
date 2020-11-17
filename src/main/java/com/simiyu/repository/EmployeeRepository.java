/**
 * 
 */
package com.simiyu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.simiyu.model.Employee;

/**
 * @author enock
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	 Page<Employee> findByDepartmentId(Long depart_id, Pageable pageable);
//	 
//	 Optional<Employee> findByIdAndDepartId(Long id, Long departId);
//	   
}
