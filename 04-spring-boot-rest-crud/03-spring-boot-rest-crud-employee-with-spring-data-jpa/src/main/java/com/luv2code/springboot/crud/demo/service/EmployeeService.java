package com.luv2code.springboot.crud.demo.service;

import com.luv2code.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findALl();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
