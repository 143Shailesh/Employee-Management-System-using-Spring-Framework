package com.example.EmpManagement.Employee.Repository;

import com.example.EmpManagement.Employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { // Changed Integer to Long
}
