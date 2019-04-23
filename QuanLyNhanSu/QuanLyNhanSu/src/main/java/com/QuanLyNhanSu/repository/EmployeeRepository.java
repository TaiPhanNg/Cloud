package com.QuanLyNhanSu.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.QuanLyNhanSu.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByNameContaining(String q);

}