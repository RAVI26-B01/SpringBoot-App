package com.springApp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springApp.Model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	void deleteEmployeeById(Long id);

	Employee findEmployeeById(Long id);

}
