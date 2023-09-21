package com.springboot.RestApi.implementation;

import com.springboot.RestApi.exception.ResourceNotFoundException;
import com.springboot.RestApi.model.Employee;
import com.springboot.RestApi.repository.EmployeeRepo;
import com.springboot.RestApi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        super();
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmploye(Employee employee) {  // save all employee details.
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {   // get all employee details.
        return employeeRepo.findAll();
    }

    // finding employee by ID.
    @Override
    public Employee getEmpByID(long id) {
        Optional<Employee> employee = employeeRepo.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        else  {
            throw new ResourceNotFoundException("Employee", "Id", id);
        }
//        return employeeRepo.findById(id).orElse(() ->
//                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmp(Employee employee, long id) {
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

        // updates details.
        existingEmployee.setEmpFirstName(employee.getEmpFirstName());
        existingEmployee.setEmpLastName(employee.getEmpLastName());
        existingEmployee.setEmpEmail(employee.getEmpEmail());

        // saving the update details.
        employeeRepo.save(existingEmployee);

        // return .
        return existingEmployee;
    }
}
