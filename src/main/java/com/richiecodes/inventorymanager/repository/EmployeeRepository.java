package com.richiecodes.inventorymanager.repository;

import com.richiecodes.inventorymanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
