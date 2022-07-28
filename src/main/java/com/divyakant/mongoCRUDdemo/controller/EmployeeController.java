package com.divyakant.mongoCRUDdemo.controller;

import com.divyakant.mongoCRUDdemo.model.Employee;
import com.divyakant.mongoCRUDdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee)
    {
        Optional phoneNumber = employeeRepository.findEmployeeByPhoneNumber(employee.getPhoneNumber());

        if(phoneNumber.isPresent())
        {
            System.out.println("Phone number is already present!");
            return ResponseEntity.internalServerError().body("Phone number is already present!");
        }
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @GetMapping
    public ResponseEntity<?> getEmployees()
    {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(employeeRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Integer id)
    {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok("Success!");
    }
}
