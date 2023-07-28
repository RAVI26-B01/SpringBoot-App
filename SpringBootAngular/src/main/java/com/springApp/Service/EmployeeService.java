package com.springApp.Service;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springApp.Exception.UserNotFoundException;
import com.springApp.Model.Employee;
import com.springApp.Repo.EmployeeRepo;



@Service
public class EmployeeService {
	private final EmployeeRepo employeeRepo;
	
	@Autowired
	public EmployeeService(EmployeeRepo employeeRepo) {
		
		this.employeeRepo=employeeRepo;
	}
	
	//save data
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepo.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	@Transactional
	public void deleteEmployee(Long id) {
		employeeRepo.deleteEmployeeById(id);
	}
	
	public Employee findEmployeeById(Long id) throws UserNotFoundException {
		 Employee employee = employeeRepo.findEmployeeById(id);
		 if(employee!=null){
			 return employee;
		 }
		 else{
			 throw new UserNotFoundException("Employee Not Found with id :" + id);
		 }
				
	}
	
	
}
