package com.matheusksn.staff_register.controller;

import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import com.matheusksn.staff_register.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest request) {
        return employeeService.create(request);
    }

    @GetMapping("/name")
    public List<EmployeeResponse> findByName(@RequestParam String name) {
        return employeeService.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/surname")
    public List<EmployeeResponse> findBySurname(@RequestParam String surname) {
        return employeeService.findBySurnameContainingIgnoreCase(surname);
    }

    @GetMapping("/cpf")
    public List<EmployeeResponse> findByCpf(@RequestParam String cpf) {
        return employeeService.findByCpf(cpf);
    }

    @GetMapping("/email")
    public List<EmployeeResponse> findByEmail(@RequestParam String email) {
        return employeeService.findByEmail(email);
    }

    @GetMapping("/personal-email")
    public List<EmployeeResponse> findByPersonalEmail(@RequestParam String personalEmail) {
        return employeeService.findByPersonalEmail(personalEmail);
    }

    @GetMapping("/position")
    public List<EmployeeResponse> findByPosition(@RequestParam Position position) {
        return employeeService.findByPosition(position);
    }

    @GetMapping("/department")
    public List<EmployeeResponse> findByDepartment(@RequestParam Long departmentId) {
        return employeeService.findByDepartment(departmentId);
    }

    @GetMapping("/seniority")
    public List<EmployeeResponse> findBySeniority(@RequestParam Seniority seniority) {
        return employeeService.findBySeniority(seniority);
    }

    @GetMapping("/salary")
    public List<EmployeeResponse> findBySalaryBetween(@RequestParam BigDecimal minSalary, @RequestParam BigDecimal maxSalary) {
        return employeeService.findBySalaryBetween(minSalary, maxSalary);
    }

    @GetMapping("/active")
    public List<EmployeeResponse> findByIsActive(@RequestParam boolean isActive) {
        return employeeService.findByIsActive(isActive);
    }

    @GetMapping("/admission-date")
    public List<EmployeeResponse> findByAdmissionDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return employeeService.findByAdmissionDateBetween(startDate, endDate);
    }

    @GetMapping("/termination-date")
    public List<EmployeeResponse> findByTerminationDateBetween(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return employeeService.findByTerminationDateBetween(startDate, endDate);
    }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return employeeService.update(id, request);
    }

    @PatchMapping("/{id}")
    public EmployeeResponse partialUpdate(@PathVariable Long id, @RequestBody EmployeeRequest request) {
        return employeeService.partialUpdate(id, request);
    }
}
