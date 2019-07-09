package com.oliveira.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
