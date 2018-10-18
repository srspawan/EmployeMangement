package com.wipro.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.employee.bean.Employee;
import com.wipro.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employee;

	@GetMapping(path = "/getAllEmployee", produces = "application/json")
	@ResponseBody
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employee.findAll();
	}
	
	@GetMapping(path = "/getalldataByName/{name}")
	@ResponseBody
	public List<Employee> getAllDataByName(@PathVariable(name = "name") String name) {
		return (List<Employee>) employee.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(path = "/getEmployeeById/{id}")
	@ResponseBody
	public Optional<Employee> getEmployeeById(@PathVariable(name = "id") int id) {
		return employee.findById(id);
	}

	@DeleteMapping(path = "/deleteEmployeeById/{id}")
	public String removeEmployeeById(@PathVariable(name = "id") int id) {
		employee.deleteById(id);
		return "Record has been deleted with the id: " + id;
	}

	@PostMapping(path = "/saveEmployee")
	public String createEmployeeData(@RequestBody Employee data) {
		employee.save(data);
		return "Employee  data has been saved successfully" ;
	}

	@PutMapping(path = "/updateEmployee")
	public String updateEmployeeData(@RequestBody Employee data) {
		if (employee.existsById(data.getId())) {
			employee.save(data);
			 return "Data has been updated successfully ";
		} else {
			return "Record not exists with the Id: ";
		}
	}
	
	@GetMapping(value="/welcome")
    public String welcome(){
        return "Welcome to Employee Application";
    }
}
