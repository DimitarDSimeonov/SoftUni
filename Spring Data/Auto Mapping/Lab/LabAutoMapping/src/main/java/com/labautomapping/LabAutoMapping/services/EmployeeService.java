package com.labautomapping.LabAutoMapping.services;

import com.labautomapping.LabAutoMapping.models.dtos.ManagerDTO;

import java.util.List;

public interface EmployeeService {

    ManagerDTO findOne(Long id);

    List<ManagerDTO> findAll();
}
