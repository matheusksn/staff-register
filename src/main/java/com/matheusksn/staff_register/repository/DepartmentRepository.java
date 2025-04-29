package com.matheusksn.staff_register.repository;

import com.matheusksn.staff_register.domain.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
