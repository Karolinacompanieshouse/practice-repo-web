package com.demoproject.employeeWEB.service;

import com.demoproject.employeeWEB.model.Employee;
import com.demoproject.employeeWEB.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class APIClientService {

    private RestTemplate restTemplate;

    @Autowired
    public APIClientService(final RestTemplate restTemplate){
        this.restTemplate= restTemplate;
    }


    public void postEmployee(Employee employee, String url){
        restTemplate.postForEntity(url, employee, Employee.class);
    }

    public void putEmployee(Employee employee, String url) {
        restTemplate.put(url, employee, Employee.class);
    }

    public ResponseEntity<Employees> getAllEmployees(String url) {
        return restTemplate.exchange(url, HttpMethod.GET, null, Employees.class);
    }

}


