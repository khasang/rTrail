package io.khasang.rtrail.controller;

import io.khasang.rtrail.dto.EmployeeDTO;
import io.khasang.rtrail.entity.Car;
import io.khasang.rtrail.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class EmployeeControllerIntegrationTest {

    private static final String ROOT = "http://localhost:8080/employee";
    private static final String ADD = "/add";
    private static final String GET_BY_ID = "/get";

    @Test
    public void checkAddCarAndEmployee() {
        Employee car = createEmployee();

        RestTemplate template = new RestTemplate();
        ResponseEntity<EmployeeDTO> responseEntity = template.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                EmployeeDTO.class,
                car.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        EmployeeDTO receivedCar = responseEntity.getBody();
        assertNotNull(receivedCar);
    }

    private Employee createEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Employee employee = prefillEmployee("Ivan");

        HttpEntity<Employee> httpEntity = new HttpEntity<>(employee, headers);

        RestTemplate template = new RestTemplate();
        Employee createdCat = template.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                Employee.class
        ).getBody();

        assertNotNull(createdCat);
        assertEquals(employee.getName(), createdCat.getName());
        return createdCat;
    }

    private Employee prefillEmployee(String barsik) {
        Employee employee = new Employee();
        employee.setName(barsik);
        employee.setState("Bos");

        Car car1 = new Car();
        car1.setModel("VAZ");
        car1.setYear(LocalDate.of(2005, 11, 12));

        Car car2 = new Car();
        car2.setModel("BMW");
        car2.setYear(LocalDate.of(2017, 3, 1));

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);

        employee.setCarList(carList);

        return employee;
    }
}
