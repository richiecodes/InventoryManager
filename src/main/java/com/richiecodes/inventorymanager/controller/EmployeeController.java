package com.richiecodes.inventorymanager.controller;

import com.richiecodes.inventorymanager.exception.ResourceNotFoundException;
import com.richiecodes.inventorymanager.model.Employee;
import com.richiecodes.inventorymanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // CREATE
    @PostMapping
    public Employee createEmployee(@RequestBody Employee e) {
        return repository.save(e);
    }

    // READ
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with ID " + id));

        return ResponseEntity.ok(employee);
    }

    // UPDATE
    @PostMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee details) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with ID " + id));

        employee.setFirstName(details.getFirstName());
        employee.setLastName(details.getLastName());
        employee.setDob(details.getDob());
        employee.setStatus(details.getStatus());
        employee.setType(details.getType());

        repository.save(employee);

        return ResponseEntity.ok(employee);
    }

    // DELETE
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with ID " + id));

        repository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
