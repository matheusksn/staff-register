package com.matheusksn.staff_register.repository;

import com.matheusksn.staff_register.domain.entity.Department;
import com.matheusksn.staff_register.domain.entity.Employee;
import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findBySurnameContainingIgnoreCase(String surname);

    List<Employee> findByCpf(String cpf);

    List<Employee> findByEmail(String email);

    List<Employee> findByPersonalEmail(String personalEmail);

    List<Employee> findByPosition(Position position);

    List<Employee> findByDepartment(Department department);

    List<Employee> findBySeniority(Seniority seniority);

    List<Employee> findBySalaryBetween(BigDecimal minSalary, BigDecimal maxSalary);

    List<Employee> findByIsActive(boolean isActive);

    List<Employee> findByAdmissionDateBetween(LocalDate startDate, LocalDate endDate);

    List<Employee> findByTerminationDateBetween(LocalDate startDate, LocalDate endDate);
}
