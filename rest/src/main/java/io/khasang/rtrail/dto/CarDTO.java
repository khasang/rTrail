package io.khasang.rtrail.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarDTO {
    private Long id;
    private List<EmployeeDTO> employeesDTO = new ArrayList<>();
    private LocalDate year;
    private String model;

    public List<EmployeeDTO> getEmployeesDTO() {
        return employeesDTO;
    }

    public void setEmployeesDTO(List<EmployeeDTO> employeesDTO) {
        this.employeesDTO = employeesDTO;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
