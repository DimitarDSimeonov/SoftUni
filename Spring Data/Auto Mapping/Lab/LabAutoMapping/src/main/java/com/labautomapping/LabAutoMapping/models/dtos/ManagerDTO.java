package com.labautomapping.LabAutoMapping.models.dtos;

import java.util.List;

public class ManagerDTO extends BaseEmployeeDTO{

    private List<EmployeeDTO> subordinates;

    public ManagerDTO() {}


    public List<EmployeeDTO> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<EmployeeDTO> subordinates) {
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s | Employees: %d", getFirstName(), getLastName(), subordinates.size()))
                .append(System.lineSeparator());
        subordinates.forEach(e -> sb.append("\t- ").append(e.toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
