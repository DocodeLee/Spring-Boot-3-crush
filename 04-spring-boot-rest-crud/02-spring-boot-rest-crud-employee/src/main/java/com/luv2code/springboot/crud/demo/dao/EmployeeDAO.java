package com.luv2code.springboot.crud.demo.dao;

import com.luv2code.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findALl();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
}
