package com.example.EmpManagement.Employee.Services;

import com.example.EmpManagement.Employee.Repository.EmployeeRepository;
import com.example.EmpManagement.Employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> fetchAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) { // Changed int to Long
        return employeeRepository.findById(id);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employeeDetails) { // Changed int to Long
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeDetails.getName());
            employee.setAddress(employeeDetails.getAddress());
            employee.setCountry(employeeDetails.getCountry());
            employee.setState(employeeDetails.getState());
            employee.setQualification(employeeDetails.getQualification());
            employee.setReligion(employeeDetails.getReligion());

            return employeeRepository.save(employee);
        }).orElseGet(() -> {
            employeeDetails.setId(id);
            return employeeRepository.save(employeeDetails);
        });
    }

    public void deleteEmployee(Long id) { // Changed int to Long
        employeeRepository.deleteById(id);
    }
}
