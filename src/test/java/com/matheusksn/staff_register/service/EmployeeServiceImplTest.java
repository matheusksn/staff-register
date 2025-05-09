package com.matheusksn.staff_register.service;

import com.matheusksn.staff_register.domain.entity.Department;
import com.matheusksn.staff_register.domain.entity.Employee;
import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import com.matheusksn.staff_register.mapper.EmployeeMapper;
import com.matheusksn.staff_register.repository.EmployeeRepository;
import com.matheusksn.staff_register.service.impl.DepartmentServiceImpl;
import com.matheusksn.staff_register.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private DepartmentServiceImpl departmentService;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        EmployeeRequest request = new EmployeeRequest();
        Employee employee = new Employee();
        Department department = new Department();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeMapper.toEntity(request)).thenReturn(employee);
        when(departmentService.findDepartmentById(anyLong())).thenReturn(department);
        when(employeeRepository.save(employee)).thenReturn(employee);
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        EmployeeResponse result = employeeService.create(request);

        assertNotNull(result);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testFindByNameContainingIgnoreCase() {
        String name = "Matheus";
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByNameContainingIgnoreCase(name)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByNameContainingIgnoreCase(name);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByNameContainingIgnoreCase(name);
    }

    @Test
    void testFindBySurnameContainingIgnoreCase() {
        String surname = "Doe";
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findBySurnameContainingIgnoreCase(surname)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findBySurnameContainingIgnoreCase(surname);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findBySurnameContainingIgnoreCase(surname);
    }

    @Test
    void testFindByCpf() {
        String cpf = "12345678900";
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByCpf(cpf)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByCpf(cpf);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByCpf(cpf);
    }

    @Test
    void testFindByEmail() {
        String email = "test@example.com";
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByEmail(email)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByEmail(email);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByEmail(email);
    }

    @Test
    void testFindByPosition() {
        Position position = Position.DEVELOPER;
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByPosition(position)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByPosition(position);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByPosition(position);
    }

    @Test
    void testFindByDepartment() {
        Long departmentId = 1L;
        Department department = new Department();
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(departmentService.findDepartmentById(departmentId)).thenReturn(department);
        when(employeeRepository.findByDepartment(department)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByDepartment(departmentId);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByDepartment(department);
    }

    @Test
    void testFindBySalaryBetween() {
        BigDecimal minSalary = BigDecimal.valueOf(1000);
        BigDecimal maxSalary = BigDecimal.valueOf(5000);
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findBySalaryBetween(minSalary, maxSalary)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findBySalaryBetween(minSalary, maxSalary);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findBySalaryBetween(minSalary, maxSalary);
    }

    @Test
    void testPartialUpdate() {
        Long id = 1L;
        EmployeeRequest request = new EmployeeRequest();
        Employee employee = new Employee();
        Department department = new Department();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(departmentService.findDepartmentById(anyLong())).thenReturn(department);
        when(employeeRepository.save(employee)).thenReturn(employee);
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        EmployeeResponse result = employeeService.partialUpdate(id, request);

        assertNotNull(result);
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    void testFindByPersonalEmail() {
        String personalEmail = "personal@example.com";
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByPersonalEmail(personalEmail)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByPersonalEmail(personalEmail);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByPersonalEmail(personalEmail);
    }

    @Test
    void testFindBySeniority() {
        Seniority seniority = Seniority.JUNIOR;
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findBySeniority(seniority)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findBySeniority(seniority);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findBySeniority(seniority);
    }

    @Test
    void testFindByIsActive() {
        boolean isActive = true;
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByIsActive(isActive)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByIsActive(isActive);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByIsActive(isActive);
    }

    @Test
    void testFindByAdmissionDateBetween() {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByAdmissionDateBetween(startDate, endDate)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByAdmissionDateBetween(startDate, endDate);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByAdmissionDateBetween(startDate, endDate);
    }

    @Test
    void testFindByTerminationDateBetween() {
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2025, 12, 31);
        Employee employee = new Employee();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeRepository.findByTerminationDateBetween(startDate, endDate)).thenReturn(Collections.singletonList(employee));
        when(employeeMapper.toResponse(employee)).thenReturn(response);

        List<EmployeeResponse> result = employeeService.findByTerminationDateBetween(startDate, endDate);

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(employeeRepository, times(1)).findByTerminationDateBetween(startDate, endDate);
    }
}