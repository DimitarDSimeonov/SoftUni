package com.labautomapping.LabAutoMapping;

import com.labautomapping.LabAutoMapping.models.dtos.EmployeeDTO;
import com.labautomapping.LabAutoMapping.models.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        ModelMapper modelMapper = new ModelMapper();

        Employee employee = new Employee("Pesho", "Peshev", LocalDate.of(1990, 12, 21),new BigDecimal(2000), "Chaika 15");

        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

        System.out.println(employeeDTO);
    }
}
