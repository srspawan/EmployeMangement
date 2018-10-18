package com.wipro.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.employee.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	public List<Employee> findByNameContainingIgnoreCase(String name);

}
