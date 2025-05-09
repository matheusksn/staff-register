package com.matheusksn.staff_register.mapper;

import com.matheusksn.staff_register.domain.entity.Employee;
import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest {

    private final EmployeeMapper mapper = new EmployeeMapper();

    @Test
    void testToEntity() {
        EmployeeRequest request = new EmployeeRequest();
        request.setName("Matheus");
        request.setSurname("Doe");
        request.setCpf("12345678900");
        request.setEmail("Matheus.doe@example.com");
        request.setPersonalEmail("Matheus.personal@example.com");
        request.setPosition(Position.DEVELOPER);
        request.setSeniority(Seniority.MID);
        request.setSalary(BigDecimal.valueOf(5000));
        request.setActive(true);
        request.setAdmissionDate(LocalDate.of(2023, 1, 1));
        request.setTerminationDate(null);

        Employee entity = mapper.toEntity(request);

        assertNotNull(entity);
        assertEquals(request.getName(), entity.getName());
        assertEquals(request.getSurname(), entity.getSurname());
        assertEquals(request.getCpf(), entity.getCpf());
        assertEquals(request.getEmail(), entity.getEmail());
        assertEquals(request.getPersonalEmail(), entity.getPersonalEmail());
        assertEquals(request.getPosition(), entity.getPosition());
        assertEquals(request.getSeniority(), entity.getSeniority());
        assertEquals(request.getSalary(), entity.getSalary());
        assertEquals(request.isActive(), entity.isActive());
        assertEquals(request.getAdmissionDate(), entity.getAdmissionDate());
        assertNull(entity.getTerminationDate());
    }

    @Test
    void testToResponse() {
        Employee entity = new Employee();
        entity.setId(1L);
        entity.setName("Matheus");
        entity.setSurname("Doe");
        entity.setCpf("12345678900");
        entity.setEmail("Matheus.doe@example.com");
        entity.setPersonalEmail("Matheus.personal@example.com");
        entity.setPosition(Position.DEVELOPER);
        entity.setSeniority(Seniority.MID);
        entity.setSalary(BigDecimal.valueOf(5000));
        entity.setActive(true);
        entity.setAdmissionDate(LocalDate.of(2023, 1, 1));
        entity.setTerminationDate(null);

        EmployeeResponse response = mapper.toResponse(entity);

        assertNotNull(response);
        assertEquals(entity.getId(), response.getId());
        assertEquals(entity.getName(), response.getName());
        assertEquals(entity.getSurname(), response.getSurname());
        assertEquals(entity.getCpf(), response.getCpf());
        assertEquals(entity.getEmail(), response.getEmail());
        assertEquals(entity.getPersonalEmail(), response.getPersonalEmail());
        assertEquals(entity.getPosition(), response.getPosition());
        assertEquals(entity.getSeniority(), response.getSeniority());
        assertEquals(entity.getSalary(), response.getSalary());
        assertEquals(entity.isActive(), response.isActive());
        assertEquals(entity.getAdmissionDate(), response.getAdmissionDate());
        assertNull(response.getTerminationDate());
    }

    @Test
    void testToResponseList() {
        Employee entity = new Employee();
        entity.setId(1L);
        entity.setName("Matheus");
        entity.setSurname("Doe");

        List<EmployeeResponse> responses = mapper.toResponseList(List.of(entity));

        assertNotNull(responses);
        assertEquals(1, responses.size());
        assertEquals(entity.getId(), responses.get(0).getId());
        assertEquals(entity.getName(), responses.get(0).getName());
        assertEquals(entity.getSurname(), responses.get(0).getSurname());
    }

    @Test
    void testPartialUpdate() {
        Employee entity = new Employee();
        entity.setName("Matheus");
        entity.setSurname("Oliveira");

        EmployeeRequest request = new EmployeeRequest();
        request.setName("Leo");
        request.setEmail("Leo@example.com");

        EmployeeResponse response = mapper.partialUpdate(entity, request);

        assertNotNull(response);
        assertEquals("Leo", entity.getName());
        assertEquals("Oliveira", entity.getSurname());
        assertEquals("Leo@example.com", entity.getEmail());
    }
}