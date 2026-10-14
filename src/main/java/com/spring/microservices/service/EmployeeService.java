package com.spring.microservices.service;

import com.spring.microservices.entity.Employee;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    Employee create(@Valid Employee employee);

    List<Employee> getAll();

    Employee getById(Long id);

    Employee update(Long id, @Valid Employee employee);

    void delete(Long id);
}
