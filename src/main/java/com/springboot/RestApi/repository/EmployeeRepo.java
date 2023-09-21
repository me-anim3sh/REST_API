package com.springboot.RestApi.repository;

import com.springboot.RestApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// Here we create JPA Employee Interface for better JPA operation.
// JpaRepository internally provides @Repository, so we don't need to provide manually.
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
