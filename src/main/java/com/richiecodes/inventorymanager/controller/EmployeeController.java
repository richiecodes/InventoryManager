package com.richiecodes.inventorymanager.controller;

import com.richiecodes.inventorymanager.exception.ResourceNotFoundException;
import com.richiecodes.inventorymanager.model.Employee;
import com.richiecodes.inventorymanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // CREATE
    @PostMapping
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Employee createEmployee(@RequestBody Employee p) {
        return repository.save(p);
    }

    // READ
    @GetMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employees with ID " + id));

        return ResponseEntity.ok(employee);
    }

//    // UPDATE
//    @PostMapping("{id}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody employee details) {
//        Employee employee = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No employees with ID " + id));
//

//
//        repository.save(employee);
//
//        return ResponseEntity.ok(employee);
//    }

    // DELETE
//    @DeleteMapping("{id}")
//    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
//    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
//        employee employee = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No employees with ID " + id));
//
//        repository.delete(employee);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }

}
