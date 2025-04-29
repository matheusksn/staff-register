package com.matheusksn.staff_register.dto;

import com.matheusksn.staff_register.domain.enums.Position;
import com.matheusksn.staff_register.domain.enums.Seniority;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeRequest {

    @NotBlank
    String surname;
    @NotBlank
    private String name;
    @Email
    private String email;

    @Email
    private String personalEmail;

    @NotBlank
    private String cpf;

    @NotNull
    private Position position;

    @NotNull
    private Seniority seniority;

    @NotNull
    private BigDecimal salary;

    private boolean isActive;

    private LocalDate admissionDate;

    private LocalDate terminationDate;

    @NotNull
    private Long departmentId;

    public EmployeeRequest() {
    }

    public @NotBlank String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank String surname) {
        this.surname = surname;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @Email String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(@Email String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public @NotBlank String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank String cpf) {
        this.cpf = cpf;
    }

    public @NotNull Position getPosition() {
        return position;
    }

    public void setPosition(@NotNull Position position) {
        this.position = position;
    }

    public @NotNull Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(@NotNull Seniority seniority) {
        this.seniority = seniority;
    }

    public @NotNull BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(@NotNull BigDecimal salary) {
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

    public @NotNull Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(@NotNull Long departmentId) {
        this.departmentId = departmentId;
    }
}


