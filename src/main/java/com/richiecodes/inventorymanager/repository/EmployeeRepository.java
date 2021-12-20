package com.richiecodes.inventorymanager.repository;

import com.richiecodes.inventorymanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);

    Boolean existsByUsername(String username);
}
