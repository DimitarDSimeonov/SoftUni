package com.labautomapping.LabAutoMapping.services;

import com.labautomapping.LabAutoMapping.models.dtos.ManagerDTO;
import com.labautomapping.LabAutoMapping.models.entities.Employee;
import com.labautomapping.LabAutoMapping.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.labautomapping.LabAutoMapping.Utils.MODEL_MAPPER;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public ManagerDTO findOne(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();

        ManagerDTO managerDTO = MODEL_MAPPER.map(employee, ManagerDTO.class);

        return managerDTO;
    }

    @Override
    public List<ManagerDTO> findAll() {

       List<ManagerDTO> managers = new ArrayList<>();
       List<Employee> employees = employeeRepository
               .findAll();
      employees.forEach(e -> managers.add(MODEL_MAPPER.map(e, ManagerDTO.class)));

      return managers;
    }
}
