package com.matheusksn.staff_register.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import com.matheusksn.staff_register.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() throws Exception {
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.create(any(EmployeeRequest.class))).thenReturn(response);

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).create(any(EmployeeRequest.class));
    }

    @Test
    void testFindByName() throws Exception {
        String name = "Matheus";
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByNameContainingIgnoreCase(name)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/name")
                        .param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByNameContainingIgnoreCase(name);
    }

    @Test
    void testFindBySurname() throws Exception {
        String surname = "Doe";
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findBySurnameContainingIgnoreCase(surname)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/surname")
                        .param("surname", surname))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findBySurnameContainingIgnoreCase(surname);
    }

    @Test
    void testFindByCpf() throws Exception {
        String cpf = "12345678900";
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByCpf(cpf)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/cpf")
                        .param("cpf", cpf))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByCpf(cpf);
    }

    @Test
    void testFindByPosition() throws Exception {
        Position position = Position.DEVELOPER;
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByPosition(position)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/position")
                        .param("position", position.name()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByPosition(position);
    }

    @Test
    void testFindBySalaryBetween() throws Exception {
        BigDecimal minSalary = BigDecimal.valueOf(1000);
        BigDecimal maxSalary = BigDecimal.valueOf(5000);
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findBySalaryBetween(minSalary, maxSalary)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/salary")
                        .param("minSalary", minSalary.toString())
                        .param("maxSalary", maxSalary.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findBySalaryBetween(minSalary, maxSalary);
    }

    @Test
    void testUpdate() throws Exception {
        Long id = 1L;
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.update(eq(id), any(EmployeeRequest.class))).thenReturn(response);

        mockMvc.perform(put("/employees/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).update(eq(id), any(EmployeeRequest.class));
    }

    @Test
    void testPartialUpdate() throws Exception {
        Long id = 1L;
        EmployeeRequest request = new EmployeeRequest();
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.partialUpdate(eq(id), any(EmployeeRequest.class))).thenReturn(response);

        mockMvc.perform(patch("/employees/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).partialUpdate(eq(id), any(EmployeeRequest.class));
    }

    @Test
    void testFindByIsActive() throws Exception {
        boolean isActive = true;
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByIsActive(isActive)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/active")
                        .param("isActive", String.valueOf(isActive)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByIsActive(isActive);
    }

    @Test
    void testFindByAdmissionDateBetween() throws Exception {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByAdmissionDateBetween(startDate, endDate)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/admission-date")
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByAdmissionDateBetween(startDate, endDate);
    }

    @Test
    void testFindByTerminationDateBetween() throws Exception {
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2023, 12, 31);
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByTerminationDateBetween(startDate, endDate)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/termination-date")
                        .param("startDate", startDate.toString())
                        .param("endDate", endDate.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByTerminationDateBetween(startDate, endDate);
    }

    @Test
    void testFindByDepartment() throws Exception {
        Long departmentId = 1L;
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByDepartment(departmentId)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/department")
                        .param("departmentId", departmentId.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByDepartment(departmentId);
    }

    @Test
    void testFindBySeniority() throws Exception {
        Seniority seniority = Seniority.JUNIOR;
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findBySeniority(seniority)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/seniority")
                        .param("seniority", seniority.name()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findBySeniority(seniority);
    }

    @Test
    void testFindByEmail() throws Exception {
        String email = "test@example.com";
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByEmail(email)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/email")
                        .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByEmail(email);
    }

    @Test
    void testFindByPersonalEmail() throws Exception {
        String personalEmail = "example@example.com";
        EmployeeResponse response = new EmployeeResponse();

        when(employeeService.findByPersonalEmail(personalEmail)).thenReturn(Collections.singletonList(response));

        mockMvc.perform(get("/employees/personal-email")
                        .param("personalEmail", personalEmail))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(employeeService, times(1)).findByPersonalEmail(personalEmail);
    }
}