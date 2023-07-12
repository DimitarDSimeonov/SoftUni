package com.labautomapping.LabAutoMapping.models.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {

    private String firstName;

    private String lastName;

    private LocalDate birthday;

    private BigDecimal salary;

    private String address;

    private Employee() {}

    public Employee(String firstName, String lastName, LocalDate birthday, BigDecimal salary, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.salary = salary;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
