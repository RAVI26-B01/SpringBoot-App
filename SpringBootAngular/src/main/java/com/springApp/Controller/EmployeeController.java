package com.springApp.Controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springApp.Exception.UserNotFoundException;
import com.springApp.Model.Employee;
import com.springApp.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees= employeeService.findAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws UserNotFoundException{
		Employee employees= employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody @Valid Employee employee){
		Employee addEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(addEmployee,HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		Employee updateEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<Employee> updateEmployeeFields(@RequestBody Employee employee, Map<String,Object> fields){
		Employee updateEmployeeFields = employeeService.updateEmployeeFields(employee,fields);
		return  new ResponseEntity<>(updateEmployeeFields,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
