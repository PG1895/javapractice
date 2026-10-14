package com.spring.microservices.service;

import com.spring.microservices.entity.Employee;
import com.spring.microservices.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

  @Autowired
  private EmployeeRepo employeeRepo;

    public Employee create(Employee employee) {
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getById(Long id) {
        return employeeRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Employee not found"));
    }

    public Employee update(Long id, Employee updated) {
        Employee employee = getById(id);
        employee.setName(updated.getName());
        employee.setDepartment(updated.getDepartment());
        employee.setSalary(updated.getSalary());

        return employeeRepo.save(employee);
    }

    public void delete(Long id) {
        Employee employee = getById(id);
        employeeRepo.delete(employee);
    }

}
