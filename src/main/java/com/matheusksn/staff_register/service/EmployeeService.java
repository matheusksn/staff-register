package com.matheusksn.staff_register.service;

import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest request);

    List<EmployeeResponse> findByNameContainingIgnoreCase(String name);

    List<EmployeeResponse> findBySurnameContainingIgnoreCase(String surname);

    List<EmployeeResponse> findByCpf(String cpf);

    List<EmployeeResponse> findByEmail(String email);

    List<EmployeeResponse> findByPersonalEmail(String personalEmail);

    List<EmployeeResponse> findByPosition(Position position);

    List<EmployeeResponse> findByDepartment(Long departmentId);

    List<EmployeeResponse> findBySeniority(Seniority seniority);

    List<EmployeeResponse> findBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary);

    List<EmployeeResponse> findByIsActive(boolean isActive);

    List<EmployeeResponse> findByAdmissionDateBetween(LocalDate startDate, LocalDate endDate);

    List<EmployeeResponse> findByTerminationDateBetween(LocalDate startDate, LocalDate endDate);

    EmployeeResponse update(Long id, EmployeeRequest request);

    EmployeeResponse partialUpdate(Long id, EmployeeRequest request);

}
