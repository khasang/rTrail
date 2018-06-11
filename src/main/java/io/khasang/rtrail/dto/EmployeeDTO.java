package io.khasang.rtrail.dto;

import io.khasang.rtrail.entity.Car;
import io.khasang.rtrail.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDTO {
    private Long id;
    private String name;
    private String state;
    private List<CarDTO> carDTOList = new ArrayList<>();

    public List<EmployeeDTO> getEmployeeDTOList(List<Employee> employeeList) {
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employeeList) {

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setState(employee.getState());

            List<CarDTO> carDTOList = new ArrayList<>();
            getCarDTOListFromCar(employee, carDTOList);

            employeeDTO.setCarDTOList(carDTOList);
            employeeDTOList.add(employeeDTO);
        }

        return employeeDTOList;
    }

    public EmployeeDTO getEmployeeDTO(Employee employee) {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setState(employee.getState());

        List<CarDTO> carDTOList = new ArrayList<>();
        getCarDTOListFromCar(employee, carDTOList);

        employeeDTO.setCarDTOList(carDTOList);

        return employeeDTO;
    }

    private void getCarDTOListFromCar(Employee employee, List<CarDTO> carDTOList) {
        for (Car car : employee.getCarList()) {
            CarDTO carDTO = new CarDTO();
            carDTO.setId(car.getId());
            carDTO.setModel(car.getModel());
            carDTO.setYear(car.getYear());

            carDTOList.add(carDTO);
        }
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<CarDTO> getCarDTOList() {
        return carDTOList;
    }

    public void setCarDTOList(List<CarDTO> carDTOList) {
        this.carDTOList = carDTOList;
    }
}
