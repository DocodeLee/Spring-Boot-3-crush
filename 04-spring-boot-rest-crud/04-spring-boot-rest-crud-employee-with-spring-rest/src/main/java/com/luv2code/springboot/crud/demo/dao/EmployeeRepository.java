package com.luv2code.springboot.crud.demo.dao;

import com.luv2code.springboot.crud.demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



//@RepositoryRestResource(path="members")

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //no need to write any code... what?

}
