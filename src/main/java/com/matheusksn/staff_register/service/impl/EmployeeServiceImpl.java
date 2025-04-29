package com.matheusksn.staff_register.service.impl;

import com.matheusksn.staff_register.domain.entity.Department;
import com.matheusksn.staff_register.domain.entity.Employee;
import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import com.matheusksn.staff_register.mapper.EmployeeMapper;
import com.matheusksn.staff_register.repository.EmployeeRepository;
import com.matheusksn.staff_register.service.DepartmentService;
import com.matheusksn.staff_register.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper mapper;
    private final DepartmentService departmentService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper mapper, DepartmentService departmentService) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.departmentService = departmentService;
    }

    @Override
    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = mapper.toEntity(request);
        employee.setDepartment(findDepartmentOrThrowError(request.getDepartmentId()));
        employee = employeeRepository.save(employee);
        return mapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> findByNameContainingIgnoreCase(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findBySurnameContainingIgnoreCase(String surname) {
        return employeeRepository.findBySurnameContainingIgnoreCase(surname)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByCpf(String cpf) {
        return employeeRepository.findByCpf(cpf)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByEmail(String email) {
        return employeeRepository.findByEmail(email)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByPersonalEmail(String personalEmail) {
        return employeeRepository.findByPersonalEmail(personalEmail)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByPosition(Position position) {
        return employeeRepository.findByPosition(position)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByDepartment(Long departmentId) {
        Department department = findDepartmentOrThrowError(departmentId);
        return employeeRepository.findByDepartment(department)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findBySeniority(Seniority seniority) {
        return employeeRepository.findBySeniority(seniority)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary) {
        return employeeRepository.findBySalaryBetween(minSalary, maxSalary)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByIsActive(boolean isActive) {
        return employeeRepository.findByIsActive(isActive)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByAdmissionDateBetween(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findByAdmissionDateBetween(startDate, endDate)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeResponse> findByTerminationDateBetween(LocalDate startDate, LocalDate endDate) {
        return employeeRepository.findByTerminationDateBetween(startDate, endDate)
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse partialUpdate(Long id, EmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        mapper.partialUpdate(employee, request);
        employee.setDepartment(findDepartmentOrThrowError(request.getDepartmentId()));
        employee = employeeRepository.save(employee);
        return mapper.toResponse(employee);
    }

    private Department findDepartmentOrThrowError(Long departmentId) {
        return departmentService.findDepartmentById(departmentId);
    }
}