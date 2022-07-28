package com.divyakant.mongoCRUDdemo.repository;

import com.divyakant.mongoCRUDdemo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    Optional<Employee> findEmployeeByPhoneNumber(String number);
}
