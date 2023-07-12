package com.labautomapping.LabAutoMapping.repositories;

import com.labautomapping.LabAutoMapping.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
