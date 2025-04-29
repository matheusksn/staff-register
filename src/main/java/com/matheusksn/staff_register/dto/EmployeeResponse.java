package com.matheusksn.staff_register.dto;

import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeResponse {

    private Long id;

    private String name;

    private String surname;

    private String cpf;

    private String email;

    private Position position;

    private Seniority seniority;

    private String personalEmail;

    private BigDecimal salary;

    private boolean isActive;

    private LocalDate admissionDate;

    private LocalDate terminationDate;

    private String departmentName;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Long id, String name, String surname, String cpf, String email, Position position, Seniority seniority, String personalEmail, BigDecimal salary, boolean isActive, LocalDate admissionDate, LocalDate terminationDate, String departmentName) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.cpf = cpf;
        this.email = email;
        this.position = position;
        this.seniority = seniority;
        this.personalEmail = personalEmail;
        this.salary = salary;
        this.isActive = isActive;
        this.admissionDate = admissionDate;
        this.terminationDate = terminationDate;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(LocalDate terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
