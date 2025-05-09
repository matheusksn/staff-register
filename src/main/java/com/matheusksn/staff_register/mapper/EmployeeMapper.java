package com.matheusksn.staff_register.mapper;

import com.matheusksn.staff_register.domain.entity.Employee;
import com.matheusksn.staff_register.dto.EmployeeRequest;
import com.matheusksn.staff_register.dto.EmployeeResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapper {

    public Employee toEntity(EmployeeRequest dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setCpf(dto.getCpf());
        employee.setEmail(dto.getEmail());
        employee.setPersonalEmail(dto.getPersonalEmail());
        employee.setPosition(dto.getPosition());
        employee.setSeniority(dto.getSeniority());
        employee.setSalary(dto.getSalary());
        employee.setActive(dto.isActive());
        employee.setAdmissionDate(dto.getAdmissionDate());
        employee.setTerminationDate(dto.getTerminationDate());
        return employee;
    }

    public EmployeeResponse toResponse(Employee entity) {
        EmployeeResponse response = new EmployeeResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setSurname(entity.getSurname());
        response.setCpf(entity.getCpf());
        response.setEmail(entity.getEmail());
        response.setPersonalEmail(entity.getPersonalEmail());
        response.setPosition(entity.getPosition());
        response.setSeniority(entity.getSeniority());
        response.setSalary(entity.getSalary());
        response.setActive(entity.isActive());
        response.setAdmissionDate(entity.getAdmissionDate());
        response.setTerminationDate(entity.getTerminationDate());
        return response;
    }

    public List<EmployeeResponse> toResponseList(List<Employee> entities) {
        return entities.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public EmployeeResponse partialUpdate(Employee entity, EmployeeRequest dto) {
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }
        if (dto.getSurname() != null) {
            entity.setSurname(dto.getSurname());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPersonalEmail() != null) {
            entity.setPersonalEmail(dto.getPersonalEmail());
        }
        if (dto.getPosition() != null) {
            entity.setPosition(dto.getPosition());
        }
        if (dto.getSeniority() != null) {
            entity.setSeniority(dto.getSeniority());
        }
        if (dto.getSalary() != null) {
            entity.setSalary(dto.getSalary());
        }
        return toResponse(entity);
    }
}