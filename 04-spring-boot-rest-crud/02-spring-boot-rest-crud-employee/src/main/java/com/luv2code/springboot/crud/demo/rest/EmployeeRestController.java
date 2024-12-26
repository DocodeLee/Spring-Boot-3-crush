package com.luv2code.springboot.crud.demo.rest;



import com.luv2code.springboot.crud.demo.entity.Employee;
import com.luv2code.springboot.crud.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {


    private EmployeeService employeeService;
    //quick and dirty : inject employee dao (use constructor injection)

    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    // expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findALl();
    }

    //Add mapping for GET /employee/{employeeId}

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee ==null){
            throw new RuntimeException("Employee id is not found - " + employeeId);
        }
        return theEmployee;
    }

    // add mapping for post / employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        //also just in case they pass an ID in JSON .. set ID  to 0
        //this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee){

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }


    //add mapping for Delete /employees/{employeeId} - delete Employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if(tempEmployee == null){
            throw new RuntimeException("Employee id is not found - " + employeeId);
        }
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " +employeeId;
    }
}
