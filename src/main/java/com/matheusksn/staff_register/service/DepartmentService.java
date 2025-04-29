package com.matheusksn.staff_register.service;

import com.matheusksn.staff_register.domain.entity.Department;

public interface DepartmentService {
    Department findDepartmentById(Long departmentId);
}
