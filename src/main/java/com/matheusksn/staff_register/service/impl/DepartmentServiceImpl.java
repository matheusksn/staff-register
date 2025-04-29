package com.matheusksn.staff_register.service.impl;

import com.matheusksn.staff_register.domain.entity.Department;
import com.matheusksn.staff_register.repository.DepartmentRepository;
import com.matheusksn.staff_register.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }
}
