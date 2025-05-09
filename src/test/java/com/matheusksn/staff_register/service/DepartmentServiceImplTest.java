package com.matheusksn.staff_register.service;

import com.matheusksn.staff_register.domain.entity.Department;
import com.matheusksn.staff_register.repository.DepartmentRepository;
import com.matheusksn.staff_register.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DepartmentServiceImplTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindDepartmentById() {
        Long departmentId = 1L;
        Department department = new Department();

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.of(department));

        Department result = departmentService.findDepartmentById(departmentId);

        assertNotNull(result);
        verify(departmentRepository, times(1)).findById(departmentId);
    }

    @Test
    void testFindDepartmentByIdNotFound() {
        Long departmentId = 1L;

        when(departmentRepository.findById(departmentId)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> departmentService.findDepartmentById(departmentId));

        assertNotNull(exception);
        assertEquals("Departamento não encontrado", exception.getMessage());
        verify(departmentRepository, times(1)).findById(departmentId);
    }


}
