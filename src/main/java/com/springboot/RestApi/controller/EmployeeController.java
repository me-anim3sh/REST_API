package com.springboot.RestApi.controller;

import com.springboot.RestApi.model.Employee;
import com.springboot.RestApi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee) {  // this ResponseEntity method will generate the response for this API.
        return new ResponseEntity<Employee>(employeeService.saveEmploye(employee), HttpStatus.CREATED);
    }

    // build get all employee REST API
    @GetMapping
    public List<Employee> getAllEmp() {
        return employeeService.getAllEmployee();
    }

    // build get all employee by ID REST API.
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmpId(@PathVariable("id") long empId) {
        return new ResponseEntity<Employee>(employeeService.getEmpByID(empId), HttpStatus.OK);
    }

    // build get update employee REST API.
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmp(@PathVariable("id") long id
                                                                                        , @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.updateEmp(employee, id), HttpStatus.OK);
    }
}
